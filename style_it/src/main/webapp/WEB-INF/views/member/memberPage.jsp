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
    top: 75px;
}
.FOLLOW{
	position: relative;
    left: 340px;
    border-radius: 27px;
    top: 15px;
    width: 120px;
    height: 31px;
    font-size: 19px;
	background-color : white;
	color : #61d2d6;
	border : #61d2d6;
}
.UNFOLLOW{
	position: relative;
    left: 340px;
    border-radius: 27px;
    top: 15px;
    width: 120px;
    height: 31px;
    font-size: 19px;
    border: gray;
	
}
.list_FOLLOW{
    font-size: 19px;
	color : white;
	border : #61d2d6;
    border-radius: 27px;
    background-color : #61d2d6;
    border-radius: 27px;
	border : #61d2d6;
}
.list_UNFOLLOW{
	color : white;
    border: gray;
    border-radius: 27px;
    font-size: 19px;
}

.imt_loaded{
	
	margin-left: 150px;
	border-radius: 150px;
    width: 250px;
    height: 250px;
}
.follow_display {
	position: fixed; width:365px; display:none; font-family:nanum; border-radius: 27px; 
	margin-left: auto; margin-right: auto; background : white;
	top : 50%;
   	left:50%;
    transform:translateX(-50%) translateY(-50%);
    z-index:9999;
}
.bg_follow {
	background: rgba(0, 0, 0, 0.5);
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	width: 100%;
	height: 100%;
	display: none;
}    
.userImg{
	border-radius: 150px;
    width: 93px;
    height: 93px;
   /*  margin-left: 50px;
    margin-right: inherit; */
}
.follow_display{
	width: 1200px;
	height: auto;
	
}
.followeeUser{
	height: 400px;
    width: 100%;
  
	
}
/* X표시  */
.close {
	position: absolute;
	font-size: 40px;
	top: 6px;
	right: 24px;
	width: 23px;
	height: 23px;
}
    
</style>
<script type="text/javascript">

function showMemProductLikeList() {
	location.href ="/member/MemProductlikelist?m_no=${mypage.m_no}";
	
}

function showFollowingList() {
 	document.getElementById("follow_display").style.display="block";
	document.getElementById("bg_follow").style.display="block";//배경 어둡게 하는 것 
	
}

function showFollowList() {
 	document.getElementById("follow_display1").style.display="block";
	document.getElementById("bg_follow1").style.display="block";//배경 어둡게 하는 것 
	
}

function  follower(m_no){

	$.ajax({
		type : "post"
		,url : "/member/follow2"
		,data : { "m_no" : m_no }
		,dataType : "json"
		,success : function( res ) {
			console.log("follow2성공");
			console.log(res);
			console.log(res.folCheck_2);
			console.log($("#followerIN${m_no }").val());

			if($("#followerIN"+m_no).val()=="FOLLOW"){
				console.log('1')
				$("#followerIN"+m_no).val("UNFOLLOW");
				$("#followerIN"+m_no).removeClass("list_FOLLOW"); 
				$("#followerIN"+m_no).addClass("list_UNFOLLOW");
			}else{
				console.log('2')
				console.log("팔로우삭제");
					$("#followerIN"+m_no).val("FOLLOW");
				$("#followerIN"+m_no).removeClass("list_UNFOLLOW");
				$("#followerIN"+m_no).addClass("list_FOLLOW");
			}
		}
		,error : function(e) {
			console.log("실패");
			console.log(e);
		}
	});
		
	}
function  follower1(m_no){

	$.ajax({
		type : "post"
		,url : "/member/follow2"
		,data : { "m_no" : m_no }
		,dataType : "json"
		,success : function( res ) {
			console.log("follow2성공");
			console.log(res);
			console.log(res.folCheck_2);
			console.log($("#followerIN${m_no }").val());

			if($("#followerIN1"+m_no).val()=="FOLLOW"){
				console.log('1')
				$("#followerIN1"+m_no).val("UNFOLLOW");
				$("#followerIN1"+m_no).removeClass("list_FOLLOW"); 
				$("#followerIN1"+m_no).addClass("list_UNFOLLOW");
			}else{
				console.log('2')
				console.log("팔로우삭제");
					$("#followerIN1"+m_no).val("FOLLOW");
				$("#followerIN1"+m_no).removeClass("list_UNFOLLOW");
				$("#followerIN1"+m_no).addClass("list_FOLLOW");
			}
		}
		,error : function(e) {
			console.log("실패");
			console.log(e);
		}
	});
		
	}

$(document).ready(function() {
	$("#followCancel").click(function() {
		document.getElementById("follow_display").style.display = "none"; 
		document.getElementById("bg_follow").style.display = "none";
	})
	$("#followCancel1").click(function() {
		document.getElementById("follow_display1").style.display = "none"; 
		document.getElementById("bg_follow1").style.display = "none";
	})
	
	
	$("#follow_button").click(function() {

		$.ajax({
			type : "post"
			,url : "/member/follow"
			,data : { "m_no" : $("#m_no").val()  }
			,dataType : "json"
			,success : function( res ) {
				console.log("성공");
				console.log(res);
				if(res.folCheck== true){
					
					$("#follow_button").val("FOLLOW");
					$("#follow_button").removeClass("UNFOLLOW");
					$("#follow_button").addClass("FOLLOW");
					location.reload();
				}else{
					
					$("#follow_button").val("UNFOLLOW");
					$("#follow_button").removeClass("FOLLOW");
					$("#follow_button").addClass("UNFOLLOW");
					location.reload();
				}
				
			}
			,error : function(e) {
				console.log("실패");
				console.log(e);
			}
			});
			
		});
	
});

