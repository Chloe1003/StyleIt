package web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import web.dto.Member;
import web.service.face.AdminUserService;
import web.util.Paging;

@Controller
public class AdminUserController {
	
	private final Logger logger = LoggerFactory.getLogger(AdminUserController.class);
	@Autowired AdminUserService uServ;
	
	//회원관리 페이지
	@RequestMapping(value="/admin/user/list", method=RequestMethod.GET)
	public void adminUser(Model model, HttpServletRequest req, String search, 
			@RequestParam HashMap<String, Object> searchMap){
		
		int curPage = uServ.getCurPage(req);
		Paging paging;
		List<Member> mList;
		
		
		if(search!=null) {
			
			int totalCount = uServ.getSearchedCount(search);
			
			paging = new Paging (totalCount, curPage);
			
			searchMap.put("search", search);
			searchMap.put("paging", paging);
			
			mList = uServ.getSearchedList(searchMap);	
			
		} else {
			int totalCount = uServ.getTotalCount();
			
			paging = new Paging (totalCount, curPage);
			
			mList = uServ.getPagingMember(paging);
		}
		model.addAttribute("search", search);
		model.addAttribute("mList", mList);
		model.addAttribute("paging", paging);	
	}
	
	//회원 정보 가져오기
	@RequestMapping(value="/admin/user/profile")
	public String getUserProfile(int m_no, Model model) {
		Member m = uServ.getUser(m_no);
		
		Map map = new HashMap();
		
		map.put("m_no", m.getM_no());
		map.put("m_nick", m.getM_nick());
		map.put("m_email", m.getM_email());
		map.put("m_pw", m.getM_pw());
//		map.put("m_valid", m.getM_valid());
		
		model.addAllAttributes(map);
		
		return "jsonView";
		
	}
	
	//회원 정보 수정
	@RequestMapping(value="/admin/user/updateprofile", method=RequestMethod.POST)
	public String adminUserUpdateProfile(String m_nick, String m_pw, int m_no) {
		Member m = new Member();
		
		logger.info("비번"+m_pw);
		

		m.setM_no(m_no);
		m.setM_nick(m_nick);
		m.setM_pw(m_pw);
		
		uServ.updateProfile(m);	
		
		return "redirect:/admin/user/list";
	}
	
	
	//회원관리 작동
	@RequestMapping(value="/admin/user", method=RequestMethod.POST)
	public String adminUserProc(){
		
		return null;
	}
	
	//회원관리 수정
	@RequestMapping(value="/admin/user/update", method=RequestMethod.GET)
	public String adminUserUpdate(){
		
		return null;
	}
	
	//회원관리 정지
	@RequestMapping(value="/admin/user/disable", method=RequestMethod.POST)
	public String adminUserDisable(HttpServletRequest req){
		
		String checked[] = req.getParameterValues("checkedList");
		
		for(String mem_no : checked) {
			int m_no = Integer.parseInt(mem_no);
			uServ.disableMember(m_no);
		}
		
		return "redirect:/admin/user/list";
	}
}
