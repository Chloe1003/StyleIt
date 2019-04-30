package web.service.face;

import web.dto.Member;

public interface MemberService {

	public void insertMember(Member member);

	public boolean loginMember(Member member);

	public int checkjoin(Member member);

}
