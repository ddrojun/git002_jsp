<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="container"  style="margin-top:2%; min-height:500px">
		<h3>MyCard</h3>
		<form action="<%=request.getContextPath()%>/delete_view.keyword?cardname=<%=request.getParameter("cardname")%>" method="post"   id="deleteForm"> 
			<div class="form-group">
			  <label for="cardname"  >카드이름</label>
			  <input type="text"   name="cardname"   id="cardname"   class="form-control" > 
			  <span>(*) 삭제시 필수입니다. </span>
			</div>
			<div class="form-group">
				<input type="submit" value=" 확인 "   class="btn btn-dark" style="background: black; color: white;" />
				<input type="reset"   onclick="history.go(-1);" value="취소" class="btn btn-dark" style="background: black; color: white;"  >  
				<a href="<%=request.getContextPath()%>/mycard_view.keyword"  class="btn btn-dark" style="background: black; color: white;">뒤로가기</a>
			</div>	
		</form>
</div>
<script>
	jQuery(document).ready(function(){
		jQuery("#deleteForm").submit(function(){
			if(jQuery("#cardname").val()==""){
				alert("카드이름 입력해주세요");
				jQuery("#cardname").focus();
				return false;
			}
		});
	});
</script>
</body>
</html>