<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang ="ko">
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" 
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>    
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>   
 
 <%@ include file="../inc/header_1.jsp" %>
 
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

.btn-default.wj_active{   color:white; background-color: black;}
/* .main_index .col-sm-3 {
    position: fixed;
    top: 5%;
    right: 5%;
} */
/* 직접검색 */
.direct_search_card {
    background-color: aliceblue;
    padding: 5% 0;
}

div#myCarousel {
    height: 345px;
    overflow: hidden;
}

.direct_search_card {
    background-color: #333;
    background-image : url(./images/loca_classic.png);
    padding: 3% 0;
    margin: 2% 0;
    background-blend-mode: darken;
}
input#search {
    font-size: 16px;
}

h3.cardrank {
    background: #ff6e61;  //#123456
    color: white;
    line-height: 4em;
    text-indent: 10px;
}
h3.cardrank.rank1 {
    background-color: #1b2838;
    color: white;
    line-height: 3em;
}
h3.cardrank.rank3 {
    background-color: #1b2838;
    color: white;
    line-height: 3em;
}
h3.cardrank.rank2 {
    background-color: white;
    color: #123456;
    line-height: 3em;
}
.cardrank_wrap {
    box-shadow: 0 0 12px rgba(0,0,0,0.2);
}

</style> 
</head>
<body>
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
			 String mpass =(String)session.getAttribute("cpass");
			 String mid = (String)session.getAttribute("cid");
			 String mwelcome=(String)session.getAttribute("welcome");
			 String aid = (String)session.getAttribute("aid");
			//
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
		session.setAttribute("mpass", mpass);
		//
		session.setAttribute("aid", aid);
		%>				
	<!--  -->
	<div class="container">
		<div class="row r1">
		<div class="col-sm-9">
<!-- 		사진이랑 슬라이드 넣으세요   -->
<!-- 	<p><img src="<%=request.getContextPath()%>/images/card4.png" alt="메인카드화면"/></p>     -->	
<!-- 슬라이드 -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="<%=request.getContextPath()%>/images/광고1.JPG" alt="image_1">
        <div class="carousel-caption">
     <!--       <h3>WonJun_CARD</h3>	-->
     <!--      <p>Money Money.</p>     -->
        </div>      
      </div>
      <div class="item">
        <img src="<%=request.getContextPath()%>/images/광고2.JPG" alt="image_2">
        <div class="carousel-caption">
        </div>      
      </div>
      <div class="item">
        <img src="<%=request.getContextPath()%>/images/광고3.JPG" alt="image_3">
        <div class="carousel-caption">
        </div>      
      </div>
 <!--       <div class="item">
        <img src="<%=request.getContextPath()%>/images/광고3.JPG" alt="image_4">
        <div class="carousel-caption">
        </div>      
      </div>           -->   
    </div> <!-- end -->

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>		<!-- 이미지 슬라이드  -->

		</div>
		<div class="col-sm-3">
<!-- 		<button onclick="location.href='<%=request.getContextPath()%>/find.customer'">아이디/비밀번호 찾기</button><button onclick="location.href='<%=request.getContextPath()%>/join_agree.customer'"> 회원가입</button><br/>	  -->	
		<c:choose>
		<c:when test="${not empty sessionScope.cid}" >
			<form action="<%=request.getContextPath()%>/logout.customer" method="post">
				<div class="form-group" style="margin-top:4%">
				<label for="text" >로그인 성공</label>
					<input type="text" class="form-control" id="cid" name="cid" value="${sessionScope.cid}님"  readonly  />
					<br/>
					<input type="text" class="form-control" id="cid" name="cid" value="${sessionScope.welcome}"  readonly  />  		
				</div>
				<div class="form-group">
					<input type="submit" class="btn-btn-default form-control" value="로그아웃" style="color:white; background:#ff6e61;"/>
				</div>
							
				<div class="form-group">
				<input type="checkbox" id="remember" name="remember" 
				<% if(remember.equals("remember")){ %> checked <% } %> />
				<label for="remember" >아이디 저장하기</label>
				</div>
			</form>		
		</c:when>
		<c:when test="${not empty sessionScope.aid}" >
			<form action="<%=request.getContextPath()%>/logout.customer" method="post">
				<div class="form-group" style="margin-top:4%">
				<label for="text" >로그인 성공</label>
					<input type="text" class="form-control" id="cid" name="cid" value="${sessionScope.aid}님"  readonly  />
					<br/>
					<input type="text" class="form-control" id="cid" name="cid" value="${sessionScope.welcome1}"  readonly  />  		
				</div>
				<div class="form-group">
					<input type="submit" class="btn-btn-default form-control" value="로그아웃" style="color:white; background:#ff6e61;"/>
				</div>
							
				<div class="form-group">
				<input type="checkbox" id="remember" name="remember" 
				<% if(remember.equals("remember")){ %> checked <% } %> />
				<label for="remember" >아이디 저장하기</label>
				</div>
			</form>		
		</c:when>			
		<c:when test="${empty sessionScope.cid}">
			<form action="<%=request.getContextPath()%>/login.customer" method="post">
				<div class="form-group" style="margin-top:4%">
				<label for="text" >로그인하세요</label>
					<input type="text" placeholder="아이디:6-13자리 입력" class="form-control" id="cid" name="cid"
					<% if(remember.equals("remember")){ %> value="<%=id%>"  <% } %>/>
					<br/>
					
				<input type="password" placeholder="비밀번호 입력" class="form-control" id="cpass" name="cpass"/>		
			 <!--		<input type="text" placeholder="비밀번호 입력 " class="form-control"  id="cpass"
					<% if(remember.equals("remember")){ %> value="<%=welcome%> 반갑습니다!"  <% } %>  />			-->	  		
				</div>
				<div class="form-group">
					<input type="submit" class="btn-btn-default form-control" value="로그인" style="background:#ff6e61; color:white;"/>
				</div>
				
				<div class="form-group">
				<input type="checkbox" id="remember" name="remember" 
				<% if(remember.equals("remember")){ %> checked <% } %> />
				<label for="remember" >아이디 저장하기</label>
				</div>
			</form>
			</c:when>								
		</c:choose>
				<div class="form-group">
				<input type="button" class="btn btn-default" value="아이디/비밀번호 찾기" style="font-size: 15px" onclick="location.href='<%=request.getContextPath()%>/find.customer'"  />
				<input type="button" class="btn btn-default" value="회원가입" style="font-size: 15px"  onclick="location.href='<%=request.getContextPath()%>/join_agree.customer'"  />
				</div>		
	<p>
		<a href="https://kauth.kakao.com/oauth/authorize?client_id=d5f8c2bc275a01f6c26e5fcab237320c&redirect_uri=http://localhost:8080/wonjun_Samsung_project/Kakao_Login&response_type=code">
			<img alt="카카오톡 로그인하기" src="<%=request.getContextPath()%>/images/kakao_login_medium_wide.png" style="width:262.5px;">
		</a>
	</p>	
	<div class="form-group">
	<input type="button" class="btn btn-default" value="QR코드" style="font-size: 15px" onclick="location.href='<%=request.getContextPath()%>/test1.jsp'"  />
	</div>	
