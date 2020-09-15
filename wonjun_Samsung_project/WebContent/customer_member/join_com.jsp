<%@page import="com.alex0517.Customerdto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include  file="../inc/header_1.jsp" %>
<%@page import="java.sql.*"%>
	<div class="container"   style="margin-top:5%">
		<h3>WONJUN_CACRD</h3>
		<p>회원가입을 축하합니다.</p> 
		<table  class="table table-striped">
			<caption>회원가입완료</caption>
			<tbody>
				<%
					CustomerDto dto = (CustomerDto)request.getAttribute("dto");
				%>
				<tr><th scope="row">아이디  </th><td><%=dto.getCid()%></td></tr>
				<tr><th scope="row">이름    </th><td><%=dto.getCname()%></td></tr>
				<tr><th scope="row">이메일  </th><td><%=dto.getCemail()%></td></tr>
				<tr><th scope="row">생년월일 </th><td><%=dto.getCbirth()%></td></tr>
				<tr><th scope="row">전화번호  </th><td><%=dto.getCphone()%></td></tr>
				<tr><th scope="row">가입날짜 </th><td><%=dto.getCdate()%></td></tr> 
				<tr><th scope="row">우편번호 </th><td><%=dto.getCpostcode()%></td></tr> 
				<tr><th scope="row">주소 </th><td><%=dto.getCpost1()+" "+dto.getCpost2()%></td></tr>  
			</tbody>
		</table>
		<p class="text-right"><a href="<%=request.getContextPath()%>/login_view.customer"  class="btn btn-dafault" style="color:white; background:#ff6e61;">로그인</a></p>
		<p class="text-right"><a href="<%=request.getContextPath()%>/start.customer"  class="btn btn-dafault" style="color:white; background:#ff6e61;">메인페이지</a></p>
	</div>
<%@ include  file="../inc/footer.jsp" %>
