package web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.MemberDao;
import web.dto.Member;
import web.service.face.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired MemberDao memberDao;	
	
	@Override
	public void memberInsert (Member member) {
		
		memberDao.insertMember(member);
	}

	@Override
	public boolean memberLogin(Member member) {
		
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
	
	public List<Member> getLoginList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> getLogoutList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void memberUpdate(int m_no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void memberinfoUpdate(int m_no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void followInsert(int f_no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void followDelete(int f_no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stylingquizInsert(int qq_no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stylingquizUpdate(int qq_no) {
		// TODO Auto-generated method stub
		

	}


	@Override
	public Member getMember(Member member) {

		return memberDao.selectMember(member);
	}


}
