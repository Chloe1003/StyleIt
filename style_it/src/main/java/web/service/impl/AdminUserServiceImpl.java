package web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.controller.ShopController;
import web.dao.face.AdminUserDao;
import web.service.face.AdminUserService;

@Service
public class AdminUserServiceImpl implements AdminUserService {
	
	private final Logger logger = LoggerFactory.getLogger(ShopController.class);
	@Autowired AdminUserDao adminUserDao;

}
