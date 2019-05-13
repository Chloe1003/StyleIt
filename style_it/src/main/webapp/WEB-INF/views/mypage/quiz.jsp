<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<c:forEach items="${qSet }" var="q" begin="0" end="${qSet.size()-1 }">
	<div class="question">${q.qq_title }</div>
		<c:if test="${aSet.brand }">
			<c:forEach items="${aSet.brand }" var="b" begin="0" end="${aSet.brand.size()-1 }">
				<div class="answer">${b.pb_name }</div>
			</c:forEach>
		</c:if>
</c:forEach>