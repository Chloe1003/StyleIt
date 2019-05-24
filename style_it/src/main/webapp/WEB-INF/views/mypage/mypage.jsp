<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
    width: 1200px;
	height: auto;
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
	z-index:9999;
}    
.userImg{
	border-radius: 150px;
    width: 93px;
    height: 93px;
   /*  margin-left: 50px;
    margin-right: inherit; */
}
.message_display{
	position: fixed; width:365px; display:none; font-family:nanum; 
	margin-left: auto; margin-right: auto; background : white;
	top : 50%;
   	left:50%;
    transform:translateX(-50%) translateY(-50%);
    z-index:9999;
	width: 600px;
	height: auto;
	
}
.message_display1{
	position: fixed; height: 640px; width: 680px; display:none; font-family:nanum;
	margin-left: auto; margin-right: auto; background : white;
	top : 50%;
   	left:50%;
    transform:translateX(-50%) translateY(-50%);
    z-index:9999;
	
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
function showMyStylingList() {
	location.href ="/mypage/mystylinglist?m_no=${m_no}";
}
function Stylinglikelist() {
	location.href ="/mypage/Stylinglikelist?m_no=${m_no}";
}
function showQuiz() {
	location.href ="/mypage/quiz?m_no=${m_no}";
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
			   	    	html += '<a href="/member/memberPage?m_no='+item.m_no+'"><img class="userImg" src="/upload/'+item.fu_storedname+'"/></a>'
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
function showMail() {
	
	document.getElementById("mrlist_display").style.display="block";
	document.getElementById("bg_mrlist").style.display="block";
		 
}
Date.prototype.format = function (f) {

    if (!this.valueOf()) return " ";



    var weekKorName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];

    var weekKorShortName = ["일", "월", "화", "수", "목", "금", "토"];

    var weekEngName = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];

    var weekEngShortName = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];

    var d = this;



    return f.replace(/(yyyy|yy|MM|dd|KS|KL|ES|EL|HH|hh|mm|ss|a\/p)/gi, function ($1) {

        switch ($1) {


            case "yy": return (d.getFullYear() % 1000).zf(2); // 년 (2자리)

            case "MM": return (d.getMonth() + 1).zf(2); // 월 (2자리)

            case "dd": return d.getDate().zf(2); // 일 (2자리)

            case "HH": return d.getHours().zf(2); // 시간 (24시간 기준, 2자리)

            case "mm": return d.getMinutes().zf(2); // 분 (2자리)

            case "ss": return d.getSeconds().zf(2); // 초 (2자리)

            default: return $1;

        }

    });

};
String.prototype.string = function (len) { var s = '', i = 0; while (i++ < len) { s += this; } return s; };

String.prototype.zf = function (len) { return "0".string(len - this.length) + this; };