</script>
				
	<div class="mypageLine">
		<div class="mypageNick">User,&nbsp;&nbsp;&nbsp;&nbsp;<span style="text-transform: capitalize; text-decoration: underline; font-size: 18px;">${mypage.m_nick }</span>  
			<input type="hidden" id="m_no"  name="m_no" value="${mypage.m_no }">
					 <c:if test="${folCheck eq true }">
						<input type="button" class="UNFOLLOW" id="follow_button" value="UNFOLLOW"/>
					</c:if>
					<c:if test="${folCheck eq false }">
						<input type="button" class="FOLLOW" id="follow_button" value="FOLLOW"/>
					</c:if> 
			<img class="mail" src="/resources/image/mypage/mail.png"/>
		</div>
		<!-- 프로필 사진 -->
		<div class="img_placeholder">
			<img class="imt_loaded" src="/upload/${mypage.fu_storedname }" />
		</div>
		<!-- 팔로잉, 팔로워 숫자 -->
		<div class="follow">
			<span style="position: relative; left: 476px; bottom: 100px;">
			<a style="cursor: pointer; color: white; font-size: 20px;" onclick="showFollowList()">${countFollower }</a>&nbsp;&nbsp;&nbsp;팔로워</span>  	
			<span style="position: relative; left: 700px; bottom: 100px;">
			<a style="cursor: pointer; color: white; font-size: 20px;" onclick="showFollowingList()">${countFollowee }</a>&nbsp;&nbsp;&nbsp;팔로잉</span>		
		</div>
	</div>
	
	<div class="mypageBottom" style="margin-left: 168px;">
	
		<div class="sBottom" style="position: relative; left: 242px; bottom: -63px;">
			<span style="position: relative; left: 25px; font-size: 20px; font-weight: bold;">${countStyling }</span>
		<br>스타일링</div>
		<div class="lBottom" style="position: relative; bottom: -13px; left: 490px;">
			<span style="cursor: pointer; position: relative; left: 15px; font-size: 20px; font-weight: bold; color: black;" onclick="showMemProductLikeList()">${countLike }</span>
		<br>좋아요</div>
	
	</div>
			<!-- 멤퍼페이지에서 팔로우 한 리스트 -->
			<div class="bg_follow" id="bg_follow"></div>
				<div class="follow_display" id="follow_display">
						<input type="hidden" id="m_no"  name="m_no" value="${mypage.m_no }">
							<button type="button" class="close" id="followCancel" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						<div class="header" id="header" style="margin-bottom: 10px; margin-top: 13px; margin-left: 40px;">
							<h3>${countFollower }</h3>팔로워
						</div>
					<div style="width:100%; height:50%;">
						<div class="followeeUser" id="followeeUser1" style="overflow: auto;">
							<c:forEach items="${memberfollowingList }" var="vo">
								<div style="text-align: center; margin-top: 10px; margin-left: 1%; width:11.5%; float:left;">
								<a href="/member/memberPage?m_no=${vo.m_no }"><img class="userImg" src="/upload/${vo.fu_storedname }"/></a>
									<br><br>
									${vo.m_nick }
									<br><br>
										<c:if test="${vo.followcheck eq 0 }">
											<a onclick="follower(${vo.m_no })"><input type="button" id="followerIN${vo.m_no }" class="list_FOLLOW" value="FOLLOW"></a>
										</c:if>
										<c:if test="${vo.followcheck eq 1 	 }">
											<a onclick="follower(${vo.m_no })"><input type="button" id="followerIN${vo.m_no }" class="list_UNFOLLOW" value="UNFOLLOW"></a>
										</c:if>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>	
				
			<!-- 멤퍼페이지에서 팔로우 당한 리스트 -->
			<div class="bg_follow" id="bg_follow1"></div>
				<div class="follow_display" id="follow_display1">
						<input type="hidden" id="m_no"  name="m_no" value="${mypage.m_no }">
							<button type="button" class="close" id="followCancel1" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						<div class="header" id="header" style="margin-bottom: 10px; margin-top: 13px; margin-left: 40px;">
							<h3>${countFollower }</h3>팔로워
						</div>
					<div style="width:100%; height:50%;">
						<div class="followeeUser" id="followeeUser1" style="overflow: auto;">
							<c:forEach items="${memberfollowList }" var="vo">
								<div style="text-align: center; margin-top: 10px; margin-left: 1%; width:11.5%; float:left;">
								<a href="/member/memberPage?m_no=${vo.m_no }"><img class="userImg" src="/upload/${vo.fu_storedname }"/></a>
									<br><br>
									${vo.m_nick }
									<br><br>
										<c:if test="${vo.followcheck eq 0 }">
											<a onclick="follower1(${vo.m_no })"><input type="button" id="followerIN1${vo.m_no }" class="list_FOLLOW" value="FOLLOW"></a>
										</c:if>
										<c:if test="${vo.followcheck eq 1  }">
											<a onclick="follower1(${vo.m_no })"><input type="button" id="followerIN1${vo.m_no }" class="list_UNFOLLOW" value="UNFOLLOW"></a>
										</c:if>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>	
	
	
	
