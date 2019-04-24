package web.dao.face;

import java.util.List;

import web.dto.QuizAnswer;
import web.dto.QuizQuestion;

public interface AdminStyleQuizDao {
	
	//관리자 퀴즈관리 페이지 조회
	public List<QuizQuestion> getList();
	
	//퀴즈질문 추가
	public QuizQuestion quizInsert();
	
	//퀴즈질문 수정
	public QuizQuestion quizUpdate();
	
	//퀴즈질문 삭제
	public QuizQuestion quizDelete();
	
	//퀴즈항목 추가
	public QuizAnswer quizAnswerInsert();
	
	//퀴즈항목 수정
	public QuizAnswer quizAnswerUpdate();
	
	//퀴즈항목 삭제
	public QuizAnswer quizAnswerDelete();
	

}
 