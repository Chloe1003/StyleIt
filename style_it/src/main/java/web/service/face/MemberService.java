package web.service.face;

import java.util.HashMap;
import java.util.List;

import web.dto.Follow;
import web.dto.Member;
import web.dto.Product;

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
		
		// 나를 팔로우 해준 사람을 팔로우 할때
		public boolean folCheck_2(Follow f);
		
		// 멤퍼 페이지 팔로잉 리스트
		public List<Member> getFollowingList(Member member);
		
		// 멤퍼페이지 팔로우 된 리스트
		public List<Member> getFollowList(Member member);
		
		// 팔로우 추가
		public void followInsert(Follow f);
		
		// 팔로우 취소
		public void followDelete(Follow f);
		
		// 팔로워 추가
		public void followerInsert(Follow f);
		
		// 팔로워 삭제
		public void followerDelete(Follow f);
		
		
		// 스타일링퀴즈 추가
		public void stylingquizInsert(int qq_no);
				
		// 스타일링퀴즈 업데이트
		public void stylingquizUpdate(int qq_no);

		// 멤버가 만든 스타일링
		public List<Product> getMemberStylingList(HashMap<String, Object> map);
		
		// 멤버가 좋아요한 스타일링 리스트
		public List<Product> getMemberStylingLikeList(HashMap<String, Object> map);

		

	

		

		

		

		

		
						


}
