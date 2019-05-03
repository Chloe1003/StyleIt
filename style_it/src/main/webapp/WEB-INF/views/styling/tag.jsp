<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
#block{
width:200px; 
height:200px; 
position:relative; 
display:inline-block;
margin: 30px;
cursor: pointer;
}

#tagname {
position:absolute;
left: 20px;
top: 135px;
font-size: 1em;
color: whitesmoke;
font-weight: 500;
padding: 4px 60px;
background: #E89994;
/* border-radius: 10px; */
}

#img{
position:absolute;
left: 0;
top: 0;
}

</style>

<div style="text-align:center;">
<c:forEach items="${stylingTag }" var="t" begin="0" end="${stylingTag.size()-1 }">
<div id="block" onclick="stylingList(${t.st_no})">
<img src="/upload/${t.fu_storedname }" alt="images" width="200" height="200" id="img">
<span id="tagname"> ${t.st_name }</span>
</div>
</c:forEach>
</div>

<script type="text/javascript"> 
function stylingList(st_no){
	location.href="/styling/list?st_no="+st_no;
}
</script>