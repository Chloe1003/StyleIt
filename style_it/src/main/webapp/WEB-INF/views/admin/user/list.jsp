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
   <form action="/admin/user/listDelete" id="listDelete" method="post">     
	   <table class="table table-hover table-condensed">
	   <thead>
		   <tr>
			   <th width="5%"><input type="checkbox" id="checkAll"></th>
			   <th width="15%">닉네임</th>
			   <th width="30%">이메일</th>
			   <th width="20%">가입일</th>
			   <th width="10%">활성여부</th>
			   <th width="20%">관리</th>
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
			   <td><c:if test="${m.m_valid eq 'y'}">활성</c:if>
			   <c:if test="${m.m_valid eq 'n'}">비활성</c:if></td>
			   <td><button class="memUpdate" style="background-color: transparent; border-color: transparent;" data-target="#updateTag_display" data-toggle="modal" onclick="update()"> 정보 수정</button></td>
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
// 		function checkedListSubmit(){
// 			var checkedList = []; // 배열 초기화
// 			$("input[name='selectedList']:checked").each(function(i){
// 				checkedList.push($(this).val()); // 체크된 값 뽑아서 배열에 넣음
// 			});
			
// 			console.log(checkedList);
// 			console.log();
			
// 			$.ajax({
// 				type : "post",
// 				url : "/board/listDelete",
// 				data : {"checkedList": JSON.stringify(checkedList) },
// 				dataType : "text"
// 			});
// 		};
});

</script>