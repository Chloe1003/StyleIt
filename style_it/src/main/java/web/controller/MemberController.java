
package web.controller;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;

import web.dto.Follow;
import web.dto.Member;
import web.dto.Product;
import web.service.face.MemberService;
import web.service.face.MypageService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	@Autowired MemberService memberService;
	@Autowired MypageService mypageService;	
	
	@RequestMapping("/main")
	public void maingo() {
	}
//	회원가입
	@RequestMapping(value = "/member/join", method = RequestMethod.POST)
	public String join(Member member) {
		
		
		memberService.memberInsert(member);
		
		return "redirect:/main";
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
		
		return "redirect:/main";
	}
//  맴버 페이지 이동
	@RequestMapping (value = "/member/memberPage", method = RequestMethod.GET)
	public void LoginList(Model model, Member member, Follow f, HttpSession session, int m_no, @RequestParam HashMap<String, Object> map) {
		
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
		

//		팔로우 버튼~
		f.setFollowee_no((int) session.getAttribute("m_no"));
		f.setFollower_no(m_no);
		boolean folCheck = memberService.folCheck(f);
		model.addAttribute("folCheck", folCheck);
		System.out.println("============"+folCheck);
		
		member.setFollowee_no ((int) session.getAttribute("m_no"));
		member.setFollower_no(m_no);

//		멤버페이지에서 보는 팔로우 당한 리스트
		List<Member> memberfollowList = memberService.getFollowList(member); 
		model.addAttribute("memberfollowList", memberfollowList);
		
//		멤버페이지에서 보는 팔로잉 리스트
		List<Member> memberfollowingList = memberService.getFollowingList(member);
		model.addAttribute("memberfollowingList", memberfollowingList);
		
			
	}
	// 맴버 팔로우할때 + 마이페이지에서 언팔로우 할때.
	@RequestMapping(value = "/member/follow", method = RequestMethod.POST)
	public String followInsert(Follow f, HttpSession session, Model model, int m_no, @RequestParam HashMap<String, Object> map ) {
		
		f.setFollowee_no((int) session.getAttribute("m_no"));
		f.setFollower_no(m_no);
		
		System.out.println("팔로잉 할 사람 번호"+session.getAttribute("m_no"));
		System.out.println("팔로우 할 사람 번호"+m_no);
		
		boolean folCheck = memberService.folCheck(f);
		model.addAttribute("folCheck", folCheck);
		logger.info("--------------------- : " + folCheck);
		
		
		if(folCheck == false) {
			memberService.followInsert(f);
			
			Map map1 = new HashMap();
			map1.put("m_no", m_no);
			map1.put("folCheck", false);
			model.addAllAttributes(map1); 
			
			
			return "jsonView";
		}else {
			memberService.followDelete(f);
			Map map1 = new HashMap();
			map1.put("m_no", m_no);
			map1.put("folCheck", true);
			model.addAllAttributes(map1); 
			
			return "jsonView";
		}
		
//		팔로잉 할때 세션 아이디값을 followee에 넣고
//		follower 에는 현재 보고 있는 페이지의 유저 넘버를 넣어야함. 
	}
	
	// 나를 팔로우 해준 사람을 팔로우 할때 ( 맞팔로우..? )
	@RequestMapping(value = "/member/follow2", method = RequestMethod.POST)
	public String followEach(Follow f, HttpSession session, Model model, int m_no ) {
		
		f.setFollowee_no ((int) session.getAttribute("m_no"));
		f.setFollower_no(m_no);
		
		System.out.println("팔로잉 할 사람 번호"+session.getAttribute("m_no"));
		System.out.println("팔로우 할 사람 번호"+m_no);
		
		boolean folCheck_2 = memberService.folCheck_2(f);
		
		if(folCheck_2 == false) {
			memberService.followerInsert(f);
			
			Map map = new HashMap();
			map.put("m_no", m_no);
			map.put("folCheck_2", false);
			model.addAllAttributes(map); 
			
			
			return "jsonView";
		}else {
			memberService.followerDelete(f);
			Map map = new HashMap();
			map.put("m_no", m_no);
			map.put("folCheck_2", true);
			model.addAllAttributes(map); 
			
			return "jsonView";
		}
		
//		팔로잉 할때 세션 아이디값을 followee에 넣고
//		follower 에는 현재 보고 있는 페이지의 유저 넘버를 넣어야함. 
	}
//	멤버페이지에서 보는 멤버가 좋아요한 상품 리스트
	@RequestMapping(value = "/member/MemProductlikelist")
	public void MemberProLikeList(Model model, int m_no, Product p) {
		System.out.println("m_no은?"+m_no);
		List<Product> ProLikeList = mypageService.getMemProLikeList(m_no); // 실수로 마이페이지 서비스로 보내버림..
		model.addAttribute("ProLikeList", ProLikeList);
		
	}
//	멤버페이지에서 보는 멤버가 좋아요한 상품 리스트
	@RequestMapping(value = "/member/MemberStylingLikeList")
	public void MemberStylingLikeList(Model model, int m_no, Product p) {
		System.out.println("m_no은?"+m_no);
		List<Product> StylingLikeList = memberService.getMemberStylingLikeList(m_no); // 실수로 마이페이지 서비스로 보내버림..
		model.addAttribute("StylingLikeList", StylingLikeList);
		
	}
//	멤머페이지에서 보는 멤머가 만든 스타일링 리스트
	@RequestMapping(value = "/member/MemberStylingList")
	public void MemberStylingList(Model model, int m_no, Product p) {
		System.out.println("m_no은?"+m_no);
		List<Product> memberstylingList = memberService.getMemberStylingList(m_no); // 실수로 마이페이지 서비스로 보내버림..
		model.addAttribute("memberstylingList", memberstylingList);
		
	}
	
	
	
	
	
	
	// 맴버 스타일링 퀴즈 추가
	@RequestMapping(value = "/member/stylingquiz", method = RequestMethod.GET)
	public String stylingquizInsert(int qq_no) {
		
		return "redirect:/main";
	}

	
}

