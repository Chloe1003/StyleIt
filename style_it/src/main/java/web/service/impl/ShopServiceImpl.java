package web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.controller.ShopController;
import web.dao.face.ShopDao;
import web.service.face.ShopService;

@Service
public class ShopServiceImpl implements ShopService{
	
	private final Logger logger = LoggerFactory.getLogger(ShopController.class);
	@Autowired ShopDao shopDao;

}
