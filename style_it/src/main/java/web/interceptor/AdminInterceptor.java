package web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(AdminInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler)
			throws Exception {
		
		logger.info("인터셉터 시작");
		
		//세션 얻기
		HttpSession session = req.getSession();
		
		if(session.getAttribute("login") == null ) {
			logger.info(" >> 접속불가 : 로그인되지 않음");
			
			resp.sendRedirect("/main");
			
			return false; //컨트롤러 접근 차단
		} else {
			logger.info(" >> 로그인 상태");
			
			if(!"admin@gmail.com".equals(session.getAttribute("m_email"))) {
				logger.info(" >> 접속불가 : 일반사용자 로그인 상태 ");
				
				resp.sendRedirect("/main");
				
				return false; //컨트롤러 접근 차단
			}
		}
		
		return true;
		//preHandle 메소드의 반환값
		//	true - 컨트롤러 접근 허용
		//	false - 컨트롤러 접근 차단
	}
	
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler,
			ModelAndView mav) throws Exception {
		
		logger.info("인터셉터 종료");
		
	}

}
