package web.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dto.StylingTag;
import web.service.face.AdminStylingTagService;

@Controller
public class AdminStylingTagController {

	@Autowired AdminStylingTagService stylingTagService;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminStylingTagController.class);
	
	// 전체 태그 리스트
	@RequestMapping(value="/admin/tag/list", method=RequestMethod.GET)
	public void tagList(Model model, String search, int st_no, String st_name, HashMap<String, Object> map) {
		
	}
	
	// 태그 추가 폼
	@RequestMapping(value="/admin/tag/insert", method=RequestMethod.GET)
	public void insertForm() {
		
	}
	
	// 태그 추가
	@RequestMapping(value="/admin/tag/insert", method=RequestMethod.POST)
	public String insert(StylingTag stylingTag, HttpSession session) {
		return null;
	}
	
	// 태그 수정 폼
	@RequestMapping(value="/admin/tag/update", method=RequestMethod.GET)
	public void updateForm(Model model, int faq_no) {
		
	}
	
	// 태그 수정
	@RequestMapping(value="/admin/tag/update", method=RequestMethod.POST)
	public String update(StylingTag stylingTag, HttpSession session) {
		return null;
	}
	
	// 태그 삭제
	@RequestMapping(value="/admin/tag/delete", method=RequestMethod.GET)
	public String delete(StylingTag stylingTag) {
		return null;
	}
	
	
}
