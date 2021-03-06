<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
#block{
    width: 280px;
    height: 280px;
    position: relative;
    display: inline-block;
    margin: 10px;
}

.img-wrapper{
box-shadow: 0 1px 4px rgba(0,0,0,0.2);
width:inherit;
height:inherit; 
position:absolute;
cursor: pointer; 
background:white;
}

.img-wrapper img {
width:inherit;
height:inherit;
object-fit: contain;
}

.darkness {
  position:absolute;
  top:0;
  left:0;
  width:inherit;
  height:inherit;
  background:linear-gradient(to bottom, #E89C8B, transparent );
  opacity:0; 
  transition:all .6s linear; 
}

.productname {
  position:absolute;
  top:180px;
  left:20px;
  width:240px;
  height:55px;
  opacity:0; 
  transition:all .3s linear; 
}

/* 추가된 부분 */
.productname span {
  font-size:0.9em;
  color:#777;
  user-select:none;
  font-weight: bold;
/*   text-shadow: 0 1px 10px rgba(0,0,0,0.4); */
}

.img-wrapper:hover .darkness{
  opacity:0.4;
}

.img-wrapper:hover .productname {
  opacity:1;
/*   transform:scale(1); */
}

.like{
  position:absolute;
  top:20px;
  left:240px;
  width:22px;
  height:22px;
  z-index:999;
  
  background-size: contain;
}

.likecnt{
  position:absolute;
  top:20px;
  left:225px;
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

<c:if test="${productList.size() eq 0 }">
<div style="text-align:center; margin-top:100px;">해당하는 제품이 없습니다</div>
</c:if>
<c:if test="${productList.size()>0 }">
<c:forEach items="${productList }" var="p" begin="0" end="${productList.size()-1 }">
<div id="block">
	<div class="img-wrapper img" onclick="productView(${p.p_no })" data-pno="${p.p_no }">
		<img src="/upload/${p.fu_storedname }" alt="images">
		<div class="likecnt" id="likecnt">${p.cntplike }</div>
		
		<c:if test="${p.plikecheck eq 0 }">
			<div class="like empty"></div>
		</c:if>
		<c:if test="${p.plikecheck eq 1 }">
			<div class="like red"></div>
		</c:if>
		
		<div class="darkness"></div>
   		<div class="productname"><div style="font-weight:600;">KRW ${p.p_price }</div>
     	<span draggable="false">${p.pb_name } <br> ${p.p_name } </span></div>

	</div>
</div>
</c:forEach>
</c:if>

<script type="text/javascript">
function productView(p_no){
	location.href="/shop/view?p_no="+p_no;
}

$(document).ready(function(){
	
	$(".like").click(function(){
		
	var login = false;	
	
	if(${login ne true}){
// 		console.log("비로그인");
		showlogin();
		
	}	else {	
	
	var p_no = $(this).parent().attr("data-pno");
	
	$.ajax({
		type : "get",
		url : "/shop/like",
		data : {"p_no": p_no },
		dataType : "json",
		success : function(res){
			console.log("성공");
			
// 			console.log($("[data-sno='"+s_no+"']").find(".likecnt"))
			$("[data-pno='"+p_no+"']").find(".likecnt").html(res.cnt);
			
			$like = $("[data-pno='"+p_no+"']").find(".like");
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
	 
	}
	
    return false;
    
	
	});
	
// 	getList(1);
		
	
});	

</script>