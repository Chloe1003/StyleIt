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
    border: none;
    color: white;
    width: 200px;
    text-align: center;
    cursor:pointer;
}
</style>

<div class="frame">
<form action="/mypage/quiz" method="post" id="quizform">
<c:forEach items="${qSet }" var="q" begin="0" end="${qSet.size()-1 }">
<div class="qna">
	<c:choose>
		<c:when test="${q.qq_no eq 1}">
			<div class="question">Q${q.qq_no }. ${q.qq_title }</div>
		</c:when>
		<c:when test="${q.qq_no > 1 and q.qq_no < 8 }">
			<div class="question">Q${q.qq_no }. ${q.qq_title }<span style="font-size: 13px;"> (최대 3개 선택)</span></div>
		</c:when>
		<c:when test="${q.qq_no eq 8}">
			<div class="question">Q${q.qq_no }. ${q.qq_title }<span style="font-size: 13px;"> (최대한 맞춰볼게요!)</span></div>
		</c:when>
	</c:choose>
	<div class="answer">
		<c:choose>
			<c:when test="${q.qq_no eq 1 }">			
				<span class="item"><input type="checkbox" class="p_gender" name="p_gender" value="1"> 여자</span>
				<span class="item"><input type="checkbox" class="p_gender" name="p_gender" value="2"> 남자</span>
			</c:when>
			<c:when test="${q.qq_no eq 2 }">
				<c:forEach items="${occasion }" var="a" begin="0" end="${occasion.size()-1 }">
					<span class="item"><input type="checkbox" class="po_no" name="po_no" value="${a.po_no }">&nbsp;${a.po_name }</span>
				</c:forEach>			
			</c:when>
			<c:when test="${q.qq_no eq 3 }">
				<c:forEach items="${brand }" var="a" begin="0" end="${brand.size()-1 }">
					<span class="item"><input type="checkbox" class="pb_no" name="pb_no" value="${a.pb_no }">&nbsp;${a.pb_name }</span>
				</c:forEach>
			</c:when>
			<c:when test="${q.qq_no eq 4 }">
				<c:forEach items="${style }" var="a" begin="0" end="${style.size()-1 }">
					<span class="item"><input type="checkbox" class="ps_no" name="ps_no" value="${a.ps_no }">&nbsp;${a.ps_name }</span>
				</c:forEach>		
			</c:when>
			<c:when test="${q.qq_no eq 5 }">
				<c:forEach items="${category }" var="a" begin="0" end="${category.size()-1 }">
					<span class="item"><input type="checkbox" class="pca_no" name="pca_no" value="${a.pca_no }">&nbsp;${a.pca_category }</span>
				</c:forEach>	
			</c:when>
			<c:when test="${q.qq_no eq 6 }">
				<c:forEach items="${color }" var="a" begin="0" end="${color.size()-1 }">
					<span class="item"><input type="checkbox" class="pco_no" name="pco_no" value="${a.pco_no }">&nbsp;${a.pco_name }</span>
				</c:forEach>		
			</c:when>
			<c:when test="${q.qq_no eq 7 }">
				<c:forEach items="${pattern }" var="a" begin="0" end="${pattern.size()-1 }">
					<span class="item"><input type="checkbox" class="pp_no" name="pp_no" value="${a.pp_no }">&nbsp;${a.pp_name }</span>
				</c:forEach>		
			</c:when>
			<c:when test="${q.qq_no eq 8 }">
				<span class="item"><input type="number" class="lprice" name="lprice"></span>원에서
				<span class="item"><input type="number" class="hprice" name="hprice"></span>원 사이
			</c:when>
		</c:choose>
		<div class="divider"></div>
	</div>
</div>
</c:forEach>
<!-- <div class="submit" onclick="submit()">제출하기</div> -->
<div style="text-align: center;"><button type="button" class="submit">제출하기</button></div>
</form>
</div>
<br><br><br><br>


<script type="text/javascript">
/* 선택 개수 제한  */
$('input:checkbox[class=p_gender]').click(function(){ //1개만 선택	  
	  var cntGender = $('input:checkbox[class=p_gender]:checked').length;   //체크갯수 확인
	 
	  if(cntGender>1){
	   alert('1개만 선택 가능합니다.')
	   $(this).prop('checked', false);
	  }
});

