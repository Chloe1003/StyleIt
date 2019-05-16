<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach items="${pc }" var="item" varStatus="stat">
<div id="Clone${stat.index }"
 style="background-size: 100% 100%; float: left; margin: 10px; background-image: url('/upload/image/${item.FU_STOREDNAME}');">
	<div style="position: absolute;">
		<div style="position: relative; top: 10px; left: 15px;">
			<button id="btnMinus" name="btnMinus" disabled
			 style="background-color:transparent; border: 0px; outline: 0px;" onclick="btnMinus()">
			
				<img style="visibility : hidden" ondragstart="return false" data-value="${item.FU_NO }"
				 src="/resources/image/styling/minus.png" />
			</button>
		</div>
	</div>
</div>
</c:forEach>

<div id="paging">
	<jsp:include page="../paging.jsp" />
</div>
