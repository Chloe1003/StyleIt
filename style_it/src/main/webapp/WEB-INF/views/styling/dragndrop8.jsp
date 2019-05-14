<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery 2.2.4 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
<!-- UI형식으로 드래그 앤 드롭 -->
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
//이미지 복사

var cnt = 0;

$(document).ready(function(){
	//원본 이미지 클릭시
	$("[id^='Clone']").click(function() {
		
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
		.appendTo("#divClone"); //divClone에 추가
		a.find('button').eq(0).removeAttr("disabled"); //속성에 disabled 삭제
		a.find('img').attr("style", "visibility : visible"); //버튼 보이기
		
		return cnt
	});
});

function btnMinus(){
	$("[id='btnMinus']").click(function(){
		$(this).parent().parent().parent().remove();
	});  
}

function Reset(){
	$("#divClone").children().remove();   
}
</script>

<script type="text/javascript">
//드래그 앤 드롭

var css_test_idx = 10;

// 보기편하게 여러줄로 코딩
$( function() {
	$( "#divClone div" )
	.draggable({
	    containment : 'parent' // 부모요소 안에 종속   
	})
	.css( 'cursor', 'move' )
	.mousedown(function(){ // mousedown 이벤트 생성
	    $(this).css('z-index', css_test_idx); // 클릭한 이미지만 z-index 증가시킴
	    css_test_idx++;
	    // 그러면 이미지가 겹칠경우 클릭한 것이 항상 위에 표시됨
	});
});

</script>

<style type="text/css">
[id^=Clone] {
	width : 130px;
	height : 130px;
}

[id^=dumy] {
	cursor : move;
	width : 130px;
	height : 130px;
}

#divClone {
	border : 5px solid gray;
	display : inline-block;
	height : 500px;
	margin : 5px;
	width : 800px;
	border-radius : 3px;
}

#img {
	width : 120px; 
	height: 120px;
	z-index: 0;
}	
</style>

</head>
<body>
<button id="Reset" onclick="Reset()">초기화</button>
<div id="divClone"></div>    
 
<div id="divOriginal">
	<div id="Clone"  
		style="background-size : contain; background-image: url(/resources/img/abc01.jpg)">
		<div style="position: absolute;">
			<div style="position: relative; top: 10px; left: 15px;">
				<button id="btnMinus" name="btnMinus" disabled 
				style='background-color:transparent; border: 0px; outline: 0px;' onclick='btnMinus()'>
				<img style="visibility : hidden" ondragstart="return false" src='/resources/img/minus.png' /></button>
			</div>
		</div>
	</div>   
	
	<div id="Clone1"  
		style="background-size : contain; background-image: url(/resources/img/abc02.jpg)">
		<div style="position: absolute;">
			<div style="position: relative; top: 10px; left: 15px;">
				<button id="btnMinus" name="btnMinus" disabled 
				style='background-color:transparent; border: 0px; outline: 0px;' onclick='btnMinus()'>
				<img style="visibility : hidden" ondragstart="return false" src='/resources/img/minus.png' /></button>
			</div>
		</div>
	</div> 
	
</div>

	
</body>
</html>