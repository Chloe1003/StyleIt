package web.dao.face;

import java.util.List;

import web.dto.Member;

public interface MemberDao {


	public void insertMember(Member member);

	public int loginMember(Member member);

	public int checkjoin(Member member);

	
	// 맴버 탈퇴 업데이트
	public void memberUpdate(int m_no);
	
	// 맴버 정보 수정 업데이트
	public void memberinfoUpdate(int m_no);
	
	// 팔로우 추가
	public void followInsert(int f_no);
	
	// 팔로우 취소
	public void followDelete(int f_no);
	
	// 스타일링퀴즈 추가
	public void stylingquizInsert(int qq_no);
	
	// 스타일링퀴즈 업데이트
	public void stylingquizUpdate(int qq_no);


	// 멤버 정보 가져오기
	public Member selectMember(Member member);

	
	
	
	
	
	
	
	
	
	

}
