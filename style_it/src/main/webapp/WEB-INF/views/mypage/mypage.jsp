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
.mySet{
	width: 25px;
	position: relative;
    left: 400px;
}
.sQuiz{
	width: 25px;
	position: relative;
    left: 350px;
}
.mail{
	width: 25px;
	position: relative;
    left: 300px;
}
.imt_loaded{
	
	margin-left: 150px;
	border-radius: 150px;
    width: 250px;
    height: 250px;
}

/* 세팅창 스타일 */
.set_display {
	position: fixed; width:365px; display:none; font-family:nanum; border-radius: 27px; 
	margin-left: auto; margin-right: auto; background : white;
	top : 50%;
   	left:50%;
    transform:translateX(-50%) translateY(-50%);
    z-index:9999;
}
.bg_set {
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
.unfol{
    font-size: 19px;
    border: gray;
    color: white;
    border-radius: 27px;
}
.FOLLOW{
    font-size: 19px;
	color : white;
	border : #61d2d6;
    border-radius: 27px;
    background-color : #61d2d6;
    border-radius: 27px;
	border : #61d2d6;
}
.UNFOLLOW{
	color : white;
    border: gray;
    border-radius: 27px;
    font-size: 19px;
}


    
    
</style>
<script type="text/javascript">

function showProductLikeList() {
	location.href ="/mypage/Productlikelist?m_no=${m_no}";
	
}

function showSetting() {
	document.getElementById("set_display").style.display="block";
	document.getElementById("bg_set").style.display="block";//배경 어둡게 하는 것
}
	
	function  followee(m_no){
		

		$.ajax({
			type : "post"
			,url : "/member/follow"
			,data : { "m_no" : m_no }
			,dataType : "json"
			,success : function( res ) {
				console.log("성공");
				console.log(res);
				console.log(res.follower_no);
				showFollowingList();
				
			}
			,error : function(e) {
				console.log("실패");
				console.log(e);
			}
		});
			
		}
	function showFollowingList() {
		
	 	document.getElementById("follow_display").style.display="block";
		document.getElementById("bg_follow").style.display="block";//배경 어둡게 하는 것 
			var m_no = $('#m_no').val();		
			
			$.ajax({
			type : "get"
			,url : "/mypage/followinglist"
			,data : { "m_no" : m_no }	
			,dataType :  "json"
			,success : function( data ) {
			    console.log("showFollowingList성공");
			    console.log(data);
			    console.log(data.followingList);

			   	    var html = ""
			   	    var count= ""
			   	    	count += '<h3>'+data.countFollowee+'</h3>' + "팔로잉"
			   	    	
				   	    $.each(data.followingList, function(index, item) {
			   	    	
			   	    	html += '<div style="text-align: center; margin-top: 10px; margin-left: 1%; width:11.5%; float:left;">'
			   	    	html += '<a href="/member/memberPage?m_no='+item.m_no+'"><img class="userImg" src="/upload/'+item.fu_storedName+'"/></a>'
			   	 		html +='<br><br>'
			   	    	html += item.m_nick	
			   	    	html +='<br><br>'
			   	    	html += '<a onclick="followee('+item.m_no+')"><button type="button" class="unfol">UNFOLLOW</button></a>'
			   	    	html += '</div>'
			   	    		
				});  
					$('#header').html(count);
					$('#followeeUser').html(html);
			}
			,error : function(e) {
				console.log("전송안됨");
				console.log(e);
			}
			}); 
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
					$("#followerIN"+m_no).val("UNFOLLOW");
 					$("#followerIN"+m_no).removeClass("FOLLOW");
					$("#followerIN"+m_no).addClass("UNFOLLOW");
				}else{
					console.log("팔로우삭제");
 					$("#followerIN"+m_no).val("FOLLOW");
					$("#followerIN"+m_no).removeClass("UNFOLLOW");
					$("#followerIN"+m_no).addClass("FOLLOW");
				}
			}
			,error : function(e) {
				console.log("실패");
				console.log(e);
			}
		});
			
		}

function showFollowList() {
	
 	document.getElementById("follow_display1").style.display="block";
	document.getElementById("bg_follow1").style.display="block";//배경 어둡게 하는 것 
		 
}

//비밀번호 정규식
var regex = /^[A-Za-z0-9]{6,12}$/;

