package web.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import web.dto.FileUpload;
import web.dto.Product;
import web.dto.ProductCategory;
import web.service.face.AdminProductService;
import web.util.Paging;

@Controller
public class AdminProductController {
	
	@Autowired public AdminProductService aps;
	@Autowired ServletContext context;
	private static final Logger logger=LoggerFactory.getLogger(AdminProductController.class);
	
	// 페이징 처리된 제품 리스트 반환(검색/카테고리&브랜드 필터링 처리)
	@RequestMapping(value="/admin/product/list", method=RequestMethod.GET)
	public void productList(Model model, String word, String cate, String brand, 
			@RequestParam HashMap<String, Object> map
			, @RequestParam(defaultValue="0") int curPage, ProductCategory pc
			) {
	
		logger.info("word : "+word);
		logger.info("페이징 처리하기... ");
		logger.info("cate : "+cate);
		logger.info("brand : "+brand);
		map.put("cate", cate);
		map.put("brand", brand);
		map.put("word", word);
		List<HashMap> pcaList = aps.getpcaList();
		logger.info("pca : "+pcaList);
		model.addAttribute("pcaList", pcaList);
		List<HashMap> pbList = aps.getpbList();
		model.addAttribute("pbList", pbList);
		Paging paging;
		List<HashMap> productList;
		
		if( word != null || cate != null || brand != null) {
			
		logger.info("word, cate, brand 존재");
		
		//총 게시글 수 얻기
		int totalCount = aps.getSearchCount(map);  
		logger.info("총 수 : " + totalCount);
			
		//페이지 객체 생성
		paging = new Paging(totalCount, curPage);
		logger.info("페이징 : "+ paging);
		
		//업로드된 파일 전체 조회
		map.put("startNo", paging.getStartNo());
		map.put("endNo", paging.getEndNo());
		
		productList = aps.getSearchedList(map);

		} else {
			
		logger.info("proudct word 존재안함");
		
		//총 게시글 수 얻기
		logger.info("test");
		int totalCount = aps.getTotalCount();
		logger.info("총 수 : " + totalCount);
			
		//페이지 객체 생성
		paging = new Paging(totalCount, curPage);
		logger.info("페이징 : "+ paging);
		
		//업로드된 파일 전체 조회
		productList = aps.getProductList(paging);
		logger.info("productList : "+productList);
		
		}
		
		//페이징객체 MODEL로 추가
		model.addAttribute("paging", paging);
		
		//게시글목록 MODEL로 추가
		model.addAttribute("productList", productList);
		
		model.addAttribute("map", map);
	}
	
	// 제품 상세 보기
	@RequestMapping(value="/admin/product/detail", method=RequestMethod.GET)
	public void productPage(Product product, HashMap<String, Object> map, Model model) {
		logger.info("PRODUCT  "+product);
		map = aps.getProduct(product);
		
		logger.info("list : "+map);
		
		model.addAttribute("list", map);
	}
	
	// 제품 정보 수정 폼 반환
	@RequestMapping(value="/admin/product/update", method=RequestMethod.GET)
	public void productUpdateForm(Product product, Model model, @RequestParam HashMap<String, Object> map) {
		logger.info("제품 수정하기... ");
		logger.info("PRODUCT  "+product);
		map = aps.getProduct(product);
		logger.info("MAP : "+map);
		model.addAttribute("list", map);
		
		//카테고리 리스트
		List<HashMap> pcaList = aps.getpcaList();
		model.addAttribute("pcaList", pcaList);
		
		//브랜드 리스트
		List<HashMap> pbList = aps.getpbList();
		model.addAttribute("pbList", pbList);
		//색 리스트
		List<HashMap> pcList = aps.getpcList();
		model.addAttribute("pcList", pcList);
		//태그리스트
		List<HashMap> poList = aps.getpoList();
		List<HashMap> ppList = aps.getppList();
		List<HashMap> psList = aps.getpsList();
		model.addAttribute("poList", poList);
		model.addAttribute("ppList", ppList);
		model.addAttribute("psList", psList);
	}
	
