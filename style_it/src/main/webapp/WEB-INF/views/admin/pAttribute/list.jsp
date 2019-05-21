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


<style type="text/css">

.button {
	float: center;
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


</style>

<div class="container">

<div class="row row-offcanvas row-offcanvas-right">

<div style="text-align: right; padding-bottom: 100px;" class="container">
	<div id="stylingContainer" style="display: flex;">
		<div id="styling_left" style="flex: 1;"></div>
		<div id="styling_center" style="flex: 3;"><h3 align="center" >제품 속성 관리</h3></div>
		<div id="styling_right" style="flex: 1;">
		</div>
	</div> 

	<table class="table table-hover table-condensed">
	<thead>
	<tr>
	<th style="width: 20%">No.</th>
	<th style="width: 40%">속성</th>
	<th style="width: 40%">관리</th>
	</tr>
	</thead>
		<thead>
	<tr>
	<th style="width: 20%">1</th>
	<th style="width: 40%">색</th>
	<th style="width: 40%"><a href="/admin/pAttribute/color/list" style="color:red;">수정</a></th>
	</tr>
	</thead>
			<thead>
	<tr>
	<th style="width: 20%">2</th>
	<th style="width: 40%">브랜드</th>
	<th style="width: 40%"><a href="/admin/pAttribute/brand/list" style="color:red;">수정</a></th>
	</tr>
	</thead>
			<thead>
	<tr>
	<th style="width: 20%">3</th>
	<th style="width: 40%">상황</th>
	<th style="width: 40%"><a href="/admin/pAttribute/occasion/list" style="color:red;">수정</a></th>
	</tr>
	</thead>
			<thead>
	<tr>
	<th style="width: 20%">4</th>
	<th style="width: 40%">스타일</th>
	<th style="width: 40%"><a href="/admin/pAttribute/style/list" style="color:red;">수정</a></th>
	</tr>
	</thead>
			<thead>
	<tr>
	<th style="width: 20%">5</th>
	<th style="width: 40%">패턴</th>
	<th style="width: 40%"><a href="/admin/pAttribute/pattern/list" style="color:red;">수정</a></th>
	</tr>
	</thead>
			<thead>
	<tr>
	<th style="width: 20%">6</th>
	<th style="width: 40%">카테고리</th>
	<th style="width: 40%"><a href="/admin/pAttribute/category/list" style="color:red;">수정</a></th>
	</tr>
	</thead>
	</table>
	<a class="button" href= "/main" style="color:white; float:right;">메인으로</a>
	</div>
	</div>
	
	</div>

	
