<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript">
//숨겨둔 로그인창처리
function showAddTag(){
	document.getElementById("addTag_display").style.display="block";
	document.getElementById("bg").style.display="block";//배경 어둡게 하는 것
}

$(document).ready(function(){
	//태그 제목 미입력시 반환처리
	$("#btnInsert").click(function(){
		if(st_name.value=="") {
			alert("태그를 입력해주세요");
			m_pw.focus();
			return false;
		}
	});
	
	$(this).parents("form").submit();
});

  
</script>

<style type="text/css">
th, td {
	margin: auto; text-align:center;
}
.modal {
        text-align: center;
}
 
@media screen and (min-width: 768px) { 
        .modal:before {
                display: inline-block;
                vertical-align: middle;
                content: " ";
                height: 100%;
        }
}
 
.modal-dialog {
        display: inline-block;
        text-align: left;
        vertical-align: middle;
}
</style>

<div class="container">

<div class="row row-offcanvas row-offcanvas-right">

<%-- <jsp:include page="/WEB-INF/views/layout/admin_sidebar.jsp" /> --%>

<div style="text-align: right; padding-bottom: 100px;" class="container">
	<div id="stylingContainer" style="display: flex;">
		<div id="styling_left" style="flex: 1;"></div>
		<div id="styling_center" style="flex: 3;"><h3 align="center" >태그 관리</h3></div>
		<div id="styling_right" style="flex: 1;">
			<button class="btn" style="background-image: url('/resources/image/admin/tag_add.png'); background-color: transparent; width: 34px; height: 34px;" data-target="#addTag_display" data-toggle="modal"></button>
		</div>
	</div> 
	
	<!-- 숨겨둔 태그 추가창 -->
	<div class="modal fade" id="addTag_display">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="addTag_title">
					<p style="padding: 20px 0px 0px 20px; font-size: 19px; font-weight: bold;">태그 추가</p>
					<button type="reset" class="close" id="loginCancel" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<hr>
				<!-- 태그추가 form -->
				<form action="/admin/tag/insert" style="z-index: 999;" method="post" class="form-horizontal" >
				<div style="padding: 20px;">
					<!-- 태그 입력 창 -->
					<div class="form-group">
						<input type="text" class="form-control" id="st_name" name="st_name" placeholder="태그명">
					</div>
					<!-- 태그 이미지 추가 -->
					<div class="form-group">
						<label>첨부파일 : <input type="file" name="fu_storedname" /></label>
					</div> 
					<!-- 확인  -->
					<div class="form-group">
						<button id="btnInsert" class="btn btn-default" style="width: 285.83px; margin-left: 38px; background: #009994; color: white;">확인</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div>
	
	
	<!-- 숨겨둔 태그 수정창 -->
	<div class="modal fade" id="updateTag_display">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="updateTag_title">
					<p style="padding: 20px 0px 0px 20px; font-size: 19px; font-weight: bold;">태그 수정</p>
					<button type="reset" class="close" id="tagCancel" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<hr>
				<!-- 태그추가 form -->
				<form action="/admin/tag/update" style="z-index: 999;" method="post" class="form-horizontal">
				<div style="padding: 20px;">
					<!-- 태그 입력 창 -->
					<div class="form-group">
						<input type="text" class="form-control" name="st_name" placeholder="태그명" value="하하하">
					</div>
					<!-- 태그 이미지 추가 -->
					<div class="form-group">
						<label>첨부파일 : <input type="file" name="fu_storedname" /></label>
					</div>  
					<!-- 확인  -->
					<div class="form-group">
						<button id="btnInsert" class="btn btn-default" style="width: 285.83px; margin-left: 38px; background: #009994; color: white;">확인</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					</div>
				</div>
				</form>
			</div>
		</div>
	</div> 
	
	<table class="table table-hover table-condensed">
	<thead>
	<tr>
	<th style="width: 10%">No.</th>
	<th style="width: 50%">태그</th>
	<th style="width: 25%">등록일</th>
	<th style="width: 15%">관리</th>
	</tr>
	</thead>
	
	<tbody>
	<c:forEach items="${stList }" var="i">
	<tr>
	<td>${i.st_no }</td>
	<td>${i.st_name }</td>
	<td><fmt:formatDate value="${i.st_date }" pattern="yyyy-MM-dd"/></td>
	<td><button class="tagUpdate" style="background-color: transparent; border-color: transparent;" data-target="#updateTag_display" data-toggle="modal">수정</button> / 삭제</td>
	</tr>
	</c:forEach>
	</tbody>

	</table>

</div>

<%-- <jsp:include page="./paging.jsp" /> --%>

</div>

</div>