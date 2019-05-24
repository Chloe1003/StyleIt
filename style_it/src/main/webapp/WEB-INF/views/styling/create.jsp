<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- Canvas -->
<script type="text/javascript" src="/resources/js/html2canvas.js"></script>
<script type="text/javascript" src="/resources/js/jquery.plugin.html2canvas.js"></script>
<!-- UI형식으로 드래그 앤 드롭 -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">

<script type="text/javascript">

function proc(result){
	$("#product").html("");
	    	
	$.each(result, function (index, item) {
            //div에 출력  
		$("#product").append('<div id="Clone'+index+'" style="background-size : 100% 100%; float:left; margin: 10px;'
				+'background-image: url(/upload/image/'+ item.FU_STOREDNAME+')"> <div style="position: absolute;">'
				+'<div style="position: relative; top: 10px; left: 15px;"><button id="btnMinus" name="btnMinus" disabled'
				+' style="background-color:transparent; border: 0px; outline: 0px;" onclick="btnMinus()">'
				+'<img style="visibility : hidden" ondragstart="return false" value="'+item.FU_NO
				+'" src="/resources/image/styling/minus.png" /></button></div></div></div>');   

	    //table에 출력	
		var str = '<tr><td>'+item.FU_STOREDNAME+'</td>';    
		str += '<td>' + item.FU_NO + '</td>';
		$('table').append(str);
		
	});
}



function filter(curPage){
	var data = $("#pca_category").val();
	var word = $("input[type='text'][name='search']").val();
	console.log(data);
	console.log(word);
	
	if(!curPage)	curPage=0;
		$.ajax ({
		type: "get"
			, url: "/styling/create/ajax?pca_no="+data+"&word="+word+"&curPage="+curPage
			, data: { } //요청파라미터
			, dataType: "html"
			, success: function( res ){
				console.log("성공");
				
				$("#product").html(res);
				
			}
			, error: function( e ) {
				console.log("실패");
			}
		});  

}



function btnMinus(){
	$("[id='btnMinus']").click(function(){
		$(this).parent().parent().parent().remove();
	});  
}

function Reset(){
	$("#createStyle").children().remove();   
}

//드래그 앤 드롭

var css_test_idx = 10;

//이미지 복사 보조 변수
var cnt = 0;

// 보기편하게 여러줄로 코딩
$(document).ready(function() {
	
	$("#word").click(function(){
		 filter();
	});
	
	$( "#createStyle div" )
	.draggable({
	    containment : 'parent' // 부모요소 안에 종속   
	})
	.css( 'cursor', 'move' )
	.mousedown(function(){ // mousedown 이벤트 생성
	    $(this).css('z-index', css_test_idx); // 클릭한 이미지만 z-index 증가시킴
	    css_test_idx++;
	    // 그러면 이미지가 겹칠경우 클릭한 것이 항상 위에 표시됨
	});

	
	//이미지 복사
	//원본 이미지 클릭시
	$("#product").on("click", "[id^='Clone']", function() {
		
		var b = "";
		b = b + $(this).attr("data-value") + ",";
		console.log("b : "+b);
		
		cnt += 1; 
		var a = $(this).clone()
		.draggable({containment : 'parent'})
		.css( 'cursor', 'move' )
		.mousedown(function(){ // mousedown 이벤트 생성
	    $(this).css('z-index', css_test_idx); // 클릭한 이미지만 z-index 증가시킴
	    css_test_idx++;
	    // 그러면 이미지가 겹칠경우 클릭한 것이 항상 위에 표시됨
		});
		a.attr("id","dumy"+cnt) //id에 숫자부여 
		.appendTo("#createStyle"); //createStyle에 추가
		a.find('button').eq(0).removeAttr("disabled"); //속성에 disabled 삭제
		a.find('img').attr("style", "visibility : visible"); //버튼 보이기
		a.find('input[type="checkbox"]').attr("checked", true);  
		
		return cnt;
	});
});




