package web.dao.face;

import java.util.HashMap;
import java.util.List;

import web.dto.Member;
import web.util.Paging;

public interface AdminUserDao {

	//회원정보 수정
	public void userUpdate(Member m);
	
	//회원관리 비활성화
	public void disableMember(int m_no);

	
	// 총 멤버 수 반환
	public int memberCnt();

	// 페이징 처리된 멤버 리스트 전체 조회
	public List<Member> selectMember(Paging paging);

	// 검색된 멤버 수 반환
	public int searchCnt(String search);

	// 페이징 처리된 이메일 검색 멤버 리스트 조회
	public List<Member> emailSearch(HashMap<String, Object> searchMap);

	//멤버 정보 가져오기
	public Member selectUser(int m_no);

}