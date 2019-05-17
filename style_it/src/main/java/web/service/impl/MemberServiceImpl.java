package web.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.MemberDao;
import web.dto.Follow;
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
	
	@Override
	public boolean folCheck(Follow f) {

		if(memberDao.folCheck(f) == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public boolean folCheck_2(Follow f) {
		
		if(memberDao.folCheck_2(f) == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public void followInsert(Follow f) {
		memberDao.followInsert(f);
		
	}

	@Override
	public void followDelete(Follow f) {
		memberDao.followDelete(f);
	}
	
	
	@Override
	public void followerInsert(Follow f) {
		memberDao.followerInsert(f);
		
	}

	@Override
	public void followerDelete(Follow f) {
		memberDao.followerDelete(f);
		
	}
	
	@Override
	public List<Member> getFollowingList(Member member) {
		return memberDao.getFollowingList(member);
	}


	@Override
	public List<Member> getFollowList(Member member) {
		return memberDao.getFollowList(member);
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


	@Override
	public Member getMemberByMno(int m_no) {
		return memberDao.selectMemberByMno(m_no);
	}

	
	

	


}
