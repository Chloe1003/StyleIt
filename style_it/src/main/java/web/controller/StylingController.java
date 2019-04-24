package web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dto.Styling;
import web.dto.StylingComment;
import web.dto.StylingLike;
import web.service.face.StylingService;

@Controller
public class StylingController {
	@Autowired StylingService stylingService;
	
	
	
//	스타일링 리스트 보기
	@RequestMapping (value = "/styling/list", method = RequestMethod.GET)
	public void StylingList(Model model) {
			
	}
//	스타일링 상세보기
	@RequestMapping(value = "/styling/view", method = RequestMethod.GET)
	public void StylingView(HttpSession session, Model model, int s_no, Styling styling) {
		
//		상세보기 페이지에서 보여질 좋아요 갯수
		int count;
//		댓글 리스트 뿌리기
		List<StylingComment> list;
		
	}
//	스타일링 좋아요
	@RequestMapping(value = "/styling/like", method = RequestMethod.POST)
	public String StylingLike(HttpSession session, Model model) {
		
		return "redirect:/styling/view";
	}
//	스타일링 선택
	@RequestMapping(value = "/styling/select", method = RequestMethod.GET)
	public void StylingSelect() {
		
	}
//	스타일링 댓글 입력
	@RequestMapping(value = "/styling/comment", method = RequestMethod.POST)
	public String StylingComment(HttpSession session, int s_no, StylingLike sLike) {
		
		return "redirect:/styling/view?s_no=\"+s_no;";
	}
//	컬렉션에 스타일링 추가하기
	@RequestMapping(value = "/styling/colInsert", method = RequestMethod.GET)
	public String CollectionInsert(int cs_no) {
		
		return "redirect:/styling/view";
	}
	
}
