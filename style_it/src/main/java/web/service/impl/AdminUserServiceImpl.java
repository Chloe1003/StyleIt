package web.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.AdminUserDao;
import web.dto.Member;
import web.service.face.AdminUserService;
import web.util.Paging;

@Service
public class AdminUserServiceImpl implements AdminUserService {
	
	@Autowired AdminUserDao uDao;
	
	@Override
	public List<Member> getPagingMember(Paging paging) {
		return uDao.selectMember(paging);
	}

	@Override
	public int getCurPage(HttpServletRequest req) {

		//요청파라미터 curPage 받기
		String param = req.getParameter("curPage");
	
		//null이나 ""이 아니면 int로 리턴
		if( param != null && !"".equals(param) ) {
			int curPage = Integer.parseInt(param);
			return curPage;
		}
		//null이나 ""면 0으로 반환하기
		return 0;	
	}

	@Override
	public int getSearchedCount(String search) {
		return uDao.searchCnt(search);
	}

	@Override
	public List<Member> getSearchedList(HashMap<String, Object> searchMap) {
		return uDao.emailSearch(searchMap);
	}

	@Override
	public int getTotalCount() {
		return uDao.memberCnt();
	}

	@Override
	public void disableMember(int m_no) {
		uDao.disableMember(m_no);
	}

	@Override
	public void updateProfile(Member m) {
		uDao.userUpdate(m);
	}

	@Override
	public Member getUser(int m_no) {
		return uDao.selectUser(m_no);
	}

}
