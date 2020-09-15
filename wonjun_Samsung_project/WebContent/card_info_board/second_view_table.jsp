<%@page import="com.alex0517.keywordDto.KeywordDto"%>
<%@page import="java.util.ArrayList"%>
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
</head>
<body>
 <%@include file ="../inc/header_1.jsp" %>	  
<% request.setCharacterEncoding("utf-8"); %>
<%ArrayList<KeywordDto> list = (ArrayList<KeywordDto>)request.getAttribute("item");  %>
<%
	pageContext.setAttribute("item", list );
%> 
 <!--  -->
 <br/>
 <br/>
 <br/>
<div class="container ">
  <h3>CARD 정보</h3>
  <div class="panel-group" id="accordion">
  <c:forEach var="item" items="${item}" varStatus="status"> 
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">        
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse${item.no}">${item.name }</a>          
        </h4>
      </div> 
      <div id="collapse${item.no }" class="panel-collapse collapse <c:if test="${status.first }">in </c:if>">
        <div class="panel-body">
			<p>카드이름 : ${item.name}</p>
			<p>출시 일자 : ${item.date}</p>
			<p>카드유형: ${item.type1}</p>
			<p>적립 유형 : ${item.type2}</p>
			<p>추천 연령대 : ${item.age}</p>
			<p>추천 성별 : ${item.gender}</p>
        </div>
       </div> 
       </div>
  </c:forEach>      
      </div>
      <div class="form-group text-right">
      	<a href="<%=request.getContextPath()%>/write_view.cardinfo" class="btn btn-danger" style="text-align: right">카드추가등록</a>
		<a href="<%=request.getContextPath()%>/card_info_board/first_view.jsp" class="btn btn-danger" style="text-align: left" >이전</a>
	  </div>
</div>
</body>
</html>