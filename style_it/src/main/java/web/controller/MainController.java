package web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import web.dto.Banner;
import web.dto.Faq;
import web.dto.Styling;
import web.service.face.AdminFaqService;
import web.service.face.MainService;
import web.service.impl.AdminFaqServiceImpl;
import web.util.Paging;

@Controller
public class MainController {
	
	private static final Logger logger=LoggerFactory.getLogger(MainController.class);
	@Autowired MainService mainService;
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public void main(Model model) {
		
		List<HashMap> bannerList = mainService.getBannerList();
		model.addAttribute("bannerList", bannerList);
				
		List<HashMap> todayStyling = mainService.getStylingList();
		model.addAttribute("todayStyling", todayStyling);
		
		List<HashMap> bestProduct = mainService.getBestProduct();
		logger.info("bestProduct : " + bestProduct);
		model.addAttribute("bestProduct", bestProduct);
		
	}
	
	@RequestMapping(value="/faq", method=RequestMethod.GET)
	public void faq(Model model, String word, @RequestParam HashMap<String, Object> map, 
			Paging paging, @RequestParam(defaultValue="0") int curPage) {
		
		
		map.put("word", word);
		List<HashMap> faqList;
	
		
		logger.info("word : "+word);
		if( word != null) {
			//총 게시글 수 얻기
			int totalCount = mainService.getSearchCount(map);  
			logger.info("총 수 : " + totalCount);
				
			//페이지 객체 생성
			paging = new Paging(totalCount, curPage);
			logger.info("페이징 : "+ paging);
			
			//업로드된 파일 전체 조회
			map.put("startNo", paging.getStartNo());
			map.put("endNo", paging.getEndNo());
			
			faqList = mainService.getFaqList(map);
			
		} else {
			
			int totalCount = mainService.getTotalCount();  
			logger.info("총 수 : " + totalCount);
			
			//페이지 객체 생성
			paging = new Paging(totalCount, curPage);
			logger.info("페이징 : "+ paging);
			
			//업로드된 파일 전체 조회
			faqList = mainService.getPagingFaqList(paging);
			logger.info("faqList : "+faqList);
		}
		
		
		model.addAttribute("paging", paging);
		model.addAttribute("faqList", faqList);
	}
	
	// 게시글 수정 AJAX
	@RequestMapping(value="/faq/ajax", method=RequestMethod.GET)
	public @ResponseBody Faq updateAjax(Model model,Faq faq) {
		logger.info("AJAX");
		logger.info("faq : "+faq);
		//본문 서치
		faq = mainService.fal(faq);
		logger.info("faq : "+faq);
		
		return faq;
	}

}
