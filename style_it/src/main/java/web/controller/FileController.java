package web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import web.dao.face.FileDao;
import web.dto.UploadFile;

@Controller
public class FileController {
	
	@Autowired ServletContext context;
	@Autowired FileDao fileDao;
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@RequestMapping(value="/file/fileup", method=RequestMethod.GET)
	public void fileForm() { }
	
	
	@RequestMapping(value="/file/fileup", method=RequestMethod.POST)
	public String fileupload(
			String title,
			UploadFile upFile,
			MultipartFile file) {
		logger.info("파일 업로드!");
		
		logger.info(title);
		
		// 고유 식별자
		String uId = UUID.randomUUID().toString().split("-")[0];

		// 저장될 파일이름
		String stored_name = null;
		stored_name = file.getOriginalFilename()+"_"+uId;		
		
		// 파일 저장 경로
		String path = context.getRealPath("upload");
		
		// 저장될 파일
		File dest = new File(path, stored_name);
		
		// 파일 업로드
		try {
			file.transferTo(dest);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		upFile.setOrigin_name(file.getOriginalFilename());
		upFile.setFile_size(file.getSize());
		upFile.setStored_name(stored_name);

		logger.info(upFile.toString());
		
		fileDao.insert(upFile);
		
		return null;
	}
	
	@RequestMapping("/file/list")
	public void filelist(Model model) {
		
		//업로드된 파일 전체 조회
		List<UploadFile> list = fileDao.selectAll();
		
		
		//모델에 추가
		model.addAttribute("list", list);
		
	}
	
	@RequestMapping("/file/download")
	public ModelAndView download(
			int fileno,
			ModelAndView mav) {
		
		//모델 값 지정 - 다운받으려는 파일의 정보
		UploadFile file = fileDao.selectByFileno(fileno);
		mav.addObject("downFile", file);
		
		//뷰지정
		mav.setViewName("down"); //빈 id
		
		return mav;
	}
	
}























