<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/FileSaver.js/1.3.8/FileSaver.min.js"></script>
<title>이미지캡처</title>
</head>
<body>
	<input type="text" id="title" name="title" />
    <div id="example" style="width: 500px;">
        안녕하세요 이미지 캡쳐 예제입니다.<br />
        안녕하세요 이미지 캡쳐 예제입니다.<br />
        안녕하세요 이미지 캡쳐 예제입니다.<br />
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ4nsgRjLZntKqK6j0kKjHsYJtQQGsLo27TeDJhy3p85qp9m9WB">
        <!-- 구글 상업정 수정 이미지 검색 활용 -->
        <!-- 외부 링크는 Access-Control-Allow-Origin 가 해당 서버에서 허용이 되지 않으면 캡쳐 대상제외 -->
    </div>
    <script type="text/javascript">
    function sample() {
        var title = $("#title").val();
        var background = document.getElementById('example').style.background;
        if(background == "") {
            document.getElementById('example').style.background = "#fff"; 
        }
            
        html2canvas(document.getElementById('example'), {
            useCORS: true, // 다른사이트의리소스가있을때활성화(그러나...Access-Control-Allow-Origin 필요)
            onrendered: function(canvas) {
                canvas.toBlob(function(blob) {
                	console.log(title);
                	console.log(blob);
                	
                	var fd = new FormData();
                	fd.append('data', blob)
                	;
                	$.ajax({
                	    type: 'POST'
            			, url: "/styling/canvas/ajax?title="+title
                	    , data: fd
                	    , processData: false
                	    , contentType: false
                	    , dataType: "json"
						, success: function( res ){
							console.log("성공");
						}
                		, error: function( e ) {
                			console.log("실패");
                		}
                	});
                	
                });
                
            }
        });
    }
    </script>
    <div id="test">test</div>
    <button onclick='sample();'>캡처</button>
</body>
</html>