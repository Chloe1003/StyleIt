package web.controller;

import java.util.List;

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
import web.dto.Styling;
import web.service.face.ShopService;

@Controller
public class ShopController {
	
	private final Logger logger = LoggerFactory.getLogger(ShopController.class);
	@Autowired ShopService shopService;
	
	//SHOP 화면 리스트 출력
	@RequestMapping(value="/shop/list", method=RequestMethod.GET)
	public void shopList(Model model) {
		
		logger.info("shopList 페이지");
		
		List<Product> list = shopService.getList();
		model.addAttribute("list", list);
		
	}
	
	//SHOP 상세 페이지
	@RequestMapping(value="/shop/view", method=RequestMethod.GET)
	public void shopView(Model model, int p_no){
		
		logger.info("제품 상세 페이지");
		
		Product view = shopService.view(p_no);
		List<Styling> list = shopService.list(p_no);
		
		model.addAttribute("view", view);
		model.addAttribute("list", list);
		
	}
	
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
