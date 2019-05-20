package web.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import web.dto.FileUpload;
import web.dto.StylingTag;
import web.service.face.AdminStylingTagService;
import web.service.face.StylingService;
import web.util.Paging;

@Controller
public class AdminStylingTagController {

	@Autowired AdminStylingTagService stylingTagService;
	@Autowired ServletContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminStylingTagController.class);
	@Autowired AdminStylingTagService asts;
	
	// 전체 태그 리스트
	@RequestMapping(value="/admin/tag/list", method=RequestMethod.GET)
	public void tagList(Model model
			, @RequestParam(defaultValue="0") int curPage
			) {
	
		logger.info("스타일링태그");
		
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
		List<StylingTag> stList = asts.getPagingTagList(paging);
		logger.info("stList : "+stList);
		
		//게시글목록 MODEL로 추가
		model.addAttribute("stList", stList);
		
	}

	// 태그 추가 폼
	@RequestMapping(value="/admin/tag/insert", method=RequestMethod.POST)
	public String insertForm( @RequestParam HashMap<String, Object> map, MultipartFile file, FileUpload upFile, Model model) {
		
		
		logger.info("파일업로드");        
		logger.info("ST : "+map);
		logger.info("Title : "+map.get("st_name"));
		logger.info("file : "+map.get("fu_storedname"));
		logger.info(file.toString());
		logger.info(file.getOriginalFilename());
		logger.info(String.valueOf(file.getSize()));
		logger.info(file.getContentType());
		logger.info(String.valueOf(file.isEmpty()));
		
//		고유한 식별자
		String uId = UUID.randomUUID().toString().split("-")[0];
		
		//저장될 파일 이름
		String stored_name = null;
		stored_name = file.getOriginalFilename()+uId;
		
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
		
		upFile.setFu_storedname(file.getOriginalFilename());
		
		logger.info(upFile.toString());
		
		map.put("stored_name", upFile.getFu_storedname()+uId);
		
		logger.info("ST : "+map);
		asts.stylingTagInsert(map);
		   
		return "redirect:/admin/tag/list";
	}

	// 태그 수정
	@RequestMapping(value="/admin/tag/update", method=RequestMethod.POST)
	public String update(@RequestParam HashMap<String, Object> map, MultipartFile file, FileUpload upFile) {
		
		logger.info("파일업로드");        
		logger.info("ST : "+map);
		logger.info("Title : "+map.get("st_name"));
		logger.info("file : "+map.get("fu_storedname"));
		if (file.isEmpty()) {
			logger.info("isEmpty");
			logger.info("file : "+file);
			logger.info("fileToString : "+file.toString());
			asts.stylingTagUpdate(map);
		} else {
		
		logger.info(file.toString());
		logger.info(file.getOriginalFilename());
		logger.info(String.valueOf(file.getSize()));
		logger.info(file.getContentType());
		logger.info(String.valueOf(file.isEmpty()));
		
//		고유한 식별자
		String uId = UUID.randomUUID().toString().split("-")[0];
		
		//저장될 파일 이름
		String stored_name = null;
		stored_name = file.getOriginalFilename()+uId;
		
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
		
		upFile.setFu_storedname(file.getOriginalFilename());
		
		logger.info(upFile.toString());
		
		map.put("stored_name", upFile.getFu_storedname()+uId);
		
		logger.info("ST : "+map);
		asts.stylingTagUpdate(map);
		
		}
		   
		return "redirect:/admin/tag/list";
	}
	
	
}
