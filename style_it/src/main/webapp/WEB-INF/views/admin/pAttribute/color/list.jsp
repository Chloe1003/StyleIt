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
function showfaq(){
	document.getElementById("productColorInsert_display").style.display="block";
	document.getElementById("bg").style.display="block";//배경 어둡게 하는 것
}

$(document).ready(function(){
	//태그 제목 미입력시 반환처리
	$("#btnInsert").click(function(){
		if(pco_name.value=="") {
			alert("색깔을 입력해주세요");
			return false;
		}
	});
	
	$("#word").click(function(){
	  var word =  $("input[type='text'][name='search']").val();
	  $(location).attr("href", "/admin/pAttribute/color/list?word="+word); 
	});
	
	$(this).parents("form").submit();
	
	$(".productColorUpdate").click(function(){
		var no = $(this).val();
		
		$.ajax({
			type: "get"
			, url: "/admin/pAttribute/color/ajax?pco_no="+no
			, data: { } //요청파라미터
			, dataType: "json"
			, success: function( res ){
				console.log("성공");
				$("#updatePco_name").val(res.pco_name);
				$("#updatePco_no").val(res.pco_no);
			}
			, error: function( e ) {
				console.log("실패");
			}
		});
	});
	
	$(".productColorDelete").click(function(){
		var no = $(this).parents().children("td").eq(0).html();
		console.log("no : "+no);
		var able = $(this).val();
		console.log("able : "+able);
		
		var $this = $(this);
		
		$.ajax({
			type: "get"
			, url: "/admin/pAttribute/color/able_ajax?pco_no="+no+"&pco_able="+able
			, data: { } //요청파라미터
			, dataType: "html"
			, success: function( res ){
				console.log("성공");

				if( $this.val() == 'y' ) {
					$this.val('n');
					
				} else {
					$this.val('y');
					
				}
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
		<div id="styling_center" style="flex: 3;"><h3 align="center" >컬러 관리</h3></div>
		<div id="styling_right" style="flex: 1;">
			<button class="btn" style="float:right; background:#009994; color:white; font-size: 15px; font-weight: bold;"
								data-target="#productColorInsert_display" data-toggle="modal">컬러 등록</button>
		</div>
	</div> 

	
	<!-- 숨겨둔 color 추가창 -->
	<div class="modal fade" id="productColorInsert_display">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="productColor_title">
					<p style="padding: 20px 0px 0px 20px; font-size: 19px; font-weight: bold;">Color 추가</p>
					<button type="reset" class="close" id="productColorCancel" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<hr>

				<!-- brand추가 form -->	
				<form action="/admin/pAttribute/color/insert" style="z-index: 999;" method="post" class="form-horizontal" >
				<div style="padding: 20px;">
					<!-- color 제목 입력 창 -->
					<div class="form-group">
						<input type="text"  class="form-control" id="pco_name" name="pco_name" placeholder="PCO제목">
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
	
	
	<!-- 숨겨둔 color 수정창 -->
	<div class="modal fade" id="productColorUpdate_display">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="productColor_title">
					<p style="padding: 20px 0px 0px 20px; font-size: 19px; font-weight: bold;">Color 수정</p>
					<button type="reset" class="close" id="productColorCancel" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<hr>
					<!-- color 수정 form -->
					<form action="/admin/pAttribute/color/update" style="z-index: 999;" method="post" class="form-horizontal" >
					<div style="padding: 20px;">
					<!-- color 제목 입력 창 -->
					<div class="form-group">
						<input type="hidden" class="form-control" id="updatePco_no" name="pco_no" >
						<input type="text"  class="form-control" id="updatePco_name" name="pco_name" 
									placeholder="Color제목" value="${updatePCO.pco_name }">
					</div>

					<!-- 확인  -->
					<div class="form-group">
						<button id="btnInsert2" class="btn btn-default" style="width: 285.83px; 
								margin-left: 38px; background: #009994; color: white;">확인</button>
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
	<th style="width: 10%">작성자</th>
	<th style="width: 15%">수정관리</th>
	<th style="width: 15%">삭제관리</th>
	</tr>
	</thead>  
	
	<tbody>
	<c:forEach items="${productColorList }" var="i">
	<tr>
	<td>${i.PCO_NO }</td>
	<td>${i.PCO_NAME }</td>
	<td>관리자</td>
	<td><button class="productColorUpdate"  style="background-color: transparent; border-color: transparent;" 
				data-target="#productColorUpdate_display" data-toggle="modal" value="${i.PCO_NO }">수정</button></td> 
	<td><input type="button" class="productColorDelete" 
		style="background-color: transparent; border-color: transparent;" value="${i.PCO_ABLE }" /></td>
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