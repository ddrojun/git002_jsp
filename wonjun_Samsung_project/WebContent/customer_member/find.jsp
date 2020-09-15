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
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>       
</head>
<%@ include  file="../inc/header_1.jsp" %>
<body>
	<%
	CustomerDto dto = (CustomerDto)request.getAttribute("dto");
	%>
	<div class="container"   style="margin-top:5%">
	<h3>아이디 / 비밀번호 찾기</h3>
 		 <ul class="nav nav-tabs">
    		<li class="active"><a data-toggle="tab" href="#menu1">아이디 찾기</a></li>
    		<li class="active"><a href="<%=request.getContextPath()%>/find_pass.customer">비밀번호 찾기</a></li>
    		<li class="active"><a href="<%=request.getContextPath()%>/join_agree.customer">회원가입 바로가기</a></li>
 		 </ul>
  	<div class="tab-content">
    	<div id="menu1" class="tab-pane fade in active">
			<div class="container" style="margin-top:1%"  >
			<form action="<%=request.getContextPath()%>/find_id_action.customer" method="post" id="id_pass">	
				<fieldset>
				<table  class="table table-striped">
					<caption>아이디 찾기</caption>
				<tbody>
					<tr><th scope="row">이름  </th><td><input type="text"  id="name_chk" name="name_chk" class="form-control"  /></td></tr>
					<tr><th scope="row">비밀번호    </th><td><input type="password"  id="pass_chk" name="pass_chk" class="form-control"  /></td></tr>
					<tr><th scope="row">이메일  </th><td><input type="email"  id="email_chk" name="email_chk" class="form-control"  /></td></tr>
					<tr><th scope="row">핸드폰번호 </th><td><input type="tel" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"  id="phone_chk" name="phone_chk" class="form-control"  /></td></tr>
				</tbody>
				</table>
			<div class="form-group text-center"> 
				<a href="<%=request.getContextPath()%>/start.customer"  class="btn btn-dafault" style="color:white; background:#ff6e61;">이전</a> 
				<input type="submit" value="아이디 찾기" class="btn btn-dafault" style="color:white; background:#ff6e61;"> 
			</div>
				</fieldset>
			</form>	
			</div>
    	</div> <!--  -->
    </div>		
    	<script>
	$(document).ready(function(){
		$("#id_pass").submit(function(){
			if( $("#name_chk").val() ==""   ){  alert("[이름]빈칸입니다\n확인해주세요");   $("#id_chk").focus();  return false; }
			if( $("#pass_chk").val() ==""   ){  alert("[비밀번호]빈칸입니다\n확인해주세요");   $("#name_chk").focus();  return false; }
			if( $("#email_chk").val() ==""   ){  alert("[이메일]빈칸입니다\n확인해주세요");   $("#email_chk").focus();  return false; }
			if( $("#phone_chk").val() ==""   ){  alert("[핸드폰번호]빈칸입니다\n확인해주세요");   $("#phone_chk").focus();  return false; }
		});
	});
</script>
	<!--  -->
	<!--  -->
	<%--
	<%@ inclue file="find_pass_tab.jsp" %>
	 --%>
	
	</div> <!-- end container -->
	<%@ include  file="/inc/footer.jsp" %>
</body>
</html>