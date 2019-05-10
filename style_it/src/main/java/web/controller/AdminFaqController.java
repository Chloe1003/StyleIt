package web.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import web.dto.Faq;
import web.service.face.AdminFaqService;
import web.util.Paging;

@Controller
public class AdminFaqController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminFaqController.class);
	@Autowired AdminFaqService fs;
	
	// FAQ 전체 리스트
	@RequestMapping(value="/admin/faq/list", method=RequestMethod.GET)
	public void faqList(Model model, String word, @RequestParam HashMap<String, Object> map
			, @RequestParam(defaultValue="0") int curPage) {
		
		logger.info("word : "+word);
		logger.info("페이징 처리하기... ");
		Paging paging;
		List<HashMap> faqList;
		
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
		
		faqList = fs.getSearchPagingList(map);
		
		
		} else {
			
		logger.info("word 존재안함");
		
		//총 게시글 수 얻기
		int totalCount = fs.getTotalCount();
		logger.info("총 수 : " + totalCount);
			
		//페이지 객체 생성
		paging = new Paging(totalCount, curPage);
		logger.info("페이징 : "+ paging);
		
			
		//업로드된 파일 전체 조회
		faqList = fs.getPagingFaqList(paging);
		logger.info("faqList : "+faqList);
		
		}
		
		//페이징객체 MODEL로 추가
		model.addAttribute("paging", paging);
		
		//게시글목록 MODEL로 추가
		model.addAttribute("faqList", faqList);
	}
	
	// 게시글 추가
	@RequestMapping(value="/admin/faq/insert", method=RequestMethod.POST)
	public String insert(Faq faq) {
		logger.info("faq : "+faq);
		fs.insert(faq);
		
		return "redirect:/admin/faq/list";
	}
	
	// 게시글 수정
	@RequestMapping(value="/admin/faq/update", method=RequestMethod.POST)
	public String update(Faq faq) {
		
		logger.info("수정: "+faq);
		fs.update(faq);
		
		return "redirect:/admin/faq/list";
	}
	
	// 게시글 수정 AJAX
	@RequestMapping(value="/admin/faq/ajax", method=RequestMethod.GET)
	public @ResponseBody Faq updateAjax(Model model,Faq faq) {
		logger.info("AJAX");
		logger.info("faq : "+faq);
		//본문 서치
		faq = fs.fal(faq);
		logger.info("faq : "+faq);
		
		return faq;
	}
	
	// 게시글 삭제
	@RequestMapping(value="/admin/faq/delete", method=RequestMethod.GET)
	public String delete(Faq faq) {
		
		logger.info("faq : "+faq);
		//삭제
		fs.delete(faq);
		
		
		return "redirect:/admin/faq/list";
	}

}
