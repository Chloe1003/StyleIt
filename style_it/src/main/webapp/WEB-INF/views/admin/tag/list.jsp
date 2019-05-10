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
			console.log($("input[type='file']").val());
			return false;
		}
		if($("input[type='file']").val()==""){
			alert("파일을 선택해주세요")
			return false;
		}
	});
	
	$("#btnInsert2").click(function(){
		if(st_name.value=="") {
			alert("태그를 입력해주세요");
			return false;
		}
	});
	
	$("input:file[name='file']").change(function () {
		var str = $(this).val();  
		var fileName = str.split('\\').pop().toLowerCase();;
		checkFileName(fileName);
	});
	
	function checkFileName(str){
		//1. 확장자명 체크
		var ext =  str.split('.').pop().toLowerCase();
		if($.inArray(ext, ['jpg', 'jpeg', 'bmp', 'gif','png']) == -1) {
			alert(ext+'파일은 업로드 하실 수 없습니다.');
			return false;
		}else {
		}
		//2. 파일명에 특수문자 체크
		var pattern =   /[\{\}\/?,;:|*~`!^\+<>@\#$%&\\\=\'\"]/gi;
		
		if(pattern.test(str) ){
			//alert("파일명에 허용된 특수문자는 '-', '_', '(', ')', '[', ']', '.' 입니다.");
			alert('파일명에 특수문자를 제거해주세요.');
			return false;
		}else {
			alert("success");
		}
	}
	
	$(this).parents("form").submit();
	
	$(".tagUpdate").click(function() {
		var no = $(this).parents("tr").children("td").eq(0).html()
		var title = $(this).parents("tr").children("td").eq(1).html();
		var able = $(this).parents("tr").children("td").eq(3).html()
		$("input[name='st_no']").val(no);
		$("input[name='st_name']").val(title);
		$("input[name='st_able'][value='"+able+"']").attr("checked", true);
	});
	
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
				<form action="/admin/tag/insert" style="z-index: 999;" method="post" class="form-horizontal" enctype="multipart/form-data">
				<div style="padding: 20px;">
					<!-- 태그 입력 창 -->
					<div class="form-group">
						<input type="text" class="form-control" id="st_name" name="st_name" placeholder="태그명">
					</div>
					<!-- 태그 활성화 수정 -->
					<div class="form-group">
						<input type="radio" name="st_able" value="y" checked/>활성화
						<input type="radio" name="st_able" value="n" />비활성화
					</div>
					<!-- 태그 이미지 추가 -->
					<div class="form-group">
						<label>첨부파일 : <input type="file" name="file" id="file" /></label>
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
				<!-- 태그수정 form -->
				<form action="/admin/tag/update" style="z-index: 999;" method="post" class="form-horizontal" enctype="multipart/form-data">
				<div style="padding: 20px;">
					<!-- 태그 입력 창 -->
					<div class="form-group">
						<input type="hidden" class="form-control" name="st_no">
						<input type="text" class="form-control" name="st_name">
					</div>
					<!-- 태그 활성화 수정 -->
					<div class="form-group">
						<input type="radio" name="st_able" value="y" />활성화
						<input type="radio" name="st_able" value="n" />비활성화
					</div> 
					<!-- 태그 이미지 수정 -->
					<div class="form-group">
						<label>첨부파일 : <input type="file" name="file" id="file" /></label>
					</div> 
					<!-- 확인  -->
					<div class="form-group">
						<button id="btnInsert2" class="btn btn-default" style="width: 285.83px; margin-left: 38px; background: #009994; color: white;">확인</button>
						<button type="button" class="btn btn-default" data-dismiss="modal" onclick='$("input[name=\"st_name\"]").val("")'>닫기</button>
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
	<th style="width: 45%">태그</th>
	<th style="width: 20%">등록일</th>
	<th style="width: 10%">활성 여부</th>
	<th style="width: 15%">관리</th>
	</tr>
	</thead>
	
	<tbody>
	<c:forEach items="${stList }" var="i">
	<tr>
	<td>${i.st_no }</td>
	<td>${i.st_name }</td>
	<td><fmt:formatDate value="${i.st_date }" pattern="yyyy-MM-dd"/></td>
	<td>${i.st_able }</td>
	<td><button class="tagUpdate" style="background-color: transparent; border-color: transparent;" data-target="#updateTag_display" data-toggle="modal" onclick="update()">수정</button>
	</tr>
	</c:forEach>
	</tbody>

	</table>
	
<jsp:include page="./paging.jsp" />

</div>


</div>

</div>