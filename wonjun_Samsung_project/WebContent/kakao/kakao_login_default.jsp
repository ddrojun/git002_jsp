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
	<div class="">
	<h3 class="panel-heading">Kakao Login</h3>
	<pre>
	1. http://developers.kakao.com/
	2. http://developers.kakao.com/tool/resource/login 버튼 다운로드 
	3. https://localhost:8080/api_xml/Kakao_Login   프로젝트명/(서블릿)
	4. 로그인 화면에서 
	GET /oauth/authorize?client_id={app_key}&redirect_uri={redirect_uri}&response_type=code HTTP/1.1
	Host: kauth.kakao.com
	//app_key : 본인rest_api키
	4-1. 
	조합하기 : https://kauth.kakao.com/oauth/authorize?client_id={app_key}&redirect_uri={redirect_uri}&response_type=code 
	4-2. 
	 		https://kauth.kakao.com/oauth/authorize?client_id=d5f8c2bc275a01f6c26e5fcab237320c
	 		&redirect_uri=https://localhost:8080/api_xml/Kakao_Login&response_type=code
	 		
	4-3. 안쓰면 활성화설정 --> 비활성화 꼭 해주기 
	
	/////
	5-1. 사용자 토큰 받기
	POST /oauth/token HTTP/1.1
	Host: kauth.kakao.com
	Content-type: application/x-www-form-urlencoded;charset=utf-8
	</pre>
	<p>
	 <a href="https://kauth.kakao.com/oauth/authorize?client_id=d5f8c2bc275a01f6c26e5fcab237320c&redirect_uri=http://localhost:8080/api_xml/Kakao_Login&response_type=code"> 
<!--	<a href="https://kauth.kakao.com/oauth/authorize?client_id=d5f8c2bc275a01f6c26e5fcab237320c&redirect_uri=http://alex0517.cafe24.com/api_xml/Kakao_Login&response_type=code">    -->
			<img alt="카카오톡 로그인하기" src="../images/kakao_login_large_narrow.png">
		</a>
	</p>
	<table class="table table-striped">
	<caption>PROFILE</caption>
	 <tbody>
	 	<tr><th scope="col">NICKNAME</th><td>${nickname}</td></tr>
	 	<tr><th scope="col">PROFILE</th><td><img src="${thumbnail_image}" alt=""></td></tr>
	 </tbody>
	</table>
	</div> <!-- end class -->
</body>
</html>



