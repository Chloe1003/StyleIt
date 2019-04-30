package web.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.service.face.FeedService;

@Controller
public class FeedController {

//	@Autowired FeedService fServ;
	private static final Logger logger=LoggerFactory.getLogger(FeedController.class);
	
	// feed 좋아요순 리스트 반환
	@RequestMapping(value="/feed/list")
	public void feedList(Model model) {

	}
	
	// feed 팔로우한 사용자 리스트 반환
	@RequestMapping(value="/feed/follow")
	public void followFeedList(HttpSession session, Model model) {
	
	}
	
	// 제품 좋아요 추가
	@RequestMapping(value="/feed/plike")
	public void addProductLike(HttpSession session, int p_no, @RequestParam HashMap<String, Integer> map) {
		
	}
	
	// 스타일링 좋아요 추가
	@RequestMapping(value="/feed/slike")
	public void addStylingLike(HttpSession session, int s_no) {
		
	}
	
	// 제품 좋아요 취소
	@RequestMapping(value="/feed/plikedelete")
	public void deleteProductLike(int plike_no) {
		
	}
	
	// 스타일링 좋아요 취소
	@RequestMapping(value="/feed/slikedelete")
	public void deleteStylingLike(int slike_no) {
		
	}
	
	// 컬렉션에 추가
	@RequestMapping(value="/feed/addtocollection")
	public void addToCollection(HttpSession session, int cf_no, int c_no, int s_no, int p_no, @RequestParam HashMap<String, Integer> map) {
	
	}
}
