package web.dao.face;

import java.util.HashMap;
import java.util.List;

import web.dto.Follow;
import web.dto.Member;
import web.dto.Product;

public interface MemberDao {


	public void insertMember(Member member);

	public int loginMember(Member member);

	public int checkjoin(Member member);
	
	// 멤버 정보 가져오기
	public Member selectMember(Member member);
	
	// 팔로우 체크
	public int folCheck(Follow f);
	
	// 팔로우 쳌 2
	public int folCheck_2(Follow f);
	
	// 팔로우 추가
	public void followInsert(Follow f);
	
	// 팔로우 취소
	public void followDelete(Follow f);
	
	// 팔로워 추가
	public void followerInsert(Follow f);

	// 팔로워 삭제
	public void followerDelete(Follow f);
	
	// 멤버페이지에서 팔로잉 리스트
	public List<Member> getFollowingList(Member member);
	// 멤퍼페이지에서 팔로우 된 리스트
	public List<Member> getFollowList(Member member);

	// 스타일링퀴즈 추가
	public void stylingquizInsert(int qq_no);
	
	// 스타일링퀴즈 업데이트
	public void stylingquizUpdate(int qq_no);

	// 멤버가 만든 스타일링 리스트
	public List<Product> getMemberStylingList(int m_no);

	// 멤버가 좋아요한 좋아요 리스트
	public List<Product> getMemberStylingLikeList(int m_no);


	// m_no로 멤버 정보 가져오기
	public Member selectMemberByMno(int m_no);


	

	

	


	

	

	

	
	
	
	
	
	
	
	
	

}
