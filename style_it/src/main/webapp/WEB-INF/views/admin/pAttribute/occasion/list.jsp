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
function showbrand(){
	document.getElementById("occasionInsert_display").style.display="block";
	document.getElementById("bg").style.display="block";//배경 어둡게 하는 것
}

$(document).ready(function(){
	//태그 제목 미입력시 반환처리
	$("#btnInsert").click(function(){
		if(po_name.value=="") {
			alert("제목를 입력해주세요");
			return false;
		}
	});
	
	$("#word").click(function(){
	  var word =  $("input[type='text'][name='search']").val();
	  $(location).attr("href", "/admin/pAttribute/occasion/list?word="+word); 
	});
	
	$(this).parents("form").submit();
	
	$(".productOccasionDelete").click(function() {
		var no = $(this).parents("tr").children("td").eq(0).html()
		result = confirm('삭제 하시겠습니까');
		if(result == true){
			$(location).attr("href","/admin/pAttribute/occasion/delete?po_no="+no);
		}else{
			return false;
		}
	});
	
	$(".productOccasionUpdate").click(function(){
		var no = $(this).val();
		
		$.ajax({
			type: "get"
			, url: "/admin/pAttribute/occasion/ajax?po_no="+no
			, data: { } //요청파라미터
			, dataType: "json"
			, success: function( res ){
				console.log("성공");
				$("#updatePo_name").val(res.po_name);
				var poNo = res.po_no;
				$("input[name='po_no'][value='"+poNo+"']").attr("checked", true);
			}
			, error: function( e ) {
				console.log("실패");
			}
		});
	});
	
});
  
</script>

<style type="text/css">

.button {
    display: block;
    width: 110px;
    height: 40px;
    background: #d63c00;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
}

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
		<div id="styling_center" style="flex: 3;"><h3 align="center" >Occasion 관리</h3></div>
		<div id="styling_right" style="flex: 1;">
						<button class="btn" style="float:right; background:#009994; color:white; font-size: 15px; font-weight: bold;"
								data-target="#productOccasionInsert_display" data-toggle="modal">상황 등록</button>
		</div>
	</div> 
	
	<!-- 숨겨둔 occasion 추가창 -->
	<div class="modal fade" id="ㅐproductOccasionInsert_display">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="occasion_title">
					<p style="padding: 20px 0px 0px 20px; font-size: 19px; font-weight: bold;">occasion 추가</p>
					<button type="reset" class="close" id="occasionCancel" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<hr>
				<!-- occasion추가 form -->
				<form action="/admin/pAttribute/occasion/insert" style="z-index: 999;" method="post" class="form-horizontal" >
				<div style="padding: 20px;">

					<!-- occasion 제목 입력 창 -->
					<div class="form-group">
						<input type="text"  class="form-control" id="po_name" name="po_name" placeholder="상황">
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
	
	
	<!-- 숨겨둔 occasion 수정창 -->
	<div class="modal fade" id="productOccasionUpdate_display">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="occasion_title">
					<p style="padding: 20px 0px 0px 20px; font-size: 19px; font-weight: bold;">상황 수정</p>
					<button type="reset" class="close" id="occasionCancel" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<hr>
				<!-- occasion수정 form -->
				<form action="/admin/pAttribute/occasion/update" style="z-index: 999;" method="post" class="form-horizontal" >
				<div style="padding: 20px;">
					<!-- occasion 제목 입력 창 -->
					<div class="form-group">
						<input type="hidden" class="form-control" id="updatePo_no" name="po_no">
						<input type="text"  class="form-control" id="updatePo_name" name="po_name" placeholder="occasion제목" value="${updatePO.po_name }">
					</div>
					<!-- 확인  -->
					<div class="form-group">
						<button id="btnInsert2" class="btn btn-default" style="width: 285.83px; margin-left: 38px; background: #009994; color: white;">확인</button>
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
	<th style="width: 50%">제목</th>
	<th style="width: 10%">관리자</th>
	<th style="width: 15%">수정</th>
	<th style="width: 15%">삭제</th>
	</tr>
	</thead>  
	
	<tbody>
	<c:forEach items="${productOccasionList }" var="i">
	<tr>
	<td>${i.PO_NO }</td>
	<td>${i.PO_NAME }</td>
	<td>관리자</td>
	<td><button class="productOccasionUpdate"  style="background-color: transparent; border-color: transparent;" data-target="#productOccasionUpdate_display" data-toggle="modal" value="${i.PO_NO }">수정</button></td> 
	<td><button class="productOccasionDelete" style="background-color: transparent; border-color: transparent;">삭제</button></td>
	</tr>
	</c:forEach>
	</tbody>

	</table>
	
	<div class="text-center">
		<input type="text" style="width: 400px" name="search" id="search">
		<button id="word" class="btn btn-success btn-sm">검색</button>
		<a class="button" href= "/admin/pAttribute/list" style="color:white; float:right;">속성관리 목록</a>
	</div>

<jsp:include page="./paging.jsp" />

</div>

</div>

</div>
