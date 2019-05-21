<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<table class="table table-striped">
						<colgroup>
							<col width="15%">
							<col width="75%">
							<col width="10%">
						</colgroup>
						<tbody>
							<c:if test="${cList.size()>0 }">
							<c:forEach items="${cList }" var="c" begin="0" end="${cList.size()-1 }">
							<tr>
								<td id="replyElements"><h6 style="margin:3px 0;">${c.m_nick }</h6></td>
								<td id="replyElements"><h6 style="margin:3px 0;">${c.co_content } <span style="font-size: 0.9em;color: #828282;"><fmt:formatDate value="${c.co_date }" pattern="yy.MM.dd/HH:mm"/></span></h6></td>
								<td id="replyElements"><c:if test="${c.m_no eq m_no }"><h6 onClick="replydelete(${c.co_no})" style="cursor: pointer;margin: 3px 0;">삭제</h6></c:if></td>
							</tr>
							</c:forEach>
<!-- 							<tr style="text-align: center;"><td colspan="6" class="noreply"></td></tr> -->
							</c:if>
							<c:if test="${cList.size() eq 0 }">
								<tr style="text-align: center;"><td colspan="6" class="noreply">아직 댓글이 없습니다</td></tr>
							</c:if>
						</tbody>
					</table>    
<!-- <table style="width: 100%;"> -->
<!-- 						<tr> -->
<!-- 							<td style="width: 90%;"><textarea id="content" class="content" name="content" style="width:100%"></textarea></td> -->
<!-- 							<td style="width: 10%;"><button id="commentsubmit" class="btn btn-default btn-sm" style="margin-left: 20%;">댓글등록</button></td> -->
<!-- 						</tr> -->
<!-- 					</table> -->
					
					
<script type="text/javascript"> 

function replydelete(co_no){
	var s_no = ${styling.s_no };
	
	$.ajax({
		type : "get",
		url : "/styling/deletecomment",
		data : {"s_no" : s_no,
				"co_no" : co_no
				},
		dataType : "html",
		success : function(res){
			console.log("댓글삭제 성공");
			
			$(".modal_body").html(res);
			
		}, 
		error : function(e){
			console.log("실패");
		}
	});
}

$(document).ready(function(){
// 	$("#commentsubmit").click(function(){
// 		var co_content = $("#content").val();
// 		var s_no = ${styling.s_no };
// 		console.log("co_content: "+co_content);
// 		console.log("s_no: "+s_no);
		
// 		$.ajax({
// 			type : "post",
// 			url : "/styling/addcomment",
// 			data : {"s_no" : s_no,
// 					"co_content": co_content
// 					},
// 			dataType : "html",
// 			success : function(res){
// 				console.log("댓글추가 성공");
				
// 				$(".modal_body").html(res);
				
// 			}, 
// 			error : function(e){
// 				console.log("실패");
// 			}
// 		});
// 	});
});
</script>