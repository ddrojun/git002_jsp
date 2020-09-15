<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang ="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" 
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>     
<style>
.myhidden{ width: 1px; height: 1px; overflow:hidden; position:absolute; left: -9999%; font-size: 0; line-height: 0;  }  
.lnb{ font-size: 10px	}
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
.mybg{ background: url(<%=request.getContextPath()%>/images/bg_header.gif) 0 -30px;	}
#header .navbar-default .navbar-nav a{
	color: black;
	font-size: 18px;
	font-weight: bold;
}
</style>

</head>
<body>
<div id="header">
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<ul class="nav navbar-nav lnb l1">
					<li><a href="">facebook</a></li>
					<li><a href="">instagram</a></li>
					<li><a href="">naver</a></li>
				</ul>			
			</div>
			<div >
			<div class="col-sm-6">
				<ul class="nav navbar-nav lnb l2">
					<li><a href="">로그인</a></li>
					<li><a href="">회원가입</a></li>
					<li><a href="">MY CGV</a></li>
					<li><a href="">VIP LOUNGE</a></li>
					<li><a href="">CLUB 서비스</a></li>
					<li><a href="">고객 센터</a></li>
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
      		<a class="navbar-brand" href="#"><img src="<%=request.getContextPath()%>/images/h1_cgv.png" alt="CGV LOGO"/></a>
    	</div>
    	<div class="col-sm-6 text-center">
    		<p ><img src="<%=request.getContextPath()%>/images/h2_cultureplex.png" alt="CGV LOGO"/></p>
      		<ul class="nav navbar-nav">
      			<li class="active"><a href="#">영화</a></li>
      			<li><a href="#">예매</a></li>
      			<li><a href="#">극장</a></li>
      			<li><a href="#">이벤트&amp;컬쳐</a></li>
      		</ul>
    	</div>
    		<div class="nav navbar-nav col-sm-3">
    		<p><a href="#"><img src="<%=request.getContextPath()%>/images/15728438201650.png" alt="현대오일뱅크 보너스카드 혜택바로가기"/></a></p>
    			<form action="" method="get">
    				<fieldset>
    				<legend class="myhidden">search</legend>
    				<input type="search" name="search" id="search" title="검색어입력창" /><input type="submit" value="검색">
    				</fieldset>
    			</form>
    		</div>
  		</div>
		</nav>	
		</div>
		
	</div> <!-- end container -->
</div>	
		<!--  			-->
		<!--  			-->
		<!--  			-->
<div class="container panel panel-info">
	<h3 class="panel-heading">NAVBAR</h3>
	<pre>
	1. h1			: 로고, 상호명
	2. h2			: GNB
	3. h3~h6		: 상세내용(중요도: h3 > h4> h5 > h6) 
	
	</pre>
</div>		
</body>
</html>