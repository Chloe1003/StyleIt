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
	font-size: 18px;
    line-height: 25px;
    color: #4a3a3a;
    text-transform: capitalize;
    text-align: center;
    margin-bottom: 15px;
}
    
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

.like, .similarlike, .stylinglike{
  position:absolute;
  top:20px;
  right:20px;
  width:22px;
  height:22px;
  z-index:999;
  cursor:pointer;
  background-size: contain;
}
.likecnt{
  position:absolute;
  top:20px;
  right:40px;
  width:22px;
  height:22px;
  z-index:999;
}

.like.red, .similarlike.red, .stylinglike.red {
	background-image: url(/resources/image/styling/redheart.png)
}
.like.empty, .similarlike.empty, .stylinglike.empty {
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
    cursor: pointer;
}

.product{
	position: relative;
    height: 400px;
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
    position: absolute;
    top: 200px;
    left: 20px;
    width: 250px;
    height: 55px;
    opacity: 0;
    transition: all .3s linear;
    text-align: left;
}

.styling-info {
  position:absolute;
  top:250px;
  left:20px;
  width: 250px;
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

.styling-info span {
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

.product-img:hover .styling-info {
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

<c:if test="${products.size()>0 }">
<div class="product">
<div class="p-header">비슷한 제품</div>
	<div class="product-area">
	<c:forEach items="${products }" var="p" begin="0" end="${products.size()-1 }">
		<div class="product-container" onclick="productView(${p.p_no })" data-similarno="${p.p_no }">
		<div class="product-img">
			<img src="/upload/${p.fu_storedname }" alt="products">
			
			<div class="likecnt" id="likecnt">${p.cntplike }</div>
			
			<c:if test="${p.plikecheck eq 0 }">
				<div class="similarlike empty"></div>
			</c:if>
			<c:if test="${p.plikecheck eq 1 }">
				<div class="similarlike red"></div>
			</c:if>			
			
			<div class="darkness"></div>
     		<div class="product-info"><div style="font-size:1.1em; color:#181818;">KRW ${p.p_price }</div>
     		<span draggable="false">${p.pb_name } <br> ${p.p_name }</span></div>
		</div>
		</div>
	</c:forEach>	
	</div>
</div>
</c:if>
<%-- 	<c:if test="${products.size() eq 0 }"> --%>
<!-- 		비슷한 제품이 없어용ㅠㅠ -->
<%-- 	</c:if>	 --%>




<c:if test="${styling.size()>0 }">
<div class="product">
<div class="p-header">어떻게 입을까?</div>
	<div class="product-area">
	<c:forEach items="${styling }" var="s" begin="0" end="${styling.size()-1 }">
		<div class="product-container" onclick="stylingView(${s.s_no })" data-sno="${s.s_no }">
		<div class="product-img">
			<img src="/upload/${s.fu_storedname }" alt="styling">
			
			<div class="likecnt" id="likecnt">${s.cntslike }</div>
			
			<c:if test="${s.slikecheck eq 0 }">
				<div class="stylinglike empty"></div>
			</c:if>
			<c:if test="${s.slikecheck eq 1 }">
				<div class="stylinglike red"></div>
			</c:if>			
			
			<div class="darkness"></div>
     		<div class="styling-info"><span draggable="false">${s.s_name }</span></div>
		</div>
		</div>
	</c:forEach>
	</div>
</div>
</c:if>
<%-- 	<c:if test="${styling.size() eq 0 }"> --%>
<!-- 		해당되는 스타일링이 없어요ㅠㅠ -->
<%-- 	</c:if> --%>



<script type="text/javascript">  
$(document.body).css("background-color", "#eff6f6");
$(document.body).find(".navbar").css("background-color", "#ffffff");

function stylingView(s_no){
	location.href="/styling/view?s_no="+s_no;
}

function productView(p_no){
	location.href="/shop/view?p_no="+p_no;
}

$(document).ready(function(){
	
	var login = false;

	$(".like").click(function(){	
	if(${login ne true}){
// 		console.log("비로그인"); 
		showlogin();
		
	}	else {
		
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
	
	}
	
    return false;
    
	
	});
	
		
		$(".stylinglike").click(function(){
		if(${login ne true}){
//		 		console.log("비로그인");
			showlogin();				
		}	else {	
			
		var s_no = $(this).parent().parent().attr("data-sno");	
		
	 	$.ajax({
			type : "get",
			url : "/styling/like",
			data : {"s_no": s_no },
			dataType : "json",
			success : function(res){
				console.log("성공");			
//	 			console.log($("[data-sno='"+s_no+"']").find(".likecnt"))
				$("[data-sno='"+s_no+"']").find(".likecnt").html(res.cnt);				
				$like = $("[data-sno='"+s_no+"']").find(".stylinglike");
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
	    //jQuery 이벤트의 경우,
	    //return false는 event.stopPropagation()과 event.preventDefault() 를
	    //모두 수행한 것과 같은 결과를 보인다.
	    return false;
		});
			
		$(".similarlike").click(function(){
					
			if(${login ne true}){
//		 		console.log("비로그인");
				showlogin();
			}	else {	
				
			var p_no = $(this).parent().parent().attr("data-similarno");
			
			$.ajax({
				type : "get",
				url : "/shop/like",
				data : {"p_no": p_no },
				dataType : "json",
				success : function(res){
					console.log("성공");
					
//		 			console.log($("[data-sno='"+s_no+"']").find(".likecnt"))
					$("[data-similarno='"+p_no+"']").find(".likecnt").html(res.cnt);				
					$like = $("[data-similarno='"+p_no+"']").find(".similarlike");
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


	$(".buy").click(function(){
		var url = "${view.p_url }";
// 		console.log(url);
		window.open(url , '_blank'); 
	});
	
});	
</script>    