$('input:checkbox[class=po_no]').click(function(){ //최대 3개까지	  
	  var cntPo = $('input:checkbox[class=po_no]:checked').length;   //체크갯수 확인
	 
	  if(cntPo>3){
	   alert('최대 3개까지 선택 가능합니다.')
	   $(this).prop('checked', false);
	  }
});

$('input:checkbox[class=pb_no]').click(function(){ //최대 3개까지	  
	  var cntPb = $('input:checkbox[class=pb_no]:checked').length;   //체크갯수 확인
	 
	  if(cntPb>3){
	   alert('최대 3개까지 선택 가능합니다.')
	   $(this).prop('checked', false);
	  }
});

$('input:checkbox[class=ps_no]').click(function(){ //최대 3개까지	  
	  var cntPs = $('input:checkbox[class=ps_no]:checked').length;   //체크갯수 확인
	 
	  if(cntPs>3){
	   alert('최대 3개까지 선택 가능합니다.')
	   $(this).prop('checked', false);
	  }
});

$('input:checkbox[class=pca_no]').click(function(){ //최대 3개까지	  
	  var cntPca = $('input:checkbox[class=pca_no]:checked').length;   //체크갯수 확인
	 
	  if(cntPca>3){
	   alert('최대 3개까지 선택 가능합니다.')
	   $(this).prop('checked', false);
	  }
});

$('input:checkbox[class=pco_no]').click(function(){ //최대 3개까지	  
	  var cntPco = $('input:checkbox[class=pco_no]:checked').length;   //체크갯수 확인
	 
	  if(cntPco>3){
	   alert('최대 3개까지 선택 가능합니다.')
	   $(this).prop('checked', false);
	  }
});

$('input:checkbox[class=pp_no]').click(function(){ //최대 3개까지	  
	  var cntPp = $('input:checkbox[class=pp_no]:checked').length;   //체크갯수 확인
	 
	  if(cntPp>3){
	   alert('최대 3개까지 선택 가능합니다.')
	   $(this).prop('checked', false);
	  }
});

$('input[class=hprice]').blur(function(){   
	
	var low = $(".lprice").val();
	var high = $(".hprice").val();
	
	console.log(low);
	
	  if(low>=high){
	   alert('가격 구간을 정확하게 입력해주세요')
	  }
});

$(".submit").click(function(){
	/* 빈 값 확인 */
	if($('input:checkbox[class=p_gender]:checked').length==0){ // 1번
		alert("문항을 모두 작성해주세요");
		$('input:checkbox[class=p_gender]').focus();
	} else if($('input:checkbox[class=po_no]:checked').length==0){ // 2번
		alert("문항을 모두 작성해주세요");
		$('input:checkbox[class=po_no]').focus();
	} else if($('input:checkbox[class=pb_no]:checked').length==0){ // 3번
		alert("문항을 모두 작성해주세요");
		$('input:checkbox[class=pb_no]').focus();
	} else if($('input:checkbox[class=ps_no]:checked').length==0){ // 4번
		alert("문항을 모두 작성해주세요");
		$('input:checkbox[class=ps_no]').focus();
	} else if($('input:checkbox[class=pca_no]:checked').length==0){ // 5번
		alert("문항을 모두 작성해주세요");
		$('input:checkbox[class=pca_no]').focus();
	} else if($('input:checkbox[class=pco_no]:checked').length==0){ // 6번
		alert("문항을 모두 작성해주세요");
		$('input:checkbox[class=pco_no]').focus();
	} else if($('input:checkbox[class=pp_no]:checked').length==0){ // 7번
		alert("문항을 모두 작성해주세요");
		$('input:checkbox[class=pp_no]').focus();
	} else if($('input[class=lprice]').val()==''){ // 8번 lprice
		alert("문항을 모두 작성해주세요");
		$('input[class=lprice]').focus();
	} else if($('input[class=hprice]').val()==''){ // 8번 hprice
		alert("문항을 모두 작성해주세요");
		$('input[class=hprice]').focus();
	} else {
		$("#quizform").submit();
	}
	
});

</script>