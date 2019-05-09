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

@Controller
public class AdminFaqController {
	
	@Autowired AdminFaqService faqService;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminFaqController.class);
	
	// FAQ 전체 리스트
	@RequestMapping(value="/admin/faq/list", method=RequestMethod.GET)
	public void faqList(Model model) {
		
		List<HashMap> faqList = faqService.getFaqList();
		logger.info("faqList : "+ faqList);
		model.addAttribute("faqList", faqList);  
		
	}
	
	// 게시글 추가
	@RequestMapping(value="/admin/faq/insert", method=RequestMethod.POST)
	public String insert(Faq faq) {
		logger.info("faq : "+faq);
		faqService.insert(faq);
		
		return "redirect:/admin/faq/list";
	}
	
	// 게시글 수정
	@RequestMapping(value="/admin/faq/update", method=RequestMethod.POST)
	public String update(Faq faq) {
		
		logger.info("수정: "+faq);
		faqService.update(faq);
		
		return "redirect:/admin/faq/list";
	}
	
	// 게시글 수정 AJAX
	@RequestMapping(value="/admin/faq/ajax", method=RequestMethod.GET)
	public @ResponseBody Faq updateAjax(Model model,Faq faq) {
		logger.info("AJAX");
		logger.info("faq : "+faq);
		//본문 서치
		faq = faqService.fal(faq);
		logger.info("faq : "+faq);
		
		return faq;
	}
	
	// 게시글 삭제
	@RequestMapping(value="/admin/faq/delete", method=RequestMethod.GET)
	public String delete(Faq faq) {
		
		logger.info("faq : "+faq);
		//삭제
		faqService.delete(faq);
		
		
		return "redirect:/admin/faq/list";
	}

}
