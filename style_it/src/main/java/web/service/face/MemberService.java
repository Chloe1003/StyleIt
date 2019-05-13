package web.service.face;

import java.util.List;

import web.dto.Follow;
import web.dto.Member;

public interface MemberService {

		
		// 맴버 가입
		public void memberInsert(Member member);
		
		// 맴버 로그인
		public boolean memberLogin(Member member);
		
		// 회원가입 체크용
		public int checkjoin(Member member);

		// 로그인 된 멤버 정보 가져오기
		public Member getMember(Member member);
		
		// m_no로 멤버 정보 가져오기
		public Member getMemberByMno(int m_no);

		// 팔로우 체크용
		public boolean folCheck(Follow f);
		
		// 팔로우 추가
		public void followInsert(Follow f);
		
		// 팔로우 취소
		public void followDelete(Follow f);
		
		
		
		
		// 스타일링퀴즈 추가
		public void stylingquizInsert(int qq_no);
				
		// 스타일링퀴즈 업데이트
		public void stylingquizUpdate(int qq_no);

		

		
						


}
