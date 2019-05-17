<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<style>
th, td{
text-align:center;
}

</style>
<div class="container">
 	<div class="jumbotron" style="padding: 5px;background-color: #eee0;border-bottom: 1px solid #ccc;border-radius: 0;" >
		<h3>회원관리</h3>
	</div>
	
    <div class="input-group">
		<input type="text" class="form-control" placeholder="이메일검색" id="emailSearch">
		   <span class="input-group-btn">
		   	<button class="btn btn-default" type="button" id="search">검색</button>
		   </span>
	</div><!-- /input-group --><br><hr>
   <form action="/admin/user/disable" id="listDelete" method="post">     
	   <table class="table table-hover table-condensed">
	   <thead>
		   <tr>
			   <th width="5%"><input type="checkbox" id="checkAll"></th>
			   <th width="20%">닉네임</th>
			   <th width="40%">이메일</th>
			   <th width="20%">가입일</th>
			   <th width="15%">관리</th>
		   </tr>
	   </thead>
	   <tbody>
	   <c:if test="${mList.size()>0 }">
	   <c:forEach items="${mList }" var="m">
		   <tr>
		   	   <td><input type="checkbox" name="checkedList" id="checkedList" value="${m.m_no }"></td>
			   <td>${m.m_nick }</td>
			   <td>${m.m_email }</td>
			   <td><fmt:formatDate value="${m.m_date }" pattern="yyyy-MM-dd"/></td>
			   <td><div class="update_button" onclick="member_update(${m.m_no })" style="cursor:pointer;">정보 수정</div></td>
		   </tr>
	   </c:forEach>
	   </c:if>
	   <c:if test="${mList.size() eq 0 }">
			<tr>
				<td colspan="6">해당하는 회원이 없습니다</td>
			</tr>
			</c:if>
	   
	   </tbody>
	   </table>
	</form>
	<button type="button" class="btn btn-sm btn-danger" id="delete" style="float:right;">삭제</button>

	<jsp:include page="./pagingMember.jsp"/>

</div>
<br><br><br>

<div class="modal fade" id="updateMember" tabindex="-1" role="dialog" aria-labelledby="updateMember" aria-hidden="true" style="padding-top: 10%;">
		<div class="modal-dialog">
			<div class="modal-content" style="width: 500px;">
				<div class="modal_header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
					 <h4 class="modal-title" id="myModalLabel" style="margin: 20px;text-align: center;">회원 정보 수정</h4>
				</div>
				<div class="modal_body" style="padding: 0 7%;">
				
		    		<form class="form-horizontal" id="profileform" action="/admin/user/updateprofile" method="post">
					<div class="row">
		 
					  <div class="form-group">
					  	<label for="email" class="col-sm-3 control-label">이메일</label>
					  		<div class="col-sm-8">
						      <input type="text" class="form-control" name="m_email" readOnly>
						   </div>
						</div>
					  <div class="form-group">
					    <label for="nick" class="col-sm-3 control-label">닉네임</label>
					    <div class="col-sm-8">
					    	<input type="text" class="form-control" name="m_nick" id="m_nickUpdate">
					    	<div id="nickUpdateChk"></div>
					    </div>
					  </div>
				
					  <div class="form-group">
					    <label for="pw" class="col-sm-3 control-label">비밀번호</label>
					    <div class="col-sm-8">
					    	<input type="text" class="form-control" name="m_pw" id="m_pwUpdate">
					    	<div id="pwUpdateChk"></div>
					    </div>
					  </div>
					  
					  <input type="hidden" name="m_no" value=>
				    	  
					  	<button type="button" id="changeProfile" class="btn btn-default" style="margin: 0 40% 20px 40%;">수정하기</button>
					</div> 	 
					</form>
							
				
				
				</div>
			</div>
		</div>
</div>



<script>

$(document).ready(function(){
		$("#search").click(function(){
			var search = $("#emailSearch").val();
			location.href="/admin/user/list?search="+search;		
		});
		
		$("#delete").click(function(){
			var msg="정말 삭제함?";
			var flag = confirm(msg);
			if(flag==true){
				console.log("삭제됨");
// 				checkedListSubmit();
				$("#listDelete").submit();

			} else {
				
			}
		});
		
		$("#checkAll").click(function(){
			
			var checked = $("#checkAll").prop("checked");
			console.log(checked);
			
			if(checked){
			$("input[type='checkbox'][name='checkedList']").prop("checked",true);

			} else {
			$("input[type='checkbox'][name='checkedList']").prop("checked",false);			
			}
			

		});
		
// 		$(".update_button").click(function(){
// 			$(this).
// 			$("#updateMember").modal();
// 		});

		// 비밀번호 정규식
	var regex = /^[A-Za-z0-9]{6,12}$/;
	
	$("#m_pwUpdate").blur(function() {
		
		console.log($("#m_pwUpdate").val());
		console.log(regex.test($("#m_pwUpdate").val()));
		
			if(!regex.test($("#m_pwUpdate").val())) {
				$("#pwUpdateChk").html("숫자와 문자 포함 형태의 6~12자리");
				$("#pwUpdateChk").css("color","red");
				$("#pwUpdateChk").css("font-size","9px");
			}
			if(regex.test($("#m_pwUpdate").val())) {
				$("#pwUpdateChk").html("사용 가능한 비밀번호 입니다");
				$("#pwUpdateChk").css("color","blue");
				$("#pwUpdateChk").css("font-size","9px");

			}
		});
	
	$("#changeProfile").click(function(){

		if($("#m_pwUpdate").val()=="") {
			$("#pwUpdateChk").html("비밀번호를 입력해 주세요");
			$("#pwUpdateChk").css("color","red");
			$("#pwUpdateChk").css("font-size","9px");

			$("#m_pwUpdate").focus();
            return false;
	   
         } else if($("#m_nickUpdate").val()=="") {
             $("#nickUpdateChk").html("닉네임을 입력해 주세요");
 			 $("#nickUpdateChk").css("color","red");
			 $("#pwUpdateChk").css("font-size","9px");

			 $("#m_nickUpdate").focus();
             return false;
         } else {
        	 $("#profileform").submit();
         }
		
		
	});

		
});


function member_update(m_no){
	console.log("수정요청");
	
	$.ajax({
		type : "get",
		url : "/admin/user/profile",
		data : {"m_no": m_no },
		dataType : "json",
		success : function(res){
			
			$("input[type='hidden'][name='m_no']").val(res.m_no);
			$("input[type='text'][name='m_email']").val(res.m_email);
			$("input[type='text'][name='m_nick']").attr('placeholder', res.m_nick);
			$("input[type='text'][name='m_email']").attr('placeholder', res.m_email);
			$("input[type='text'][name='m_pw']").attr('placeholder', res.m_pw);
			
		},
		error : function(e){
			console.log("실패");
		}			
	});
	
	$("#updateMember").modal();
}

</script>