<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.frame{
    width: 45%;
    margin-left: auto;
    margin-right: auto;
}

.qna{
    margin-bottom: 27px;
}

.question{
    font-size: 20px;
    margin: 15px 0;
}
.item{
	margin: 10px;
}
.item-button{
    background: white;
    padding: 5px 20px;
    border-radius: 0;
}
.divider{
	width: 100%;
    height: 2px;
    background-color: #f0f6f6;
    margin: 20px 0;
}
.submit{
	padding: 5px 30px;
    background: #009994;
    border-radius: 15px;
    color: white;
    width: 200px;
    margin-left: auto;
    margin-right: auto;
    text-align: center;
    cursor:pointer;
}
</style>

<div class="frame">
<form action="/mypage/quiz" method="post">
<c:forEach items="${qSet }" var="q" begin="0" end="${qSet.size()-1 }">
<div class="qna">
	<div class="question">Q${q.qq_no }. ${q.qq_title }</div>
	<div class="answer">
		<c:choose>
			<c:when test="${q.qq_no eq 1 }">
<!-- 				<div class="btn-group" role="group"> -->
<!-- 				  <button type="button" class="btn btn-default" name="p_gender" value="f">여자</button> -->
<!-- 				  <button type="button" class="btn btn-default" name="p_gender" value="m">남자</button> -->
<!-- 				</div> -->
			
				<span class="item"><input type="checkbox" name="p_gender" value="1">여자</span>
				<span class="item"><input type="checkbox" name="p_gender" value="2">남자</span>
			</c:when>
			<c:when test="${q.qq_no eq 2 }">
				<c:forEach items="${occasion }" var="a" begin="0" end="${occasion.size()-1 }">
					<span class="item"><input type="checkbox" name="po_no" value="${a.po_no }">${a.po_name }</span>
				</c:forEach>			
			</c:when>
			<c:when test="${q.qq_no eq 3 }">
				<c:forEach items="${brand }" var="a" begin="0" end="${brand.size()-1 }">
					<span class="item"><input type="checkbox" name="pb_no" value="${a.pb_no }">${a.pb_name }</span>
				</c:forEach>
			</c:when>
			<c:when test="${q.qq_no eq 4 }">
				<c:forEach items="${style }" var="a" begin="0" end="${style.size()-1 }">
					<span class="item"><input type="checkbox" name="ps_no" value="${a.ps_no }">${a.ps_name }</span>
				</c:forEach>		
			</c:when>
			<c:when test="${q.qq_no eq 5 }">
				<c:forEach items="${category }" var="a" begin="0" end="${category.size()-1 }">
					<span class="item"><input type="checkbox" name="pca_no" value="${a.pca_no }">${a.pca_category }</span>
				</c:forEach>	
			</c:when>
			<c:when test="${q.qq_no eq 6 }">
				<c:forEach items="${color }" var="a" begin="0" end="${color.size()-1 }">
					<span class="item"><input type="checkbox" name="pco_no" value="${a.pco_no }">${a.pco_name }</span>
				</c:forEach>		
			</c:when>
			<c:when test="${q.qq_no eq 7 }">
				<c:forEach items="${pattern }" var="a" begin="0" end="${pattern.size()-1 }">
					<span class="item"><input type="checkbox" name="pp_no" value="${a.pp_no }">${a.pp_name }</span>
				</c:forEach>		
			</c:when>
			<c:when test="${q.qq_no eq 8 }">
				<span class="item"><input type="number" name="lprice"></span> ~
				<span class="item"><input type="number" name="hprice"></span>
			</c:when>
		</c:choose>
		<div class="divider"></div>
	</div>
</div>
</c:forEach>
<!-- <div class="submit" onclick="submit()">제출하기</div> -->
<button class="submit">제출하기</button>
</form>
</div>
<br><br><br><br>


<script type="text/javascript">

function submit(){
	form.submit();
}

</script>