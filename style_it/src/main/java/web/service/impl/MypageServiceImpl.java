package web.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.MypageDao;

import web.dto.FileUpload;
import web.dto.Follow;
import web.dto.Member;
import web.dto.MemberQuiz;
import web.dto.Product;
import web.service.face.MypageService;

@Service
public class MypageServiceImpl implements MypageService{
	
	@Autowired MypageDao mypageDao;
//	유저 정보 조회
	@Override
	public Member getUserInfo(Member member) {
		return mypageDao.getUserInfo(member);
	}
//	비밀번호 확인
	@Override
	public int checkPass(Member member) {
		if( mypageDao.checkPass(member) == 1) {
			return 1;
		}else {
			return 0;
		}
		
	}
//	비밀번호 변경
	@Override
	public void changePass(Member member) {
		mypageDao.changePass(member);
	}
//	nick 변경
	@Override
	public void changeNick(Member member) {
		mypageDao.changeNick(member);
	}
//	프로필 사진 삽입
	@Override
	public void insertImg(FileUpload fu) {
		mypageDao.insertImg(fu);
	}
//	유저 사진 업데이트
	@Override
	public void updateUserImg(Member member) {
		mypageDao.updateUserImg(member);
	}
//	고객 다음 사진 번호 받아오기
	@Override
	public int dualNo() {
		
		return mypageDao.dualNo();
	}
//	회원 탈퇴
	@Override
	public void deleteUser(Member member) {
		 mypageDao.deleteUser(member);
	}
//	팔로우 숫자 뿌리기
	@Override
	public int getFollower(Member member) {
		return mypageDao.getFollower(member);
	}
//	팔로잉 숫자 뿌리기
	@Override
	public int getFollowee(Member member) {
		return mypageDao.getFollowee(member);
	}
//	스타일링 숫자 뿌리기
	@Override
	public int getCoStyling(Member member) {
		return mypageDao.getCoStyling(member);
	}
//	컬렉션 숫자 뿌리기
	@Override
	public int getCoCollection(Member member) {
		return mypageDao.getCoCollection(member);
	}
//	본인이 체크한 모든 좋아요 수 
	@Override
	public int getCoLike(Member member) {
		return mypageDao.getCoLike(member);
	}
//	팔로우 리스트
	@Override
	public List<Member> getFollowList(int m_no) {
		return mypageDao.getFollowList(m_no);
	}
//	팔로잉 리스트
	@Override
	public List<Member> getFollowingList(int m_no) {
		return mypageDao.getFollowingList(m_no);
	}
//	내가 좋아요한 상품 리스트
	@Override
	public List<Product> getProLikeList(int m_no) {
		return mypageDao.getProLikeList(m_no);
	}
//	유저가 좋아요한 상품 리스트
	@Override
	public List<Product> getMemProLikeList(int m_no) {
		return mypageDao.getMemProLikeList(m_no);
	}
	
	
	
	
	
	@Override
	public List getFollowingList() {
		return mypageDao.getFollowingList();
	}

	@Override
	public List getStylieLikeList() {
		return mypageDao.getStylieLikeList();
	}

	@Override
	public void removeStylieList() {
		mypageDao.removeStylieList();
	}

	@Override
	public List getCollectionLikeList() {
		return mypageDao.getCollectionLikeList();
	}

	@Override
	public void removeCollectionList() {
		mypageDao.removeCollectionList();
	}

	@Override
	public List getProdurctLikeList() {
		return mypageDao.getProdurctLikeList();
	}

	@Override
	public void removeProductLike() {
		mypageDao.removeProductLike();
	}

	@Override
	public List getMypageStyling() {
		return mypageDao.getMypageStyling();
	}

	@Override
	public void insertStyling() {
		mypageDao.insertStyling();
	}

	@Override
	public void updateStyling() {
		mypageDao.updateStyling();
	}

	@Override
	public void deleteStyling() {
		mypageDao.deleteStyling();
	}

	@Override
	public List getMypageCollection() {
		return mypageDao.getMypageCollection();
	}

	@Override
	public void insertCollection() {
		mypageDao.insertCollection();
	}

	@Override
	public void updateCollection() {
		mypageDao.updateCollection();
	}

	@Override
	public void deleteCollection() {
		mypageDao.deleteCollection();
	}

	@Override
	public List<Product> getRecommendProduct(int m_no) {
		
		List<MemberQuiz> mq = mypageDao.selectMemberQuiz(m_no);
		
		
		
		return null;
	}
	

	


	
	
	
	



	
}
