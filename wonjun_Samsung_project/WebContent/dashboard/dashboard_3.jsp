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
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>   
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
</style>

</head>
<body>
<div id="header">
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<ul class="nav navbar-nav lnb l1">
					<li><a href="https://www.facebook.com/">facebook</a></li>
					<li><a href="https://www.instagram.com/">instagram</a></li>
					<li><a href="https://www.naver.com/">naver</a></li>
				</ul>			
			</div>
			<div >
			<div class="col-sm-6">
				<ul class="nav navbar-nav lnb l2">
 	     <%
      	if(session.getAttribute("cid") !=null){ %>
    	  <li><a href="<%=request.getContextPath()%>/mypage_view.customer"><%=session.getAttribute("cid")%>님</a></li>
    	  <li><a href="<%=request.getContextPath()%>/logout.customer">LOGOUT</a></li>
      	<%}%>					
					<li><a href="<%=request.getContextPath()%>/login_view.customer">회원로그인</a></li>
					<li><a href="<%=request.getContextPath()%>/join_agree.customer">회원가입</a></li>
					<li><a href="#">MY CARD</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">카드 추천/비교
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<%=request.getContextPath()%>/list.condition">조건별 검색</a></li>
            <li><a href="<%=request.getContextPath()%>/card_info_board/first_view.jsp">키워드 검색</a></li>
          </ul>
        </li>					
					<li><a href="<%=request.getContextPath()%>/list.do">자유게시판</a></li>
					<li><a href="<%=request.getContextPath()%>/list.replydo">고객센터</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">카드 MORE
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="<%=request.getContextPath()%>/InvestmentServlet_1">투자정보</a></li>
            <li><a href="<%=request.getContextPath()%>/card_info_board/first_view.jsp">카드정보</a></li>
          </ul>
        </li>
        <li><a href="#"><span class="glyphicon glyphicon-search"></span></a></li>	
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
	<br/>
	<br/>			
	<!--  LAYOUT		-->
	<!--  		-->
	<!--  		-->
	<hr style="font-weight:bolder">
	<!--  -->
		<%
		    String mid = (String)session.getAttribute("cid");
			String remember = "";
			String id = "";
			String welcome="";
			//1. 쿠키존재하는지확인
		    String cookie = request.getHeader("Cookie");
			//2. 쿠키값가져오기
			if(  cookie != null){
				Cookie  []cookies = request.getCookies();  
				for(int i=0;  i<cookies.length;  i++){   
					if(cookies[i].getName().equals("remember")){  
						remember = cookies[i].getValue();  
					}
					if(cookies[i].getName().equals("cid")){  
						id = cookies[i].getValue();  
					}		
					if(cookies[i].getName().equals("welcome")){  
						welcome = cookies[i].getValue();  
					}
				}
			}
		%>
		<%
		session.setAttribute("mid", mid);
		%>				
	<!--  -->
	<div class="container">
		<div class="row r1">
		<div class="col-sm-9">
		사진이랑 슬라이드 넣으세요
		</div>
		<div class="col-sm-3">
		
		<button>1</button> <button>2</button> <button>3</button> <button>4</button><br/>
		<form action="<%=request.getContextPath()%>/logout.customer" method="post">
			<div class="form-group" style="margin-top:4%">
				<input type="text"  class="form-control" id="cid" name="cid"  
				<% if(remember.equals("remember")){ %> value="<%=id%> 님 반갑습니다!"  <% } %>  readonly />		
		 		<input type="text" class="form-control"  value="<%=welcome %>" readonly/>		     
	 	<!--		<input type="text" class="form-control"  id="cpass"
				<% if(remember.equals("remember")){ %> value="<%=welcome%> 반갑습니다!"  <% } %>   />	   -->
				
			</div>
			<div class="form-group">
				<input type="submit" class="btn-btn-default form-control" value="로그아웃" style="color:white; background:orange;"/>
			</div>
			
		<div class="form-group">
		<input type="checkbox" id="remember" name="remember" 
		<% if(remember.equals("remember")){ %> checked <% } %> />
		<label for="remember" >아이디 저장하기</label>
		</div>
		</form>
		<div class="form-group">
		<a href="<%=request.getContextPath()%>/find.customer" id="find">아이디/비밀번호 찾기</a><span><a href="<%=request.getContextPath()%>/join_agree.customer" id="create">회원가입</a></span>
		
		</div>
		
		</div>
		</div><!-- row r1 end -->
	<div class="row r2" style="margin-top:5%">
		<button class="col-sm-2">카드</button>
		<button class="col-sm-2">헤택</button>
		<button class="col-sm-2">금융</button>
		<button class="col-sm-2">쇼핑</button>
		<button class="col-sm-2">포인트</button>
		<button class="col-sm-2">모바일</button>
	</div>
	<div class="row r3" style="margin-top:5%">
		<div class="col-sm-8">
		<input type="radio" class="card"/><label>추천카드</label>
		<input type="radio" id="card"/><label>숫자카드</label>
		<input type="radio" id="card" /><label>프리미엄카드</label>
		<input type="radio" id="card"/><label>법인카드</label>
		</div>
		<div class="row col-sm-4">
		
		<button class="col-sm-6" id="card_find">내게 맞는 카드 찾기</button><button class="col-sm-6" id="reco">친구에게 카드추천</button>
		</div>
		
		

		</div>
			<div class="row r4" style="margin-top:5%">
			<p class="col-sm-1"> &gt;-</p>
		<button class="col-sm-2">삼성카드</button>
		<button class="col-sm-2">324234</button>
		<button class="col-sm-2">23423</button>
		<button class="col-sm-2">23423</button>
		<button class="col-sm-2">234243</button>
				<p class="col-sm-1"> &gt;-</p>
		
	</div>
	
	
	
	</div><!-- end  -->				
		
	
			
</body>
</html>