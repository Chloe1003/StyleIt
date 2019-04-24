package web.controller;

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

import web.dto.Faq;
import web.service.face.AdminFaqService;

@Controller
public class AdminFaqController {
	
	@Autowired AdminFaqService faqService;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminFaqController.class);
	
	// FAQ 전체 리스트
	@RequestMapping(value="/admin/faq/list", method=RequestMethod.GET)
	public void faqList(Model model, HttpServletRequest req) {
		
	}
	
	// 게시글 상세보기
	@RequestMapping(value="/admin/faq/view", method=RequestMethod.GET)
	public void view(Model model, int faq_no) {
		
	}
	
	// 게시글 추가 폼
	@RequestMapping(value="/admin/faq/insert", method=RequestMethod.GET)
	public void insertForm() {
		
	}
	
	// 게시글 추가
	@RequestMapping(value="/admin/faq/insert", method=RequestMethod.POST)
	public String insert(Faq faq, HttpSession session) {
		return null;
	}
	
	// 게시글 수정 폼
	@RequestMapping(value="/admin/faq/update", method=RequestMethod.GET)
	public void updateForm(Model model, int faq_no) {
		
	}
	
	// 게시글 수정
	@RequestMapping(value="/admin/faq/update", method=RequestMethod.POST)
	public String update(Faq faq, HttpSession session) {
		return null;
	}
	
	// 게시글 삭제
	@RequestMapping(value="/admin/faq/delete", method=RequestMethod.GET)
	public String delete(Faq faq) {
		return null;
	}

}