<%--	<%@ include  file="/test1.jsp" %>		 --%>
		
		</div>
	</div><!-- row r1 end -->
</div>	
	<!-- 직접검색 start -->
	<!-- 직접검색 start -->
	<!-- 직접검색 start -->
	<!-- Trigger the modal with a button -->
	<%@ include  file="../direct_search/mainpage_direct_search.jsp" %>

	<!-- 직접검색 end -->
	<!-- 직접검색 end -->
	<!-- 직접검색 end -->		
	
	<!--카드 조건 검색  START-->
	<!--카드 조건 검색  START-->
	<!--카드 조건 검색  START-->

	<%@ include  file="../card_search_condition/search_form_index.jsp" %>
	
	
	<!--카드 조건 검색  END-->
	<!--카드 조건 검색  END-->
	<!--카드 조건 검색  END-->
	<!--카드 조건 검색  END-->
	
	
	<!-- 키워드 start -->
	<!-- 키워드 start -->
	<!-- class="btn btn-default btn-lg" style="background-color: #1b2838; color:white; width:256px;"	 -->
	<div class="direct_search_card  wj_keyword">
	<div class="container  " >	
	 <div class="col-sm-6">
	 <input type="button" class="btn btn-default btn-lg" style="background-color: #1b2838; color:white; width:256px;" value="키워드추천 클릭" id="card_find" onclick="location.href='<%=request.getContextPath()%>/listall.keyword'" />		
	 </div>
	 <div class="col-sm-6">
		<input type="button" class="btn btn-default btn-lg" style="background-color: #1b2838; color:white; width:256px;" value="조건별 추천 클릭"  id="reco" onclick="location.href='<%=request.getContextPath()%>/list.condition' " />
	</div>
	</div>
	</div>
	<!--키워드 end  -->
	<!--키워드 end  -->	
	<div style="background-color: #f9f9f9">
<div class="container">	
	<div class="col-sm-4">
	<%@ include  file="../card_search_keyword/all_card_mainpage1.jsp" %>
	</div>
	<div class="col-sm-4">
  <!-- sample start -->
	<%@ include  file="../card_search_keyword/all_card_mainpage2.jsp" %>
	</div>
	<div class="col-sm-4">
  <!-- sample start -->
 	<%@ include  file="../card_search_keyword/all_card_mainpage3.jsp" %>
	</div>		
</div>	
</div>
	<!--  -->	
<!-- 	<div class="container">
		<!-- 카드 랭킹 살짝보여주기 -->
<%--	<%@ include  file="../card_search_keyword/all_card_mainpage.jsp" %>		 --%>
<!-- 	</div>   -->

<%-- 	<div class="container">
		<%@ include  file="../api/naver_book_search_2.jsp" %>	<!-- 네이버 검색 -->	
	</div>	
--%>
 	<div class="container">
		<%@ include  file="../api/naver_shopping.jsp" %>	<!-- 네이버 쇼핑 검색 -->	
	</div>	 

	<div class="direct_search_card">">
	<%@ include  file="../gallery/view1.jsp" %>		<!--카드사진 -->
	</div> 
	
<%--	
	<div class="direct_search_card">">
	<%@ include  file="../gallery/view2.jsp" %>			<!--카드사진 -->
	</div>		--%>
	
	<div class="container">	
		 <%@ include  file="../youtube/youtube1.jsp" %>		<!-- 유튜브 광고 -->
	</div>
	


	
	<div class="container">		
		<!-- 네이버 검색 넣기 쇼핑,등등 -->
	</div>
	
	
	

		
	
<%@ include  file="/inc/footer.jsp" %>	
</body>
</html>


	