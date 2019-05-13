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
$(document).ready(function(){
	
	$("#btnUpdate").click(function(){
		$(location).attr("href", "/admin/product/update?p_no=${list.P_NO }");
	});
});


</script>
<style type="text/css">
th, td {
	margin: auto; text-align:center;
}
</style>

<div class="container" style="padding-bottom: 100px;">
<h3 align="center">제품 상세보기</h3>
<hr>

<div>
<form class="form-horizontal" name="detail" >
	<div class="form-group">
		<label for="category" class="col-sm-3 col-sm-offset-1 control-label">성별</label>
		<div class="col-sm-5">
			${list.P_GENDER }
		</div>
	</div>

	<div class="form-group">
		<label for="category" class="col-sm-3 col-sm-offset-1 control-label">카테고리</label>
		<div class="col-sm-5">
			${list.PCA_NO }
		</div>
	</div>
	
	<div class="form-group">
		<label for="brand" class="col-sm-3 col-sm-offset-1 control-label">브랜드</label>
		<div class="col-sm-5">
			${list.PB_NAME }
		</div>
	</div>
		
	<div class="form-group">
		<label for="productName" class="col-sm-3 col-sm-offset-1 control-label">제품명</label>
		<div class="col-sm-5">
			${list.P_NAME }
		</div>
	</div>

	<div class="form-group">
		<label for="p_price" class="col-sm-3 col-sm-offset-1 control-label">가격</label>
		<div class="col-sm-5">
			${list.P_PRICE }
		</div>
	</div>
	
	<div class="form-group">
		<label for="p_url" class="col-sm-3 col-sm-offset-1 control-label">URL</label>
		<div class="col-sm-5">
			${list.P_URL }
		</div>
	</div>
	
	<div class="form-group">
		<label for="fu_no" class="col-sm-3 col-sm-offset-1 control-label" >이미지</label>
		<div class="col-sm-5">
			<img src="/upload/image/${list.FU_STOREDNAME }" style="width: 120px; height: 120px">
		</div>
	</div>	
	
	<div class="form-group">
		<label for="pco_no" class="col-sm-3 col-sm-offset-1 control-label">색</label>
		<div class="col-sm-5">
			${list.PCO_NAME }
		</div>	
	</div>
	
	<div class="form-group">
		<label for="pco_no" class="col-sm-3 col-sm-offset-1 control-label">태그</label>
		<div class="col-sm-5">
			${list.PO_NAME }
			${list.PP_NAME }
			${list.PS_NAME }
		</div>	
	</div>

	
	<br>
	<br>
	<div class="col-sm-3 col-sm-offset-1"></div>
	<div class="col-sm-3">
		<button type="button" id="btnUpdate" class="btn btn-primary btn-lg btn-block">수정</button>
	</div>
	<div class="col-sm-2">
		<button type="button" id="btnCancel" class="btn btn-lg btn-block">취소</button>
	</div>
</form>
</div>


</div>