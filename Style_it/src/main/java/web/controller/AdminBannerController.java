package web.controller;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


import javax.servlet.ServletContext;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import web.service.face.AdminBannerService;
import web.dto.Banner;
import web.dto.FileUpload;
import web.util.Paging;

@Controller
public class AdminBannerController {
	
	@Autowired AdminBannerService bannerService;
	@Autowired ServletContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminBannerController.class);
	@Autowired AdminBannerService asts;

	// 배너 리스트 가져오기
	@RequestMapping(value="/admin/banner/list", method=RequestMethod.GET)
		public void bannerList(Model model
				, @RequestParam(defaultValue="0") int curPage
				) {
		
			logger.info("배너");
			
			logger.info("페이징 처리하기... ");
			
			//총 게시글 수 얻기
			int totalCount = asts.getTotalCount();
			logger.info("총 수 : " + totalCount);
				
			//페이지 객체 생성
			Paging paging = new Paging(totalCount, curPage);
			logger.info("페이징 : "+ paging);
			
			//페이징객체 MODEL로 추가
			model.addAttribute("paging", paging);
			
			//업로드된 파일 전체 조회
			List<Banner> bList = asts.getPagingBannerList(paging);
			logger.info("bList : "+bList);
			
			//게시글목록 MODEL로 추가
			model.addAttribute("bList", bList);
			
		}

	
	// 배너 추가 폼 반환
	@RequestMapping(value="/admin/banner/insert", method=RequestMethod.GET)
	public void bannerInsertForm() {
		
	}
	
	// 배너 추가 폼
	@RequestMapping(value="/admin/banner/insert", method=RequestMethod.POST)
	public String bannerInsert(@RequestParam HashMap<String, Object> map, MultipartFile file, FileUpload upFile, Model model) {
		
		logger.info("파일업로드");        
		logger.info("Banner : "+map);
		logger.info("Title : "+map.get("b_name"));
		logger.info("file : "+map.get("fu_storedname"));
		logger.info(file.toString());
		logger.info(file.getOriginalFilename());
		logger.info(String.valueOf(file.getSize()));
		logger.info(file.getContentType());
		logger.info(String.valueOf(file.isEmpty()));
		
		//저장될 파일 이름
		String stored_name = null;
		stored_name = file.getOriginalFilename();
		
		//파일 저장 경로
		String path = context.getRealPath("upload");
		
		//저장될 파일
		File dest = new File(path, stored_name);
		
		//파일 업로드
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		upFile.setFu_storedName(file.getOriginalFilename());
		
		logger.info(upFile.toString());
		
		map.put("stored_name", upFile.getFu_storedName());
		
		logger.info("Banner : "+map);
		asts.bannerInsert(map);
		   
		return "redirect:/admin/banner/list";
	}
		
	
	// 배너 수정 폼 반환
	@RequestMapping(value="/admin/banner/update", method=RequestMethod.GET)
	public void bannerUpdateForm(int b_no, Model model) {
	
	}
	
	// 배너 수정
	@RequestMapping(value="/admin/banner/update", method=RequestMethod.POST)
	public String bannerUpdate(@RequestParam HashMap<String, Object> map, MultipartFile file, FileUpload upFile) {
		logger.info("파일업로드");        
		logger.info("Banner : "+map);
		logger.info("Title : "+map.get("b_name"));
		logger.info("file : "+map.get("fu_storedname"));
		if (file.isEmpty()) {
			logger.info("isEmpty");
			logger.info("file : "+file);
			logger.info("fileToString : "+file.toString());
			asts.bannerUpdate(map);
		} else {
		
		logger.info(file.toString());
		logger.info(file.getOriginalFilename());
		logger.info(String.valueOf(file.getSize()));
		logger.info(file.getContentType());
		logger.info(String.valueOf(file.isEmpty()));
		
		//저장될 파일 이름
		String stored_name = null;
		stored_name = file.getOriginalFilename();
		
		//파일 저장 경로
		String path = context.getRealPath("upload");
		
		//저장될 파일
		File dest = new File(path, stored_name);
		
		//파일 업로드
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		upFile.setFu_storedName(file.getOriginalFilename());
		
		logger.info(upFile.toString());
		
		map.put("stored_name", upFile.getFu_storedName());
		
		logger.info("Banner : "+map);
		asts.bannerUpdate(map);
		
		}
		   
		return "redirect:/admin/banner/list";
	}

	
	// 배너 삭제
	@RequestMapping(value="/admin/banner/delete")
	public String bannerDelete(int b_no) {

		return null;
	}
	

}
