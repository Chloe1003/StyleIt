package web.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import web.dto.FileUpload;
import web.dto.StylingTag;
import web.service.face.AdminStylingTagService;
import web.service.face.StylingService;

@Controller
public class AdminStylingTagController {

	@Autowired AdminStylingTagService stylingTagService;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminStylingTagController.class);
	@Autowired StylingService stylingService;
	
	// 전체 태그 리스트
	@RequestMapping(value="/admin/tag/list", method=RequestMethod.GET)
	public void tagList(Model model) {
	
		logger.info("스타일링태그");
		//스타일링태그 리스트 조회
		List<StylingTag> stList = stylingService.getStylingTagList();
		
		//출력
		model.addAttribute("stList", stList);
		
	}

	// 태그 추가 폼
	@RequestMapping(value="/admin/tag/insert", method=RequestMethod.POST)
	public String insertForm( @RequestParam HashMap<String, Object> map) {
		
		
		logger.info("ST : "+map);
		stylingService.stylingTagInsert(map);
		   
		return "redirect:/admin/tag/list";
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
