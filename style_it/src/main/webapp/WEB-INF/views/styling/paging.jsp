<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style type="text/css">
ul.pagination li{
	cursor: pointer;
}
</style>

<div class="text-center"><!-- 부트스트랩 지원 클래스 -->
<ul class="pagination pagination-sm">
	<%-- 첫페이지가 아니라면 처음 버튼 보이기 --%>
	<c:if test="${paging.curPage ne 1 }">
	<li>
	<span onclick="filter(1);">&larr;처음</span>
	</li>
	</c:if>
	
	
	<%-- 이전 페이지그룹 --%>
	<c:if test="${paging.curPage le paging.pageCount }">
	<li class="disabled"><span>&laquo;</span></li>
	</c:if>
	
	<c:if test="${paging.curPage gt paging.pageCount }">
	<li><span onclick="filter(${paging.startPage-paging.pageCount });">&laquo;</span></li>
	</c:if>
	
	<%-- 페이징 리스트 --%>
	<c:forEach begin="${paging.startPage }" 
	end="${paging.endPage }" 
	var="i">
	
	<c:if test="${paging.curPage eq i }">
	<li class="active"><span onclick="filter(${i });">${i }</span></li>
	</c:if>
		
	<c:if test="${paging.curPage ne i }">
	<li><span onclick="filter(${i });">${i }</span></li>
	</c:if>
	
	</c:forEach>
	

	<%-- 다음 페이지그룹 --%>
	<c:if test="${paging.endPage eq paging.totalPage }">
	<li class="disabled"><span>&raquo;</span></li>
	</c:if>
	
	<c:if test="${paging.endPage ne paging.totalPage }">
	<li><span onclick="filter(${paging.startPage+paging.pageCount });">&raquo;</span></li>
	</c:if>
	
	<%-- 마지막페이지가 아니라면 마지막 버튼 보이기 --%>
	<c:if test="${paging.curPage ne paging.totalPage }">
	<li><span onclick="filter(${paging.totalPage });">마지막&rarr;</span></li>
	</c:if>
	
</ul>
</div>