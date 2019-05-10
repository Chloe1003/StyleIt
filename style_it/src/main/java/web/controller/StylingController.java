package web.controller;

import java.io.IOException;
import java.io.Writer;
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

import web.dto.Member;
import web.dto.Product;
import web.dto.Styling;
import web.dto.StylingLike;
import web.service.face.MemberService;
import web.service.face.StylingService;

@Controller
public class StylingController {
	private static final Logger logger=LoggerFactory.getLogger(StylingController.class);

	@Autowired StylingService sServ;
	@Autowired MemberService mServ;
	
	//스타일링 작성 페이지
	@RequestMapping(value="/styling/create", method=RequestMethod.GET)
	public void styling() {
		
	}
	
	// 스타일링 태그 리스트 페이지
	@RequestMapping(value="/styling/tag")
	public void stylingTag(Model model) {
		model.addAttribute("stylingTag", sServ.getStylingTag());
	}
	
//	스타일링 리스트 보기
	@RequestMapping (value = "/styling/list")
	public void StylingList(HttpSession session , 
			@RequestParam HashMap<String, Integer> map, Model model, int st_no) {
		
		boolean login = false;
		
		try {
			
			if(session.getAttribute("login") != null) {
				login = (boolean) session.getAttribute("login");
			}
			
		} catch (Exception e) {
			
		}
		
		
		if (login==true) { // 로그인 되어 있을 때
			
			logger.info("login true");
			
			int m_no = (int) session.getAttribute("m_no");
						
			map.put("m_no", m_no);
			map.put("st_no", st_no);	
			
			model.addAttribute("stylingList", sServ.getStylingList(map));	
		
		} else { // 로그인 안되어 있을 때
			logger.info("login false");

			model.addAttribute("stylingList", sServ.getStylingListNoLogin(st_no));
			
		}
		
	}
//	스타일링 상세보기
	@RequestMapping(value = "/styling/view", method = RequestMethod.GET)
	public void StylingView(HttpSession session, Model model, int s_no,
			@RequestParam HashMap<String, Integer> map) {
		
		boolean login = false;
		
		try {
			
			if(session.getAttribute("login") != null) {
				login = (boolean) session.getAttribute("login");
			}
			
		} catch (Exception e) {
			
		}
		
		if (login==true) { // 로그인 되어 있을 때
			
			int m_no = (int) session.getAttribute("m_no");
						
			map.put("m_no", m_no);
			map.put("s_no", s_no);
			
			Styling s = sServ.getStylingView(map);
			int make = s.getM_no();
			Member maker = mServ.getMemberByMno(make);			
			
			List<Product> pList = sServ.getProductByStyling(map);

			model.addAttribute("styling", s);	
			model.addAttribute("maker", maker);
			model.addAttribute("product", pList);
			
		} else { // 로그인 안되어 있을 때
			logger.info("login false");

			Styling s = sServ.getStylingViewNoLogin(s_no);
			int make = s.getM_no();
			Member maker = mServ.getMemberByMno(make);
			
			model.addAttribute("styling", s);
			model.addAttribute("maker", maker);
			model.addAttribute("product", sServ.getProductByStylingNoLogin(s_no));

		}

	}
//	스타일링 좋아요
	@RequestMapping(value = "/styling/like", method = RequestMethod.GET)
	public void StylingLike(int s_no, HttpSession session, 
			@RequestParam HashMap<String, Object> like, Writer out) {
		
		logger.info("좋아요");

		int m_no = (int) session.getAttribute("m_no");
		
		like.put("m_no", m_no);
		like.put("s_no", s_no);
		
		sServ.sLikeUpdate(like);
		
		logger.info("업데이트 완료");
		
		try {
			out.write("{\"cnt\" :"+ sServ.slikeCnt(s_no)+", \"check\" :"+sServ.slikeCheck(like)+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}

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
