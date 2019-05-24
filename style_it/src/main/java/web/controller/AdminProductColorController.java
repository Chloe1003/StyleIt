package web.controller;

import java.io.IOException;
import java.io.Writer;
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

import web.dto.ProductColor;
import web.service.face.AdminProductColorService;
import web.util.Paging;

@Controller
public class AdminProductColorController {

	private static final Logger logger = LoggerFactory.getLogger(AdminProductColorController.class);
	@Autowired AdminProductColorService fs;
	
	// ProductColor 전체 리스트
	@RequestMapping(value="/admin/pAttribute/color/list", method=RequestMethod.GET)
	public void productColorList(Model model, String word, @RequestParam HashMap<String, Object> map
			, @RequestParam(defaultValue="0") int curPage) {
		
		logger.info("word : "+word);
		logger.info("페이징 처리하기... ");
		Paging paging;
		List<HashMap> productColorList;
		
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
		
		productColorList = fs.getSearchPagingList(map);
		
		} else {
			
		logger.info("word 존재안함");
		//총 게시글 수 얻기
		int totalCount = fs.getTotalCount();
		logger.info("총 수 : " + totalCount);
			
		//페이지 객체 생성
		paging = new Paging(totalCount, curPage);
		logger.info("페이징 : "+ paging);
			
		//업로드된 파일 전체 조회
		productColorList = fs.getPagingProductColorList(paging);
		logger.info("productColorList : "+productColorList);
		}
		
		//페이징객체 MODEL로 추가
		model.addAttribute("paging", paging);
		//게시글목록 MODEL로 추가
		model.addAttribute("productColorList", productColorList);
	}
	
	// 게시글 추가
		@RequestMapping(value="/admin/pAttribute/color/insert", method=RequestMethod.POST)
		public String insert(ProductColor productColor) {
			logger.info("productColor : "+productColor);
			fs.insert(productColor);
			
			return "redirect:/admin/pAttribute/color/list";
		}
		
		// 게시글 수정
		@RequestMapping(value="/admin/pAttribute/color/update", method=RequestMethod.POST)
		public String update(ProductColor productColor) {
			
			logger.info("수정: "+productColor);
			fs.update(productColor);
			
			return "redirect:/admin/pAttribute/color/list";
		}
		
		// 게시글 수정 AJAX
		@RequestMapping(value="/admin/pAttribute/color/ajax", method=RequestMethod.GET)
		public @ResponseBody ProductColor updateAjax(Model model,ProductColor productColor) {
			logger.info("AJAX");
			logger.info("productColor : "+productColor);
			//본문 서치
			productColor = fs.fal(productColor);
			logger.info("productColor : "+productColor);
			
			return productColor;
		}
		
		// 활성화여부
		@RequestMapping(value="/admin/pAttribute/color/able_ajax", method=RequestMethod.GET)
		public void delete(ProductColor productColor, Writer out) {
			
			logger.info("AJAX");
			logger.info("productColor : "+productColor);
			
			//본문 서치
			if(productColor.getPco_able().equals("y")) {
				logger.info("Disable");
				fs.disable(productColor);
			} else {
				logger.info("Able");
				fs.able(productColor);
			}
			logger.info("AJAX 완료");

			try {
				out.append("");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
