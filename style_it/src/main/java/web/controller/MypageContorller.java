package web.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import web.service.face.MypageService;

@Controller
public class MypageContorller {
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
	public void RecommendProduct(HttpSession session, Model model) {
		int m_no = (int) session.getAttribute("m_no");

		
		
		
	}
	
	
	
	
	
}