// 비밀번호 빈칸 및 일치확인, 널값 커밋 방지용
function chPass() {

	var a = $("#m_pw_set1").val()
	var b = $("#m_pw_set2").val()
	
	 if(a==""){
			$("#ChangePassChk1").html("새 비밀번호를 입력해 주시요");
			$("#ChangePassChk1").css("color","red");
			m_pw.focus();
			return false;
	 }
	 
	if(a==b){
		$("#ChangePassChk1").html("비밀번호가 일치합니다.");
		$("#ChangePassChk1").css("color","blue");
	}else{
		$("#ChangePassChk1").html("비밀번호가 다릅니다.");
		$("#ChangePassChk1").css("color","red");
		return false;
	}
	
};
// 닉 빈칸 및 널값 입력 방지용
function chNick() {
	 if(m_nick_mypage.value=="") {
         $("#newNickChk").html("새로운 nick을 입력해세요");
		 $("#newNickChk").css("color","red");
         m_nick.focus();
         return false;
	 }else{
		 $("#newNickChk").html("");
		 alert("Nick 변경 성공");
	 }
};
// 탈퇴 확인/취소 창
function deleteUser() {
	var dele = confirm("정말 탈퇴하시겠습니까?");
	
	if(dele==true){
		return true;
	}else{
		return false;
	}
};


$(document).ready(function() {
	// 비밀번호 정규식 
	$("#m_pw_set1").keyup(function() {
		if(!regex.test($("#m_pw_set1").val())) {
			$("#ChangePassChk").html("숫자와 문자 포함 형태의 6~12자리 이내의 암호");
			$("#ChangePassChk").css("color","red");
		}
		if(regex.test($("#m_pw_set1").val())) {
			$("#ChangePassChk").html("사용 가능한 비밀번호 입니다");
			$("#ChangePassChk").css("color","blue");
		}
	});
	// 새 비밀번호1 + 새 비밀번호2 일치하는지 확인하는 창
	$("#m_pw_set2").keyup(function() {
		var a = $("#m_pw_set1").val()
		var b = $("#m_pw_set2").val()
		
		if(a==b){
			$("#ChangePassChk1").html("비밀번호가 일치합니다.");
			$("#ChangePassChk1").css("color","blue");
		}else{
			$("#ChangePassChk1").html("비밀번호가 다릅니다.");
			$("#ChangePassChk1").css("color","red");
			return false;
		}
	});
		//X 버튼 눌렀을때 해당 화면 다시 숨기기
		$("#set_displayCancel").click(function() {
			document.getElementById("set_display").style.display = "none"; 
			document.getElementById("bg_set").style.display = "none";
		});
		$("#set_display1Cancel").click(function() {
			document.getElementById("set_display1").style.display = "none"; 
			document.getElementById("bg_set1").style.display = "none";
		});
		$("#set_display1Cance2").click(function() {
			document.getElementById("set_display2").style.display = "none"; 
			document.getElementById("bg_set2").style.display = "none";
		});
		$("#set_display1Cance3").click(function() {
			document.getElementById("set_display3").style.display = "none"; 
			document.getElementById("bg_set3").style.display = "none";
		});
		$("#set_display1Cance4").click(function() {
			document.getElementById("set_display4").style.display = "none"; 
			document.getElementById("bg_set4").style.display = "none";
		});
		$("#followCancel").click(function() {
			document.getElementById("follow_display").style.display = "none"; 
			document.getElementById("bg_follow").style.display = "none";
			location.reload();
		})
		$("#followCancel1").click(function() {
			document.getElementById("follow_display1").style.display = "none"; 
			document.getElementById("bg_follow1").style.display = "none";
			location.reload();
		})
		// 여기까지 x표시꺼 ( 위와 동일한 기능 )
		
		// 비밀번호 입력 후 각자 표시창에서 넘어갈때마다 각 창 블락 및 논 처리 하는 것
		$("#changePass").click(function() {
			document.getElementById("set_display1").style.display="none";
	    	document.getElementById("bg_set1").style.display="none";
	    	document.getElementById("set_display2").style.display="block";
	    	document.getElementById("bg_set2").style.display="block";
		})
		$("#changeNick").click(function() {
			document.getElementById("set_display1").style.display="none";
	    	document.getElementById("bg_set1").style.display="none";
	    	document.getElementById("set_display3").style.display="block";
	    	document.getElementById("bg_set3").style.display="block";
		})
		$("#changeImg").click(function() {
			document.getElementById("set_display1").style.display="none";
	    	document.getElementById("bg_set1").style.display="none";
	    	document.getElementById("set_display4").style.display="block";
	    	document.getElementById("bg_set4").style.display="block";
		})
		// 요기 까지 위와 동일한 기능
	
		// 처음 비밀번호 확인 ajax 처리
		$("#checkPass").click(function() {
		
			$.ajax({
				type : "post"
				,url : "/mypage/checkPass"
				,data : { "m_email" : $("#m_email_set").val() 
						 ,"m_pw" : $("#m_pw_set").val() }	
				,dataType : "json"
				,success : function( data ) {
					console.log("성공");
					console.log(data);
					console.log(data.hashMap.checkPass);
							
				    if(data.hashMap.checkPass==1){
				    	console.log("비번같음");
				    	// 비밀번호가 같을 때 블락, 논 처리 한 것.
				    	document.getElementById("set_display").style.display="none";
				    	document.getElementById("bg_set").style.display="none";
				    	document.getElementById("set_display1").style.display="block";
				    	document.getElementById("bg_set1").style.display="block";
				    	
				    	
				    }else{
				 		console.log("비번다름");
					$("#resultPass").html("비밀번호가 틀립니다");
					$("#resultPass").css("color","red");
						$('#m_pw_set').val('');
						m_pw_set.focus();
					}
				}
				,error : function(e) {
					console.log("전송안됨");
					console.log(e);
				}
				});
					
			});
		
});

