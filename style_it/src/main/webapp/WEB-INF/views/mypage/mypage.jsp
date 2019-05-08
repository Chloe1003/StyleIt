<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>



<body>

	마이 페이지
	${mypage.m_no }
	${mypage.m_email }
	${mypage.m_nick }
		<div class="img_placeholder">
				<img class="imt_loaded"
					src="/upload/${mypage.fu_storedName }" />
		</div>
	
</body>
