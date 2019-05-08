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
	document.getElementById("faqInsert_display").style.display="block";
	document.getElementById("bg").style.display="block";//배경 어둡게 하는 것
}

function show2(){
	//show 호출시 넘겨준 값을 이용하여 ajax 등을 통해 modal 을 띄울때 동적으로 바뀌어야 하는 값을 얻어온다.  
	//얻어온 값을 이용하여, modal 에서 동적으로 바뀌어야 하는 값을 바꾸어 준다..  
    $("#title").html("ajax를 통해 얻어온 id에 해당하는 값");
    $("#content").html("ajax를 통해 얻어온 id에 해당하는 값");
    //modal을 띄워준다.  
    $("#myModal").modal('show');



출처: https://carami.tistory.com/61 [carami's story]
}

$(document).ready(function(){
	//FAQ 수정하기
	$("button[name='faqUpdate']").click(function(){
		action = 'faqUpdate';
		type = 'PUT';
		bno = this.value;
		
		//content담기
		var row = $(this).parent().parent().parent();
		var tr = row.children();
		
		var 
	});
	
// 	$(this).parents("form").submit();
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
		<div id="styling_center" style="flex: 3;"><h3 align="center" >FAQ 관리</h3></div>
		<div id="styling_right" style="flex: 1;">
			<button class="btn" style="background-image: url('/resources/image/admin/tag_add.png'); background-color: transparent; width: 34px; height: 34px;" data-target="#faqInsert_display" data-toggle="modal"></button>
		</div>
	</div> 
	
	<!-- 숨겨둔 faq 추가창 -->
	<div class="modal fade" id="faqInsert_display">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="faq_title">
					<p style="padding: 20px 0px 0px 20px; font-size: 19px; font-weight: bold;">FAQ 추가</p>
					<button type="reset" class="close" id="faqCancel" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<hr>
				<!-- faq추가 form -->
				<form action="/admin/faq/insert" style="z-index: 999;" method="post" class="form-horizontal" >
				<div style="padding: 20px;">
					<!-- faqCategory 선택 -->
					<div class="form-group">
						<input type="radio" id="faqct_no" name="faqct_no" value="1" /> 회원
						<input type="radio" id="faqct_no" name="faqct_no" value="2" /> 스타일링
						<input type="radio" id="faqct_no" name="faqct_no" value="3" /> 팔로우
						<input type="radio" id="faqct_no" name="faqct_no" value="4" /> 컬렉션
						<input type="radio" id="faqct_no" name="faqct_no" value="5" /> 제품
						<input type="radio" id="faqct_no" name="faqct_no" value="6" /> 기타
					</div>
					<!-- faq 제목 입력 창 -->
					<div class="form-group">
						<input type="text"  class="form-control" id="faq_name" name="faq_name" placeholder="FAQ제목">
					</div>
					<!-- faq 내용 입력 창 -->
					<div class="form-group">
						<textarea rows="13" cols="80" id="faq_answer" name="faq_answer" style="width : 98%; height: 300px;"></textarea>
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
	
	
	<!-- 숨겨둔 faq 수정창 -->
	<div class="modal fade" id="faqUpdate_display">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="faq_title">
					<p style="padding: 20px 0px 0px 20px; font-size: 19px; font-weight: bold;">FAQ 수정</p>
					<button type="reset" class="close" id="faqCancel" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<hr>
				<!-- faq추가 form -->
				<form action="/admin/faq/update" style="z-index: 999;" method="post" class="form-horizontal" >
				<div style="padding: 20px;">
					<!-- faqCategory 선택 -->
					<div class="form-group">
<%-- 						<label class="radio-inline"> <input type="radio" id="faqct_no" name="faqct_no" value="1" <c:if test="${faqList.faqct_no eq 1 }"> checked </c:if> /> 회원 </label> --%>
<%-- 						<label class="radio-inline"> <input type="radio" id="faqct_no" name="faqct_no" value="2" <c:if test="${faqList.faqct_no eq 2 }"> checked </c:if> /> 스타일링 </label> --%>
<%-- 						<label class="radio-inline"> <input type="radio" id="faqct_no" name="faqct_no" value="3" <c:if test="${faqList.faqct_no eq 3 }"> checked </c:if> /> 팔로우 </label>  --%>
<%-- 						<label class="radio-inline"> <input type="radio" id="faqct_no" name="faqct_no" value="4" <c:if test="${faqList.faqct_no eq 4 }"> checked </c:if> /> 컬렉션 </label>  --%>
<%-- 						<label class="radio-inline"> <input type="radio" id="faqct_no" name="faqct_no" value="5" <c:if test="${faqList.faqct_no eq 5 }"> checked </c:if> /> 제품 </label>  --%>
<%-- 						<label class="radio-inline"> <input type="radio" id="faqct_no" name="faqct_no" value="6" <c:if test="${faqList.faqct_no eq 6 }"> checked </c:if> /> 기타 </label> --%>
					</div>
					<!-- faq 제목 입력 창 -->
					<div class="form-group">
<%-- 						<input type="text"  class="form-control" id="faq_name" name="faq_name" placeholder="FAQ제목" value="${faqList.faq_name }"> --%>
					</div>
					<!-- faq 내용 입력 창 -->
					<div class="form-group">
<%-- 						<textarea rows="13" cols="80" id="faq_answer" name="faq_answer" style="width : 98%; height: 500px;" value="${faqList.faq_answer }"></textarea> --%>
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
	<th style="width: 50%">제목</th>
	<th style="width: 10%">항목</th>
	<th style="width: 15%">작성자</th>
	<th style="width: 15%">관리</th>
	</tr>
	</thead>  
	
	<tbody>
	<c:forEach items="${faqList }" var="i">
	<tr>
	<td>${i.FAQ_NO }</td>
	<td>${i.FAQ_NAME }</td>
	<td>${i.FAQCT_NAME }</td>
	<td>관리자</td>
	<td><button class="faqUpdate" style="background-color: transparent; border-color: transparent;" data-target="#faqUpdate_display" data-toggle="modal" value="${i.FAQ_NO }">수정</button> / 삭제</td>
	</tr>
	</c:forEach>
	</tbody>

	</table>

</div>

<%-- <jsp:include page="./paging.jsp" /> --%>

</div>

</div>
