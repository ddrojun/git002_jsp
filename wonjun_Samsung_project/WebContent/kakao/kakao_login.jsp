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
<body>

	<!--/api_xml  -->
	<p>
	 <a href="https://kauth.kakao.com/oauth/authorize?client_id=d5f8c2bc275a01f6c26e5fcab237320c&redirect_uri=http://localhost:8080/wonjun_Samsung_project/Kakao_Login&response_type=code">  
<!--	<a href="https://kauth.kakao.com/oauth/authorize?client_id=d5f8c2bc275a01f6c26e5fcab237320c&redirect_uri=http://alex0517.cafe24.com/api_xml/wonjun_Samsung_project/Kakao_Login&response_type=code">	-->    
			<img alt="카카오톡 로그인하기" src="../images/kakao_login_large_narrow.png">
		</a>
	</p>
<%--	<table class="table table-striped">
	<caption>PROFILE</caption>
	 <tbody>
	 	<tr><th scope="col">NICKNAME</th><td>${nickname}</td></tr>
	 	<tr><th scope="col">PROFILE</th><td><img src="${thumbnail_image}" alt=""></td></tr>
	 </tbody>
	</table>
	
	 --%>

</body>
</html>



