
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style type="text/css">
/* 로그인창 스타일 */
.login_display {
	position: fixed; width:365px; display:none; font-family:nanum; border-radius: 27px; 
	margin-left: auto; margin-right: auto; background : white;
	top : 50%;
   	left:50%;
    transform:translateX(-50%) translateY(-50%);
    z-index:9999;}/* 위치 가운대로 지정 *


/*회원가입창 스타일  */
.join_display1 {
	position: fixed;
	width: 500px;
	display: none;
	font-family: nanum;
	margin-left: auto;
	border-radius: 27px;
	margin-right: auto;
	background: white;
	top: 50%;
	left: 50%;
	transform: translateX(-50%) translateY(-50%);
	z-index:9998;
}

/* 뒷배경 설정 */
.bg {
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

.bg1 {
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
//숨겨둔 로그인창처리
	function showlogin(){
		document.getElementById("login_display").style.display="block";
		document.getElementById("bg").style.display="block";//배경 어둡게 하는 것
		document.getElementById("join_display").style.display = "none"; //회원가입창 감추기
		document.getElementById("bg1").style.display = "none";
	}
//숨겨둔 회원가입창	
	function showjoin() {
		document.getElementById("join_display").style.display = "block";
		document.getElementById("bg1").style.display = "block";//배경 어둡게 하는 것
		document.getElementById("login_display").style.display = "none";
		document.getElementById("bg").style.display = "none";
	}
	
	function logout() {
		alert("로그아웃 되었습니다.");
		location.href = "/member/logout";
	}
	function mypage(){
		location.href="/mypage/mypage?m_no=${m_no }";
	}
	
	function adminpage(){
		location.href="/admin/user/list";
	}
	
</script>

<script type="text/javascript">

	/* 회원가입 정규식 */
	var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	// 비밀번호 정규식
	var regex = /^[A-Za-z0-9]{6,12}$/;
	// 중복체크 했느냐
	var Chk = false;
	
	$(document).ready(function() {
		
		/* 회원가입 */
		$("input").eq(0).focus();
		
		$("#m_pw").keyup(function() {
			if(!regex.test($("#m_pw").val())) {
				$("#pwChk").html("숫자와 문자 포함 형태의 6~12자리 이내의 암호");
				$("#pwChk").css("color","red");
			}
			if(regex.test($("#m_pw").val())) {
				$("#pwChk").html("사용 가능한 비밀번호 입니다");
				$("#pwChk").css("color","blue");
			}
		});
		
		
			
			$(this).parents("form").submit();
						$("#joinCancel").click(function() {
							document.getElementById("join_display").style.display = "none"; //회원가입창 감추기
							document.getElementById("bg1").style.display = "none";
						});
						$("#loginCancel").click(function() {
							document.getElementById("login_display").style.display = "none";
							document.getElementById("bg").style.display = "none";
						});
			
			$("#btnlogin").click(function() {
				
				$.ajax({
					type : "post"
					,url : "/member/login"
					,data : { "m_email" : $("#m_emaillogin").val()
							  ,"m_pw" : $("#m_pwlogin").val()	
							  }
					,dataType : "json"
					,success : function (data) {
							console.log(data.login);
							if(data.login==true){
							console.log("성공");
							alert("로그인 성공");
							location.href = "/main";
							}else{
							console.log("실패");
							 $("#loginChk").html("로그인 실패");
							 $("#loginChk").css("color","red");
							}
						}
						,error : function(e) {  
							console.log("실패");
						}
					});
						
				});

			$("#check").click(function() {

					$.ajax({
						type : "post"
						,url : "/member/joincheck"
						,data : { "m_email" : $("#m_email").val() }
						,dataType : "json"
						,success : function( data ) {
							console.log("성공");
							console.log(data);
							console.log(data.hashMap.check);
									
						   if(m_email.value=="") {
						   $("#idChk").html("이메일을 입력해 주세요");
						   $("#idChk").css("color","red");
								        
						         m_email.focus();
						        return false;
						   }

						   if(!check(re2, m_email, "적합하지 않은 이메일 형식입니다.")) {
						         return false;
						    }
									
						    if(data.hashMap.check==1){
							$("#idChk").html("사용 가능한 아이디입니다.");
							$("#idChk").css("color","blue");
							Chk = true;
						    }else{
						 		console.log("중복된아이디");
							$("#idChk").html("사용 불가한 아이디입니다.");
							$("#idChk").css("color","red");
								$('#m_email').val('');
								 m_email.focus();
							}
						}
						,error : function(e) {
							console.log("실패");
							console.log(e);
						}
						});
							
					});
						
			});		

	function joinAllChk() {
		
		if(Chk == false){
			$("#idChk").html("아이디 중복검사가 필요합니다");
			$("#idChk").css("color","red");
			m_email.focus();
     	   return false;
        }
		if(m_pw.value=="") {
			$("#pwChk").html("비밀번호를 입력해 주시오");
			$("#pwChk").css("color","red");
            m_pw.focus();
            return false;
	   
         }
		 if(m_nick.value=="") {
             $("#nickChk").html("nick을 입력해세요");
 			   $("#nickChk").css("color","red");
             m_nick.focus();
             return false;
         }
		
	};
	function check(re, what, message) {
		 if(re.test(what.value)) {
			return true;
			 }
			$("#idChk").html(message);
			$("#idChk").css("color","red");
			 what.value = "";
			 what.focus();
			 //return false;
		}
			
</script>


<script type="text/javascript">
	$(document).ready(function() {

		$("#logo").click(function() {
			location.href = "/main";
		});
		
		$("#create").click(function(){
			   var login = false;   
			   
			   if(${login ne true}){
//			       console.log("비로그인");
			      showlogin();
			      
			   } else {   
				location.href = "/styling/create";
			   }
		});
		
		$("#style").click(function(){
			location.href = "/main";
		});
	});
</script>


<!-- Start Header Area -->
<nav class="navbar navbar-default navbar-fixed-top" 
	style=" background-image: linear-gradient(to bottom, #fff 100%, #f8f8f8 100%); position: sticky; z-index: 9999; margin-bottom: 0;">
	<div class="container">
		<div class="row">
			<div class="navbar-header" style="margin-left: 45%">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<h1
					style="color: #009994; font-family: 'Permanent Marker', cursive; margin-bottom: 15px;">
					<span id="style" style="cursor:pointer">
					style it
					</span>
					</h1>
			</div>
			<div id="navbar" class="navbar-right">
				<ul class="nav navbar-nav" style="font-size: 0.85em;">
					<li><a href="javascript:void(0)" id="create">CREATE+&nbsp;<span><img alt="faq"
								src="/resources/image/main/hanger.png" style="width: 20px;"></span></a></li>
					<c:if test="${m_nick eq 'admin' }">  
						<li><a href="javascript:void(0);" onclick="adminpage();">ADMINPAGE</a></li>
					</c:if>
					<c:if test="${login eq true }">   
						<li><a href="javascript:void(0);" onclick="mypage();">MYPAGE</a></li>
						<li><a href="javascript:void(0);" onclick="logout();">LOGOUT</a></li>
					</c:if>
					<c:if test="${empty login }">
						<li><a href="javascript:void(0);" onclick="showjoin();">JOIN</a></li>
						<li><a href="javascript:void(0);" onclick="showlogin();">LOGIN</a></li>
					</c:if>

					<li><a href="faq"><span><img alt="faq" src="/resources/image/main/faq.png" style="width: 20px;"></span></a></li>
				</ul>
			</div>
		</div>

	</div>
</nav>

<!-- 뒷배경 -->
<div class="bg" id="bg"></div>
<!-- 숨겨둔 로그인창 -->
<div class="login_display" id="login_display">

	<div class="login_title">
		<p style="padding: 20px 0px 0px 20px; font-size: 19px; font-weight: bold;">로그인</p>
		<button type="reset" class="close" id="loginCancel" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>

	</div>
	<hr>
	<!-- 로그인 form -->
	<form action="/member/login" style="z-index: 999;" method="post"
		class="form-horizontal">
		<div style="padding: 20px;">

			<!-- 로그인 입력 창 -->
			<div class="form-group">
				<input type="text" class="form-control" name="m_email" id="m_emaillogin" placeholder="이메일 주소">
			</div>
			<div style="text-align: center; color: red;" id="LoginUseremailBlankChk"></div>
			<!-- 비밀번호 입력 창 -->
			<div class="form-group">
				<input type="password" class="form-control" name="m_pw" id="m_pwlogin" placeholder="비밀번호">
			</div>
			<!-- 로그인폼의 로그인, 회원가입 버튼 -->
			<div class="form-group">
				<button type="button" id="btnlogin" class="btn btn-default"
				style="width: 285.83px; margin-left: 38px; background: #009994; color: white;">로그인</button>
				<div id="loginChk" style="text-align: center;"></div>
			</div>

		</div>
	</form>
</div>

<!-- 숨겨둔 회원가입창 -->
<div class="bg1" id="bg1"></div>
<div class="join_display1" id="join_display">
	<div class="login_title">
		<p style="padding: 20px 0px 0px 20px; font-size: 19px; font-weight: bold;">회원가입</p>
		<button type="reset" class="close" id="joinCancel" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
	<hr>


	<form action="/member/join" method="post" class="form-horizontal" onsubmit="return joinAllChk()">
		<div style="padding: 20px;">
			<div class="form-group form-inline">
				<label for="m_email" class="col-sm-3 control-label ">이메일주소</label>
				<div class="col-sm-7" style="padding: 0;">
					<input type="text" id="m_email"name="m_email" class="form-control"	style="width: 285.83px;"/>
						<div id="idChk"></div>
				</div>
				<button type="button" id="check" style="height: 33px; color: white; background-color: #009994;">중복검사</button>
			</div>
		
			
			
			
							
			<div class="form-group">
				<label for="m_pw" class="col-sm-3 control-label">패스워드</label>
				<div class="col-sm-7" style="padding: 0;">
					<input type="password" id="m_pw" name="m_pw" class="form-control"/>
						<div id="pwChk"></div>
				</div>
			</div>
		
			<div class="form-group">
				<label for="m_nick" class="col-sm-3 control-label">nick</label>
				<div class="col-sm-7" style="padding: 0;">
					<input type="text" id="m_nick" name="m_nick" class="form-control" />
						<div id="nickChk"></div>
				</div>
			</div>

			<button type="submit" id="btnJoin" class="btn btn-default"
				style="width: 285.83px; margin-left: 107px; background: #009994; color: white;">가입</button>

			<div class="col-sm-offset-4"></div>
		</div>
	</form>
</div>





<!-- End Header Area -->

