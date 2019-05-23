package web.controller;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

import java.sql.Blob;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import web.dto.FileUpload;
import web.dto.Follow;
import web.dto.Member;
import web.dto.Product;
import web.dto.ProductCategory;
import web.dto.Styling;
import web.dto.StylingComment;
import web.dto.StylingLike;
import web.dto.StylingTag;
import web.service.face.MemberService;
import web.service.face.StylingService;
import web.util.StylingPaging;

@Controller
public class StylingController {
	private static final Logger logger=LoggerFactory.getLogger(StylingController.class);

	@Autowired StylingService sServ;
	@Autowired MemberService mServ;
	@Autowired ServletContext context;
	
	//스타일링 작성 페이지
	@RequestMapping(value="/styling/create", method=RequestMethod.GET)
	public String styling(Model model, HttpSession session,@RequestParam HashMap<String, Integer> map) {
		
		boolean login = false;
		
		try {
			
			if(session.getAttribute("login") != null) {
				login = (boolean) session.getAttribute("login");
			}
			
		} catch (Exception e) {
			
		}
		
		logger.info("login : "+login);
		
		
		if (login==true) { // 로그인 되어 있을 때
			
			logger.info("login true");
			
			int m_no = (int) session.getAttribute("m_no");
						
			map.put("m_no", m_no);
		
			logger.info("CREATE 페이지");
//			HashMap<String, Object> map = sServ.getProductCategory();
			List<ProductCategory> pc = sServ.getProductCategory();
			List<StylingTag> st = sServ.getStylingTag();
			logger.info("MAP  :"+ pc +", ST : "+st);
			model.addAttribute("list", pc);
			model.addAttribute("stList", st);
			
		}  else {
			
			return "redirect:/main";
		}
		
		return "styling/create";
	}
	
	//스타일링 작성 AJAX
	@RequestMapping(value="/styling/create/ajax", method=RequestMethod.GET)
	public ModelAndView ajax(@RequestParam HashMap<String, Object> map,
			@RequestParam(defaultValue="0") int curPage, ModelAndView mav) {
		
		logger.info("PRO  : "+map);
		StylingPaging paging;
		
		//총 게시글 수 얻기
		int totalCount = sServ.getSearchCount(map);  
		logger.info("총 수 : " + totalCount);
			
		//페이지 객체 생성
		paging = new StylingPaging(totalCount, curPage, 9, 5);
		logger.info("페이징 : "+ paging);
		
		map.put("paging", paging);
		
		List<HashMap> pc = sServ.getProduct(map); 
		logger.info("PC : "+pc);
		
		mav.addObject("pc", pc);
		mav.addObject("paging", paging);

		mav.setViewName("styling/create/ajax");
		
		return mav;
	}
	
	// 스타일링 캔버스
	@RequestMapping(value="/styling/canvas", method=RequestMethod.GET)
	public void canvas() {
	}
	
