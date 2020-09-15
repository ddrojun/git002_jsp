<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang ="ko">
<head>
<meta charset="UTF-8">
<title>portfolio_김원준</title>
<!-- Latest compiled and minified CSS -->
<meta name ="viewport" content= "width=device-width, initial-scale =1" >
<link href="images/iconfinder_SDKs_copy_Java_259269.png" rel="shortcut icon" type="images/x-icon"  >
<!--  -->
 <link rel="stylesheet" 
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">    
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
<style> 
.myhidden{ width: 1px; height: 1px; overflow:hidden; position:absolute; left: -9999%; font-size: 0; line-height: 0;  }  
.lnb{ font-size: 12px	} <!--  원래는 10   -->
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
id header
*/
#header .nav>li>a:focus, #header .nav>li>a:hover {
    text-decoration: none;
    background-color: transparent;
    color:#ff6e61;
}



/*
ajax_wj
*/

.btn-default.wj_active{   color:white; background-color: black;}

.btn-default.wj_active1{   color:black; background-color: black; }

/*
header
*/
.mybg_header.mh1 {
    background-color: #333;
    font-size: 18px;
    color: #ff6e61;
    padding: 6px;
}
.mybg_1 {
    height: 100px;
    background-color: #1b2838;
}

.mybg_1 .container .navbar-nav>li>a {
    padding: 12px;	//12: ;
    font-size: 18px;
    font-weight: bold;
    color: white;
}
.mybg_1 ul.nav.navbar-nav.lnb.l2 {
    padding-top: 18px;
}

</style>

</head>
<body>
<div id="header">
<div class="mybg_header mh1">
	<div class="container">
		<div class="row text-center">
			카드의 정석 ALEX카드<%-- <a href="<%=request.getContextPath()%>/youtube/youtube.jsp">포트폴리오_동영상_클릭</a>	--%>	
		</div>	
 	
		
	</div> <!-- end container -->
</div>	
	<!--  -->
	<div class="mybg_1">
		<div class="container">
		<div class="row">
			<div class="col-sm-4">  <!-- logo_10th.gif   로고2.png-->
				 <a href="<%=request.getContextPath()%>/start.customer"><img src="<%=request.getContextPath()%>/images/logo_10th.gif" alt="CARD LOGO"/></a>			 
		<%--	<a href="<%=request.getContextPath()%>/start.customer"><img src="<%=request.getContextPath()%>/images/logo_1.png" alt="CARD LOGO"/></a>	--%>
			</div>
			<div >
			<div class="col-sm-8">
				<ul class="nav navbar-nav lnb l2">
	      					
			<!-- 		<li><a href="<%=request.getContextPath()%>/card_info_board/mycard.jsp">MY CARD</a></li>	 	-->
           <li><a href="<%=request.getContextPath()%>/list.condition">조건별 검색</a></li>
           <li><a href="<%=request.getContextPath()%>/list.keyword">키워드 검색</a></li>	
           		
		<!-- dropdown 카드추천 비교  -->	
<%-- 		<!-- 
	<li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown">로그인
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
					<li><a href="<%=request.getContextPath()%>/login_view.customer">로그인</a></li>
					<li><a href="<%=request.getContextPath()%>/join_agree.customer">회원가입</a></li>
          </ul>
    </li>
		 --> --%>



         <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown">고객센터 
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
				<li><a href="<%=request.getContextPath()%>/list.do">자유게시판</a></li>
				<li><a href="<%=request.getContextPath()%>/list.replydo">고객센터</a></li>
				<li><a href="<%=request.getContextPath()%>/api/mail.jsp">메일문의</a></li>
          </ul>
        </li>	       
				
			 
		<!-- dropdown 카드 More -->		
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="<%=request.getContextPath()%>/board.cardinfo">카드 MORE
           <span class="caret"></span></a>		 
          <ul class="dropdown-menu">
            <li><a href="<%=request.getContextPath()%>/board.cardinfo">카드정보</a></li>
      <!--       <li><a href="<%=request.getContextPath()%>/card_info_board/first_view.jsp">카드정보</a></li>		 -->
          </ul>
        </li>	
         <li><a href="<%=request.getContextPath()%>/youtube/youtube.jsp">자바 MINI PROJECT</a></li>
 	     <%
      	if(session.getAttribute("cid") !=null){ %>
    	  <li><a href="<%=request.getContextPath()%>/mypage_view.customer"><%=session.getAttribute("cid")%>님 / 카드정보</a></li>
    	  <li><a href="<%=request.getContextPath()%>/logout.customer">LOGOUT</a></li>
<%--      <!--  	 <li><a href="<%=request.getContextPath()%>/mycard_view.keyword">MY CARD</a></li>	 -->
    <!--	  <li><a href="<%=request.getContextPath()%>/card_info_board/mycard.jsp">MY CARD</a></li>	--> --%>
      	<%}%>	
      	<% 
      	if(session.getAttribute("aid") !=null){ %>
    	  <li><a href="<%=request.getContextPath()%>/list.admin"><%=session.getAttribute("aid")%>님 / 회원찾기</a></li>
    	  <li><a href="<%=request.getContextPath()%>/logout.customer">LOGOUT</a></li>
      	<%}%>       
        			
				</ul>
			</div>			
			</div>
		</div>	
	</div> <!-- end container -->
	
	</div>
</div>	
		<!--  			-->
		<!--  			-->
		<!--  			-->	
<!-- </body>
</html> -->