</script>
				
	<div class="mypageLine">
		<div class="mypageNick">안녕,&nbsp;&nbsp;&nbsp;&nbsp;<span style="text-transform: capitalize; text-decoration: underline; font-size: 18px;">${mypage.m_nick }</span>  
			<img class="mail" src="/resources/image/mypage/mail.png"/>
			<img class="sQuiz" src="/resources/image/mypage/clipboard.png"/>
			<a style="cursor: pointer;" onclick="showSetting()"><img class="mySet" src="/resources/image/mypage/settings.png"/></a>
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
			<span style="position: relative; left: 15px; font-size: 20px; font-weight: bold;">
				<a style="cursor: pointer; color: black" onclick="showProductLikeList()">${countLike }</a></span>
		<br>좋아요</div>
<!-- 		<div class="cBottom" style="position: relative; bottom: 36px;  left: 740px;"> -->
<%-- 			<span style="position: relative; left: 15px; font-size: 20px; font-weight: bold;">${countCollection }</span> --%>
<!-- 		<br>컬렉션</div> -->
	
	</div>
	
	
	<div class="bg_set" id="bg_set"></div>
		<div class="set_display" id="set_display">
				<div style="padding: 20px;">
					비밀번호를 입력해 주세요.
						<button type="reset" class="close" id="set_displayCancel" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					<div class="form-group">
						<input type="hidden" class="form-control" name="m_email" id="m_email_set" value="${mypage.m_email }"/>
					</div>
						<!-- 비밀번호 입력 창 -->
						<div class="form-group">
							<input type="password" class="form-control" name="m_pw" id="m_pw_set" placeholder="비밀번호">
						</div>
					<div class="form-group">
						<button type="button" id="checkPass" class="btn btn-default"
						style="width: 285.83px; margin-left: 38px; background: #009994; color: white;">확인</button>
						<div id="resultPass" style="text-align: center;"></div>
				</div>

			</div>
		</div>
		
	<div class="bg_set" id="bg_set1"></div>
		<div class="set_display" id="set_display1">
				<div style="padding: 20px;">
					변경할 항목을 눌러 주세요
						<button type="reset" class="close" id="set_display1Cancel" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						
						<div class="form-group">
							<button type="button" id="changeImg" class="btn btn-default"
							style="width: 285.83px; margin-left: 38px; background: #009994; color: white;">프로필 사진 변경</button>
						</div>
						
						<div class="form-group">
							<button type="button" id="changeNick" class="btn btn-default"
							style="width: 285.83px; margin-left: 38px; background: #009994; color: white;">nick 변경</button>
						</div>
						
						<div class="form-group">
							<button type="button" id="changePass" class="btn btn-default"
							style="width: 285.83px; margin-left: 38px; background: #009994; color: white;">비밀번호 변경</button>
						</div>
							<form action="/mypage/deleteUser" method="post" onsubmit="return deleteUser()">
								<div class="form-group">
										<input type="hidden" name="m_no" value="${mypage.m_no }"/>
									<button id="dU" class="btn btn-default"
									style="width: 285.83px; margin-left: 38px; background: #009994; color: white;">회원 탈퇴</button>
								</div>
							</form>
			</div>
		</div>
		
		
		
	<div class="bg_set" id="bg_set2"></div>
		<div class="set_display" id="set_display2">
			<form action="/mypage/changepass" method="post" onsubmit="return chPass()"> 
				<div style="padding: 20px;">
					새 비밀번호를 입력해 주세요.
						<button type="reset" class="close" id="set_display1Cance2" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<input type="hidden" name="m_no" value="${mypage.m_no }"/>
						<div class="form-group">
							<input type="password" class="form-control" name="m_pw" id="m_pw_set1" placeholder="새비밀번호">
						</div>
								<div id="ChangePassChk" style="text-align: center;"></div>
						<div class="form-group">
							<input type="password" class="form-control" name="m_pw1" id="m_pw_set2" placeholder="새비밀번호 확인">
								<div id="ChangePassChk1" style="text-align: center;"></div>
						</div>
					<div class="form-group">
						<button id="changePass" class="btn btn-default"
						style="width: 285.83px; margin-left: 38px; background: #009994; color: white;">변경</button>
						<div id="resultPass1" style="text-align: center;"></div>
				</div>

				</div>
			</form>
		</div>
		
	<div class="bg_set" id="bg_set3"></div>
		<div class="set_display" id="set_display3">
			<form action="/mypage/changenick" method="post" onsubmit="return chNick()">
				<div style="padding: 20px;">
					새 Nick을 입력해 주세요.
						<button type="reset" class="close" id="set_display1Cance3" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<input type="hidden" name="m_no" value="${mypage.m_no }"/>
						<div class="form-group">
							<input type="text" class="form-control" name="m_nick" id="m_nick_mypage" placeholder="새로운 nick 등록">
								<div id="newNickChk" style="text-align: center;"></div>
						</div>
					<div class="form-group">
						<button type="submit" id="changeNick" class="btn btn-default"
						style="width: 285.83px; margin-left: 38px; background: #009994; color: white;">변경</button>
					<div id="resultPass1" style="text-align: center;"></div>
				</div>

				</div>
			</form>
		</div>
		
		
		<div class="bg_set" id="bg_set4"></div>
			<div class="set_display" id="set_display4">
				<form action="/mypage/insertImg" method="post" enctype="multipart/form-data">
					<div style="padding: 20px;">
						프로필 사진을 올려주세요.
							<button type="reset" class="close" id="set_display1Cance4" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<input type="hidden" name="m_no" value="${mypage.m_no }"/>
							<div class="form-group">
								<input type="file" class="form-control" name="file" id="file">
							</div>
						<div class="form-group">
							<button type="submit" id="updateUserImg" class="btn btn-default" 
							style="width: 285.83px; margin-left: 38px; background: #009994; color: white;">확인</button>
					</div>
	
					</div>
				</form>
			</div>
			<!-- 내가 팔로우한 리스트 Ajax 처리 삭제때문 -->
			<div class="bg_follow" id="bg_follow"></div>
				<div class="follow_display" id="follow_display">
						<button type="button" class="close" id="followCancel" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
				 <div class="header" id="header" style="margin-bottom: 10px; margin-top: 13px; margin-left: 40px;"></div>
					<div style="width:100%; height:50%;">
						<div class="followeeUser" id="followeeUser" style="overflow: auto;"></div>
					</div>
				</div> 
			<!-- 나를 팔로워한 리스트 -->
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
							<c:forEach items="${followList }" var="vo">
								<div style="text-align: center; margin-top: 10px; margin-left: 1%; width:11.5%; float:left;">
								<a href="/member/memberPage?m_no=${vo.m_no }"><img class="userImg" src="/upload/${vo.fu_storedname }"/></a>
									<br><br>
									${vo.m_nick }
									<br><br>
										<c:if test="${vo.followcheck eq 0 }">
											<a onclick="follower(${vo.m_no })"><input type="button" id="followerIN${vo.m_no }" class="FOLLOW" value="FOLLOW"></a>
										</c:if>
										<c:if test="${vo.followcheck eq 1  }">
											<a onclick="follower(${vo.m_no })"><input type="button" id="followerIN${vo.m_no }" class="UNFOLLOW" value="UNFOLLOW"></a>
										</c:if>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>	
	
