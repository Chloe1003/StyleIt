<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.navlist{
	margin-left: 20px;
	margin-right: 20px;
}
</style>
    
    <!-- MYNAV start -->    
<nav class="navbar nav">
      <div class="container">
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav navbar-center">
              <li class="navlist"><a href="/mypage/mypage?m_no=${m_no }" style="color:#777;">MY</a></li>
              <li class="navlist"><a href="/mypage/stylinglist" style="color:#777;">STYLING</a></li>
              <li class="navlist"><a href="/mypage/Productlikelist?m_no=${m_no }" style="color:#777;">LIKE</a></li>
              <li class="navlist"><a href="/mypage/recommend?m_no=${m_no }" style="color:#777;">FOR YOU</a></li>	 
           </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <!-- MYNAV end -->    
    