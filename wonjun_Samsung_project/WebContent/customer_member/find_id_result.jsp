<%@page import="com.alex0517.Customerdto.CustomerDto"%>
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
</head>
<body>
<%
 CustomerDto dto = (CustomerDto)request.getAttribute("dto");
%>
 	<div class="container">
 		<h3>회원님의 아이디</h3>
 	<div  class="form-group">
		<p class="form-control">아이디 : <%=dto.getCid()%> 입니다. </p>
		<p>까먹지마시오</p>
	</div>
	<div>
		 <a href="<%=request.getContextPath()%>/start.customer" class="btn btn-dafault" style="color:white; background:#ff6e61;" >확인</a> 
	</div>			
 	</div> <!-- end container -->
</body>
</html>