	// 스타일링 캔버스
	@RequestMapping(value="/styling/canvas/ajax", method=RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> canvas_ajax(MultipartFile data, FileUpload upFile, 
			@RequestParam HashMap<String, Object> map, HttpSession session, int[] checked) {
			
			logger.info("파일업로드");        
			logger.info("ST : "+map);
			logger.info("Title : "+map.get("s_name")+".png");
			logger.info("Checked : "+Arrays.toString(checked));
			logger.info(data.toString());
			logger.info(String.valueOf(data.getSize()));
			logger.info(data.getContentType());
			logger.info(String.valueOf(data.isEmpty()));
			
			//고유한 식별자
			String uId = UUID.randomUUID().toString().split("-")[0];
			
			//저장될 파일 이름
			String stored_name = null;
			stored_name = map.get("s_name")+uId+".png";
			logger.info("stored_name : "+stored_name);
			
			//파일 저장 경로
			String path = context.getRealPath("upload");
			
			//저장될 파일
			File dest = new File(path, stored_name);
			
			//파일 업로드
			try {
				data.transferTo(dest);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			int m_no = (int) session.getAttribute("m_no");
			
			map.put("stored_name", stored_name);
			map.put("m_no", m_no);
			logger.info("MAP  : " + map);
			
			sServ.stylingInsert(map, checked);
			
		return map;
	}
	
	// 스타일링 태그 리스트 페이지
	@RequestMapping(value="/styling/tag")
	public void stylingTag(Model model) {
		model.addAttribute("stylingTag", sServ.getStylingTag());
	}
	
//	스타일링 리스트 보기
	@RequestMapping (value = "/styling/list")
	public void StylingList(HttpSession session , 
			@RequestParam HashMap<String, Integer> map, Model model, int st_no) {
		
		boolean login = false;
		
		try {
			
			if(session.getAttribute("login") != null) {
				login = (boolean) session.getAttribute("login");
			}
			
		} catch (Exception e) {
			
		}
		
		
		if (login==true) { // 로그인 되어 있을 때
			
			logger.info("login true");
			
			int m_no = (int) session.getAttribute("m_no");
						
			map.put("m_no", m_no);
			map.put("st_no", st_no);	
			
			model.addAttribute("stylingList", sServ.getStylingList(map));	
		
		} else { // 로그인 안되어 있을 때
			logger.info("login false");

			model.addAttribute("stylingList", sServ.getStylingListNoLogin(st_no));
			
		}
		
	}
//	스타일링 상세보기
	@RequestMapping(value = "/styling/view", method = RequestMethod.GET)
	public void StylingView(HttpSession session, Model model, int s_no,
			@RequestParam HashMap<String, Integer> map) {
		
		boolean login = false;
		
		try {
			
			if(session.getAttribute("login") != null) {
				login = (boolean) session.getAttribute("login");
			}
			
		} catch (Exception e) {
			
		}
		
		if (login==true) { // 로그인 되어 있을 때
			
			int m_no = (int) session.getAttribute("m_no");
						
			map.put("m_no", m_no);
			map.put("s_no", s_no);
			
			logger.info("m_no : "+m_no);
			logger.info("s_no : "+s_no);
			
			Styling s = sServ.getStylingView(map);
			int make = s.getM_no();
			Member maker = mServ.getMemberByMno(make);
			logger.info("MAKER : "+maker);

			
			List<Product> pList = sServ.getProductByStyling(map);	
			List<StylingComment> cList = sServ.getComments(s_no);
			int commentcnt = sServ.commentCnt(s_no);
			
			//팔로우 리스트
			
			logger.info("fm_no : "+maker.getM_no());
			logger.info("fwm_no : "+(int) session.getAttribute("m_no"));
			
			map.put("fm_no", maker.getM_no());
			map.put("fwm_no", (int) session.getAttribute("m_no"));
			
			int fcheck = sServ.checkFollow(map);
			logger.info("fcheck : "+fcheck);
			
			if( fcheck==1) {
			int followNo = sServ.getFollowNo(map); 
			logger.info("followNo : "+followNo);
			model.addAttribute("fno", followNo);
			}
			
			model.addAttribute("fcheck", fcheck);
			model.addAttribute("styling", s);	
			model.addAttribute("maker", maker);
			model.addAttribute("product", pList);
			model.addAttribute("cList", cList);
			model.addAttribute("commentcnt", commentcnt);
			
		} else { // 로그인 안되어 있을 때
			logger.info("login false");

			Styling s = sServ.getStylingViewNoLogin(s_no);
			logger.info("s :  : : : ");
			int make = s.getM_no();
			logger.info("make :  : : : ");
			Member maker = mServ.getMemberByMno(make);
			List<StylingComment> cList = sServ.getComments(s_no);
			int commentcnt = sServ.commentCnt(s_no);

			
			
			model.addAttribute("styling", s);
			model.addAttribute("maker", maker);
			model.addAttribute("product", sServ.getProductByStylingNoLogin(s_no));
			model.addAttribute("cList", cList);
			model.addAttribute("commentcnt", commentcnt);

		}

	}
//	스타일링 좋아요
	@RequestMapping(value = "/styling/like", method = RequestMethod.GET)
	public void StylingLike(int s_no, HttpSession session, 
			@RequestParam HashMap<String, Object> like, Writer out) {
		
		logger.info("좋아요");

		int m_no = (int) session.getAttribute("m_no");
		
		like.put("m_no", m_no);
		like.put("s_no", s_no);
		
		sServ.sLikeUpdate(like);
		
		logger.info("업데이트 완료");
		
		try {
			out.write("{\"cnt\" :"+ sServ.slikeCnt(s_no)+", \"check\" :"+sServ.slikeCheck(like)+"}");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
//	스타일링 선택
	@RequestMapping(value = "/styling/select", method = RequestMethod.GET)
	public void StylingSelect() {
		
	}
//	스타일링 댓글 입력
	@RequestMapping(value = "/styling/addcomment", method = RequestMethod.POST)
	public String addComment(HttpSession session, int s_no, String co_content, Model model) {
		
		logger.info("스타일링 댓글 추가");
					
		HashMap<String, Object> map = new HashMap<>();
		
		int m_no = (int) session.getAttribute("m_no");
		
		map.put("m_no", m_no);
		map.put("co_content", co_content);
		map.put("s_no", s_no);
		
		sServ.addComment(map);
		
		
		List<StylingComment> cList = sServ.getComments(s_no);

		model.addAttribute("cList", cList);

		
		return "styling/comment";
	}
	
	// 스타일링 댓글 삭제
	@RequestMapping(value = "/styling/deletecomment", method = RequestMethod.GET)
	public String deleteComment(HttpSession session, int s_no, int co_no, Model model) {
		
		logger.info("스타일링 댓글 삭제");
		
		sServ.deleteComment(co_no);
		List<StylingComment> cList = sServ.getComments(s_no);

		model.addAttribute("cList", cList);
		
		return "styling/comment";
	}
	
	// 스타일링 팔로우
	@RequestMapping(value="/styling/follow", method=RequestMethod.GET)
	public String follow(@RequestParam HashMap<String, Object> map) {
	
		logger.info("map : "+ map);
//		sServ.insertFollow(map);
		
		return "redirect:/styling/view?s_no=83";
	}
	
	// 스타일링 팔로우
	@RequestMapping(value="/styling/unfollow", method=RequestMethod.GET)
	public String unfollow(@RequestParam HashMap<String, Object> map) {
	
		logger.info("map : "+ map);
		   
		
		
		return "redirect:/styling/view?s_no=83";
	}
	
	
	
}
