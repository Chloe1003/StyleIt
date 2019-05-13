<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.following_user{
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
.following_nick{
	text-align: center;
	font-weight: bold; 
	margin-top: 22px;
}
</style>
<script type="text/javascript">

function  a(follower_no){
	

$.ajax({
	type : "post"
	,url : "/member/follow"
	,data : { "follower_no" : follower_no }
	,dataType : "json"
	,success : function( res ) {
		console.log("성공");
		console.log(res);
		console.log(res.follower_no);
		$("#clic").toggleClass("btn-danger");
	}
	,error : function(e) {
		console.log("실패");
		console.log(e);
	}
});
	
}

</script>


<ul class="ul_box">
	<c:forEach items="${followingList }" var="fo">
		<li>
			<div class="following_user" >	
				<img class="userImg" src="/upload/${fo.fu_storedName }" onclick="location.href='/member/memberPage?m_no=${fo.m_no }'"/>	
					<div class="following_nick">
						<span>${fo.m_nick }</span>
					</div>
						<input type="hidden" id="follower_no" name="follower_no" value="${fo.follower_no }">
							<c:if test="${fo.followee_no eq m_no }">
								<a onclick="a(${fo.follower_no })"><button type="button">언팔로우</button></a>
							</c:if>
			</div>
		</li>
	</c:forEach>
</ul>