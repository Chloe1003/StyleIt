<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
.frame{
 position:relative;  
 display:block; 
}

.img-wrapper{
box-shadow: 0 1px 4px rgba(0,0,0,0.2);
width:400px; 
height:400px;  
position:absolute; 
}

.info{
position:absolute;


}

</style> 
    
<div class="frame">
	<div class="img-wrapper">
		<img src="/upload/${styling.fu_storedname }" alt="styling">
	</div>
	<div class="info">
		<div>${styling.s_name }</div>
		<div>${styling.s_content }</div>
		<div class="icon">
			<c:if test="${s.slikecheck eq 0 }">
				<div class="like empty"></div>
			</c:if>
			<c:if test="${s.slikecheck eq 1 }">
				<div class="like red"></div>
			</c:if>
			
			<div class="comment" onclick="comment(${s.s_no })"><img src="/resources/image/styling/comment.png" alt="comments"></div>
			<div class="collection"><img src="/resources/image/add.png"></div>
		</div>
	</div>






</div>    
    
    
<script type="text/javascript">
$(document.body).css("background-color", "#eff6f6");
$(document.body).find(".navbar").css("background-color", "#ffffff");
</script>    