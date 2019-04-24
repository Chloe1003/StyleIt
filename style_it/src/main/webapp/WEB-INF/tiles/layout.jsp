<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스타일잇</title>
<style type="text/css">
	/* 모든 페이지에 적용되는 스타일 */
	.wrap{
		width: 1100px;
		margin: 0 auto;
	}
</style>

<!-- 모든 페이지에 jQuery 2.2.4.min 추가 -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
/* 모든 페이지에 적용되는 자바스크립트 */

</script>

<!-- 부트스트랩 -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<!-- 커스텀 -->
<link href="/resources/css/custom.css" rel="stylesheet">
<!-- 글씨체 -->
<link href="/resources/css/font.css" rel="stylesheet">

</head>
<body>

<!-- HEADER -->
<tiles:insertAttribute name="header"/>

<!-- NAV -->
<tiles:insertAttribute name="nav"/>

<!-- BODY -->
<div class="wrap">
	<tiles:insertAttribute name="body"/>
</div>

<!-- FOOTER -->
<tiles:insertAttribute name="footer"/>

</body>
</html>