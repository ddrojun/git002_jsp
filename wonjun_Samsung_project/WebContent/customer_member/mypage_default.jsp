<%@page import="com.alex0517.Customerdto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include  file="../inc/header_1.jsp" %>
<%@page import="java.sql.*"%>
	<div class="container"   style="margin-top:5%">
		<h3> MYPAGE</h3> 
		<table  class="table table-striped">
			<caption>회원정보</caption>
			<tbody>
 				<%
 					CustomerDto dto = (CustomerDto)request.getAttribute("dto");
 				%>
				<tr><th scope="row">아이디  </th><td><%=dto.getCid()%></td></tr>
				<tr><th scope="row">이름    </th><td><%=dto.getCname()%></td></tr>
				<tr><th scope="row">이메일  </th><td><%=dto.getCemail()%></td></tr>
				<tr><th scope="row">생년월일 </th><td><%=dto.getCbirth()%></td></tr> 
				<tr><th scope="row">핸드폰번호 </th><td><%=dto.getCphone()%></td></tr> 
				<tr><th scope="row">가입날짜 </th><td><%=dto.getCdate()%></td></tr> 
			</tbody>
		</table>
		<p class="text-center">
			<a href="<%=request.getContextPath()%>/mypage_edit_view.customer"  class="btn btn-danger">회원정보 수정</a>
			<a href="<%=request.getContextPath()%>/mypage_pass_view.customer"  class="btn btn-danger">비밀번호 수정</a>
		    <a href="#"  class="btn btn-danger"  id="delete">탈퇴</a>
		 
		</p>
		<script>
		$(document).ready(function(){
			$("#delete").click(function(){
				if( confirm("정말 탈퇴하시겠습니까? ")){
					location.href="<%=request.getContextPath()%>/mypage_delete.customer?cpass="+prompt('당신의 비밀번호를 입력해주세요');
				}
				return false;
			});
		});
		</script>
	</div>

 	<jsp:include page="<%=request.getContextPath()%>/mycard_view.keyword"  />
<%@ include  file="../inc/footer.jsp" %>