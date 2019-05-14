package web.service.face;

import java.util.HashMap;
import java.util.List;

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

public interface MypageService {
	
//	팔로우 리스트
	public List getFollowList();
//	팔로잉 리스트
	public List getFollowingList();
	
//	본인이 좋아요한 스타일 리스트
	public List getStylieLikeList();
//	마이페이지에서 삭제할 좋아요한 스타일 리스트
	public void removeStylieList();
	
//	본인이 좋아요한 컬렉션 리스트
	public List getCollectionLikeList();
//	마이페이지에서 삭제할 좋아요한 컬렉션 리스트
	public void removeCollectionList();
	
//	본인이 좋아요한 상품 리스트
	public List getProdurctLikeList();
//	마이페이지에서 삭제할 좋아요한 상품 리스트
	public void removeProductLike();
	
//	본인이 작성한 스타일링 리스트
	public List getMypageStyling();
//	스타일링 작성
	public void insertStyling();
//	스타일링 수정
	public void updateStyling();
//	스타일링 삭제
	public void deleteStyling();
	
//	본인이 작성한 컬렉션 리스트
	public List getMypageCollection();
//	컬렉션 작성
	public void insertCollection();
//	컬렉션 수정
	public void updateCollection();
//	컬렉션 삭제
	public void deleteCollection();
	
//	추천받은 상품 리스트
	public List<Product> getRecommendProduct(int m_no);
	
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
	


	
	
	
}
