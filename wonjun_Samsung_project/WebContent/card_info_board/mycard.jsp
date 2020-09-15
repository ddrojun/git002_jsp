<%@page import="com.alex0517.cardbasketDao.CardbasketDao"%>
<%@page import="com.alex0517.keywordDto.KeywordDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.alex0517.cardbasketDto.CardbasketDto"%>
<%@page import="com.alex0517.Customerdto.CustomerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include  file="../inc/header_1.jsp" %>
<%@page import="java.sql.*"%>
<%
	CardbasketDao dao = new CardbasketDao();
	//request.setAttribute("list", dao.listAll());	//테이블 리스트
	//request.setAttribute("list", dao. );	//테이블 리스트
 %>
	<div class="container"   style="margin-top:5%">
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
		<!-- 			<td>${item.no}</td>		 -->
					<td>${item.id}</td>
			<!-- 		<td>${item.cardname}</td>   -->
			<td><a href="<%=request.getContextPath()%>/search_detail.keyword?no=${item.cardnum}">${item.cardname }</a></td>
			<!-- 		<td><a href="<%=request.getContextPath()%>/delete_view.keyword?cardname=${item.cardname}">${item.cardname }</a></td>	 -->
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<p class="text-center">
			<a href="<%=request.getContextPath()%>/start.customer"  class="btn btn-dafault" style="color:white; background:#ff6e61;">이전</a>		 
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
<%@ include  file="../inc/footer.jsp" %>
