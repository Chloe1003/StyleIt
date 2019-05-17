<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>



<style>

	body {font-size:12pt; padding:0; margin:0; text-align: center;}
	h3 {color: #1bb7a7; font-size: 14pt; margin:10 auto; padding: 10px;}
	.contents {width: 100%; height: 10%; background-color: #d6d6d6; margin: 0 auto;}
	
	/* banner */
	.banner {position: relative; width: 100%;  top: 0px;  margin:0 auto; padding:0; overflow: hidden;}
	.banner ul {position: absolute; margin: 0px; height: 50% padding:0; list-style: none; }
	.banner ul li {float: left; width:100%; margin:0; padding:0;}
	.banner ul li img{width: 100%;}


</style>

</head>
<body>

  <div class="contents">
		 
		<div class="banner">
			<ul>
			<c:forEach items="${bannersList }" var="bannersList">
			
				<li><img src="/upload/${b.fu_storedname }" ></li>
				
			</c:forEach>
			</ul>
		</div>
		 
	</div>

</body>
</html>