function SAVE() {   
	console.log("ajax?")
var s_name = $("#s_name").val();
var s_content = $("#s_content").val();
var st_no = $("#st_no").val();
console.log("st_no : "+ st_no);
var checked = "";
//선택된 라디오박스 val 담는 변수

$( "input[name='check']:checked" ).each (function (){
   checked = checked + $(this).attr("data-value")+"," ;
   //var checked에 라디오박스 val 담기
});

checked = checked.substring(0,checked.lastIndexOf( ","))
   //맨뒤의 ,(컴마) 지우기
console.log(checked)

var background = document.getElementById('createStyle').style.background;
if(background == "") {
    document.getElementById('createStyle').style.background = "#fff"; 
}

html2canvas(document.getElementById('createStyle'), {
    useCORS: true, // 다른사이트의리소스가있을때활성화(그러나...Access-Control-Allow-Origin 필요)
    onrendered: function(canvas) {
        canvas.toBlob(function(blob) {
        	console.log(s_name);
        	console.log(blob);
        	
        	var fd = new FormData();
        	fd.append('data', blob);
        	
        	$.ajax({
        	    type: 'POST'
    			, url: "/styling/canvas/ajax?s_name="+s_name+"&s_content="+s_content+"&st_no="+st_no+"&checked="+checked
        	    , data: fd
        	    , processData: false
        	    , contentType: false
        	    , dataType: "json"
				, success: function( res ){
					alert("저장되었습니다.");
					location.href = "/mypage/mystylinglist?m_no="+${m_no };
				}
        		, error: function( e ) {
        			console.log(e)
        			alert("실패되었습니다.");
        		}
        	});
        });
    }
});
}
</script>
<style type="text/css">
#createStyle {
	display : inline-block;
	min-height : 500px;
	margin : 5px;
	width : 90%;
	border-radius : 3px;
}	

[id^=Clone] {
	width : 130px;
	height : 130px;
}

[id^=dumy] {
	cursor : move;
	width : 130px;
	height : 130px;
}

</style>

<div class="contain" style="padding-bottom: 120px; padding-left: 100px; padding-right: 120px;">
<h3 align="center">스타일링 만들기</h3>  
<hr>

<div>    
	<div id="stylingContainer" style="display: flex; padding-bottom: 20px;">
		<div style="border: 1px solid #ffffff; flex: 7;" >
			<input type="text" id="s_name" name="s_name" placeholder="Title" style="width: 90%;"/>
			<input type="text" id="s_content" name="s_content" placeholder="Description" style="width: 90%;"/>
			<select id="st_no" name="st_no"> 
				<c:forEach items="${stList }" var="s">	
					<option value="${s.st_no }">${s.st_name }</option>
				</c:forEach>
			</select>
			<div id="createStyle"></div> <br>
			<button id="Reset" onclick="Reset()">초기화</button> 
		</div>
		
		<div style="border: 1px solid #ffffff; flex: 4;">
			<div id="productTop" style="display: flex;">
				<input type="text" style="width: 100%; flex: 8" name="search" id="search" placeholder="Search">
				<button id="word" name="word" class="btn btn-success btn-sm" onchange="filter();" style="flex: 1">검색</button>
			</div>
			<div id="productList">
				<div style="text-align: center"> 
					제품 선택하기 : 
					<select id="pca_category" name="pca_category" onchange="filter();">
						<option value="">제품선택 </option>
						<c:forEach items="${list }" var="i">
								<option id="ajax" value="${i.pca_no }">${i.pca_category }</option>
						</c:forEach>
					</select>   
				</div>
				<hr>
				<div id="tb">
					<div id="product">
					</div>
				</div>
				<div id="paging" style="visibility: hidden;">
					<jsp:include page="./paging.jsp" />
				</div>
			</div>
		</div>  
	</div>
			  
	
	<br>
	<br>
	<div class="col-sm-3 col-sm-offset-1"></div>
	<div class="col-sm-2">
		<button type="button" id="btnSave" class="btn btn-primary btn-lg btn-block" onclick="SAVE()">저장</button>
	</div>   
	<div class="col-sm-2">
		<button type="button" id="btnCancel" class="btn btn-lg btn-block">뒤로 가기</button>
	</div>
</div>


</div>