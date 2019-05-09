<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
.mypageLine{

	width: 100%;
    height: 254px;
    background-color: #61d2d6;
    padding-top: 20px;
}
.mypageNick{
	
	text-align: center;
	color: white;
	font-size: 18px;
}
.mySet{

	width: 25px;
}
.imt_loaded{
	
	border-radius: 150px;
	width : 90px;
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

    
    
    
</style>
<script type="text/javascript">
function showSetting() {
	document.getElementById("set_display").style.display="block";
	document.getElementById("bg_set").style.display="block";//배경 어둡게 하는 것
}

//비밀번호 정규식
var regex = /^[A-Za-z0-9]{6,12}$/;



$(document).ready(function() {
	
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
		<div class="mypageNick">안녕, ${mypage.m_nick }  
		<a onclick="showSetting()"><img class="mySet" src="/resources/image/mypage/settings.png"/></a></div>
		<div class="img_placeholder">
				<img class="imt_loaded" src="/upload/${mypage.fu_storedName }" />
		</div>

	
		
	</div>
	
	
	<div class="bg_set" id="bg_set"></div>
		<div class="set_display" id="set_display">
				<div style="padding: 20px;">
					비밀번호를 입력해 주세요.
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
						<div class="form-group">
						<button type="button" id="changeImg" class="btn btn-default"
						style="width: 285.83px; margin-left: 38px; background: #009994; color: white;">프로필 사진 변경</button>
						</div>
						<!-- 비밀번호 입력 창 -->
						<div class="form-group">
							<button type="button" id="changeNick" class="btn btn-default"
						style="width: 285.83px; margin-left: 38px; background: #009994; color: white;">nick 변경</button>
						</div>
						<div class="form-group">
						<button type="button" id="changePass" class="btn btn-default"
						style="width: 285.83px; margin-left: 38px; background: #009994; color: white;">비밀번호 변경</button>
						</div>
							<form action="/mypage/deleteUser" method="post">
								<div class="form-group">
									<input type="hidden" name="m_no" value="${mypage.m_no }"/>
									<button type="submit" id="deleteUser" class="btn btn-default"
									style="width: 285.83px; margin-left: 38px; background: #009994; color: white;">회원 탈퇴</button>
								</div>
							</form>
			</div>
		</div>
		
		
		
	<div class="bg_set" id="bg_set2"></div>
		<div class="set_display" id="set_display2">
			<form action="/mypage/changepass" method="post">
				<div style="padding: 20px;">
					새 비밀번호를 입력해 주세요.
						<input type="hidden" name="m_no" value="${mypage.m_no }"/>
						<div class="form-group">
							<input type="password" class="form-control" name="m_pw" id="m_pw_set1" placeholder="새비밀번호">
						</div>
						<div id="ChangePassChk" style="text-align: center; color: red;"></div>
						<div class="form-group">
							<input type="password" class="form-control" name="m_pw1" id="m_pw_set2" placeholder="새비밀번호 확인">
						</div>
					<div class="form-group">
						<button type="button" id="changePass" class="btn btn-default"
						style="width: 285.83px; margin-left: 38px; background: #009994; color: white;">변경</button>
						<div id="resultPass1" style="text-align: center;"></div>
				</div>

				</div>
			</form>
		</div>
		
	<div class="bg_set" id="bg_set3"></div>
		<div class="set_display" id="set_display3">
			<form action="/mypage/changenick" method="post">
				<div style="padding: 20px;">
					새 비밀번호를 입력해 주세요.
						<input type="hidden" name="m_no" value="${mypage.m_no }"/>
						<div class="form-group">
							<input type="text" class="form-control" name="m_nick" id="m_nick_mypage" placeholder="새로운 nick 등록">
						</div>
						<div id="ChangePassChk" style="text-align: center; color: red;"></div>
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
			
		
		
	
	
	
