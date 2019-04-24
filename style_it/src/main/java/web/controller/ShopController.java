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

import web.dto.CollectionProduct;
import web.dto.Product;
import web.dto.ProductLike;
import web.dto.StylingTag;
import web.service.face.ShopService;
import web.util.Paging;

@Controller
public class ShopController {
	
	private final Logger logger = LoggerFactory.getLogger(ShopController.class);
	@Autowired ShopService shopService;
	
	//SHOP 화면 리스트 출력
	@RequestMapping(value="/shop", method=RequestMethod.GET)
	public void shopList(Model model, Paging paging, HashMap<String, Object> map, 
			HttpServletRequest req, StylingTag st, Product product){
		
	}
	
	//SHOP 상세 페이지
	@RequestMapping(value="/shop/view", method=RequestMethod.GET)
	public void shopView(Model model, Product product){}
	
	//필터 선택 시 작동
	@RequestMapping(value="/shop/select", method=RequestMethod.POST)
	public String shopSelect(Product product){ 
		
		return null;
	}
	
	//추천
	@RequestMapping(value="/shop/recommend", method=RequestMethod.GET)
	public String shopRecommend(ProductLike plike){ 
		
		return null;
	}
	
	//콜렉션 추가
	@RequestMapping(value="/shop/collection", method=RequestMethod.GET)
	public String shopCollection(CollectionProduct clike){ 
		
		return null;
	}
	

}
