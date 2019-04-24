package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import web.service.face.AdminStyleQuizService;


@Controller
public class AdminStyleQuizController {
	
	private final Logger logger = LoggerFactory.getLogger(AdminStyleQuizController.class);
	@Autowired AdminStyleQuizService adminStyleQuizService;
	
	//adminQuiz 화면 리스트 출력
	@RequestMapping(value="/admin/quiz", method=RequestMethod.GET)
	public void quizList(){	}
	
	//adminQuiz 화면 리스트 POST
	@RequestMapping(value="/admin/quiz", method=RequestMethod.POST)
	public String quizListProc(){
		
		return null;
	}
	
	//adminQuiz 퀴즈 추가
	@RequestMapping(value="/admin/insert", method=RequestMethod.GET)
	public String quizInsert(){ 
		
		return null;
	}
	
	//adminQuiz 퀴즈 수정
	@RequestMapping(value="/admin/update", method=RequestMethod.GET)
	public String quizUpdate(){ 
		
		return null;
	}
	
	//adminQuiz 퀴즈 삭제
	@RequestMapping(value="/admin/delete", method=RequestMethod.GET)
	public String quizDelete(){ 
		
		return null;
	}
	
	//adminQuiz 퀴즈 항목 추가
	@RequestMapping(value="/admin/answer/insert", method=RequestMethod.GET)
	public String quizAnswerInsert(){ 
		
		return null;
	}
	
	//adminQuiz 퀴즈 항목 수정
	@RequestMapping(value="/admin/answer/update", method=RequestMethod.GET)
	public String quizAnswerUpdate(){ 
		
		return null;
	}
	
	//adminQuiz 퀴즈 항목 삭제
	@RequestMapping(value="/admin/answer/delete", method=RequestMethod.GET)
	public String quizAnswerDelete(){ 
		
		return null;
	}
	
	

}
