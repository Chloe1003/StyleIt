<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">
td {
	border: 1px solid #ffffff
}
</style>
   

<script type="text/javascript">
$(document).ready(function() {
	$('#mainBanner').carousel('cycle');
	
	$("#btnStyling").click(function(){
		var login = false;
		   
		if(${login ne true}){
		
			console.log("test");
			showlogin();
		     
		} else {   
			location.href = "/styling/create";
		}
	});
	
	$("#btnStyleSearch").click(function(){
		location.href = "/styling/tag";
	});

	$("#btnProductSearch").click(function(){
		location.href = "/shop/list";
	});
	
	$("#btnProductRecommend").click(function(){
		
		var login = false;
		   
		if(${login ne true}){
			console.log("test");
			showlogin();
		} else {
			location.href = "/mypage/recommend";
		}
	});
	
});
</script>

<div style="text-align: right; padding-bottom: 100px;" class="container">
<!-- <div class="container"> -->
	<div id="mainBanner" class="carousel slide" data-ride="carousel" data-interval="3000">
	<ol class="carousel-indicators">
		<c:forEach var="i" begin="0" end="${bannerList.size()-1 }"> 
			<c:if test="${i eq 0 }">
   			<li data-target="#mainBanner" data-slide-to="${i }" class="active"></li>
			</c:if>
			<c:if test="${i ne 0 }">
   			<li data-target="#mainBanner" data-slide-to="${i }" class=""></li>
   			</c:if>
		</c:forEach>
 	</ol>
	  		
	<div class="carousel-inner" role="listbox">
	
		<c:forEach var="i" begin="0" end="${bannerList.size()-1 }">
	  		<c:if test="${i eq 0 }">
	    	<div class="item active" style="width: 100%; height: 350px;">
	      		<img src="/upload/${bannerList[i].FU_STOREDNAME }" style="width: 100%; height: 100%;">
	    	</div>
	    	</c:if>
	    	<c:if test="${i ne 0 }">
	    	<div class="item" style="width: 100%; height: 350px;">
	      		<img src="/upload/${bannerList[i].FU_STOREDNAME }" style="width: 100%; height: 100%;">
	    	</div>
	    	</c:if>
		</c:forEach>
				    	
	</div>
	  		
	<a class="left carousel-control" href="#mainBanner" role="button" data-slide="prev">
  		<button class="glyphicon glyphicon-chevron-left" aria-hidden="true"
  		style="background-color:transparent; border: 0px; outline: 0px;"></button>
  		<button class="sr-only">Previous</button>
	</a>
	<a class="right carousel-control" href="#mainBanner" role="button" data-slide="next">
  		<button class="glyphicon glyphicon-chevron-right" aria-hidden="true"
  		style="background-color:transparent; border: 0px; outline: 0px;"></button>  
  		<button class="sr-only">Next</button>
	</a>
	</div>
</div>

<div style="text-align: right; padding-bottom: 100px;" class="container">
	<h3 align="center">나만의 스타일을 찾아보세요!</h3>
	<table class="table" style="text-align: center;">  
	<thead></thead>
	<tbody>
		<tr>
			<td><img src="/resources/image/main/main1.jpg"></td>
			<td><img src="/resources/image/main/main2.jpg"></td>
			<td><img src="/resources/image/main/main3.jpg"></td>
			<td><img src="/resources/image/main/main4.jpg"></td>
		</tr>
		
		<tr>
			<td>우리의 끝없는 옷장에서 어울리는 스타일 조합을<br>만들어보세요!</td>
			<td>아이디어를 얻고, 당신만의 독특한 스타일을<br>찾아보세요!</td>
			<td>구매하기 전에 어떻게 매치해야 할 지<br>상상해보세요!</td>
			<td>당신만을 위한 개인 스타일리스트를<br>만나보세요!</td>
		</tr>
		
		<tr>
			<td><button class="btn btn-info" id="btnStyling">스타일링 하기</button></td>
			<td><button class="btn btn-info" id="btnStyleSearch">스타일링 찾아보기</button></td>
			<td><button class="btn btn-info" id="btnProductSearch">제품 찾아보기</button></td>
			<td><button class="btn btn-info" id="btnProductRecommend">내게 맞는 제품 추천하기</button></td>  
		</tr>
		</tbody>
	</table>
