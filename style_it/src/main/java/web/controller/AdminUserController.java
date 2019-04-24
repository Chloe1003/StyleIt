package web.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.service.face.AdminUserService;
import web.util.Paging;

@Controller
public class AdminUserController {
	
	private final Logger logger = LoggerFactory.getLogger(ShopController.class);
	@Autowired AdminUserService adminUserService;
	
	//회원관리 페이지
	@RequestMapping(value="/admin/user", method=RequestMethod.GET)
	public void adminUser(Model model, Paging paging, HashMap<String, Object> map, 
			HttpServletRequest req){}
	
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
	@RequestMapping(value="/admin/user/disable", method=RequestMethod.GET)
	public String adminUserDisable(){
		
		return null;
	}
}
