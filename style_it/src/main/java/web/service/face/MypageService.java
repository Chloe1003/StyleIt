package web.service.face;

import java.util.HashMap;
import java.util.List;


import web.dto.FileUpload;
import web.dto.Follow;
import web.dto.Member;

import web.dto.Product;

import web.dto.MemberQuiz;
import web.dto.MemberQuizSet;
import web.dto.Message;
import web.dto.Product;
import web.dto.ProductBrand;
import web.dto.ProductCategory;
import web.dto.ProductColor;
import web.dto.ProductLike;
import web.dto.ProductOccasion;
import web.dto.ProductPattern;
import web.dto.ProductStyle;
import web.dto.QuizQuestion;
import web.dto.Styling;
import web.dto.StylingLike;


public interface MypageService {
	
//	유저 정보 조회
	public Member getUserInfo(Member member);
//	비밀번호 확인
	public int checkPass(Member member);
//	비밀번호 변경
	public void changePass(Member member);
//	nick 변경
	public void changeNick(Member member);
//고객 다음 사진 번호 받아오기
	public int dualNo();
//	프로필 사진 삽입
	public void insertImg(FileUpload fu);
//	유저 사진 업데이트
	public void updateUserImg(Member member);
//	회원 탈퇴
	public void deleteUser(Member member);
//	팔로우 숫자 뿌리기
	public int getFollower(Member member);
//	팔로잉 숫자 뿌리기
	public int getFollowee(Member member);
//	스타일링 숫자 뿌리기
	public int getCoStyling(Member member);
//	컬렉션 숫자 뿌리기
	public int getCoCollection(Member member);
//	본인이 체크한 모든 좋아요 수 
	public int getCoLike(Member member);
//	팔로우 리스트
	public List<Member> getFollowList(int m_no);
//	팔로잉 리스트
	public List<Member> getFollowingList(int m_no);
//	내가 좋아요 한 상품 리스트
	public List<Product> getProLikeList(int m_no);
//	내가 만든 스타일링 리스트
	public List<Product> getStylingList(int m_no);
//	유저가 좋아요 한 스타일링 리스트
	public List<Product> getStylingLikeList(int m_no);
//	유저가 좋아요 한 상품리스트
	public List<Product> getMemProLikeList(int m_no);
	
//	프로필 사진 세션에 넘김.
	public String getUserImg(String m_nick);
	
//	안일은 메세지 전체 수
	public int getCountAllRead(Message message);
	
	

//	추천받은 상품 리스트
	public List<Product> getRecommendProduct(MemberQuizSet mq);
	
//	작성된 스타일링 퀴즈 가져오기 
	public List<MemberQuiz> getMemberQuiz(int m_no);
	

	
//	스타일링 퀴즈 답변 가져오기
	public List<QuizQuestion> getStylingQuiz();
	public List<ProductBrand> getBrand();
	public List<ProductCategory> getCategory();
	public List<ProductColor> getColor();
	public List<ProductOccasion> getOccasion();
	public List<ProductPattern> getPattern();
	public List<ProductStyle> getStyle();
	
//	작성한 스타일링 퀴즈 저장하기
	public void saveMemberQuiz(MemberQuizSet mq);
	
//	멤버퀴즈 리스트를 멤버퀴즈셋 형태로 변경
	public MemberQuizSet transferToMemberQuizSet(List<MemberQuiz> answer);

	//---------yoon---------//
	
	//마이페이지 좋아요한 제품 리스트
	public List<ProductLike> getProductLikeList();
	
	//마이페이지 좋아요한 스타일링 리스트
	public List<StylingLike> getStylingLikeList();
	
	public List<Styling> getStylingList(int m_no);
	
	//마이페이지 내가 좋아요한 스타일링 수
	public int getCountStyling(int m_no);
	
	//마이페이지 내가 좋아요한 제품 수
	public int getCountProduct(int m_no);

		
	
}

