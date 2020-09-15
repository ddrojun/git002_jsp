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
	<h3>우편번호 검색</h3>
	<div class="row">	
		<div class="col-sm-2">
			<label for="postcode">우편번호</label>		
		</div>
		<div class="col-sm-4">
			<input type="text" id="postcode" name="postcode" class="form-control" placeholder="우편번호 입력해주세요" />
		</div>
		<div class="col-sm-6">
			<input type="button" id="post" value="우편번호" class="btn btn-danger"  />
		</div>
		
	</div> <!-- end row -->
	<div class="row">
		<div class="col-sm-2">
			<label for="address">상세주소</label>		
		</div>
		<div class="col-sm-4">
			<input type="text" id="address" name="address" class="form-control" placeholder="주소" />
		</div>
		<div class="col-sm-6">
			<input type="text" id="address2" name="address" class="form-control" placeholder="상세주소 입력해주세요" />
		</div>
	</div> <!-- end row -->	
	
	
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	$(function(){
		$("#post").click(function(){
			new daum.Postcode({
				oncomplete: function(data){			//oncomplete : 우편번호 검색 목록에서 특정항목 클린한 경우 콜백 함수를 정의하는 부분
					console.log(data);
					console.log(data.zonecode);
					console.log(data.address);
					$("#postcode").val(data.zonecode);
					$("#address").val(data.address);
					$("#address2").focus();
				}
			}).open();
		});
	});
	$(document).ready(function(){
		$("#join2").submit(function(){
			if( $("#postcode").val() ==""   ){  alert("[우편번호]빈칸입니다\n확인해주세요");   $("#postcode").focus();  return false; }
			if( $("#address").val() ==""   ){  alert("[주소]빈칸입니다\n확인해주세요");   $("#address2").focus();  return false; }
			if( $("#address2").val() ==""   ){  alert("[상세주소]빈칸입니다\n확인해주세요");   $("#address2").focus();  return false; }

		});
	});	
</script>
</body>
</html>