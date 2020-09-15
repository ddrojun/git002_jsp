<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang ="ko">
<body>
<div class="container"   style="margin-top:5%">
	<h3>CARD</h3> 
	<form action="<%=request.getContextPath()%>/find_pass_action.customer" method="post" id="pass_find">	
		<fieldset>
		<legend>회원정보 확인</legend>
		<table  class="table table-striped">
		<caption>비밀번호 찾기</caption>
			<tbody>
				<tr><th scope="row">아이디  </th><td><input type="text"  id="id_chk" name="id_chk" class="form-control"  /></td></tr>
				<tr><th scope="row">이름    </th><td><input type="text"  id="name_chk" name="name_chk" class="form-control"  /></td></tr>
				<tr><th scope="row">이메일  </th><td><input type="email"  id="email_chk" name="email_chk" class="form-control"  /></td></tr>
				<tr><th scope="row">핸드폰번호 </th><td><input type="tel" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"  id="phone_chk" name="phone_chk" class="form-control"  /></td></tr>
			</tbody>
		</table>
		<div class="form-group text-center"> 
			<a href="<%=request.getContextPath()%>/find.customer"  class="btn btn-dafault" style="color:white; background:#ff6e61;">이전</a> 
			<input type="submit" value="비밀번호 찾기" class="btn btn-dafault" style="color:white; background:#ff6e61;"> 
		</div>
	</fieldset>
	</form>	
	</div>
	<script>
	$(document).ready(function(){
		$("#pass_find").submit(function(){
			if( $("#id_chk").val() ==""   ){  alert("[아이디]빈칸입니다\n확인해주세요");   $("#id_chk").focus();  return false; }
			if( $("#name_chk").val() ==""   ){  alert("[이름]빈칸입니다\n확인해주세요");   $("#name_chk").focus();  return false; }
			if( $("#email_chk").val() ==""   ){  alert("[이메일]빈칸입니다\n확인해주세요");   $("#email_chk").focus();  return false; }
			if( $("#phone_chk").val() ==""   ){  alert("[핸드폰번호]빈칸입니다\n확인해주세요");   $("#phone_chk").focus();  return false; }
		});
	});
	
	
	
</script>	
</body>
</html>