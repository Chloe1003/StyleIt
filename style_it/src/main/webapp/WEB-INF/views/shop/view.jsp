<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style>
h5 {
	color:#777;
	text-align: center;
}

</style>

<table style="margin-left: auto; margin-right: auto; text-align: center;">
<tr>
	<td rowspan="6"><img src="/upload/${view.fu_storedname }" width="200px" height="200px"></td>
	<td></td>
</tr>
<tr>
	<td>
	<div style="margin: 10px 30px 10px 30px;">
	</div>
	</td>
	<td>${view.p_name }</td>
</tr>
<tr>
	<td></td>
	<td>${view.pb_name }</td>
</tr>
<tr>
	<td></td>
	<td>${view.p_price }원</td>
</tr>
<tr>
	<td></td>
	<td><a href="${view.p_url }" target="_blank" style="color:#777;">구매하러가기</a></td>
</tr>
<tr>
	<td></td>
	<td><a href="#" style="color:#777;"><img alt="faq" src="/resources/image/main/hanger.png" style="width: 20px;">&nbsp;스타일링하기</a>&emsp;&emsp;&emsp;
	<a href="#" style="color:#777;"><img alt="add" src="/resources/image/main/add.png" style="width: 20px;">&nbsp;컬렉션 추가</a></td>
</tr>

</table>

<hr>

<div>

<h5>어떻게 입을까?</h5>

<c:forEach items="${list }" var="l" begin="0" end="${list.size() }">
<div id=block>
<img src="/upload/${l.fu_storedname }" width="200px" height="200px">
<span>${l.s_name }</span>
</div>
</c:forEach>

</div>
