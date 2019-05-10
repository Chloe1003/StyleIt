package web.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
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

@Controller
public class AdminStylingTagController {

	@Autowired AdminStylingTagService stylingTagService;
	@Autowired ServletContext context;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminStylingTagController.class);
	@Autowired StylingService stylingService;
	
	// 전체 태그 리스트
	@RequestMapping(value="/admin/tag/list", method=RequestMethod.GET)
	public void tagList(Model model) {
	
		logger.info("스타일링태그");
		//스타일링태그 리스트 조회
		List<StylingTag> stList = stylingService.getStylingTagList();
		
		//출력
		model.addAttribute("stList", stList);
		
	}

	// 태그 추가 폼
	@RequestMapping(value="/admin/tag/insert", method=RequestMethod.POST)
	public String insertForm( @RequestParam HashMap<String, Object> map, MultipartFile file, FileUpload upFile, Model model) {
		
		
		logger.info("파일업로드");        
		logger.info("ST : "+map);
		logger.info("Title : "+map.get("st_name"));
		logger.info("file : "+map.get("fu_storedname"));
//		if (file == null) {
//			model.addAttribute("msg", "파일을 선택해 주세요");
//			return "redirect:/admin/tag/list";
//		}
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
		
		upFile.setFu_storedname(file.getOriginalFilename());
		
		logger.info(upFile.toString());
		
		map.put("stored_name", upFile.getFu_storedname());
		
		logger.info("ST : "+map);
		stylingService.stylingTagInsert(map);
		   
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
			stylingService.stylingTagUpdate(map);
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
		
		upFile.setFu_storedname(file.getOriginalFilename());
		
		logger.info(upFile.toString());
		
		map.put("stored_name", upFile.getFu_storedname());
		
		logger.info("ST : "+map);
		stylingService.stylingTagUpdate(map);
		
		}
		   
		return "redirect:/admin/tag/list";
	}
//	// 태그 삭제
//	@RequestMapping(value="/admin/tag/delete", method=RequestMethod.GET)
//	public String delete(StylingTag st) {
//		
//		logger.info("ST : "+ st);
//		stylingService.stylingTagDelete(st);
//		
//		return "redirect:/admin/tag/list";
//	}
	
	
}
