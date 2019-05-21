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

import web.dto.ProductCategory;
import web.service.face.AdminProductCategoryService;
import web.util.Paging;

@Controller
public class AdminProductCategoryController {

	private static final Logger logger = LoggerFactory.getLogger(AdminProductCategoryController.class);
	@Autowired AdminProductCategoryService fs;
	
	// ProductCategory 전체 리스트
	@RequestMapping(value="/admin/pAttribute/category/list", method=RequestMethod.GET)
	public void productCategoryList(Model model, String word, @RequestParam HashMap<String, Object> map
			, @RequestParam(defaultValue="0") int curPage) {
		
		logger.info("word : "+word);
		logger.info("페이징 처리하기... ");
		Paging paging;
		List<HashMap> productCategoryList;
		
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
		
		productCategoryList = fs.getSearchPagingList(map);
		
		
		} else {
			
		logger.info("word 존재안함");
		
		//총 게시글 수 얻기
		int totalCount = fs.getTotalCount();
		logger.info("총 수 : " + totalCount);
			
		//페이지 객체 생성
		paging = new Paging(totalCount, curPage);
		logger.info("페이징 : "+ paging);
		
			
		//업로드된 파일 전체 조회
		productCategoryList = fs.getPagingProductCategoryList(paging);
		logger.info("productCategoryList : "+productCategoryList);
		
		}
		
		//페이징객체 MODEL로 추가
		model.addAttribute("paging", paging);
		
		//게시글목록 MODEL로 추가
		model.addAttribute("productCategoryList", productCategoryList);
	}
	
	// 게시글 추가
		@RequestMapping(value="/admin/pAttribute/category/insert", method=RequestMethod.POST)
		public String insert(ProductCategory productCategory) {
			logger.info("productCategory : "+productCategory);
			fs.insert(productCategory);
			
			return "redirect:/admin/pAttribute/category/list";
		}
		
		// 게시글 수정
		@RequestMapping(value="/admin/pAttribute/category/update", method=RequestMethod.POST)
		public String update(ProductCategory productCategory) {
			
			logger.info("수정: "+productCategory);
			fs.update(productCategory);
			
			return "redirect:/admin/pAttribute/category/list";
		}
		
		// 게시글 수정 AJAX
		@RequestMapping(value="/admin/pAttribute/category/ajax", method=RequestMethod.GET)
		public @ResponseBody ProductCategory updateAjax(Model model,ProductCategory productCategory) {
			logger.info("AJAX");
			logger.info("productCategory : "+productCategory);
			//본문 서치
			productCategory = fs.fal(productCategory);
			logger.info("productCategory : "+productCategory);
			
			return productCategory;
		}
		
		// 게시글 삭제
		@RequestMapping(value="/admin/pAttribute/category/delete", method=RequestMethod.GET)
		public String delete(ProductCategory productCategory) {
			
			logger.info("productCategory : "+productCategory);
			//삭제
			fs.delete(productCategory);
			
			
			return "redirect:/admin/pAttribute/category/list";
		}

	}
