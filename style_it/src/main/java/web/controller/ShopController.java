package web.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import web.dto.CollectionProduct;
import web.dto.Product;
import web.dto.ProductStyle;
import web.dto.Styling;
import web.service.face.ShopService;
import web.util.imgPaging;

@Controller
public class ShopController {
	
	private final Logger logger = LoggerFactory.getLogger(ShopController.class);
	@Autowired ShopService shopService;
	
	//SHOP 화면 리스트 출력
	@RequestMapping(value="/shop/list", method=RequestMethod.GET)
	public void shopList(HttpSession session, HttpServletRequest req,
			@RequestParam(defaultValue="0") int curPage, Model model) {
		
		HashMap<String, Object> map = new HashMap<>();
		logger.info("shopList 페이지");
		
		logger.info("curPage :"+curPage);
		imgPaging paging;
		
		
		boolean login = false;
		boolean filter = false;
		
		List<ProductStyle> psList = shopService.getProductStyle();
		
		try {
			if(session.getAttribute("login") != null) {
				login = (boolean) session.getAttribute("login");
			}

		} catch (Exception e) {}
		
		int totalCount = shopService.getTotalCount();
		paging = new imgPaging (totalCount, curPage);
		List<Product> pList;
				
		int m_no = 0; 
		if(login==true) {
			m_no = (int) session.getAttribute("m_no");
		}
	
		map.put("m_no", m_no);
		map.put("paging", paging);
		map.put("login", login);
		map.put("filter", filter);
		
		pList = shopService.getProductList(map);
		
		model.addAttribute("psList", psList);
		model.addAttribute("productList", pList);	
		model.addAttribute("paging", paging);
				
	}
	
	//SHOP 상세 페이지
	@RequestMapping(value="/shop/view", method=RequestMethod.GET)
	public void shopView(HttpSession session, Model model, @RequestParam int p_no){
		HashMap<String, Integer> map = new HashMap<>();
		HashMap<String, Object> view = new HashMap<>();
		logger.info("제품 상세 페이지");
		
		boolean login = false;
		
		try {
			if(session.getAttribute("login") != null) {
				login = (boolean) session.getAttribute("login");
			}
		} catch (Exception e) {}
		
		int m_no = 0;
		
		if (login==true) { // 로그인 되어 있을 때
			m_no = (int) session.getAttribute("m_no");
		}
						
		map.put("m_no", m_no);
		map.put("p_no", p_no);
			
		Product p = shopService.getProductView(map);
		Product selected = shopService.getProduct(p_no);
			
		view.put("m_no", m_no);
		view.put("login", login);
		view.put("products", selected);
			
		List<Product> pList = shopService.getSimilarProduct(view);
		List<Styling> sList = shopService.getStylingByProduct(map);			
			
		model.addAttribute("products", pList);
		model.addAttribute("styling", sList);
		model.addAttribute("view", p);		
	}
	
	
//	제품 좋아요
	@RequestMapping(value = "/shop/like", method = RequestMethod.GET)
	public void productLike(int p_no, HttpSession session, 
			@RequestParam HashMap<String, Object> like, Writer out) {
		
		logger.info("좋아요");

		int m_no = (int) session.getAttribute("m_no");
		
		like.put("m_no", m_no);
		like.put("p_no", p_no);
		
		shopService.pLikeUpdate(like);
		
		logger.info("업데이트 완료");
		
		try {
			out.write("{\"cnt\" :"+ shopService.plikeCnt(p_no)+", \"check\" :"+shopService.plikeCheck(like)+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}	
	
	//콜렉션 추가
	@RequestMapping(value="/shop/collection", method=RequestMethod.GET)
	public String shopCollection(CollectionProduct clike){ 
		
		return null;
	}
	
	@RequestMapping(value="/shop/listloading")
	public String listloading(HttpSession session, HttpServletRequest req, @RequestParam(defaultValue="0") int ps_no,
			@RequestParam(defaultValue="0") int curPage, @RequestParam(defaultValue="") String search, Model model) {
		
		logger.info("shopList 추가로딩 페이지");
		
		HashMap<String, Object> map = new HashMap<>();
		
//		int curPage = shopService.getCurPage(req);
		logger.info("curPage :"+curPage);
		imgPaging paging;
		
		
		boolean login = false;
		boolean filter;
		boolean searching = false;
		
		if(ps_no>0) {
			filter=true;
		} else {
			filter=false;
		}
		
		List<ProductStyle> psList = shopService.getProductStyle();
		
		try {
			if(session.getAttribute("login") != null) {
				login = (boolean) session.getAttribute("login");
			}
		} catch (Exception e) {}
		
		logger.info("ps_no : "+ps_no);
		
		int totalCount = shopService.getTotalCount();
		paging = new imgPaging (totalCount, curPage);
		List<Product> pList;
			
		int m_no = 0; 
		if(login==true) {
			m_no = (int) session.getAttribute("m_no");
		}
	
		map.put("ps_no", ps_no);	
		map.put("m_no", m_no);
		map.put("paging", paging);
		map.put("login", login);
//		map.put("filter", filter);
		if(search!=null) {
			searching = true;
//			map.put("searching", searching);
			map.put("search", search);			
		}
		
		pList = shopService.getProductList(map);
		
		model.addAttribute("psList", psList);
		model.addAttribute("productList", pList);	
		model.addAttribute("paging", paging);
		
		return "shop/listloading";
	}
	

}
