package web.dao.face;

import web.dto.Member;

public interface MemberDao {

	public void insertMember(Member member);

	public int loginMember(Member member);

}
