package web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dto.Collection;
import web.service.face.CollectionService;

@Controller
public class CollectionController {
	
	@Autowired CollectionService collectionService;
	
	private static final Logger logger = LoggerFactory.getLogger(CollectionController.class);
	
	// 전체 폴더 리스트
	@RequestMapping(value="/collection/list", method=RequestMethod.GET)
	public void collectionList(Model model,HttpServletRequest req) {
		
	}
	
	// 폴더 안 상세 보기
	@RequestMapping(value="/collection/view", method=RequestMethod.GET)
	public void view(Model model, int cf_no) {
		
	}
	
	// 컬렉션 폴더 추가 폼
	@RequestMapping(value="/collection/insert", method=RequestMethod.GET)
	public void insertForm() {
		
	}
	
	// 컬렉션 폴더 추가
	@RequestMapping(value="/collection/insert", method=RequestMethod.POST)
	public String insert(Collection collection, HttpSession session) {
		return null;
	}
	
	// 컬렉션 폴더 수정 폼
	@RequestMapping(value="/collection/update", method=RequestMethod.GET)
	public void updateForm(Model model, int cf_no) {
		
	}
	
	// 컬렉션 폴더 수정
	@RequestMapping(value="/collection/update", method=RequestMethod.POST)
	public String update(Collection collection, HttpSession session) {
		return null;
	}
	
	// 컬렉션 폴더 삭제
	@RequestMapping(value="/collection/delete", method=RequestMethod.GET)
	public String delete(Collection collection) {
		return null;
	}

}
