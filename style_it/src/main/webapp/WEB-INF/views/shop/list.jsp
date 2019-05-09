<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style>
.frame{
    width: 80%;
    margin-left: auto;
    margin-right: auto;
}

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


<div class="frame">
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
</div>

<script type="text/javascript">
var page = 1;  //페이징과 같은 방식이라고 생각하면 된다. 
 
$(function(){  //페이지가 로드되면 데이터를 가져오고 page를 증가시킨다.
     getList(page);
     page++;
}); 
 
$(window).scroll(function(){   //스크롤이 최하단 으로 내려가면 리스트를 조회하고 page를 증가시킨다.
     if($(window).scrollTop() >= $(document).height() - $(window).height()){
          getList(page);
           page++;   
     } 
});
 
function getList(page){
 
    $.ajax({
        type : 'POST',  
        dataType : 'json', 
        data : {"page" : page},
        url : '/shop/list'
        success : function(returnData) {
            var data = returnData.rows;
            var html = "";
            if (page==1){ //페이지가 1일경우에만 class가 frame인 html을 비운다.
                  $(".frame").html(""); 
            }
            if (returnData.startNum<=returnData.totCnt){
                if(data.length>0){
                // for문을 돌면서 행을 그린다.
                }else{
                //데이터가 없을경우
                }
            }
            html = html.replace(/%20/gi, " ");
            if (page==1){  //페이지가 1이 아닐경우 데이터를 붙힌다.
                $(".frame").html(html); 
            }else{
                $("#busStopList").append(html);
            }
       },error:function(e){
           if(e.status==300){
               alert("데이터를 가져오는데 실패하였습니다.");
           };
       }
    }); 
}

</script>

<script type="text/javascript">
$(document.body).css("background-color", "#eff6f6");
$(document.body).find(".navbar").css("background-color", "#ffffff");

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
		
	
});	


function comment(s_no){
	
}

</script> 
