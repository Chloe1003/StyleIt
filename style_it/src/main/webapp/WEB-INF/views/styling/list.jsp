<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
#block{
width:300px; 
height:350px; 
position:relative; 
display:inline-block;
margin: 20px;
}

.img-wrapper{
box-shadow: 0 1px 4px rgba(0,0,0,0.2);
width:inherit;
height:inherit; 
position:absolute;
cursor: pointer; 
}

.img-wrapper img {
width:inherit;
height:inherit;

}

.darkness {
  position:absolute;
  top:0;
  left:0;
  width:inherit;
  height:inherit;
  background:#E89C8B;
  opacity:0; 
  transition:all .6s linear; 
}

.stylingname {
  position:absolute;
  top:300px;
  left:20px;
  width:inherit;
  height:55px;
  opacity:0; 
  transition:all .3s linear; 
}

/* 추가된 부분 */
.stylingname span {
  font-size:0.9em;
  color:#ffffff;
  user-select:none;
  font-weight: bold;
  text-shadow: 0 1px 10px rgba(0,0,0,0.4);
}

.img-wrapper:hover .darkness{
  opacity:0.4;
}

.img-wrapper:hover .stylingname {
  opacity:1;
/*   transform:scale(1); */
}

.like{
  position:absolute;
  top:20px;
  left:253px;
  width:22px;
  height:22px;
  z-index:999;
}

.comment{
  position:absolute;
  top:50px;
  left:253px;
  width:22px;
  height:22px;
  z-index:999;
}
</style>
<div class="frame">
<c:forEach items="${stylingList }" var="s" begin="0" end="${stylingList.size()-1 }">
<div id="block">
	<div class="img-wrapper img" onclick="stylingView(${s.s_no})">
		<img src="/upload/${s.fu_storedname }" alt="images">
		<div class="like" onclick="like(${s.s_no })"><img src="/resources/image/styling/emptyheart.png" alt="like"></div>
		<div class="comment" onclick="comment(${s.s_no })"><img src="/resources/image/styling/comment.png" alt="comments"></div>
		<div class="darkness"></div>
     	<div class="stylingname"><span draggable="false">${s.s_name }</span></div>
	</div>
</div>
</c:forEach>
</div>

<script type="text/javascript">
$(document.body).css("background-color", "#eff6f6");
$(document.body).find(".navbar").css("background-color", "#ffffff");

function stylingView(s_no){
	location.href="/styling/view?s_no="+s_no;
}

function like(s_no){
 	alert("like!");
}

function comment(s_no){
	
}

</script> 

