<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang ="ko">
<head>
<meta charset="UTF-8">
<title>portfolio</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" 
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
<style>
.notice{width:300px; position:fixed; top:20%; left: 20%; box-shadow: 0 0 5px rgba(0,0,0,0.5); 
		padding:10px; border-radius: 20px;
}
.notice img{ width : 200px; }

</style>

    
</head>
<body>
	<div class="notice">
	<h3>포트폴리오 공지사항</h3>	
		<p>
		본 사이트는 상업적 목적이 아닌 개인 포트폴리오 용도로 제작되었으며, 
		홈페이지의 일부내용과 기타 이미지 등은 그 출처가 따로 있음을 밝힙니다.
		
		</p>
		<p><img src="images/QRCodeImg.jpg" alt="포트폴리오 바로가기"  /></p>
		<p>
		<input type="checkbox" id="subpop" name="subpop" /></p>
		<label for="subpop">오늘하루동안 이창 열지 않음. </label>
		<input type="button" value="[close]" class="btn btn-danger" onclick="location.href='<%=request.getContextPath()%>/start.customer'"  />
		
	</div>
</body>
</html>

<!-- iconfinder_icon-78-document-file-java_315699.png -->
<!-- QRCodeImg.jpg -->