<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Theme Made By www.w3schools.com - No Copyright -->
  <title>Bootstrap Theme The Band</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <!--  -->
<!-- <link rel="stylesheet" href="../css/mycss.css"> -->
   <link rel="stylesheet" href="<%=request.getContextPath()%>/css/mycss_main.css">
  <!--  -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
  	<a class="navbar-brand" href="<%=request.getContextPath()%>/layout/mainpage.jsp">WONJUN_CARD</a>	
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
 <!--      <li><a href="#myPage">HOME</a></li>		-->   
 		<!--  -->
 	     <%
      	if(session.getAttribute("cid") !=null){ %>
    	  <li><a href="<%=request.getContextPath()%>/mypage_view.customer"><%=session.getAttribute("cid")%>님</a></li>
    	  <li><a href="<%=request.getContextPath()%>/logout.customer">LOGOUT</a></li>
      	<%}%>	
 		
 		<!--  -->
 <!--  <li><a href="<%=request.getContextPath()%>/BList">BOARD3</a></li> -->
 		<li><a href="<%=request.getContextPath()%>/login_view.customer">로그인</a></li>
 		<li><a href="<%=request.getContextPath()%>/join_agree.customer">회원가입</a></li>
 		<li><a href="<%=request.getContextPath()%>/card_info_board/first_view.jsp">투자정보</a></li>
 		
 		<li><a href="<%=request.getContextPath()%>/list.do">자유게시판</a></li>
<!--  		<li><a href="<%=request.getContextPath()%>/BList">게시판</a></li>    -->
        <li><a href="<%=request.getContextPath()%>/layout/mainpage.jsp">HOME</a></li>
        <li><a href="#tour">MYPAGE</a></li>
 <!--        <li><a href="#contact">LOGOUT</a></li>   -->
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">MORE
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Merchandise</a></li>
            <li><a href="#">Extras</a></li>
            <li><a href="#">Media</a></li> 
          </ul>
        </li>
        <li><a href="#"><span class="glyphicon glyphicon-search"></span></a></li>
      </ul>
    </div>
  </div>
</nav>
