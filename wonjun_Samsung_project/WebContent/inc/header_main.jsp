<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang ="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
   <link rel="stylesheet"  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> 
   
<!--  -->
 <link rel="stylesheet" 
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">    
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
<style>
.myhidden{ width: 1px; height: 1px; overflow:hidden; position:absolute; left: -9999%; font-size: 0; line-height: 0;  }  
.lnb{ font-size: 13px	} <!--  원래는 10   -->
#header .navbar-nav.lnb>li>a{ padding-top: 2px; padding-bottom: 2px; padding-left: 7px; padding-right: 7px; }
#header form #search{ width:141px; height:24px; border: 1px solid #b5b5b5; }
#header p {margin-top: 20px;}
#header input[type ="submit"] {
	border :0 none;
	background-color: crimson;
	color: white;
	padding : 2px;		
}
#header nav.navbar.navbar-default {
    background-color: transparent;
    border: 0 none;
}
#header .navbar-default .navbar-nav>.active>a{
	background-color: transparent;
}
#header .container-fluid {
    background-color: transparent;
    border: 0 none;
}

#header .navbar-default .navbar-nav a{
	color: black;
	font-size: 18px;
	font-weight: bold;
}
a#create {
    margin-left: 27%;
    color: black;
}
a#find {
    color: black;
}

/*
ajax_wj
*/

.btn-default.wj_active{   color:white; background-color: black;}

.btn-default.wj_active1{   color:black; background-color: black; }
</style>

</head>
<body>
<div id="header">
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<ul class="nav navbar-nav lnb l1">
					<li><a href="<%=request.getContextPath()%>/api/map.jsp">찾아오시는길</a></li>
					<li><a href="<%=request.getContextPath()%>/api/post.jsp">우편번호 검색</a></li>
			<!-- 		<li><a href="https://www.naver.com/">NAVER</a></li>		 -->
					<li><a href="<%=request.getContextPath()%>/youtube/youtube.jsp">Youtube</a></li>
				</ul>			
			</div>
			<div >
			<div class="col-sm-8">
				<ul class="nav navbar-nav lnb l2">
 	     <%
      	if(session.getAttribute("cid") !=null){ %>
    	  <li><a href="<%=request.getContextPath()%>/mypage_view.customer"><%=session.getAttribute("cid")%>님</a></li>
    	  <li><a href="<%=request.getContextPath()%>/logout.customer">LOGOUT</a></li>
     	 <li><a href="<%=request.getContextPath()%>/mycard_view.keyword">MY CARD</a></li>	 
    <!--	  <li><a href="<%=request.getContextPath()%>/card_info_board/mycard.jsp">MY CARD</a></li>	-->
      	<%}%>	
      	<% 
      	if(session.getAttribute("aid") !=null){ %>
    	  <li><a href="<%=request.getContextPath()%>/mypage_view.customer"><%=session.getAttribute("aid")%>님</a></li>
    	  <li><a href="<%=request.getContextPath()%>/logout.customer">LOGOUT</a></li>
      	<%}%>	      					
					<li><a href="<%=request.getContextPath()%>/login_view.customer">로그인</a></li>
					<li><a href="<%=request.getContextPath()%>/join_agree.customer">회원가입</a></li>
			<!-- 		<li><a href="<%=request.getContextPath()%>/card_info_board/mycard.jsp">MY CARD</a></li>	 	-->
		<!-- dropdown 카드추천 비교  -->	
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown">카드 추천/비교
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<%=request.getContextPath()%>/list.condition">조건별 검색</a></li>
            <li><a href="<%=request.getContextPath()%>/list.keyword">키워드 검색</a></li>
          </ul>
        </li>					
				<li><a href="<%=request.getContextPath()%>/list.do">자유게시판</a></li>
				<li><a href="<%=request.getContextPath()%>/list.replydo">고객센터</a></li>
				<li><a href="<%=request.getContextPath()%>/api/mail.jsp">메일문의</a></li>
				
		<!-- dropdown 카드 More -->		
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="<%=request.getContextPath()%>/board.cardinfo">카드 MORE
           <span class="caret"></span></a>		 
          <ul class="dropdown-menu">
            <li><a href="<%=request.getContextPath()%>/InvestmentServlet_1">투자정보</a></li>
            <li><a href="<%=request.getContextPath()%>/board.cardinfo">카드정보</a></li>
      <!--       <li><a href="<%=request.getContextPath()%>/card_info_board/first_view.jsp">카드정보</a></li>		 -->
          </ul>
        </li>				
				</ul>
			</div>			
			</div>
		</div>	
	</div> <!-- end container -->
	<!--  -->
	<div class="mybg">
	<div class="container">
		<h1 class="myhidden">LOGO</h1> <!-- #추가1 -->
		<nav class="navbar navbar-default">
			<h2 class="myhidden">주메뉴</h2>
  		<div class="container-fluid">
    		<div class="navbar-header col-sm-3">
   <a class="navbar-brand" href="<%=request.getContextPath()%>/start.customer"><img src="<%=request.getContextPath()%>/images/card1.png" alt="CARD LOGO"/></a>
    	</div>
    		<div class="col-sm-6 text-center">
    	<!--  	<p ><img src="<%=request.getContextPath()%>/images/h2_cultureplex.png" alt="CGV LOGO"/></p>  -->
    	<h2 style="text-align: center"><a href="<%=request.getContextPath()%>/start.customer">WONJUN_CARD</a></h2>
 <!--     		<ul class="nav navbar-nav">
      			<li class="active"><a href="#">영화</a></li>
      			<li><a href="#">예매</a></li>
      			<li><a href="#">극장</a></li>
      			<li><a href="#">이벤트&amp;컬쳐</a></li>
      		</ul>    -->  
    		</div>
  		</div>
		</nav>	
		</div>
		
	</div> <!-- end container -->
</div>	
		<!--  			-->
		<!--  			-->
		<!--  			-->	
</body>
</html>