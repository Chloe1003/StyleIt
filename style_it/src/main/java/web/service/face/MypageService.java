package web.service.face;

import java.util.List;

import web.dto.FileUpload;
import web.dto.Member;

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
	public List getRecommendProduct();
	

	
	
	




	

	
	
}
