<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="/resources/js/jssor.slider-23.0.0.mini.js" type="text/javascript"></script>
<style>

.frame{
/* margin: 50px 0; */

	height: 680px;
    width: 100%;
    display: flex;
    justify-content: space-around;
    padding: 20px;
    background-color: #fff;


}

.img-wrapper{
	width: auto;
    height: 650px;
    display: flex;
    -webkit-box-pack: center;
    justify-content: center;
    -webkit-box-align: center;
    align-items: center;
    position: relative;
    -webkit-box-flex: 1;
    flex: 1 1 auto;
}
.img-wrapper img{
/* box-shadow: 0 1px 4px rgba(0,0,0,0.2); */
width:85%;
height:100%;
object-fit: contain;
}

.info{
	width: 380px;
    padding: 85px 20px 20px;
    height: 100%;
    margin: auto;

    display: flex;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;
    flex-direction: column;
    -webkit-box-align: center;
    align-items: center;

}
.info-header{
/* font-family: Montserrat-Light,sans-serif; */
    font-size: 18px;
    line-height: 18px;
    color: #4a3a3a;
    text-transform: capitalize;
    text-align: center;
    margin-bottom: 26px;
    
}
.info-divider{
	width: 100%;
    height: 4px;
    background-color: #f0f6f6;
    margin-bottom: 20px;
}
.info-detail{
/* font-family: Montserrat-Light,sans-serif; */
    font-size: 12px;
    line-height: 12px;
    opacity: .34;
    color: #2f394c;
    margin-bottom: 20px;
    text-align: center;

}

.icon {
display:inline-flex;
margin-bottom: 20px;
}

.like{
  width:20px;
  height:20px;
  background-size: contain;
  margin-right: 20px;
  cursor: pointer;
}

.like.red {
	background-image: url(/resources/image/styling/redheart.png)
}
.like.empty {
	background-image: url(/resources/image/styling/emptyheart.png)
}
.comment {
	background-image: url(/resources/image/styling/comment.png);
	width:20px;
    height:20px;
    background-size: contain;
    margin: 0 20px;    
}
.collection{
	background-image: url(/resources/image/styling/add.png);
	width:20px;
    height:20px;
    background-size: contain;
    margin: 0 10px 0 20px;
}
.member{
display:inline-flex;
}
.profile{
	width:40px;
    height:40px;
}
.profile img{
	width:inherit;
	height: inherit;
	border-radius:50%;
	margin-right:10px;
}
.nickname{
    margin: 0 20px;

}
.follow{
	padding: 5px 30px;
    background: #009994;
    border-radius: 15px;
    color: white;
    margin-left:30px;

}
.product{
	position: relative;
    height: 500px;
    width: 100%;
    background-color: rgba(250,211,204,.25);

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
    border-bottom: #E89C8B;
    border-bottom-style: double;
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


</style> 
    
<div class="frame">
	<div class="img-wrapper">
		<img src="/upload/${styling.fu_storedname }" alt="styling">
	</div>

	<div class="info">
		<div class="info-header">${styling.s_name }</div>
		
		<div class="info-divider"></div>
		
		<div class="info-detail">${styling.s_content }</div>
		
		<div class="info-divider"></div>
		
		<div class="icon">
			<c:if test="${styling.slikecheck eq 0 }">
				<div class="like empty"></div>
			</c:if>
			<c:if test="${styling.slikecheck eq 1 }">
				<div class="like red"></div>
			</c:if>
			<div class="likecnt" id="likecnt">${styling.cntslike }</div>
			
			<div class="comment" onclick="comment(${styling.s_no })"></div>
			<div class="collection"></div><span>컬렉션에 추가</span>
		</div>

		<div class="info-divider"></div>

		<div class="member">
			<div class="profile"><img src="/upload/${maker.fu_storedname }" alt="profile"></div>
			<div class="nickname">
				<div style="color:#ccc;">Created by</div>
				<div>${maker.m_nick }</div>
			</div>
			<div style="margin-top: 7px;">
				<div class="follow">FOLLOW</div>
			</div>
		</div>
	</div>
</div>
<div class="product">
<div class="p-header">스타일링에 사용된 제품보기</div>
	<div class="product-area">
	<c:forEach items="${product }" var="p" begin="0" end="${product.size()-1 }">
		<div class="product-container" onclick="productView(${p.p_no })" data-pno="${p.p_no }">
		<div class="product-img">
			<img src="/upload/${p.fu_storedname }" alt="product">
			
<%-- 			<div class="likecnt" id="likecnt">${p.cntplike }</div> --%>
			
<%-- 			<c:if test="${p.plikecheck eq 0 }"> --%>
<!-- 				<div class="like empty"></div> -->
<%-- 			</c:if> --%>
<%-- 			<c:if test="${p.plikecheck eq 1 }"> --%>
<!-- 				<div class="like red"></div> -->
<%-- 			</c:if>			 --%>
			
			<div class="darkness"></div>
     		<div class="product-info"><div style="font-size:1.1em; color:#181818;">KRW ${p.p_price }</div>
     		<span draggable="false">${p.pb_name } <br> ${p.p_name }</span></div>
		</div>
		</div>
	</c:forEach>
	</div>
	




</div>
  
<br>



<script type="text/javascript">  
$(document.body).css("background-color", "#eff6f6");
$(document.body).find(".navbar").css("background-color", "#ffffff");

function productView(p_no){
	location.href="/product/view?p_no="+p_no;
}

$(document).ready(function(){
	
	$(".like").click(function(){
		
		
	var s_no = ${styling.s_no }
	console.log("s_no: "+s_no);
	
	$.ajax({
		type : "get",
		url : "/styling/like",
		data : {"s_no": s_no },
		dataType : "json",
		success : function(res){
			console.log("성공");
			
// 			console.log($("[data-sno='"+s_no+"']").find(".likecnt"))
			$(".likecnt").html(res.cnt);
			
			$like = $(".like");
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
</script>    