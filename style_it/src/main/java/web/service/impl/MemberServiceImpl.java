package web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.MemberDao;
import web.dto.Member;
import web.service.face.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired MemberDao memberDao;	
	
	@Override
	public void insertMember(Member member) {
		
		memberDao.insertMember(member);
	}

	@Override
	public boolean loginMember(Member member) {
		
		if(memberDao.loginMember(member)==1) {
			return true;
		}else {
			return false;
		}
		
		
	}

	@Override
	public int checkjoin(Member member) {
		
		if(memberDao.checkjoin(member) == 1) {
			return 0;
		}else {
			return 1;
		}
	}

}
