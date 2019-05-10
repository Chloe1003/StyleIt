
package web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		
		
		memberService.memberInsert(member);
		
		return "redirect:/home";
	}
//	회원가입 중복처리
	@RequestMapping(value = "/member/joincheck", method = RequestMethod.POST)
	public String joincheck(Member member, Model model) {
		
		int check = memberService.checkjoin(member);
		Map map = new HashMap();
		map.put("check", check);
		model.addAttribute(map);
		
		return "jsonView";
	}
	

	
//	로그인


	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String login(Member member, HttpSession session, Model model, HttpServletRequest req) {
		
		boolean login = memberService.memberLogin(member);
		
		String m_email = req.getParameter("m_email");
		String m_pw = req.getParameter("m_pw");
		
		Member m = new Member();
		
		m.setM_email(m_email);
		m.setM_pw(m_pw);
		
		m = memberService.getMember(m);
		
		Map map = new HashMap();
		
		if(login==true) {
			
			session.setAttribute("login", true);

			session.setAttribute("m_no", m.getM_no());
			session.setAttribute("m_email", m.getM_email());
			session.setAttribute("m_pw", m.getM_pw());
			session.setAttribute("m_nick", m.getM_nick());
			
			
//			map.put("login", true);
			model.addAttribute("login", true);
			return "jsonView";


		}else {
//			map.put("login", false);
			model.addAttribute("login", "님은 실패");
			
			return "jsonView";
		}
	}

//	로그아웃


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
		
		return "redirect:/main";
	}

	
}

