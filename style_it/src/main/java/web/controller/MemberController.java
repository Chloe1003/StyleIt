package web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dto.Member;
import web.service.face.MemberService;

@Controller
public class MemberController {
	
	@Autowired MemberService memberService;
	
	
	@RequestMapping("/home")
	public void maingo() {
	}
	
	// 맴버 가입
	@RequestMapping(value = "/member/join", method = RequestMethod.POST)
	public String join(Member member) {
		
		
		memberService.memberInsert(member);
		
		return "redirect:/home";
	}
	
	// 맴버 로그인
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String login(Member member, HttpSession session) {
		
		boolean login = memberService.memberLogin(member);
		
		if(login==true) {
			session.setAttribute("login", login);
			return "redirect:/home";
		}else {
			return null;
		}
	}
	
	// 맴버 로그아웃
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/home";
	}
	
	// 맴버 리스트 보기
	@RequestMapping (value = "/member/list", method = RequestMethod.GET)
	public void LoginList(Model model) {
			
	}
	
	// 맴버 팔로우
	@RequestMapping(value = "/member/follow", method = RequestMethod.POST)
	public String followInsert(HttpSession session, Model model) {
		
		return null;
	}
	
	// 맴버 스타일링 퀴즈 추가
	@RequestMapping(value = "/member/stylingquiz", method = RequestMethod.GET)
	public String stylingquizInsert(int qq_no) {
		
		return "redirect:/home";
	}
	
}
