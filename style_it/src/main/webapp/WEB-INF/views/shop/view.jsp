<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style>
.frame{
	height: 420px;
    width: 100%;

    display: flex;
    -webkit-box-pack: center;

    justify-content: center;
    -webkit-box-align: center;

    align-items: center;
    padding: 0 20px;
    background-color: #fff;
    border-bottom: 3px solid #f0f5f5;
}

.img-wrapper{
    
    position: relative;
    display: flex;
/*     -webkit-box-flex: 0; */
    flex: 0 1 450px;
    height: 100%;
    width: 450px;
/*     -webkit-box-pack: center; */
    justify-content: center;
    margin-left: 25%;
    
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
    font-size: 15px;
    line-height: 25px;
/*     opacity: .34; */
    color: #777;
    margin-bottom: 20px;
    text-align: center;

}

.icon {
display:inline-flex;
margin-bottom: 20px;
}

.like{
  position:absolute;
  top:20px;
  right:10px;
  width:22px;
  height:22px;
  z-index:999;
  
  background-size: contain;
}

.likecnt{
  position:absolute;
  top:20px;
  right:30px;
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
.styling {
	background-image: url(/resources/image/main/hanger.png);
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

.buy{
	padding: 5px 100px;
    background: #009994;
    border-radius: 15px;
    color: white;

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
		<img src="/upload/${view.fu_storedname }" alt="product">
		
			<c:if test="${view.plikecheck eq 0 }">
				<div class="like empty"></div>
			</c:if>
			<c:if test="${view.plikecheck eq 1 }">
				<div class="like red"></div>
			</c:if>
			<div class="likecnt" id="likecnt">${view.cntplike }</div>
		
		
	</div>

	<div class="info">
		<div class="info-header">${view.p_name }</div>
	
		<div class="info-detail">${view.pb_name }<br> KRW ${view.p_price }</div>
		
		<div class="info-divider"></div>
		
		<div class="icon">			
			<div class="styling"></div><span>스타일링하기</span>
			<div class="collection"></div><span>컬렉션에 추가</span>
		</div>

		<div class="info-divider"></div>

			<div style="margin-top: 7px;">
				<div class="buy">BUY</div>
			</div>
		
	</div>
</div>






<!-- <hr> -->

<!-- <div> -->

<!-- <h5>어떻게 입을까?</h5> -->

<%-- <c:forEach items="${list }" var="l" begin="0" end="${list.size() }"> --%>
<!-- <div id=block> -->
<%-- <img src="/upload/${l.fu_storedname }" width="200px" height="200px"> --%>
<%-- <span>${l.s_name }</span> --%>
<!-- </div> -->
<%-- </c:forEach> --%>

<!-- </div> -->


<script type="text/javascript">  
$(document.body).css("background-color", "#eff6f6");
$(document.body).find(".navbar").css("background-color", "#ffffff");

function StylingView(s_no){
	location.href="/styling/view?s_no="+s_no;
}

$(document).ready(function(){
	
	$(".like").click(function(){
		
	var p_no = ${view.p_no }
	
	$.ajax({
		type : "get",
		url : "/shop/like",
		data : {"p_no": p_no },
		dataType : "json",
		success : function(res){
			console.log("성공");
			
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
	 
    return false;
    
	
	});
	
	$(".buy").click(function(){
		
		window.open(view.p_url , '_blank'); 
	});
	
});	
</script>    
