package web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dto.MemberQuiz;
import web.dto.MemberQuizSet;
import web.dto.Product;
import web.dto.ProductBrand;
import web.dto.ProductCategory;
import web.dto.ProductColor;
import web.dto.ProductOccasion;
import web.dto.ProductPattern;
import web.dto.ProductStyle;
import web.dto.QuizQuestion;
import web.service.face.MypageService;

@Controller
public class MypageContorller {
	
	private final Logger logger = LoggerFactory.getLogger(MypageContorller.class);
	@Autowired MypageService mypageService;	
	
//	팔로우 리스트
	@RequestMapping(value = "/mypage/followlist")
	public void FollowList(Model model) {
	}
//	팔로잉 리스트
	@RequestMapping(value = "/mypage/followinglist")
	public String FollowingList(Model model) {
		return null;
	}
//	마이페이지에서 보는 본인이 체크한 모든 좋아요 리스트
	@RequestMapping(value = "/mypage/alllikelist")
	public void AllLikeList(Model model) {
		
	}
//	본인이 만든 모든 스타일링리스트
	@RequestMapping(value = "/mypage/stylinglist")
	public void MypageStylingList(Model model) {
		
	}
//	스타일링 작성 수정 삭제 
	@RequestMapping(value = "/mypage/styling")
	public String MypageStyling(HttpSession session, Model model) {
		
		return null;
	}
//	본인이 만든 모든 컬렉션리스트
	@RequestMapping(value = "/mypage/allcollectionlist")
	public void AllCollectionList(Model model) {
		
	}
//	컬렉션 작성 수정 삭제 
	@RequestMapping(value = "/mypage/collection")
	public String MypageCollection(HttpSession session, Model model) {
		
		return null;
	}
	
//	추천받은 제품 리스트
	@RequestMapping(value = "/mypage/recommend")
	public void recommendProduct(HttpSession session, Model model) {
		int m_no = (int) session.getAttribute("m_no");

//		스타일링 퀴즈 답변 가져오기
		List<MemberQuiz> answer = mypageService.getMemberQuiz(m_no);
		
		List<Product> rList = new ArrayList<>();
		
		if(answer!=null) {
			
			MemberQuizSet mqs = mypageService.transferToMemberQuizSet(answer);
			mqs.setM_no(m_no);
			
			logger.info(mqs.toString());		
			
			rList = mypageService.getRecommendProduct(mqs);
		}
		
		model.addAttribute("rList", rList);
		
	}
	
	@RequestMapping(value="/mypage/quiz", method=RequestMethod.GET)
	public void stylingQuizForm(Model model) {
		
		List<QuizQuestion> quiz = mypageService.getStylingQuiz();
		List<ProductBrand> brand = mypageService.getBrand();
		List<ProductCategory> category = mypageService.getCategory();
 		List<ProductColor> color = mypageService.getColor();
		List<ProductOccasion> occasion = mypageService.getOccasion();
		List<ProductPattern> pattern = mypageService.getPattern();
		List<ProductStyle> style = mypageService.getStyle();
		
		model.addAttribute("qSet", quiz);
		model.addAttribute("brand", brand);
		model.addAttribute("category", category);
		model.addAttribute("color", color);
		model.addAttribute("occasion", occasion);
		model.addAttribute("pattern", pattern);
		model.addAttribute("style", style);
		
	}
	
	@RequestMapping(value="/mypage/quiz", method=RequestMethod.POST)
	public String stylingQuizSubmit(MemberQuizSet mq, HttpSession session) {
		int m_no = (int) session.getAttribute("m_no");
		mq.setM_no(m_no);
		
		mypageService.saveMemberQuiz(mq);
		
		
		return "redirect:/mypage/quiz";
	}
	
	
	
	
}
