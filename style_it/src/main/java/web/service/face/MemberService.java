package web.service.face;

import java.util.List;

import web.dto.Member;

public interface MemberService {

		// 로그인 리스트 얻어오기
		public List<Member> getLoginList();
		
		// 로그아웃 리스트 얻어오기
		public List<Member> getLogoutList();
		
		// 맴버 가입
		public void memberInsert(Member member);
		
		// 맴버 로그인
		public boolean memberLogin(Member member);
		
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

	public int checkjoin(Member member);


	// 로그인 된 멤버 정보 가져오기
	public Member getMember(Member member);


}
