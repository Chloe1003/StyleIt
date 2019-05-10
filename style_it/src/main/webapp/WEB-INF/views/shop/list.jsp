<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style>

.wrap-loading{ /*화면 전체를 어둡게 합니다.*/
    position: fixed;
    left:0;
    right:0;
    top:0;
    bottom:0;
    background: rgba(0,0,0,0.2); /*not in ie */
    filter: progid:DXImageTransform.Microsoft.Gradient(startColorstr='#20000000', endColorstr='#20000000');    /* ie */
}
.wrap-loading div{ /*로딩 이미지*/
    position: fixed;
    top:50%;
    left:50%;
    margin-left: -21px;
    margin-top: -21px;
}

.display-none{ /*감추기*/
	display:none;
}

.frame{
    width: 80%;
    margin-left: auto;
    margin-right: auto;
}
.shop-section{
    width: 80%;
    margin-left: auto;
    margin-right: auto;
}
.section-cate{
    width: 108px;
    margin: 10px;
    font-size: 12px;
    line-height: 15px;
    color: #4a3a3a;

}
.section-type-button{
	height: 44px;
    min-width: 125px;
    margin: 10px 3px;
    border: 2px solid rgba(231,214,207,.66);
    font-size: 14px;
    line-height: 18px;
    color: #4a3a3a;
    letter-spacing: .09px;
}

</style>
<!-- <div class="wrap-loading display-none"> -->
<!-- 	<div><img src="/image/shop/loading.gif"/></div> -->
<!-- </div> -->

<div class="shop-section">
	<div class="section">
<!-- 		<span class="section-cate">상황별</span> -->
<!-- 		<span class="section-cate">스타일별</span> -->
	</div>
	
	<div class="section-type">
		<c:forEach items="${psList }" var="ps" begin="0" end="${psList.size()-1 }">
			<button class="section-type-button" type="button" onclick="sortByStyle(${ps.ps_no })"><span>${ps.ps_name }</span></button>
		</c:forEach>
	</div>
</div>

<div class="frame" id="frame">

</div>

<br><br>


<script type="text/javascript">
$(document.body).css("background-color", "#eff6f6");
$(document.body).find(".navbar").css("background-color", "#ffffff");

function productView(p_no){
	location.href="/shop/view?p_no="+p_no;
}

function sortByStyle(ps_no){
	location.href="/shop/list?ps_no="+ps_no;
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
	
	getList(1);
		
	
});	


function comment(s_no){
	
}

var page = 2;

$(window).scroll(function() {
    if ($(window).scrollTop() == $(document).height() - $(window).height()) {
      console.log("스크롤 발생");
      console.log(page);
      getList(page);
      page++
    }
});
function getList(page){
	
  	$.ajax({
		type : "get",
		url : "/shop/listloading",
		data : {"curPage": page },
		dataType : "html",
		success : function(res){
			console.log("스크롤 로딩 성공");			
// 			$("#page").append(res);
			$(".frame").append(res);
			
		},
		beforeSend:function(){
// 			이미지 보여주기 처리
			$(".wrap-loading").removeClass('display-none');
		},
		complete:function(){
			$(".wrap-loading").addClass('display-none');
		},
		error : function(e){
			console.log("실패");
		}			
	});
      
}      



</script>

