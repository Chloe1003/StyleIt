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

import web.dto.ProductOccasion;
import web.service.face.AdminProductOccasionService;
import web.util.Paging;

@Controller
public class AdminProductOccasionController {

	private static final Logger logger = LoggerFactory.getLogger(AdminProductOccasionController.class);
	@Autowired AdminProductOccasionService fs;
	
	// ProductOccasion 전체 리스트
	@RequestMapping(value="/admin/pAttribute/occasion/list", method=RequestMethod.GET)
	public void productOccasionList(Model model, String word, @RequestParam HashMap<String, Object> map
			, @RequestParam(defaultValue="0") int curPage) {
		
		logger.info("word : "+word);
		logger.info("페이징 처리하기... ");
		Paging paging;
		List<HashMap> productOccasionList;
		
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
		
		productOccasionList = fs.getSearchPagingList(map);
		
		
		} else {
			
		logger.info("word 존재안함");
		
		//총 게시글 수 얻기
		int totalCount = fs.getTotalCount();
		logger.info("총 수 : " + totalCount);
			
		//페이지 객체 생성
		paging = new Paging(totalCount, curPage);
		logger.info("페이징 : "+ paging);
		
			
		//업로드된 파일 전체 조회
		productOccasionList = fs.getPagingProductOccasionList(paging);
		logger.info("productOccasionList : "+productOccasionList);
		
		}
		
		//페이징객체 MODEL로 추가
		model.addAttribute("paging", paging);
		
		//게시글목록 MODEL로 추가
		model.addAttribute("productOccasionList", productOccasionList);
	}
	
	// 게시글 추가
		@RequestMapping(value="/admin/pAttribute/occasion/insert", method=RequestMethod.POST)
		public String insert(ProductOccasion productOccasion) {
			logger.info("productOccasion : "+productOccasion);
			fs.insert(productOccasion);
			
			return "redirect:/admin/pAttribute/occasion/list";
		}
		
		// 게시글 수정
		@RequestMapping(value="/admin/pAttribute/occasion/update", method=RequestMethod.POST)
		public String update(ProductOccasion productOccasion) {
			
			logger.info("수정: "+productOccasion);
			fs.update(productOccasion);
			
			return "redirect:/admin/pAttribute/occasion/list";
		}
		
		// 게시글 수정 AJAX
		@RequestMapping(value="/admin/pAttribute/occasion/ajax", method=RequestMethod.GET)
		public @ResponseBody ProductOccasion updateAjax(Model model,ProductOccasion productOccasion) {
			logger.info("AJAX");
			logger.info("productOccasion : "+productOccasion);
			//본문 서치
			productOccasion = fs.fal(productOccasion);
			logger.info("productOccasion : "+productOccasion);
			
			return productOccasion;
		}
		
		// 게시글 삭제
		@RequestMapping(value="/admin/pAttribute/occasion/delete", method=RequestMethod.GET)
		public String delete(ProductOccasion productOccasion) {
			
			logger.info("productOccasion : "+productOccasion);
			//삭제
			fs.delete(productOccasion);
			
			
			return "redirect:/admin/pAttribute/occasion/list";
		}

	}
