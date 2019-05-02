package web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.dto.Banner;
import web.service.face.MainService;

@Controller
public class MainController {
	
	private static final Logger logger=LoggerFactory.getLogger(MainController.class);
	@Autowired MainService mainService;
	
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public void main(Model model) {
		
		List<Banner> bannerList = mainService.getBannerList();
		model.addAttribute("bannerList", bannerList);
				
		
	}
	
	@RequestMapping(value="/faq", method=RequestMethod.GET)
	public void faq() {
		
	}
	

}
