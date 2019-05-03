<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style>
#block{
width:200px; 
height:200px; 
position:relative; 
display:inline-block;
margin: 30px;
}
</style>

<div class="container" style= "padding-bottom: 200px;">

<input type="text" name="searchProduct" style="width: 400px">
<button type="submit">검색</button><br><br>

<button type="button">오피스</button>
<button type="button">캐주얼</button>
<button type="button">데이트</button>
<button type="button">결혼식</button>
<button type="button">데일리</button>
<button type="button">여행</button>
<button type="button">파티</button>
<button type="button">운동</button>

<hr>

<c:forEach items="${list }" var="l" begin="0" end="${list.size()-1 }">
<div id=block>
<a href="/shop/view?p_no=${l.p_no }"><img src="/upload/${l.fu_storedname }" width="200px" height="200px"></a>
<span>${l.p_name }</span>
</div>
</c:forEach>

</div>

