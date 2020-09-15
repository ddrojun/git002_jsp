<%@page import="com.alex0517.Customerdto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include  file="/inc/header_1.jsp" %>
<%@page import="java.sql.*"%>

	<div class="container"   style="margin-top:5%">
		<h3> MYPAGE</h3> 
	<form action="<%=request.getContextPath()%>/mypage_edit.customer" method="post">	
		<fieldset>
		<legend>회원정보 수정</legend>
		<table  class="table table-striped">
			<caption>당신의 소중한정보를 수정해주세요!</caption>
			<tbody>
				<%
					CustomerDto dto = (CustomerDto)request.getAttribute("dto");
				%>
				<tr><th scope="row">아이디  </th><td><%=dto.getCid()%></td></tr> 
				<tr><th scope="row"><label for="cname">이름</label>    </th>
				<td><input type="text"  id="cname"    name="cname"  value="<%=dto.getCname()%>"  class="form-control"  /></td></tr>				
				<tr><th scope="row"><label for="cemail">이메일 </label></th>
				<td><input type="text" value="<%=dto.getCemail()%>"   id="cemail"   name="cemail"    class="form-control"/></td></tr>
					<tr><th scope="row"><label for="cbirth">생년월일 </label></th>
				<td><input type="text" value="<%=dto.getCbirth()%>"   id="cbirth"   name="cbirth"    class="form-control"/></td></tr>
					<tr><th scope="row"><label for="cphone">휴대폰번호 </label></th>
				<td><input type="text" value="<%=dto.getCphone()%>"   id="cphone"   name="cphone"    class="form-control"/></td></tr>
						<tr><th scope="row"><label for="cpostcode">우편번호 </label></th>
				<td><input type="text" value="<%=dto.getCpostcode()%>"   id="cpostcode"   name="cpostcode"    class="form-control"/></td></tr>			
						<tr><th scope="row"><label for="cpost1">주소(구,동) </label></th>
				<td><input type="text" value="<%=dto.getCpost1()%>"   id="cpost1"   name="cpost1"    class="form-control"/></td></tr>	
					<tr><th scope="row"><label for="cpost2">상세주소 </label></th>
				<td><input type="text" value="<%=dto.getCpost2()%>"   id="cpost2"   name="cpost2"    class="form-control"/></td></tr>									
				<tr><th scope="row">가입날짜 </th><td><%=dto.getCdate()%></td></tr>

			</tbody>
		</table>
		<p class="text-center"> 
			<a href="<%=request.getContextPath()%>/mypage_view.customer"  class="btn btn-default" style="color:white; background:#ff6e61;">이전</a> 
			<input type="submit"   value="회원정보수정" class="btn btn-default" style="color:white; background:#ff6e61;"> 
		</p>
	</fieldset>
	</form>	
	</div>
<%@ include  file="/inc/footer.jsp" %>