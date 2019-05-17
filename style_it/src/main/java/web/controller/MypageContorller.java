package web.controller;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


import web.dto.FileUpload;
import web.dto.Member;
import web.service.face.MypageService;

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
	@Autowired MypageService mypageService;	
	@Autowired ServletContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(MypageContorller.class);
	
//	마이페이지 이동
	@RequestMapping("/mypage/mypage")
	public void mypagego(Model model, Member member) {
		
//		회원정보 뿌리기
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
//		본인이 체크한 모든 좋아요 숫자 뿌리기
		int countLike = mypageService.getCoLike(member);
		model.addAttribute("countLike", countLike);
		
	}
//	현재 아이디 비밀번호 확인
	@RequestMapping(value = "/mypage/checkPass", method = RequestMethod.POST)
	public String checkPass(Member member, Model model) {
		
		int checkPass = mypageService.checkPass(member);
		Map map = new HashMap();
		map.put("checkPass", checkPass);
		model.addAttribute(map);
		return "jsonView";
	}
	
//	마이페이지 비밀번호 수정하기
	@RequestMapping(value = "/mypage/changepass", method = RequestMethod.POST)
	public String changePass(Member member, int m_no) {
		
		mypageService.changePass(member);
		
		return "redirect:/mypage/mypage?m_no="+m_no;
	}
//	마이페이지 nick 변경
	@RequestMapping(value = "/mypage/changenick", method = RequestMethod.POST)
	public String changeNick(Member member, int m_no) {
		
		mypageService.changeNick(member);
		
		return "redirect:/mypage/mypage?m_no="+m_no;
	}
//	마이페이지 프로필 사진 바꾸기
	@RequestMapping(value = "/mypage/insertImg", method = RequestMethod.POST )
	public String insertImg(Member member, FileUpload fu, int m_no, MultipartFile file, Model model) {
		
		
		logger.info("파일 업로드!");
		logger.info(file.getName());
		logger.info(file.getOriginalFilename());
		logger.info(String.valueOf(file.getSize()));
		logger.info(file.getContentType());
		logger.info(String.valueOf(file.isEmpty()));
		
//		고유한 식별자
		String uId = UUID.randomUUID().toString().split("-")[0];
		logger.info("uId : " + uId);
//		저장될 파일이름
		String fu_storedName = null;
		fu_storedName = file.getOriginalFilename()+"_"+uId;
//		파일이 저장될 경로
		String path = context.getRealPath("upload");
//		저장될 파일
		File dest = new File(path,fu_storedName);
		
		try {
			file.transferTo(dest); //업로드 파일을 dest에 저장함
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		fu.setFu_storedName(fu_storedName);
		
		
		
		logger.info(fu.toString());
//		다음번호 미리 가져와기
		int fu_no = mypageService.dualNo();
//		미리 가져온 번호 담아주고
		fu.setFu_no(fu_no);
		mypageService.insertImg(fu);
//		또 담아주고
		member.setFu_no(fu_no);
		mypageService.updateUserImg(member);
		
		
		return "redirect:/mypage/mypage?m_no="+m_no;
		
//		먼저 인서트하고 그다음에 유저 fu_no를 업데이트 해준다!
	}
	
//	회원탈퇴
	@RequestMapping(value = "/mypage/deleteUser", method = RequestMethod.POST)
	public String deleteUser(Member member, HttpSession session) {
		
		
		mypageService.deleteUser(member);
		session.invalidate();
		
		return "redirect:/home";
		
	}
	
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
	
  //퀴즈 항목 
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
	
  //작성한 퀴즈 값 저장
	@RequestMapping(value="/mypage/quiz", method=RequestMethod.POST)
	public String stylingQuizSubmit(MemberQuizSet mq, HttpSession session) {
		int m_no = (int) session.getAttribute("m_no");
		mq.setM_no(m_no);
		
		mypageService.saveMemberQuiz(mq);
		
		
		return "redirect:/mypage/quiz";
	}
	
	
	
	
	
}

