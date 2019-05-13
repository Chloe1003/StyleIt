
package web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dto.Follow;
import web.dto.Member;
import web.service.face.MemberService;
import web.service.face.MypageService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberService memberService;
	@Autowired MypageService mypageService;	
	
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
//  맴버 페이지 이동
	@RequestMapping (value = "/member/memberPage", method = RequestMethod.GET)
	public void LoginList(Model model, Member member) {
		
		model.addAttribute("mypage", mypageService.getUserInfo(member));
//		팔로우 숫자 뿌리기
		int countFollower = mypageService.getFollower(member);
		model.addAttribute("countFollower", countFollower);
//		팔로잉 숫자 뿌리기
		int countFollowee = mypageService.getFollowee(member);
		model.addAttribute("countFollowee", countFollowee);
//		본인이 만든 스타일링 숫자 뿌리기
		int countStyling = mypageService.getCoStyling(member);
		model.addAttribute("countStyling", countStyling);
//		본인이 만든 컬렉션 숫자 뿌리기
		int countCollection = mypageService.getCoCollection(member);
		model.addAttribute("countCollection", countCollection);
//		본인이 체크한 모든 좋아요 숫자 뿌리기 -> 이건 문제있음 체크해야함
		int countLike = mypageService.getCoLike(member);
		model.addAttribute("countLike", countLike);
			
	}
	// 맴버 팔로우
	@RequestMapping(value = "/member/follow", method = RequestMethod.POST)
	public String followInsert(Follow f, HttpSession session, Model model, int follower_no ) {
		
		f.setFollowee_no ((int) session.getAttribute("m_no"));
		f.setFollower_no(follower_no);
		
		boolean folCheck = memberService.folCheck(f);
		
		if(folCheck == false) {
			memberService.followInsert(f);
			
			Map map = new HashMap();
			map.put("follower_no", follower_no);
			
			model.addAllAttributes(map); 
			
			
			return "jsonView";
		}else {
			memberService.followDelete(f);
			Map map = new HashMap();
			map.put("follower_no", follower_no);
			model.addAllAttributes(map); 
			
			return "jsonView";
		}
		
		
		
		
//		팔로잉 할때 세션 아이디값을 followee에 넣고
//		follower 에는 현재 보고 있는 페이지의 유저 넘버를 넣어야함. 
		
		
	}
	
	// 맴버 스타일링 퀴즈 추가
	@RequestMapping(value = "/member/stylingquiz", method = RequestMethod.GET)
	public String stylingquizInsert(int qq_no) {
		
		return "redirect:/main";
	}

	
}

