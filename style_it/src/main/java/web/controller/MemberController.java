package web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value = "/member/join", method = RequestMethod.POST)
	public String join(Member member) {
		
		
		memberService.insertMember(member);
		
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String login(Member member, HttpSession session) {
		
		boolean login = memberService.loginMember(member);
		
		if(login==true) {
			session.setAttribute("login", login);
			return "redirect:/home";
		}else {
			return null;
		}
	}
	
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/home";
	}
	
}
