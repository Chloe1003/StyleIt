<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">
td {
	border: 1px solid #ffffff
}
</style>


<h1> Main 화면</h1>
<hr>

<h3> 안녕 메인 </h3>


<script type="text/javascript">
$(document).ready(function() {
	$('#mainBanner').carousel('cycle');
});

</script>

<div style="text-align: right; padding-bottom: 100px;" class="container">
<!-- <div class="container"> -->
	<div id="mainBanner" class="carousel slide" data-ride="carousel" data-interval="3000">
	<ol class="carousel-indicators">
		<c:forEach var="i" begin="0" end="${bannerList.size()-1 }"> 
			<c:if test="${i eq 0 }">
   			<li data-target="#mainBanner" data-slide-to="${i }" class="active"></li>
			</c:if>
			<c:if test="${i ne 0 }">
   			<li data-target="#mainBanner" data-slide-to="${i }" class=""></li>
   			</c:if>
		</c:forEach>
 	</ol>
	  		
	<div class="carousel-inner" role="listbox">
	
		<c:forEach var="i" begin="0" end="${bannerList.size()-1 }">
	  		<c:if test="${i eq 0 }">
	    	<div class="item active" style="width: 100%; height: 350px;">
	      		<img src="/resources/image/banner/${bannerList[i].b_name }" style="width: 100%; height: 100%;">
	    	</div>
	    	</c:if>
	    	<c:if test="${i ne 0 }">
	    	<div class="item" style="width: 100%; height: 350px;">
	      		<img src="/resources/image/banner/${bannerList[i].b_name }" style="width: 100%; height: 100%;">
	    	</div>
	    	</c:if>
		</c:forEach>
				    	
	</div>
	  		
	<a class="left carousel-control" href="#mainBanner" role="button" data-slide="prev">
  		<button class="glyphicon glyphicon-chevron-left" aria-hidden="true"
  		style="background-color:transparent; border: 0px; outline: 0px;"></button>
  		<button class="sr-only">Previous</button>
	</a>
	<a class="right carousel-control" href="#mainBanner" role="button" data-slide="next">
  		<button class="glyphicon glyphicon-chevron-right" aria-hidden="true"
  		style="background-color:transparent; border: 0px; outline: 0px;"></button>  
  		<button class="sr-only">Next</button>
	</a>
	</div>
</div>

<div style="text-align: right; padding-bottom: 100px;" class="container">
	<h3 align="center">나만의 스타일을 찾아보세요!</h3>
	<table class="table" style="text-align: center;">  
	<thead></thead>
	<tbody>
		<tr>
			<td><img src="/resources/image/main/main1.jpg"></td>
			<td><img src="/resources/image/main/main2.jpg"></td>
			<td><img src="/resources/image/main/main3.jpg"></td>
			<td><img src="/resources/image/main/main4.jpg"></td>
		</tr>
		
		<tr>
			<td>우리의 끝없는 옷장에서 어울리는 스타일 조합을<br>만들어보세요!</td>
			<td>아이디어를 얻고, 당신만의 독특한 스타일을<br>찾아보세요!</td>
			<td>구매하기 전에 어떻게 매치해야 할 지<br>상상해보세요!</td>
			<td>당신만을 위한 개인 스타일리스트를<br>만나보세요!</td>
		</tr>
		
		<tr>
			<td><button class="btn btn-info" id="btnStyling">스타일링 하기</button></td>
			<td><button class="btn btn-info" id="btnStyleSearch">스타일링 찾아보기</button></td>
			<td><button class="btn btn-info" id="btnProductSearch">제품 찾아보기</button></td>
			<td><button class="btn btn-info" id="btnProductRecommend">내게 맞는 제품 추천하기</button></td>  
		</tr>
		</tbody>
	</table>
</div>

<div style="text-align: right; padding-bottom: 100px;" class="container">
	<div id="stylingContainer" style="display: flex;">
		<div id="styling_left" style="flex: 1;"></div>
		<div id="styling_center" style="flex: 3;"><h3 align="center" >오늘의 스타일링</h3></div>
		<div id="styling_right" style="flex: 1;">더 보기</div>
	</div>
</div>

<div style="text-align: right; padding-bottom: 100px;" class="container">
	<div id="stylingContainer" style="display: flex;">
		<div id="styling_left" style="flex: 1;"></div>
		<div id="styling_center" style="flex: 3;"><h3 align="center" >인기 제품</h3></div>
		<div id="styling_right" style="flex: 1;">더 보기</div>
	</div>
</div>