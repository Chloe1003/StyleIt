package web.dao.face;

import java.util.HashMap;
import java.util.List;


import web.dto.FileUpload;
import web.dto.Follow;
import web.dto.Member;

import web.dto.MemberQuiz;
import web.dto.Product;

import web.dto.ProductLike;

import web.dto.MemberQuiz;
import web.dto.MemberQuizSet;
import web.dto.Message;
import web.dto.Product;
import web.dto.ProductBrand;
import web.dto.ProductCategory;
import web.dto.ProductColor;
import web.dto.ProductOccasion;
import web.dto.ProductPattern;
import web.dto.ProductStyle;
import web.dto.QuizQuestion;
import web.dto.Styling;
import web.dto.StylingLike;

public interface MypageDao {
	
//	유저 정보 가져오기
	public Member getUserInfo(Member member);
//	비밀번호 확인하기
	public int checkPass(Member member);
//	비밀번호 변경하기
	public void changePass(Member member);
//	nick 변경
	public void changeNick(Member member);
//고객 다음 사진 번호 받아오기
	public int dualNo();
//	프로필 사진 삽입
	public void insertImg(FileUpload fu);
//	유저 사진 바꾸기
	public void updateUserImg(Member member);
//	유저 탈퇴 하기
	public void deleteUser(Member member);
//	팔로우 숫자 뿌리기
	public int getFollower(Member member);
//	팔로잉 숫자 뿌리기
	public int getFollowee(Member member);
//	스타일링 숫자 뿌리기
	public int getCoStyling(Member member);
//	컬렉션 숫자 뿌리기
	public int getCoCollection(Member member);
//	체크한 모든 좋아요 숫자
	public int getCoLike(Member member);
//	팔로우 리스트
	public List<Member> getFollowList(int m_no);
//	팔로잉 리스트
	public List<Member> getFollowingList(int m_no);
//	좋아요한 상품 리스트
	public List<Product> getProLikeList(int m_no);
//	유저가 좋아요 한 상품 리스트
	public List<Product> getMemProLikeList(int m_no);
//  유저가 좋아요한 스타일링 리스트
	public List<Product> getStylingLikeList(int m_no);
//	유저가 만든 스타일링 리스트
	public List<Product> getStylingList(int m_no);
//	프로필 사진 세션에 넘기기(채팅창에 뜨기 위함)
	public String getUserImg(String m_nick);
//	안읽은 메세지 전체 카운트
	public int getCountAllRead(Message message);
	
	
	
	
  
//	제품 좋아요 리스트 가져오기
	public String selectProductLike(int m_no);
	
//	멤버 번호로 작성된 스타일링 퀴즈 가져오기
	public List<MemberQuiz> selectMemberQuiz(int m_no);
	
//	스타일링 퀴즈 가져오기
	public List<QuizQuestion> selectStylingQuiz();
	
//	스타일링 퀴즈 답변 가져오기
	public List<ProductBrand> selectBrand();		
	public List<ProductCategory> selectCategory();
	public List<ProductColor> selectColor();
	public List<ProductOccasion> selectOccasion();
	public List<ProductPattern> selectPattern();
	public List<ProductStyle> selectStyle();
	
//	작성한 스타일링 퀴즈 내역 삽입
//	public void insertMemberQuiz(MemberQuizSet mq);
	
	public void insertMemberQuizGender(MemberQuizSet mq);
	public void insertMemberQuizCategory(HashMap<String, Integer> map);
	public void insertMemberQuizColor(HashMap<String, Integer> map);
	public void insertMemberQuizBrand(HashMap<String, Integer> map);
	public void insertMemberQuizOccasion(HashMap<String, Integer> map);
	public void insertMemberQuizStyle(HashMap<String, Integer> map);
	public void insertMemberQuizPattern(HashMap<String, Integer> map);
	public void insertMemberQuizLprice(MemberQuizSet mq);
	public void insertMemberQuizHprice(MemberQuizSet mq);

//	추천 상품 리스트 가져오기
	public List<Product> selectRecommendProduct(MemberQuizSet mq);
	
	//---------yoon---------//
	
	//제품 좋아요 리스트 가져오기
	public List<ProductLike> getProductLikeList();
	
	//스타일링 좋아요 리스트 가져오기
	public List<StylingLike> getStylingLikeList();
	
	public List<Styling> getStylingList(int m_no);
	
	//마이페이지 내가 좋아요한 스타일링 수
	public int selectCountStyling(int m_no);
	
	//마이페이지 내가 좋아요한 제품 수
	public int selectCountProduct(int m_no);
	
	
	
	
	
	
	
	
	
	
	
	
	

}

