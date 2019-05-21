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

import web.dto.ProductStyle;
import web.service.face.AdminProductStyleService;
import web.util.Paging;

@Controller
public class AdminProductStyleController {

	private static final Logger logger = LoggerFactory.getLogger(AdminProductStyleController.class);
	@Autowired AdminProductStyleService fs;
	
	// ProductStyle 전체 리스트
	@RequestMapping(value="/admin/pAttribute/style/list", method=RequestMethod.GET)
	public void productStyleList(Model model, String word, @RequestParam HashMap<String, Object> map
			, @RequestParam(defaultValue="0") int curPage) {
		
		logger.info("word : "+word);
		logger.info("페이징 처리하기... ");
		Paging paging;
		List<HashMap> productStyleList;
		
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
		
		productStyleList = fs.getSearchPagingList(map);
		
		
		} else {
			
		logger.info("word 존재안함");
		
		//총 게시글 수 얻기
		int totalCount = fs.getTotalCount();
		logger.info("총 수 : " + totalCount);
			
		//페이지 객체 생성
		paging = new Paging(totalCount, curPage);
		logger.info("페이징 : "+ paging);
		
			
		//업로드된 파일 전체 조회
		productStyleList = fs.getPagingProductStyleList(paging);
		logger.info("productStyleList : "+productStyleList);
		
		}
		
		//페이징객체 MODEL로 추가
		model.addAttribute("paging", paging);
		
		//게시글목록 MODEL로 추가
		model.addAttribute("productStyleList", productStyleList);
	}
	
	// 게시글 추가
		@RequestMapping(value="/admin/pAttribute/style/insert", method=RequestMethod.POST)
		public String insert(ProductStyle productStyle) {
			logger.info("productStyle : "+productStyle);
			fs.insert(productStyle);
			
			return "redirect:/admin/pAttribute/style/list";
		}
		
		// 게시글 수정
		@RequestMapping(value="/admin/pAttribute/style/update", method=RequestMethod.POST)
		public String update(ProductStyle productStyle) {
			
			logger.info("수정: "+productStyle);
			fs.update(productStyle);
			
			return "redirect:/admin/pAttribute/style/list";
		}
		
		// 게시글 수정 AJAX
		@RequestMapping(value="/admin/pAttribute/style/ajax", method=RequestMethod.GET)
		public @ResponseBody ProductStyle updateAjax(Model model,ProductStyle productStyle) {
			logger.info("AJAX");
			logger.info("productStyle : "+productStyle);
			//본문 서치
			productStyle = fs.fal(productStyle);
			logger.info("productStyle : "+productStyle);
			
			return productStyle;
		}
		
		// 게시글 삭제
		@RequestMapping(value="/admin/pAttribute/style/delete", method=RequestMethod.GET)
		public String delete(ProductStyle productStyle) {
			
			logger.info("productStyle : "+productStyle);
			//삭제
			fs.delete(productStyle);
			
			
			return "redirect:/admin/pAttribute/style/list";
		}

	}
