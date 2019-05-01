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
}

#tagname {
position:absolute;
left: 30px;
top: 135px;
font-size: 1.5em;
color: whitesmoke;
font-weight: 550;
padding: 2px 50px;
background: #009994;
border-radius: 10px;
}

#img{
position:absolute;
left: 0;
top: 0;
}

</style>

<div style="text-align:center;">
<c:forEach items="${stylingTag }" var="t" begin="0" end="${stylingTag.size()-1 }">
<div id="block">
<img src="/upload/${t.fu_storedname }" alt="images" width="200" height="200" id="img">
<a href="/styling/list?st_no=${t.st_no }"><span id="tagname"> ${t.st_name }</span></a>
</div>
</c:forEach>
</div>