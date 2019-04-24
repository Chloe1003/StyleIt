package web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.controller.ShopController;
import web.dao.face.AdminStyleQuizDao;
import web.service.face.AdminStyleQuizService;

@Service
public class AdminStyleQuizServiceImpl implements AdminStyleQuizService{
	
	private final Logger logger = LoggerFactory.getLogger(ShopController.class);
	@Autowired AdminStyleQuizDao adminStyleQuizDao;

}
