<%@page import="com.alex0517.cardbasketDto.CardbasketDto"%>
<%@page import="com.alex0517.cardbasketDao.CardbasketDao"%>
<%@page import="com.alex0517.Customerdto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>     
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>  
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
				<tr><th scope="row">우편번호 </th><td><%=dto.getCpostcode()%></td></tr> 
				<tr><th scope="row">주소 </th><td><%=dto.getCpost1()+" "+dto.getCpost2()%></td></tr>  
			</tbody>
		</table>
		<p class="text-center">
			<a href="<%=request.getContextPath()%>/mypage_edit_view.customer"  class="btn btn-default" style="color:white; background:#ff6e61;">회원정보 수정</a>
			<a href="<%=request.getContextPath()%>/mypage_pass_view.customer"  class="btn btn-default" style="color:white; background:#ff6e61;">비밀번호 수정</a>
		    <a href="#"  class="btn btn-dafault" style="color:white; background:#ff6e61;"  id="delete">탈퇴</a>
		 
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
<!--  -->
<!--  -->
<!--  -->
<%
	CardbasketDao dao = new CardbasketDao();
	CustomerDto dto1 = (CustomerDto)request.getAttribute("dto");
 %>
	<div class="container">
		<h3> MYCARD</h3> 
		<table  class="table table-striped">
			<caption>카드 장바구니</caption>
		<thead>
			<tr>
	<!-- 			<th scope="col">NO</th>		 -->
				<th scope="col">ID</th>
			    <th scope="col">CARD</th>
			</tr>
		</thead>			
			<tbody>
			<c:forEach var="item" items="${dto111}" varStatus="status">
				<tr>
					<td>${item.id}</td>
					<td><a href="<%=request.getContextPath()%>/search_detail.keyword?no=${item.cardnum}">${item.cardname }</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<p class="text-center">
			<a href="<%=request.getContextPath()%>/start.customer"  class="btn btn-dafault" style="color:white; background:#ff6e61;">이전</a>		 
		</p>
	</div>

 <%--		<jsp:include page="<%=request.getContextPath()%>/mycard_view.keyword"  /> 	--%>
 	
<%--	<%@ include file="../card_info_board/mycard.jsp" %>		--%>

 	
<%@ include  file="../inc/footer.jsp" %>