</div>
<script src="/resources/js/jssor.slider-23.0.0.mini.js" type="text/javascript"></script>
<script type="text/javascript">
jQuery(document).ready(function ($) {

    var jssor_1_options = {
//       $AutoPlay: 1,
//       $AutoPlaySteps: 4,
      $SlideDuration: 160,
      $SlideWidth: 200,
      $SlideSpacing: 3, 
      $Cols: 4,
      $ArrowNavigatorOptions: {
        $Class: $JssorArrowNavigator$,
        $Steps: 1
      },
      $BulletNavigatorOptions: {
        $Class: $JssorBulletNavigator$,
        $SpacingX: 1,
        $SpacingY: 1
      }
    };

    var jssor_1_slider = new $JssorSlider$("jssor_1", jssor_1_options);

    /*responsive code begin*/
    /*remove responsive code if you don't want the slider scales while window resizing*/
    function ScaleSlider() {
        var refSize = jssor_1_slider.$Elmt.parentNode.clientWidth;
        if (refSize) {
            refSize = Math.min(refSize, 809);
            jssor_1_slider.$ScaleWidth(refSize);
        }
        else {
            window.setTimeout(ScaleSlider, 30);
        }
    }
    ScaleSlider();
    $(window).bind("load", ScaleSlider);
    $(window).bind("resize", ScaleSlider);
    $(window).bind("orientationchange", ScaleSlider);
    /*responsive code end*/
});

jQuery(document).ready(function ($) {

    var jssor_2_options = {
//       $AutoPlay: 1,
//       $AutoPlaySteps: 4,
      $SlideDuration: 160,
      $SlideWidth: 200,
      $SlideSpacing: 3, 
      $Cols: 4,
      $ArrowNavigatorOptions: {
        $Class: $JssorArrowNavigator$,
        $Steps: 1
      },
      $BulletNavigatorOptions: {
        $Class: $JssorBulletNavigator$,
        $SpacingX: 1,
        $SpacingY: 1
      }
    };

    var jssor_2_slider = new $JssorSlider$("jssor_2", jssor_2_options);

    /*responsive code begin*/
    /*remove responsive code if you don't want the slider scales while window resizing*/
    function ScaleSlider() {
        var refSize = jssor_2_slider.$Elmt.parentNode.clientWidth;
        if (refSize) {
            refSize = Math.min(refSize, 809);
            jssor_2_slider.$ScaleWidth(refSize);
        }
        else {
            window.setTimeout(ScaleSlider, 30);
        }
    }
    ScaleSlider();
    $(window).bind("load", ScaleSlider);
    $(window).bind("resize", ScaleSlider);
    $(window).bind("orientationchange", ScaleSlider);
    /*responsive code end*/
});
</script>
<style>
/* jssor slider bullet navigator skin 03 css */
/*
.jssorb03 div           (normal)
.jssorb03 div:hover     (normal mouseover)
.jssorb03 .av           (active)
.jssorb03 .av:hover     (active mouseover)
.jssorb03 .dn           (mousedown)
*/
.jssorb03 {
    position: absolute;
}
.jssorb03 div, .jssorb03 div:hover, .jssorb03 .av {
    position: absolute;
    /* size of bullet elment */
    width: 21px;
    height: 21px;
    text-align: center;
    line-height: 21px;
    color: white;
    font-size: 12px;
    overflow: hidden;
    cursor: pointer;
}
.jssorb03 div { background-position: -5px -4px; }
.jssorb03 div:hover, .jssorb03 .av:hover { background-position: -35px -4px; }
.jssorb03 .av { background-position: -65px -4px; }
.jssorb03 .dn, .jssorb03 .dn:hover { background-position: -95px -4px; }

