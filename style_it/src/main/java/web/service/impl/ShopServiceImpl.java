package web.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.controller.ShopController;
import web.dao.face.ShopDao;
import web.dto.Product;
import web.service.face.ShopService;

@Service
public class ShopServiceImpl implements ShopService{
	
	private final Logger logger = LoggerFactory.getLogger(ShopController.class);
	@Autowired ShopDao shopDao;
	
	@Override
	public List<Product> getList() {
		return shopDao.getList();
	}

	@Override
	public Product view(int p_no) {
		return shopDao.view(p_no);
	}

}
