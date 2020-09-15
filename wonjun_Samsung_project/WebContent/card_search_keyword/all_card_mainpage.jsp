<%@page import="com.alex0517.keywordDao.KeywordDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>    
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>  
 <%
	KeywordDao dao = new KeywordDao();
	//request.setAttribute("list", dao.listAll());	//테이블 리스트
	request.setAttribute("list", dao.listcnt());	//테이블 리스트
 %>
<div class="container"   style="margin-top:2%; min-height:500px">
	<h3>CARD 랭킹</h3>
	<table  class="table table-striped">	
		<thead>
			<tr>
				<th scope="col">순위</th>
				<th scope="col">카드이름</th>
			    <th scope="col">카드번호</th>
			    <th scope="col">성별</th>
			    <th scope="col">연령대</th>
			    <th scope="col">신용/체크</th>
			    <th scope="col">전체/할인/포인트</th> 	
		<!-- 	    <th scope="col">혜택</th>    -->
		<!-- 	    <th scope="col">날짜</th>	-->
			</tr>
		</thead>
		<tbody>
		<c:set var="sum" value="${total}"></c:set>
			<c:forEach var="item" items="${list}" varStatus="status">
				<tr>
					<td>${item.no}</td>
					<td><a href="<%=request.getContextPath() %>/search_detail.keyword?no=${item.no}">${item.name}</a></td>
					<td>${item.idnum}</td>
					<td>${item.gender}</td>
					<td>${item.age}</td>
					<td>${item.type1}</td>
					<td>${item.type2}</td>
		<!-- 			<td>${item.benefit}</td>	 -->
		<!--			<td>${item.date}</td>		-->
			<c:set var="sum" value="${sum-1}"></c:set>
				</tr>
			</c:forEach>
		</tbody>	
	</table>
<!-- +"</td><td><a href='"+request.getContextPath()+"/search_detail.keyword?no="+rset.getInt("no")+"'>"+rset.getString("name") -->
</div>
