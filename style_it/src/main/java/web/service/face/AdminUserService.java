package web.service.face;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import web.dto.Member;
import web.util.Paging;

public interface AdminUserService {

//	페이징 처리된 멤버 리스트 가져오기
	public List<Member> getPagingMember(Paging paging);
	
	// 현재페이지 반환
	public int getCurPage(HttpServletRequest req);

	// 검색된 회원 수 얻기
	public int getSearchedCount(String search);

	// 이메일 검색 회원 반환
	public List<Member> getSearchedList(HashMap<String, Object> searchMap);

	//총 회원 수 얻기
	public int getTotalCount();

	//멤버 비활성화
	public void disableMember(int m_no);

	//멤버 프로필 변경
	public void updateProfile(Member m);

	//멤버 정보 가져오기
	public Member getUser(int m_no);

//	//회원관리 리스트
//	public List<Member> selectSerachList();
//	
//	//회원관리 수정
//	public void userUpdate(Member member);
//	
//	//회원관리 비활성화
//	public void userDisable(Member member);
}
