package web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dto.Member;
import web.service.face.MemberService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberService memberService;
	
	
	@RequestMapping("/home")
	public void maingo() {
	}
//	회원가입
	@RequestMapping(value = "/member/join", method = RequestMethod.POST)
	public String join(Member member) {
		
		
		memberService.insertMember(member);
		
		return "redirect:/home";
	}
//	회원가입 중복처리
	@RequestMapping(value = "member/joincheck", method = RequestMethod.POST)
	public String joincheck(Member member, Model model) {
		
		int check = memberService.checkjoin(member);
		Map map = new HashMap();
		map.put("check", check);
		model.addAttribute(map);
		
		return "jsonView";
	}
	
	
//	로그인
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
//	로그아웃
	@RequestMapping(value = "/member/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/home";
	}
	
	
	
	
	
}
