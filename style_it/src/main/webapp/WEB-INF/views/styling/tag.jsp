<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

스타일링 태그
<div style="text-align:center;">
<c:forEach items="${stylingTag }" var="t" begin="0" end="${stylingTag.size()-1 }">
<div style="width:200px; height:200px; position:relative; display:inline-block;margin: 30px;">
<img src="/upload/${t.fu_storedname }" alt="images" width="200" height="200" style="position:absolute;left: 0;top: 0;">
<span style="position:absolute;left: 78px;top: 120px;font-size: 1.5em;font-weight: bold;"> ${t.st_name }</span>
<div style="width:200px; height:40px;"></div>
</div>
</c:forEach>
</div>