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
	
	$("#word").click(function(){
		 filter();
	});
});

function filter(){
var cate = $("#category").val();
var brand = $("#brand").val();
var word = $("input[type='text'][name='search']").val();
	console.log("cate : "+cate+", brand : "+brand+", word : "+word );
	
	$(location).attr("href", "/admin/product/list?word="+word+"&cate="+cate+"&brand="+brand);
	
}

</script>
<style type="text/css">
th, td {
	margin: auto; text-align:center;
}
</style>

<div class="container">

<div class="row row-offcanvas row-offcanvas-right">


<div style="text-align: center; padding-bottom: 80px;" class="container">
	<div id="adminProductContainer" style="display: flex; padding-bottom: 20px;">
		<div id="ap_left" style="flex: 1;">
			<a href="/admin/product/list" style="color: black"><span>제품관리</span></a></div>  
		<div id="ap_left2" style="flex: 1;">
			<a href="#" style="color: black"><span>제품속성 관리</span></a></div>  
		<div id="ap_center" style="flex: 3;"></div>  
		<div id="ap_right" style="flex: 1;">
			<a href="/admin/product/insert" style="color: black"><span>제품 등록</span></a></div>
	</div> 
	
	<table class="table table-hover table-condensed">
	<thead>
	<tr>
	<th style="width: 5%">선택</th>
	<th style="width: 15%">
		<select class="form-control" id="category" name="category" onchange="filter();"> 
			<option value="">카테고리 전체</option>
		<c:forEach items="${pcaList }" var="p">	
			<option value="${p.PCA_CATEGORY }">${p.PCA_CATEGORY }</option>
		</c:forEach>
		</select>
	</th>
	<th style="width: 15%">
		<select class="form-control" id="brand" name="brand" onchange="filter();">
			<option value="">브랜드 전체</option>
		<c:forEach items="${pbList }" var="b">
			<option value="${b.PB_NAME }">${b.PB_NAME }</option>		
		</c:forEach>
		</select></th>
	<th style="width: 55%">제품명</th>
	<th style="width: 15%">관리</th>
	</tr>
	</thead>
	
	<tbody>
	<c:forEach items="${productList }" var="i">
	<tr>
	<td><input type="checkbox" value="${i.P_NO }"></td>
	<td>${i.PCA_CATEGORY }</td>
	<td>${i.PB_NAME }</td>
	<td>${i.P_NAME }</td>
	<td><a href="/admin/product/detail?p_no=${i.P_NO }">상세 / </a>
	<a href="/admin/product/update?p_no=${i.P_NO }">수정</a></td>
	</tr>
	</c:forEach>
	</tbody>

	</table>

	<div id="apContainer" style="display: flex; padding-bottom: 20px;">
		<div id="ap_left" style="flex: 1;"></div>
		<div id="ap_center" style="flex: 3;">
			<input type="text" style="width: 400px" name="search" id="search">
			<button id="word" name="word" class="btn btn-success btn-sm" onchange="filter();">검색</button></div>
		<div id="ap_left" style="flex: 1;">
			<button id="btnDelete" class="btn btn-danger btn-sm" style="text-align: right">삭제</button>
		</div>
	</div>

<jsp:include page="./paging.jsp" />

</div>

</div>

</div>