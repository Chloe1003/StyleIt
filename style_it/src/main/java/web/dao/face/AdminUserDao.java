package web.dao.face;

import java.util.List;

import web.dto.Member;

public interface AdminUserDao {

	//회원관리 리스트 조회
	public List<Member> getSearchList();
	
	//회원관리 수정
	public Member userUpdate();
	
	//회원관리 비활성화
	public Member userDisable();

}