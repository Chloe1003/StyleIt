<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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

}

$(document).ready(function(){
	//태그 제목 미입력시 반환처리
	$("#btnInsert").click(function(){
		if(faq_name.value=="") {
			alert("제목를 입력해주세요");
			return false;
		}
	});
	
	$("#word").click(function(){
	  var word =  $("input[type='text'][name='search']").val();
	  $(location).attr("href", "/admin/faq/list?word="+word); 
	});
	
	$(this).parents("form").submit();
	
	$(".faqDelete").click(function() {
		var no = $(this).parents("tr").children("td").eq(0).html()
		result = confirm('삭제 하시겠습니까');
		if(result == true){
			$(location).attr("href","/admin/faq/delete?faq_no="+no);
		}else{
			return false;
		}
	});
	
	$(".faqUpdate").click(function(){
		var no = $(this).val();
		

		 

		$.ajax({
			type: "get"
			, url: "/admin/faq/ajax?faq_no="+no
			, data: { } //요청파라미터
			, dataType: "json"
			, success: function( res ){
				console.log("성공");
				console.log(res.faqct_no);
				$("#updateFaq_no").val(res.faq_no);
				$("#updateFaq_name").val(res.faq_name);
				$("#updateFaq_answer").val(res.faq_answer);
				var faqctNo = res.faqct_no;
				$("input[name='faqct_no'][value='"+faqctNo+"']").attr("checked", true);
			}
			, error: function( e ) {
				console.log("실패");
			}
		});

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
						<input type="radio" name="faqct_no" value="1" checked/> 회원
						<input type="radio" name="faqct_no" value="2" /> 스타일링
						<input type="radio" name="faqct_no" value="3" /> 팔로우
						<input type="radio" name="faqct_no" value="4" /> 컬렉션
						<input type="radio" name="faqct_no" value="5" /> 제품
						<input type="radio" name="faqct_no" value="6" /> 기타  
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
				<!-- faq수정 form -->
				<form action="/admin/faq/update" style="z-index: 999;" method="post" class="form-horizontal" >
				<div style="padding: 20px;">
					<!-- faqCategory 선택 -->
					<div class="form-group">
						<input type="radio" name="faqct_no" value="1" /> 회원
						<input type="radio" name="faqct_no" value="2" /> 스타일링
						<input type="radio" name="faqct_no" value="3" /> 팔로우
						<input type="radio" name="faqct_no" value="4" /> 컬렉션
						<input type="radio" name="faqct_no" value="5" /> 제품
						<input type="radio" name="faqct_no" value="6" /> 기타  
					</div>
					<!-- faq 제목 입력 창 -->
					<div class="form-group">
						<input type="hidden" class="form-control" id="updateFaq_no" name="faq_no">
						<input type="text"  class="form-control" id="updateFaq_name" name="faq_name" placeholder="FAQ제목" value="${updateFAQ.faq_name }">
					</div>
					<!-- faq 내용 입력 창 -->
					<div class="form-group">
						<textarea rows="13" cols="80" id="updateFaq_answer" name="faq_answer" style="width : 98%; height: 300px;" >${updateFAQ.faq_answer }</textarea>
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
	<td><button class="faqUpdate"  style="background-color: transparent; border-color: transparent;" data-target="#faqUpdate_display" data-toggle="modal" value="${i.FAQ_NO }">수정</button> / 
	 	<button class="faqDelete" style="background-color: transparent; border-color: transparent;">삭제</button></td>
	</tr>
	</c:forEach>
	</tbody>

	</table>
	
	<div class="text-center">
		<input type="text" style="width: 400px" name="search" id="search">
		<button id="word" class="btn btn-success btn-sm">검색</button>
	</div>

<jsp:include page="./paging.jsp" />

</div>

</div>

</div>
