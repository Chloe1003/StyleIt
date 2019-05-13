<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.follower_user{
	float: left;
	margin-right: 60px;
    margin-top: 62px;
    margin-left: 66px;
}
.userImg{
	
	border-radius: 150px;
    width: 225px;
    height: 225px;
}
.ul_box li{
	list-style: none;
}
.follwer_nick{
	text-align: center;
	font-weight: bold; 
	margin-top: 22px;
}
</style>


<ul class="ul_box">
	<c:forEach items="${followList }" var="fo">
		<li>
			<div class="follower_user" onclick="location.href='/member/memberPage?m_no=${fo.m_no }'">	
				<img class="userImg" src="/upload/${fo.fu_storedName }"/>	
					<div class="follwer_nick">
						<span>${fo.m_nick }</span>
					</div>
			</div>
		</li>
	</c:forEach>
</ul>