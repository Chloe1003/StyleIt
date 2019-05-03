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
  
  background-size: contain;
}

.likecnt{
  position:absolute;
  top:20px;
  left:233px;
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
.like.red {
	background-image: url(/resources/image/styling/redheart.png)
}
.like.empty {
	background-image: url(/resources/image/styling/emptyheart.png)
}
</style>
<div class="frame">
<c:forEach items="${stylingList }" var="s" begin="0" end="${stylingList.size()-1 }">
<div id="block">
	<div class="img-wrapper img" onclick="stylingView(${s.s_no })" data-sno="${s.s_no }">
		<img src="/upload/${s.fu_storedname }" alt="images">
		<div class="likecnt" id="likecnt">${s.cntslike }</div>
		
		<c:if test="${s.slikecheck eq 0 }">
			<div class="like empty"></div>
		</c:if>
		<c:if test="${s.slikecheck eq 1 }">
			<div class="like red"></div>
		</c:if>
		
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


$(document).ready(function(){
	
	$(".like").click(function(){
	var s_no = $(this).parent().attr("data-sno");
// 	console.log("s_no: "+s_no);
	
	$.ajax({
		type : "get",
		url : "/styling/like",
		data : {"s_no": s_no },
		dataType : "json",
		success : function(res){
			console.log("성공");
			
// 			console.log($("[data-sno='"+s_no+"']").find(".likecnt"))
			$("[data-sno='"+s_no+"']").find(".likecnt").html(res.cnt);
			
			$like = $("[data-sno='"+s_no+"']").find(".like");
			if($like.hasClass("red")) {
				$like.removeClass("red");
				$like.addClass("empty");
			} else {
				$like.addClass("red");
				$like.removeClass("empty");
			}
			
		},
		error : function(e){
			console.log("실패");
		}			
	});
	 
    //jQuery 이벤트의 경우,
    //return false는 event.stopPropagation()과 event.preventDefault() 를
    //모두 수행한 것과 같은 결과를 보인다.
    return false;
    
	});
		
	
});	





function comment(s_no){
	
}

</script> 