	// 제품 정보 수정
	@RequestMapping(value="/admin/product/update", method=RequestMethod.POST)
	public String productUpdate(@RequestParam HashMap<String, Object> map, MultipartFile file, FileUpload upFile, Model model) {
		
		logger.info("파일업로드");        
		logger.info("PRODUCT : "+map);
		logger.info("Title : "+map.get("st_name"));
		logger.info("file : "+map.get("fu_storedname"));
		logger.info(file.toString());
		logger.info(file.getOriginalFilename());
		logger.info(String.valueOf(file.getSize()));
		logger.info(file.getContentType());
		logger.info(String.valueOf(file.isEmpty()));
		
		//저장될 파일 이름
		String stored_name = null;
		stored_name = file.getOriginalFilename();
		
		//파일 저장 경로
		String path = context.getRealPath("upload/image");
		
		//저장될 파일
		File dest = new File(path, stored_name);
		
		//파일 업로드
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		upFile.setFu_storedname(file.getOriginalFilename());
		
		logger.info(upFile.toString());
		
		map.put("stored_name", upFile.getFu_storedname());
		
		logger.info("제품 : "+map);
		aps.updateProduct(map);
		
		return "redirect:/admin/product/list";
		
	}
	
	// 제품 추가 
	@RequestMapping(value="/admin/product/insert", method=RequestMethod.GET)
	public void productAddForm(Model model, @RequestParam HashMap<String, Object> map) {
		logger.info("제품 추가하기... ");
		logger.info("MAP  "+map);
		
		//카테고리 리스트
		List<HashMap> pcaList = aps.getpcaList();
		model.addAttribute("pcaList", pcaList);
		
		//브랜드 리스트
		List<HashMap> pbList = aps.getpbList();
		model.addAttribute("pbList", pbList);
		//색 리스트
		List<HashMap> pcList = aps.getpcList();
		model.addAttribute("pcList", pcList);
		//태그리스트
		List<HashMap> poList = aps.getpoList();
		List<HashMap> ppList = aps.getppList();
		List<HashMap> psList = aps.getpsList();
		model.addAttribute("poList", poList);
		model.addAttribute("ppList", ppList);
		model.addAttribute("psList", psList);
	}
	
	// 제품 추가
	@RequestMapping(value="/admin/product/insert", method=RequestMethod.POST)
	public String productAdd(@RequestParam HashMap<String, Object> map, MultipartFile file, FileUpload upFile, Model model) {
		
		logger.info("파일업로드");        
		logger.info("PRODUCT : "+map);
		logger.info("Title : "+map.get("st_name"));
		logger.info("file : "+map.get("fu_storedname"));
		logger.info(file.toString());
		logger.info(file.getOriginalFilename());
		logger.info(String.valueOf(file.getSize()));
		logger.info(file.getContentType());
		logger.info(String.valueOf(file.isEmpty()));
		
		//저장될 파일 이름
		String stored_name = null;
		stored_name = file.getOriginalFilename();
		
		//파일 저장 경로
		String path = context.getRealPath("upload/image");
		
		//저장될 파일
		File dest = new File(path, stored_name);
		
		//파일 업로드
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		upFile.setFu_storedname(file.getOriginalFilename());
		
		logger.info(upFile.toString());
		
		map.put("stored_name", upFile.getFu_storedname());
		
		logger.info("제품 : "+map);
		aps.addProduct(map);
		
		return "redirect:/admin/product/list";
	}
	
	// 제품 삭제
	@RequestMapping(value="/admin/product/delete")
	public String productDelete(int[] p_no) {

		logger.info("삭제 : "+Arrays.toString(p_no));
		aps.deleteProduct(p_no);
		return "redirect:/admin/product/list";    
	}
	
	// 제품 속성 리스트 반환
	@RequestMapping(value="/admin/pAttribute/list", method=RequestMethod.GET)
	public void productAttributeList() {
	
	}
	
	// 페이징 처리된 선택 제품 속성의 리스트 반환(검색 처리)
	@RequestMapping(value="/admin/pAttribute/list", method=RequestMethod.POST)
	public void productAttributeList(String attributeType, String search, Model model, @RequestParam HashMap<String, Object> map) {
	
	}
	
	// 선택 제품 속성 추가
	@RequestMapping(value="/admin/pAttribute/add")
	public void productAttributeAdd(String attributeType, String name) {
	
	}
	
	// 선택 제품 속성 수정
	@RequestMapping(value="/admin/pAttribute/update")
	public void productAttributeUpdate(String attributeType, String name) {
	
	}
	
	// 선택 제품 속성 삭제
	@RequestMapping(value="/admin/pAttribute/delete")
	public void productAttributeDelete(String attributeType, int attribute_no) {
	
	}
	
}
