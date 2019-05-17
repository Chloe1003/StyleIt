<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>

.button {
	
	margin-left:10%;
    display: block;
    width: 150px;
    height: 40px;
    background: #d63c00;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    color: white;
    font-weight: bold;
}

.product{
	position: relative;
    height: 500px;
    width: 100%;
    background-color: white;

    display: flex;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;

    flex-direction: column;
    -webkit-box-pack: justify;

/*     justify-content: space-between; */
    -webkit-box-align: center;

    align-items: center;

}
.p-header{
    font-size: 16px;
    line-height: 16px;
    text-transform: uppercase;
    color: #333;
    height: 40px;
    display: flex;
    -webkit-box-pack: center;
    /* justify-content: center; */
    -webkit-box-align: center;
    align-items: center;
    margin: 20px 5px;
}
.product-area{
    height: 100%;
    width: 96%;
    margin-left: 5%;
    margin-right: 5%;
}
.product-container{
    width: 290px;
    height: 300px;
    position: relative;
    display: inline-block;
    margin: 5px;

}
.product-img{
box-shadow: 0 1px 4px rgba(0,0,0,0.2);
width:inherit;
height:inherit; 
position:absolute;
cursor: pointer; 
background:white;

/* 	display: block; */
/*     width: 100%; */
/*     height: 100%; */
/*     box-sizing: border-box; */
}
.product-img img{
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
.product-info {
  position:absolute;
  top:220px;
  left:20px;
  width:inherit;
  height:55px;
  opacity:0; 
  transition:all .3s linear; 
  text-align: left;
}

.product-info span {
  font-size:0.9em; 
  color:#777;
  user-select:none;
/*   font-weight: bold; */
  line-height: 15px;
}

.product-img:hover .darkness{
  opacity:0.4;
}

.product-img:hover .product-info {
  opacity:1;
/*   transform:scale(1); */
}

.plike{
  position:absolute;
  top:20px;
  right:20px;
  width:22px;
  height:22px;
  z-index:999;
  cursor:pointer;
  background-size: contain;
}
.plikecnt{
  position:absolute;
  top:20px;
  right:40px;
  width:22px;
  height:22px;
  z-index:999;
}
.plike.red {
	background-image: url(/resources/image/product/redheart.png)
}
.plike.empty {
	background-image: url(/resources/image/product/emptyheart.png)
}
</style>

<a class="button" href= "/mypage/mypage" style="color:white;">마이페이지 홈으로</a>
<div class="product">
<div class="p-header">내가 좋아하는 제품리스트 / <span style="position: relative; left: 7px; font-size: 15px; font-weight: bold;">
								${countProductLike } 개</span></div></div>
	<div class="product-area">
	
	<c:if test="${pKList.size()>0 }">
	<c:forEach items="${pKList }" var="p" begin="0" end="${pKList.size()-1 }">
		<div class="product-container" onclick="productView(${p.p_no })" data-pno="${p.p_no }">
		<div class="product-img">
			<img src="/upload/${p.fu_storedname }" alt="product">
			
			<div class="plikecnt" id="plikecnt">${p.cntslike }</div>
			
			<c:if test="${p.plikecheck eq 0 }">
				<div class="plike empty"></div>
			</c:if>
			<c:if test="${p.plikecheck eq 1 }">
				<div class="plike red"></div>
			</c:if>			
			
			<div class="darkness"></div>
     			<div class="productname"><span draggable="false">${p.p_name }</span></div>
		</div>
		</div>
	</c:forEach>
	</c:if>
	</div>

<br><br><br><br>

<script type="text/javascript">
function productView(p_no){
	location.href="/product/view?p_no="+p_no;
}

$(document).ready(function(){
	
	$(".plike").click(function(){
		
	var p_no = $(this).parent().parent().attr("data-pno");
	
	$.ajax({
		type : "get",
		url : "/product/like",
		data : {"p_no": p_no },
		dataType : "json",
		success : function(res){
			console.log("성공");
			
			console.log($("[data-pno='"+p_no+"']").find(".likecnt"))
			$("[data-pno='"+p_no+"']").find(".plikecnt").html(res.cnt);
			
			$like = $("[data-pno='"+p_no+"']").find(".plike");
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
	
    return false;
	});
	
		
	
});	

</script>