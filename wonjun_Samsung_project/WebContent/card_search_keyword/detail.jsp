<%@page import="com.alex0517.conditionDto.CardBenefitDto"%>
<%@page import="com.alex0517.keywordDto.KeywordDto"%>
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
</head>
<%@ include  file="../inc/header_1.jsp" %>
<body>
<div class="container"  style="margin-top:4%; min-height:500px">
	<%
	KeywordDto dto = (KeywordDto)request.getAttribute("dto");
	CardBenefitDto dto1 = (CardBenefitDto)request.getAttribute("dto1");
	%>
<% pageContext.setAttribute("newLineChar", "\n"); %>
	<form action="<%=request.getContextPath()%>/addcard.keyword?no=<%=dto.getNo()%>" method="post" id="add">
	<h3>카드정보</h3>
	<span class="glyphicon glyphicon-plus">  카드이름</span> 					
	<div class="form-group">
		 <input type="text" id ="cardname1" name ="cardname1" class="form-control" style="color:navy; font-weight: bold" value="<%=dto.getName()%>" />
	</div>	
	<span class="glyphicon glyphicon-plus">  카드번호</span> 
	  <div  class="form-group">
		<p class="form-control" style="color:navy; font-weight: bold"><%=dto.getIdnum()%></p>
	</div>	
	<%if(!dto1.getOil().equals("null")) {%>
	  <span class="glyphicon glyphicon-plus">  주유헤택 </span> 	
	  <div  class="form-group">
 		<p class="form-control" style="color:orange; font-weight: bold"><%=dto1.getOil()%> 할인 </p>
	  </div>
	  <%} %>
	 <%if(!dto1.getMoive().equals("null"))  {%> 
	  <span class="glyphicon glyphicon-plus">  영화혜택 </span> 	
	  <div  class="form-group">
     <p class="form-control" style="color:orange; font-weight: bold" ><%=dto1.getMoive()%> 할인 </p>
	  </div>
	  <%} %>
	  <%if(!dto1.getCoffee().equals("null"))  {%>  
	  <span class="glyphicon glyphicon-plus">  커피헤택 </span> 	
	  <div  class="form-group">
     <p class="form-control" style="color:orange; font-weight: bold"><%=dto1.getCoffee()%> 할인 </p>
	  </div>
	  <%} %>
	  <!--  -->
	  <%if (!dto1.getTransportation().equals("null")) {%>
	  <span class="glyphicon glyphicon-plus">  교통헤택 </span> 	
	  <div  class="form-group">
     <p class="form-control" style="color:orange; font-weight: bold"><%=dto1.getTransportation()%> 할인 </p>
	  </div>
	  <%} %>
	  <!--  -->
	  <%if(!dto1.getAir().equals("null"))  {%>  
	  <span class="glyphicon glyphicon-plus">  항공헤택 </span> 	
	  <div  class="form-group">
     <p class="form-control" style="color:orange; font-weight: bold"><%=dto1.getAir()%> 할인 </p>
	  </div>	
	  <%} %>
	  <%if(!dto1.getShopping().equals("null"))  {%>  
	  <span class="glyphicon glyphicon-plus">  쇼핑헤택 </span> 	
	  <div  class="form-group">
     <p class="form-control" style="color:orange; font-weight: bold"><%=dto1.getShopping()%> 할인 </p>
	  </div>
	  <%} %>
	 <%if(!dto1.getFastfood().equals("null"))  {%>  
	  <span class="glyphicon glyphicon-plus">  패스트푸드헤택 </span> 	
	  <div  class="form-group">
     <p class="form-control" style="color:orange; font-weight: bold"><%=dto1.getFastfood()%> 할인 </p>
	  </div>	  	    	  	  	  	
	  <%} %>
	 <%if(!dto1.getPhone().equals("null"))  {%>  
	  <span class="glyphicon glyphicon-plus">  휴대전화헤택 </span> 	
	  <div  class="form-group">
     <p class="form-control" style="color:orange; font-weight: bold"><%=dto1.getPhone()%> 할인 </p>
	  </div>
	  <%} %>
	 <%if(!dto1.getMart().equals("null"))  {%>   
	<span class="glyphicon glyphicon-plus">  마트헤택 </span> 	
	  <div  class="form-group">
     <p class="form-control" style="color:orange; font-weight: bold"><%=dto1.getMart()%> 할인 </p>
	  </div>  	
	<%} %>  
	  <!--  -->	
	  <!--  -->
	 <c:if test="${empty sessionScope.cid}">
		 <script>
		 	$(function(){
		 		$("#addcard_btn").on("click", function(){
		 			alert("회원만 가능합니다.");
		 				return false;
		 		});
		 });
		 </script>
	</c:if>	  
	 <%-- if(session.getAttribute("cid") !=null ){ --%>	  
	<div class="form-group text-center"> 
		<input type ="submit" class="btn btn-default form-control" style="color:white; background:#ff6e61;" id="addcard_btn" value="카드담기"  />
	</div> <!-- end group -->	
	 <%--}--%>			  
	<div class="form-group text-center"> 
		<input type="button"   onclick="history.go(-1);" value="뒤로가기" class="btn btn-default form-control" style="color:white; background:#ff6e61;"  >   
	</div> <!-- end group -->	  
	  
	</form>  
	  <!--  -->  
	<!--  -->			
<!-- 	 <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body">
        <p><%=dto.getName()%></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>		
     -->	 
</div>	
</body>
</html>