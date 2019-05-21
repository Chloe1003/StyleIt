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

import web.dto.ProductPattern;
import web.service.face.AdminProductPatternService;
import web.util.Paging;

@Controller
public class AdminProductPatternController {

	private static final Logger logger = LoggerFactory.getLogger(AdminProductPatternController.class);
	@Autowired AdminProductPatternService fs;
	
	// ProductPattern 전체 리스트
	@RequestMapping(value="/admin/pAttribute/pattern/list", method=RequestMethod.GET)
	public void productPatternList(Model model, String word, @RequestParam HashMap<String, Object> map
			, @RequestParam(defaultValue="0") int curPage) {
		
		logger.info("word : "+word);
		logger.info("페이징 처리하기... ");
		Paging paging;
		List<HashMap> productPatternList;
		
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
		
		productPatternList = fs.getSearchPagingList(map);
		
		
		} else {
			
		logger.info("word 존재안함");
		
		//총 게시글 수 얻기
		int totalCount = fs.getTotalCount();
		logger.info("총 수 : " + totalCount);
			
		//페이지 객체 생성
		paging = new Paging(totalCount, curPage);
		logger.info("페이징 : "+ paging);
		
			
		//업로드된 파일 전체 조회
		productPatternList = fs.getPagingProductPatternList(paging);
		logger.info("productPatternList : "+productPatternList);
		
		}
		
		//페이징객체 MODEL로 추가
		model.addAttribute("paging", paging);
		
		//게시글목록 MODEL로 추가
		model.addAttribute("productPatternList", productPatternList);
	}
	
	// 게시글 추가
		@RequestMapping(value="/admin/pAttribute/pattern/insert", method=RequestMethod.POST)
		public String insert(ProductPattern productPattern) {
			logger.info("productPattern : "+productPattern);
			fs.insert(productPattern);
			
			return "redirect:/admin/pAttribute/pattern/list";
		}
		
		// 게시글 수정
		@RequestMapping(value="/admin/pAttribute/pattern/update", method=RequestMethod.POST)
		public String update(ProductPattern productPattern) {
			
			logger.info("수정: "+productPattern);
			fs.update(productPattern);
			
			return "redirect:/admin/pAttribute/pattern/list";
		}
		
		// 게시글 수정 AJAX
		@RequestMapping(value="/admin/pAttribute/pattern/ajax", method=RequestMethod.GET)
		public @ResponseBody ProductPattern updateAjax(Model model,ProductPattern productPattern) {
			logger.info("AJAX");
			logger.info("productPattern : "+productPattern);
			//본문 서치
			productPattern = fs.fal(productPattern);
			logger.info("productPattern : "+productPattern);
			
			return productPattern;
		}
		
		// 게시글 삭제
		@RequestMapping(value="/admin/pAttribute/pattern/delete", method=RequestMethod.GET)
		public String delete(ProductPattern productPattern) {
			
			logger.info("productPattern : "+productPattern);
			//삭제
			fs.delete(productPattern);
			
			
			return "redirect:/admin/pAttribute/pattern/list";
		}

	}
