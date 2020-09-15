<%@page import="com.alex0517.Customerdto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include  file="/inc/header_1.jsp" %>
	<div class="container"   style="margin-top:5%">
		<h3> MYPAGE</h3> 
		<form action="<%=request.getContextPath()%>/mypage_pass.customer"  method="post"  id="passUpdate">
			<fieldset>
			<legend>회원정보 수정</legend>
			<table  class="table table-striped">
				<caption>비밀번호 수정</caption>
				<tbody> 
				<%
 					CustomerDto dto = (CustomerDto)request.getAttribute("dto");
 				%>
					<tr><th scope="row"><label for="old">이전 비밀번호</label>    </th>
					<td><input type="password"   id="old"    name="old"  value="<%=dto.getCpass()%>"  class="form-control"/></td></tr>
					<tr><th scope="row"><label for="new">새 비밀번호</label>    </th>
					<td><input type="password"   id="new"   name="new"  class="form-control"/></td></tr>
					<tr><th scope="row"><label for="new2">새 비밀번호확인 </label></th>
					<td><input type="password"  id="new2"   name="new2"   class="form-control"/></td></tr>
				</tbody>
			</table>
			<p class="text-center"> 
				<a href="javascript:history.go(-1)"  class="btn btn-default" style="color:white; background:#ff6e61;">이전</a> 
				<input type="submit"   value="비밀번호 수정하러가기" class="btn btn-default" style="color:white; background:#ff6e61;"> 
			</p>
			</fieldset>
		</form>	
	</div>
	<script>
	$(document).ready(function(){
		$("#passUpdate").submit(function(){
			if( $("#old").val() ==""   ){  alert("빈칸입니다\n확인해주세요");   $("#old").focus();  return false; }
			if( $("#new").val() ==""   ){  alert("빈칸입니다\n확인해주세요");   $("#new").focus();  return false; } 
			if( $("#new2").val() ==""   ){  alert("빈칸입니다\n확인해주세요");   $("#new2").focus();  return false; } 
			if( $("#new").val() !=$("#new2").val()  ){  alert("비밀번호와 비밀번호 확인이 다릅니다.\n확인해주세요");  
									$("#new").focus();  return false; } 
		});
	});
</script>		
<%@ include  file="/inc/footer.jsp" %>