<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- UI형식으로 드래그 앤 드롭 -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
function filter(){
	var data = $("#pca_category").val();
	console.log(data);
	
		$.ajax ({
		type: "get"
			, url: "/styling/create/ajax?pca_no="+data
			, data: { } //요청파라미터
			, dataType: "json"
			, success: function( res ){
				console.log("성공");
				console.log(res);
// 				$("#tb").html(res.data1 + "<br>" + res.data2);
			}
			, error: function( e ) {
				console.log("실패");
			}
		});
}
</script>
<style type="text/css">
#createStyle {
	border : 3px solid gray;
	display : inline-block;
	min-height : 500px;
	margin : 5px;
	width : 90%;
	border-radius : 3px;
}	
</style>

<div class="container" style="padding-bottom: 100px;">
<h3 align="center">스타일링 만들기</h3>
<hr>

<div>
	<div id="stylingContainer" style="display: flex; padding-bottom: 20px;">
		<div style="border: 1px solid #ffffff; flex: 7;" >
			<input type="text" id="s_name" name="s_name" placeholder="Title" style="width: 90%;"/>
			<div id="createStyle"></div>
		</div>
		
		<div style="border: 1px solid #ffffff; flex: 3;">
			<div id="productTop" style="display: flex;">
				<input type="text" style="width: 100%; flex: 8" name="search" id="search" placeholder="Search">
				<button id="word" name="word" class="btn btn-success btn-sm" onchange="filter();" style="flex: 1">검색</button>
			</div>
			<div id="productList">
				<div style="text-align: center"> 
					제품 선택하기 : 
					<select id="pca_category" name="pca_category" onchange="filter();">
						<option value="">제품선택 </option>
						<c:forEach items="${list }" var="i">
								<option id="ajax" value="${i.pca_no }">${i.pca_category }</option>
						</c:forEach>
					</select>
				</div>
				<hr>
				<div id="tb">
					제품선택
				</div>
			</div>
		</div>  
	</div>

	
		

	
	
	
	

	
	<br>
	<br>
	<div class="col-sm-3 col-sm-offset-1"></div>
	<div class="col-sm-2">
		<button type="button" id="btnUpdate" class="btn btn-primary btn-lg btn-block">수정</button>
	</div> 
	<div class="col-sm-2">
		<button type="button" id="btnCancel" class="btn btn-lg btn-block">뒤로 가기</button>
	</div>
</div>


</div>