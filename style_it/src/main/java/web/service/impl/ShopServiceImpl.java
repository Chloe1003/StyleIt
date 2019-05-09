package web.service.impl;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.controller.ShopController;
import web.dao.face.ShopDao;
import web.dto.Product;
import web.dto.Styling;
import web.service.face.ShopService;

@Service
public class ShopServiceImpl implements ShopService{
	
	private final Logger logger = LoggerFactory.getLogger(ShopController.class);
	@Autowired ShopDao shopDao;
	
//	@Override
//	public List<Product> getList() {
//		return shopDao.getList();
//	}

	@Override
	public Product getProduct(int p_no) {
		return shopDao.selectProduct(p_no);
	}


	@Override
	public List<Product> getProductList(int m_no) {
		return shopDao.selectProductList(m_no);
	}

	@Override
	public List<Product> getProductNoLogin() {
		return shopDao.selectProductListNoLogin();
	}

	@Override
	public void pLikeUpdate(HashMap<String, Object> like) {
		if(shopDao.plikeCheck(like)>0) {
			shopDao.plikeDelete(like);
		} else {
			shopDao.plikeInsert(like);
		}
		
	}

	@Override
	public int plikeCnt(int p_no) {
		return shopDao.plikeCnt(p_no);
	}

	@Override
	public int plikeCheck(HashMap<String, Object> like) {
		return shopDao.plikeCheck(like);
	}

	@Override
	public Product getProductView(HashMap<String, Integer> map) {
		return shopDao.selectProductView(map);
	}

	@Override
	public Product getProductViewNoLogin(int p_no) {
		return shopDao.selectProductViewNoLogin(p_no);
	}

	@Override
	public List<Styling> getStylingByProductNoLogin(int p_no) {
		return shopDao.selectStylingByProductNoLogin(p_no);
	}
	
	@Override
	public List<Styling> getStylingByProduct(HashMap<String, Integer> map) {
		return shopDao.selectStylingByProduct(map);
	}


	@Override
	public List<Product> getSimilarProduct(HashMap<String, Object> map) {
		return shopDao.selectSimilarProduct(map);
	}


	@Override
	public List<Product> getSimilarProductNoLogin(Product p) {
		return shopDao.selectSimilarProductNoLogin(p);
	}



}