Number.prototype.zf = function (len) { return this.toString().zf(len); };
function showMessage1(mr_no, m_no) {
	aaa= m_no
	$.ajax({
		type : "get"
		,url : "/message/Mr_no"
		,data : { "mr_no" : mr_no,
					"m_no" : m_no	}
		,dataType : "json"
		,success : function( res ) {
			var list = res.MessageList
			console.log("성공");
			console.log(res.m_no);
				var html ="";
			
			$.each( list, function(index, value) {
				var date = new Date(value.msg_date);
				date.format('yy/MM/dd, HH:mm:ss');
				
				
							
				if( value.receiver_no == m_no ){
					
					html += '<p style="margin-bottom: -4px; margin-top: 8px;">'+value.m_nick+' '+ date.format('yy/MM/dd, HH:mm:ss') +'</p>';
					html += '<p style="width: 300px; height: 30px; background-color: #ffff9e; display: inline-block; font-weight: bold; font-size: 17px;">'+value.msg_content+'</p>';
					html += '<div style="position: relative; display: inline-block"><img style="border-radius: 150px; width: 45px;height: 45px;"src="/upload/'+value.fu_storedname+'"</img></div>';
					html += '<hr>'
				
				}else{
					
					html += '<p style="margin-bottom: -4px; margin-top: 8px;">'+value.m_nick+' '+ date.format('yy/MM/dd, HH:mm:ss') +'</p>';
					html += '<p style="width: 300px; height: 30px; background-color: #87e1ff; display: inline-block; font-weight: bold; font-size: 17px;">'+value.msg_content+'</p>';
					html += '<div style="position: relative; display: inline-block"><img style="border-radius: 150px; width: 45px;height: 45px;"src="/upload/'+value.fu_storedname+'"</img></div>';
					html += '<hr>'
				}
				
			} );
			
// 			html += value.m_nick
			 $("#meaa").html(html);
			$('#chatAreabox').scrollTop($('#chatAreabox')[0].scrollHeight);
			
			
		}
		,error : function(e) {
			console.log("실패");
			console.log(e);
		}
	});
	
	showMessage(msg_content);
	 
	
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

var aaa = 0;
$(document).ready(function() {
	$("#sendMsg").click(function() {

		$.ajax({
			type : "post"
			,url : "/message/insertmr"
			,data : { "m_no" : aaa,
					  "msg_content" : $("#msg_content").val() }
			,dataType : "json"
			,success : function( res ) {
				console.log("성공");
				console.log(res.message.msg_content);
				 $("#msg_content").focus();				
				
			}
			,error : function(e) {
				console.log("실패");
				console.log(e);
			}
			});
			
		});
	// 비밀번호 정규식 
	$("#messageListCancel").click(function() {
		document.getElementById("mrlist_display").style.display = "none"; 
		document.getElementById("bg_mrlist").style.display = "none";
		location.reload();
	})
	$("#messageCancel").click(function() {
		document.getElementById("Message_display").style.display = "none"; 
		document.getElementById("bg_Message").style.display = "none";
		location.reload();
		disconnect();
	})
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
			<a style="cursor: pointer;" onclick="showMail()"><img class="mail" src="/resources/image/mypage/mail.png"/></a>
				<span style="position: relative; left: 290px; border: solid 2px red; border-radius: 8px; background-color: red; top: -7px;" >${countAllRead }</span>
			<a style="cursor: pointer;" onclick="showQuiz()"><img class="sQuiz" src="/resources/image/mypage/clipboard.png"/></a>
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
			<span style="position: relative; left: 25px; font-size: 20px; font-weight: bold;">
			<a style="cursor: pointer; color: black" onclick="showMyStylingList()">${countStyling }</a></span>
		<br>스타일링</div>
		<div class="lBottom" style="position: relative; bottom: -13px; left: 490px;">
			<span style="position: relative; left: 15px; font-size: 20px; font-weight: bold;">
				<a style="cursor: pointer; color: black" onclick="showProductLikeList()">${countLike }</a></span>

		<br><span style="position: relative; left: -22px;">Product 좋아요</span></div>
		<div class="cBottom" style="position: relative; bottom: 36px;  left: 740px;">
			<span style="position: relative; left: 15px; font-size: 20px; font-weight: bold;">
			<a style="cursor: pointer; color: black" onclick="Stylinglikelist()">${countCollection }</a></span>
		<br><span style="position: relative; left: -20px;">Styling 좋아요</span></div>


	
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
				
				
				<!-- 채팅방 리스트 -->	
				<div class="bg_follow" id="bg_mrlist"></div>
					<div class="message_display" id="mrlist_display">
						<button type="button" class="close" id="messageListCancel" aria-label="Close"><span aria-hidden="true">&times;</span></button>
								<div style="background-color: #61d2d6; height: 80px; text-align: center; padding-top: 29px; font-size: 22px; color: white;">Messages</div>
								
									<div style="width:100%; height:auto;">
										<div id="mrList1" style="overflow-y: scroll; height: 460px">
													<c:forEach items="${MRList }" var="mr">
			 											<div style="background-color: #f2feff; text-align: center; margin-top: 10px; margin-left: 1%; border: 2px solid rgba(231,214,207,.66); width: 98%; height: 100px; padding: 25px 100px;">
															<p style="margin-bottom: -4px; margin-top: 8px; font-size: 10px; color: #b0b0b0;">
																<fmt:formatDate value="${mr.mr_date }" pattern="yy/MM/dd, HH:mm:SS"/>
															<span style="color: red; font-size: 14px; font-weight: bold;">${mr.notRead }</span>
															</p>
															<input type="hidden" id="m_no" name=m_no value="${mr.m_no }"/>
															<a onclick="showMessage1(${mr.mr_no }, ${mr.m_no })" style="width: 300px; height: 30px; margin: auto; display: inline-block; font-size: 20px; cursor: pointer;">
																	${mr.m_nick }
															</a>
															<div style="position: relative; display: flex;  bottom: 45px; width: 45px;">
																<a href="/member/memberPage?m_no=${mr.m_no }"><img style="border-radius: 150px; width: 45px;height: 45px;" src="/upload/${mr.fu_storedname }"/></a>
															</div> 
														</div>
													</c:forEach>
											</div>
	  							   	  </div> 
							</div>
				
				
				<!-- 챠팅방 -->
						<div class="bg_follow" id="bg_Message"></div>
							<div class="message_display1" id="Message_display">
					  				<input type="hidden" id="m_no"  name="m_no" value="${mypage.m_no }">
						  				<button type="button" class="close" id="messageCancel" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
								<div style="background-color: #61d2d6; height: 80px; text-align: center; padding-top: 29px; font-size: 22px; color: white;">MessageRoom</div>
									<div style="width:100%; height:auto;">
											<div id="chatAreabox" style="overflow-y: scroll; height: 460px">
												<div id="meaa"style="text-align: center; margin-top: 10px; margin-left: 1%;"></div>
											</div>
	  							   	  </div> 
	  							  <div style="width: 100%; height: 100px; background-color: #e8e8e8;">
										<input type="text" id="msg_content" name="msg_content" placeholder="메세지를 입력해주세요."
										style="width: 524px; height: 75px; margin-left: 61px; margin-top: 12px;
											   font-size: 16px; line-height: 18px; color: #b0b0b0;"/>
				  						<input type="button" id="sendMsg"value="SEND" 
				  						style="height: 40px; width: 67px; background-color: #61d2d6; border-color: #61d2d6; border: none; font-size: 18px; color: white;"/>
	  							  </div>
							</div>
				
				
<script>
// sockjs 를 이용한 서버와 연결되는 객체
var ws = null;
var user_nick= null;
var first = 0;
function showMessage(msg_content) {
	
	document.getElementById("mrlist_display").style.display = "none"; 
	document.getElementById("bg_mrlist").style.display = "none";
	document.getElementById("Message_display").style.display="block";
	document.getElementById("bg_Message").style.display="block";//배경 어둡게 하는 것 
	 $("#msg_content").focus();
	 $('#chatAreabox').scrollTop($('#chatAreabox')[0].scrollHeight);
	 
	 if(first==0){
			connect();
			first++;
		}
    console.log(msg_content);
    var jsonMessage = JSON.parse(msg_content);
    var curDate =  new Date();
   
    if('${m_nick}' == jsonMessage.m_nick){
       
		$("#meaa").append('<p style="margin-bottom: -4px; margin-top: 8px;">'+jsonMessage.m_nick+  curDate.format('yy/MM/dd, HH:mm:ss')+'</p>');
		$("#meaa").append('<p style="width: 300px; height: 30px; background-color: #ffff9e; display: inline-block; font-weight: bold; font-size: 17px;">'+jsonMessage.msg_content+'</p>');
		$("#meaa").append('<div style="position: relative; display: inline-block"><img style="border-radius: 150px; width: 45px;height: 45px;"src="/upload/'+jsonMessage.fu_storedname+'"</img></div>');
		$("#meaa").append('<hr>');
    }else{
    	$("#meaa").append('<p style="margin-bottom: -4px; margin-top: 8px;">'+jsonMessage.m_nick+ '</p>');
    	$("#meaa").append('<p style="width: 300px; height: 30px; background-color: #87e1ff; display: inline-block; font-weight: bold; font-size: 17px;">'+jsonMessage.msg_content+'</p>');
    	$("#meaa").append('<div style="position: relative; display: inline-block"><img style="border-radius: 150px; width: 45px;height: 45px;"src="/upload/'+jsonMessage.fu_storedname+'"</img></div>');
    	$("#meaa").append('<hr>');
    }
	
	$('#chatAreabox').scrollTop($('#chatAreabox')[0].scrollHeight);
	

}


function connect() {
    // SockJS라이브러리를 이용하여 서버에 연결
    ws = new WebSocket("ws://localhost:8088/chatEcho");
  	console.log(ws);

    // 서버가 메시지를 보내주면 함수가 호출된다.
    ws.onmessage = function(msg_content) {
        showMessage(msg_content.data);
    }
}

function disconnect() {
    if (ws != null) {
        ws.close();
    }
    setConnected(false);
    console.log("Disconnected");
}

function send() {
    // 웹소켓 서버에 메시지를 전송
    ws.send(JSON.stringify({'msg_content': $("#msg_content").val()}));
    // 채팅입력창을 지우고 포커싱하라.
    $("#msg_content").val('');
    $("#msg_content").focus();
}


// $(함수(){ 함수내용 });  // jquery에서 문서가 다 읽어들이면 함수()를 호출한다.
$(function () {
//        connect();
    // 채팅입력창에서 키가 눌리면 함수가 호출
    // 엔터를 입력하면 send()함수가 호출
    $("#msg_content").keypress(function(e) {
        if (e.keyCode == 13){
            send();
        }
    });

    $( "#sendMsg" ).click(function() { send(); });
});
</script>
				
				
				
	
