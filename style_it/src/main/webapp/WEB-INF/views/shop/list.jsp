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
	height: 30px;
    min-width: 125px;
    margin: 10px 3px 30px 3px;
    border: none; 
    font-size: 14px;
    line-height: 18px;
    color: whitesmoke;
    letter-spacing: .09px;
    background: #E89994;
    
}
.shop-search {
	display: flex;
    -webkit-box-pack: center;
    justify-content: center;
    -webkit-box-align: center;
    align-items: center;
    position: relative;
    height: 100%;
    width: 100%;
    font-family: Quicksand-Medium,sans-serif;
    font-size: 20px;
    line-height: 20px;
    font-weight: 700;
    color: #4a3a3a;
    letter-spacing: 2px;
}
.shop-search-input{
	height: 100%;
    position: relative;
    display: flex;
    -webkit-box-align: center;
    align-items: center;
}
.search-input{
	height: 40px;
    max-width: 80vw;
    padding: 0 50px;
    width: 800px;
    border: 1px solid #f7f7f7;
    border-radius: 100px;
    background-color: #fff;
    -webkit-box-shadow: inset 0 1px 2px 0 rgba(80,80,80,.24);
    box-shadow: inset 0 1px 2px 0 rgba(80,80,80,.24);
    font-family: Quicksand-Regular,sans-serif;
    font-size: 16px;
    line-height: 16px;
    color: #9b9b9b;
    letter-spacing: 1.74px;
}


</style>
<!-- <div class="wrap-loading display-none"> -->
<!-- 	<div><img src="/image/shop/loading.gif"/></div> -->
<!-- </div> -->

<div class="shop-search">
  <div class="shop-search-input">
    <input placeholder="Search" type="text" class="search-input" id="search">
  </div>
</div>

<div class="shop-section">	
	<div class="section-type">
		<c:forEach items="${psList }" var="ps" begin="0" end="${psList.size()-1 }">
			<button class="section-type-button" type="button" onclick="sortByStyle(${ps.ps_no })"><span>${ps.ps_name }</span></button>
		</c:forEach>
	</div>
</div>

<div class="frame" id="frame">

</div>

<br><br>
<input type="hidden" id="style">
<input type="hidden" id="searchWord">

<script type="text/javascript">
$(document.body).css("background-color", "#eff6f6");
$(document.body).find(".navbar").css("background-color", "#ffffff");

$("#search").keydown(function(e){
	if(window.event.keyCode == 13){
		
		console.log("검색어 입력");
		
		var search = $("#search").val();
		$("#searchWord").val(search);
		
	    var ps_no = $("#style").val();	
	     
	  	$.ajax({
			type : "get",
			url : "/shop/listloading",
			data : {"curPage": 1, 
					"ps_no": ps_no,
					"search" : search },
			dataType : "html",
			success : function(res){
				console.log("검색 성공");			
//	 			$("#page").append(res);
				$(".frame").html(res);
				
			},
			error : function(e){
				console.log("실패");
			}			
		});
		
	}
});
	
function productView(p_no){
	location.href="/shop/view?p_no="+p_no;
}

function sortByStyle(ps_no){
		
	$("#style").val(ps_no);
	
  	$.ajax({
		type : "get",
		url : "/shop/listloading",
		data : {"curPage": 1, 
				"ps_no": ps_no,
				"search" : search },
		dataType : "html",
		success : function(res){
			console.log("카테고리 선택 성공");			
// 			$("#page").append(res);
			$(".frame").html(res);
			
		},
		error : function(e){
			console.log("실패");
		}			
	});

	
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
	
	getList(1, 0);
		
	
});	


function comment(s_no){
	
}

var page = 2;

$(window).scroll(function() {
    if ($(window).scrollTop() == $(document).height() - $(window).height()) {
      console.log("스크롤 발생");
      console.log(page);
      var ps_no = $("#style").val();
      var search = $("#searchWord").val();
      getList(page, ps_no, search);
      page++
    }
});


function getList(page, ps_no, search){
	
  	$.ajax({
		type : "get",
		url : "/shop/listloading",
		data : {"curPage": page, 
				"ps_no": ps_no,
				"search" : search },
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

