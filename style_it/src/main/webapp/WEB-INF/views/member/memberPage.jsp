<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style type="text/css">
a:link { color: white; text-decoration: none;}
a:visited { color: white; text-decoration: none;}
a:hover { color: white; text-decoration: none;}
a:active {text-decoration: none; color: white;}

.mypageLine{

	width: 100%;
    height: 254px;
    background-color: #61d2d6;
    padding-top: 20px;
}
.mypageNick{
	
	text-align: center;
	color: white;
	font-size: 12px;
}
.follow{
	color: white;
	font-size: 12px;
}
.mail{
	width: 25px;
	position: relative;
    left: 300px;
}
.imt_loaded{
	
	border-radius: 150px;
    width: 225px;
    height: 225px;
}
    
</style>
<script type="text/javascript">

function showFollowList(m_no) {
	location.href="/mypage/followlist?m_no=${mypage.m_no }"; 
}
function showFollowingList(m_no) {
	location.href="/mypage/followinglist?m_no=${mypage.m_no }"; 
}

</script>
				
	<div class="mypageLine">
		<div class="mypageNick"><span style="text-transform: capitalize; text-decoration: underline; font-size: 18px;">${mypage.m_nick }</span>  
			<img class="mail" src="/resources/image/mypage/mail.png"/>
		</div>
		<!-- 프로필 사진 -->
		<div class="img_placeholder">
			<img class="imt_loaded" src="/upload/${mypage.fu_storedName }" />
		</div>
		<!-- 팔로잉, 팔로워 숫자 -->
		<div class="follow">
			<span style="position: relative; left: 476px; bottom: 100px;">
			<a style="cursor: pointer;" onclick="showFollowList()">${countFollower }&nbsp;&nbsp;팔로워</a></span>  	
			<span style="position: relative; left: 700px; bottom: 100px;">
			<a style="cursor: pointer;" onclick="showFollowingList()">${countFollowee }&nbsp;&nbsp;팔로잉</a></span>		
		</div>
	</div>
	
	<div class="mypageBottom">
	
		<div class="sBottom" style="position: relative; left: 242px; bottom: -63px;">
			<span style="position: relative; left: 25px; font-size: 20px; font-weight: bold;">${countStyling }</span>
		<br>스타일링</div>
		<div class="lBottom" style="position: relative; bottom: -13px; left: 490px;">
			<span style="position: relative; left: 15px; font-size: 20px; font-weight: bold;">${countLike }</span>
		<br>좋아요</div>
		<div class="cBottom" style="position: relative; bottom: 36px;  left: 740px;">
			<span style="position: relative; left: 15px; font-size: 20px; font-weight: bold;">${countCollection }</span>
		<br>컬렉션</div>
	
	</div>
	
	
	
