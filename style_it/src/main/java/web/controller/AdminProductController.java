package web.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import web.dto.Product;
import web.service.face.AdminProductService;
import web.util.Paging;

@Controller
public class AdminProductController {
	
	@Autowired public AdminProductService aps;
	private static final Logger logger=LoggerFactory.getLogger(AdminProductController.class);
	
	// 페이징 처리된 제품 리스트 반환(검색/카테고리&브랜드 필터링 처리)
	@RequestMapping(value="/admin/product/list", method=RequestMethod.GET)
	public void productList(Model model, String word, @RequestParam HashMap<String, Object> map
			, @RequestParam(defaultValue="0") int curPage
			) {
	
		logger.info("word : "+word);
		logger.info("페이징 처리하기... ");
//		HashMap<String, Object> map2 = new HashMap<String, Object>();
//		map2 = aps.getpcaList();
		Paging paging;
		List<HashMap> productList;
		
		if( word != null) {
			
		logger.info("proudct word 존재");
		
		//총 게시글 수 얻기
		int totalCount = aps.getSearchCount(word);
		logger.info("총 수 : " + totalCount);
			
		//페이지 객체 생성
		paging = new Paging(totalCount, curPage);
		logger.info("페이징 : "+ paging);
		
		//업로드된 파일 전체 조회
		map.put("startNo", paging.getStartNo());
		map.put("endNo", paging.getEndNo());
		map.put("word", word);
		
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
	}
	
	// 제품 상세 보기
	@RequestMapping(value="/admin/product/detail")
	public void productPage(int p_no, Model model) {
	
	}
	
	// 제품 정보 수정 폼 반환
	@RequestMapping(value="/admin/product/update", method=RequestMethod.GET)
	public void productUpdateForm(int p_no, Model model) {
	
	}
	
	// 제품 정보 수정
	@RequestMapping(value="/admin/product/update", method=RequestMethod.POST)
	public String productUpdate(Product product) {
		return null;
	}
	
	// 제품 추가 폼 반환
	@RequestMapping(value="/admin/product/add", method=RequestMethod.GET)
	public void productAddForm() {
	
	}
	
	// 제품 추가
	@RequestMapping(value="/admin/product/add", method=RequestMethod.POST)
	public String productAdd(Product product) {
	
		return null;
	}
	
	// 제품 삭제
	@RequestMapping(value="/admin/product/delete")
	public String productDelete(int p_no) {

		return null;
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
