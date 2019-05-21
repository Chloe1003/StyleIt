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

.styling{
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
.s-header{
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
.styling-area{
    height: 100%;
    width: 96%;
    margin-left: 5%;
    margin-right: 5%;
}
.styling-container{
    width: 290px;
    height: 300px;
    position: relative;
    display: inline-block;
    margin: 5px;

}
.styling-img{
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
.styling-img img{
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
.styling-info {
  position:absolute;
  top:220px;
  left:20px;
  width:inherit;
  height:55px;
  opacity:0; 
  transition:all .3s linear; 
  text-align: left;
}

.styling-info span {
  font-size:0.9em; 
  color:#777;
  user-select:none;
/*   font-weight: bold; */
  line-height: 15px;
}

.styling-img:hover .darkness{
  opacity:0.4;
}

.styling-img:hover .styling-info {
  opacity:1;
/*   transform:scale(1); */
}

.slike{
  position:absolute;
  top:20px;
  right:20px;
  width:22px;
  height:22px;
  z-index:999;
  cursor:pointer;
  background-size: contain;
}
.slikecnt{
  position:absolute;
  top:20px;
  right:40px;
  width:22px;
  height:22px;
  z-index:999;
}
.slike.red {
	background-image: url(/resources/image/styling/redheart.png)
}
.slike.empty {
	background-image: url(/resources/image/styling/emptyheart.png)
}
</style>

<a class="button" href= "/styling/create" style="color:white;">+ 새로운 스타일링</a>
<div class="styling">
<div class="s-header">나의 스타일링  / <span style="position: relative; left: 7px; font-size: 15px; font-weight: bold;">
								${countStyling } 개</span></div>
	<div class="styling-area">
	
	<c:if test="${sList.size()>0 }">
	<c:forEach items="${sList }" var="s" begin="0" end="${sList.size()-1 }">
		<div class="styling-container" onclick="stylingView(${s.s_no })" data-sno="${s.s_no }">
		<div class="styling-img">
			<img src="/upload/${s.fu_storedname }" alt="styling">
			
			<div class="slikecnt" id="slikecnt">${s.cntslike }</div>
			
			<c:if test="${s.slikecheck eq 0 }">
				<div class="slike empty"></div>
			</c:if>
			<c:if test="${s.slikecheck eq 1 }">
				<div class="slike red"></div>
			</c:if>			
			
			<div class="darkness"></div>
     			<div class="stylingname"><span draggable="false">${s.s_name }</span></div>
		</div>
		</div>
	</c:forEach>
	</c:if>
	</div>
</div>
<br><br><br><br>

<script type="text/javascript">
function stylingView(s_no){
	location.href="/styling/view?s_no="+s_no;
}

$(document).ready(function(){
	
	$(".slike").click(function(){
		
	var s_no = $(this).parent().parent().attr("data-sno");
	
	$.ajax({
		type : "get",
		url : "/styling/like",
		data : {"s_no": s_no },
		dataType : "json",
		success : function(res){
			console.log("성공");
			
			console.log($("[data-sno='"+s_no+"']").find(".likecnt"))
			$("[data-sno='"+s_no+"']").find(".slikecnt").html(res.cnt);
			
			$like = $("[data-sno='"+s_no+"']").find(".slike");
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