/* jssor slider arrow navigator skin 03 css */
/*
.jssora03l                  (normal)
.jssora03r                  (normal)
.jssora03l:hover            (normal mouseover)
.jssora03r:hover            (normal mouseover)
.jssora03l.jssora03ldn      (mousedown)
.jssora03r.jssora03rdn      (mousedown)
.jssora03l.jssora03ldn      (disabled)
.jssora03r.jssora03rdn      (disabled)
*/
.jssora03l, .jssora03r {
    display: block;
    position: absolute;
    /* size of arrow element */
    width: 55px;
    height: 55px;
    cursor: pointer;
    overflow: hidden;
}
.jssora03l { background-position: -3px -33px; }
.jssora03r { background-position: -63px -33px; }
.jssora03l:hover { background-position: -123px -33px; }
.jssora03r:hover { background-position: -183px -33px; }
.jssora03l.jssora03ldn { background-position: -243px -33px; }
.jssora03r.jssora03rdn { background-position: -303px -33px; }
.jssora03l.jssora03lds { background-position: -3px -33px; opacity: .3; pointer-events: none; }
.jssora03r.jssora03rds { background-position: -63px -33px; opacity: .3; pointer-events: none; }
</style>
<div style="text-align: right; padding-bottom: 100px;" class="container">
	<div id="stylingContainer" style="display: flex;">
		<div id="styling_left" style="flex: 1;"></div>
		<div id="styling_center" style="flex: 3;"><h3 align="center" >오늘의 스타일링</h3></div>
		<div id="styling_right" style="flex: 1;"><a href="/styling/tag">더 보기</a></div>
	</div>
	<div id="jssor_1" style="position:relative;margin:0 auto;top:0px;left:0px;width:809px;height:150px;overflow:hidden;visibility:hidden;">
		<!-- Loading Screen -->
		<div data-u="loading" style="position:absolute;top:0px;left:0px;background-color:rgba(0,0,0,0.7);">
			<div style="filter: alpha(opacity=70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
				<div style="position:absolute;display:block;background:url('/resources/image/main/loading.gif') no-repeat center center;top:0px;left:0px;width:100%;height:100%;"></div>
		</div>
		<div data-u="slides" style="cursor:default;position:relative;top:0px;left:0px;width:809px;height:150px;overflow:hidden;">
			<c:forEach var="i" items="${todayStyling }" begin="0" end="${todayStyling.size()-1 }">
				<div>
		    		<a href="/styling/view?s_no=${i.S_NO }"><img data-u="image" src="/upload/${i.FU_STOREDNAME }" /></a>
				</div>
			</c:forEach>  
		</div>
		
	<!-- Arrow Navigator -->
	<span data-u="arrowleft" class="jssora03l" style="top:0px;left:8px;width:55px;height:55px;" data-autocenter="2">
	<img data-u="left-arrow" src="/resources/image/main/left-arrow.png" /></span>
	<span data-u="arrowright" class="jssora03r" style="top:0px;right:8px;width:55px;height:55px;" data-autocenter="2">
	<img data-u="right-arrow" src="/resources/image/main/right-arrow.png" /></span>
	</div>
	<!-- #endregion Jssor Slider End -->	
</div>

<div style="text-align: right; padding-bottom: 100px;" class="container">
	<div id="stylingContainer" style="display: flex;">
		<div id="styling_left" style="flex: 1;"></div>
		<div id="styling_center" style="flex: 3;"><h3 align="center" >인기 제품</h3></div>
		<div id="styling_right" style="flex: 1;"><a href="/shop/list">더 보기</a></div>
	</div>
	<div id="jssor_2" style="position:relative;margin:0 auto;top:0px;left:0px;width:809px;height:150px;overflow:hidden;visibility:hidden;">
		<!-- Loading Screen -->
		<div data-u="loading" style="position:absolute;top:0px;left:0px;background-color:rgba(0,0,0,0.7);">
			<div style="filter: alpha(opacity=70); opacity: 0.7; position: absolute; display: block; top: 0px; left: 0px; width: 100%; height: 100%;"></div>
				<div style="position:absolute;display:block;background:url('/resources/image/main/loading.gif') no-repeat center center;top:0px;left:0px;width:100%;height:100%;"></div>
		</div>
		<div data-u="slides" style="cursor:default;position:relative;top:0px;left:0px;width:809px;height:150px;overflow:hidden;">
   			<c:forEach var="i" items="${bestProduct }" begin="0" end="${bestProduct.size()-1 }">
				<div>
		    		<a href="shop/view?p_no=${i.P_NO }"><img data-u="image" src="/upload/${i.FU_STOREDNAME }" /></a>
				</div>
			</c:forEach>  
		</div>
	<!-- Arrow Navigator -->
	<span data-u="arrowleft" class="jssora03l" style="top:0px;left:8px;width:55px;height:55px;" data-autocenter="2">
	<img data-u="left-arrow" src="/resources/image/main/left-arrow.png" /></span>
	<span data-u="arrowright" class="jssora03r" style="top:0px;right:8px;width:55px;height:55px;" data-autocenter="2">
	<img data-u="right-arrow" src="/resources/image/main/right-arrow.png" /></span>
	</div>
	<!-- #endregion Jssor Slider End -->
</div>