package web.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.controller.ShopController;
import web.dao.face.ShopDao;
import web.dto.Product;
import web.dto.ProductOccasion;
import web.dto.ProductStyle;
import web.dto.Styling;
import web.service.face.ShopService;
import web.util.imgPaging;

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
	public List<Product> getProductList(HashMap<String, Object> map) {
		return shopDao.selectProductList(map);
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
	public Product getProductView(HashMap<String, Object> map) {
		return shopDao.selectProductView(map);
	}

	
	@Override
	public List<Styling> getStylingByProduct(HashMap<String, Object> map) {
		return shopDao.selectStylingByProduct(map);
	}


	@Override
	public List<Product> getSimilarProduct(HashMap<String, Object> map) {
		return shopDao.selectSimilarProduct(map);
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
	public int getTotalCount() {
		return shopDao.totalCnt();
	}


	@Override
	public List<ProductOccasion> getProductOccasion() {
		return shopDao.selectProductOccasion();
	}


	@Override
	public List<ProductStyle> getProductStyle() {
		return shopDao.selectProductStyle();
	}


	

}
