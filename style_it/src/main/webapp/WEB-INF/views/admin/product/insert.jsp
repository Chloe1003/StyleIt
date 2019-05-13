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
	
	$("#btnInsert").click(function(){
		$(this).parents("form").submit();
	});
});

</script>
<style type="text/css">
th, td {
	margin: auto; text-align:center;
}
</style>

<div class="container" style="padding-bottom: 100px;">
<h3 align="center">제품 추가</h3>
<hr>

<div>
<form action="/admin/product/insert" method="post" class="form-horizontal" name="insert" enctype="multipart/form-data">
	<div class="form-group">
		<label for="category" class="col-sm-3 col-sm-offset-1 control-label">성별</label>
		<div class="col-sm-5">
			<select class="form-control" id="p_gender" name="p_gender">
					<option value="f">여자</option>
					<option value="m">남자</option>
			</select>
		</div>
	</div>

	<div class="form-group">
		<label for="category" class="col-sm-3 col-sm-offset-1 control-label">카테고리</label>
		<div class="col-sm-5">
			<select class="form-control" id="category" name="category">
				<c:forEach items="${pcaList }" var="p">	
					<option value="${p.PCA_NO }">${p.PCA_CATEGORY }</option>
				</c:forEach>
			</select>
		</div>
	</div>
	
	<div class="form-group">
		<label for="brand" class="col-sm-3 col-sm-offset-1 control-label">브랜드</label>
		<div class="col-sm-5">
			<select class="form-control" id="brand" name="brand">
				<c:forEach items="${pbList }" var="b">	
					<option value="${b.PB_NO }">${b.PB_NAME }</option>
				</c:forEach>
			</select>
		</div>
	</div>
		
	<div class="form-group">
		<label for="productName" class="col-sm-3 col-sm-offset-1 control-label">제품명</label>
		<div class="col-sm-5">
		<input type="text" id="p_name" name="p_name" class="form-control"/>
		</div>
	</div>

	<div class="form-group">
		<label for="p_price" class="col-sm-3 col-sm-offset-1 control-label">가격</label>
		<div class="col-sm-5">
			<input type="text" id="p_price" name="p_price" class="form-control"/>
		</div>
	</div>
	
	<div class="form-group">
		<label for="p_url" class="col-sm-3 col-sm-offset-1 control-label">URL</label>
		<div class="col-sm-5">
			<input type="text" id="p_url" name="p_url" class="form-control"/>
		</div>
	</div>
	
	<div class="form-group">
		<label for="fu_no" class="col-sm-3 col-sm-offset-1 control-label" >이미지</label>
		<div class="col-sm-5">
			<input type="file" id="file" name="file" accept='image/jpeg,image/gif,image/png' />
		</div>
	</div>	
	
	<div class="form-group">
		<label for="pco_no" class="col-sm-3 col-sm-offset-1 control-label">색</label>
		<div class="col-sm-5">
			<select class="form-control" id="pcolor" name="pcolor">
				<c:forEach items="${pcList }" var="c">	
					<option value="${c.PCO_NO }">${c.PCO_NAME }</option>
				</c:forEach>
			</select>
		</div>	
	</div>
	
	<div class="form-group">
		<label for="pco_no" class="col-sm-3 col-sm-offset-1 control-label">태그</label>
		<div class="col-sm-5">
			<select class="form-control" id="poccasion" name="poccasion">
				<option value=null> 선택 안함 </option>
				<c:forEach items="${poList }" var="o">	
					<option value="${o.PO_NO }">${o.PO_NAME }</option>
				</c:forEach>
			</select>
			<select class="form-control" id="ppattern" name="ppattern">
				<option value=null> 선택 안함 </option>
				<c:forEach items="${ppList }" var="pp">	
					<option value="${pp.PP_NO }">${pp.PP_NAME }</option>
				</c:forEach>
			</select>
			<select class="form-control" id="pstyle" name="pstyle">
				<option value=null> 선택 안함 </option>
				<c:forEach items="${psList }" var="ps">	
					<option value="${ps.PS_NO }">${ps.PS_NAME }</option>
				</c:forEach>
			</select>
		</div>	
	</div>

	
	<br>
	<br>
	<div class="col-sm-3 col-sm-offset-1"></div>
	<div class="col-sm-3">
		<button type="button" id="btnInsert" class="btn btn-primary btn-lg btn-block">등록</button>
	</div>
	<div class="col-sm-2">
		<button type="button" id="btnCancel" class="btn btn-lg btn-block">취소</button>
	</div>
</form>
</div>


</div>