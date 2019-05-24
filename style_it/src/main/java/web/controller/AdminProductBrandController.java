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
import org.springframework.web.bind.annotation.ResponseBody;

import web.dto.ProductBrand;
import web.service.face.AdminProductBrandService;
import web.util.Paging;

@Controller
public class AdminProductBrandController {

	private static final Logger logger = LoggerFactory.getLogger(AdminProductBrandController.class);
	@Autowired AdminProductBrandService fs;
	
	// ProductBrand 전체 리스트
	@RequestMapping(value="/admin/pAttribute/brand/list", method=RequestMethod.GET)
	public void productBrandList(Model model, String word, @RequestParam HashMap<String, Object> map
			, @RequestParam(defaultValue="0") int curPage) {
		
		logger.info("word : "+word);
		logger.info("페이징 처리하기... ");
		Paging paging;
		List<HashMap> productBrandList;
		
		if( word != null) {
			
		logger.info("word 존재");
		
		//총 게시글 수 얻기
		int totalCount = fs.getSearchCount(word);
		logger.info("총 수 : " + totalCount);
			
		//페이지 객체 생성
		paging = new Paging(totalCount, curPage);
		logger.info("페이징 : "+ paging);
		
		//업로드된 파일 전체 조회
		map.put("startNo", paging.getStartNo());
		map.put("endNo", paging.getEndNo());
		map.put("word", word);
		
		productBrandList = fs.getSearchPagingList(map);
		
		
		} else {
			
		logger.info("word 존재안함");
		
		//총 게시글 수 얻기
		int totalCount = fs.getTotalCount();
		logger.info("총 수 : " + totalCount);
			
		//페이지 객체 생성
		paging = new Paging(totalCount, curPage);
		logger.info("페이징 : "+ paging);
		
			
		//업로드된 파일 전체 조회
		productBrandList = fs.getPagingProductBrandList(paging);
		logger.info("productBrandList : "+productBrandList);
		
		}
		
		//페이징객체 MODEL로 추가
		model.addAttribute("paging", paging);
		
		//게시글목록 MODEL로 추가
		model.addAttribute("productBrandList", productBrandList);
	}
	
	// 게시글 추가
		@RequestMapping(value="/admin/pAttribute/brand/insert", method=RequestMethod.POST)
		public String insert(ProductBrand productBrand) {
			logger.info("productBrand : "+productBrand);
			fs.insert(productBrand);
			
			return "redirect:/admin/pAttribute/brand/list";
		}
		
		// 게시글 수정
		@RequestMapping(value="/admin/pAttribute/brand/update", method=RequestMethod.POST)
		public String update(ProductBrand productBrand) {
			
			logger.info("수정: "+productBrand);
			fs.update(productBrand);
			
			return "redirect:/admin/pAttribute/brand/list";
		}
		
		// 게시글 수정 AJAX
		@RequestMapping(value="/admin/pAttribute/brand/ajax", method=RequestMethod.GET)
		public @ResponseBody ProductBrand updateAjax(Model model,ProductBrand productBrand) {
			logger.info("AJAX");
			logger.info("productBrand : "+productBrand);
			//본문 서치
			productBrand = fs.fal(productBrand);
			logger.info("productBrand : "+productBrand);
			
			return productBrand;
		}
		
		// 게시글 삭제
		@RequestMapping(value="/admin/pAttribute/brand/delete", method=RequestMethod.GET)
		public String delete(ProductBrand productBrand) {
			
			logger.info("productBrand : "+productBrand);
			//삭제
			fs.delete(productBrand);
			
			
			return "redirect:/admin/pAttribute/brand/list";
		}

	}
