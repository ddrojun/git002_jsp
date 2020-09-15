<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<%@ include  file="../inc/header_1.jsp" %>
<br/>
<br/>
<div class="container"   style="margin-top:2%; min-height:500px">
	<h3>카드 리스트</h3>
		<div class="form-group" style="text-align: right">
			<a href="<%=request.getContextPath()%>/list.keyword">
			<input type="button" value="추천검색 바로가기" class="btn btn-dark" style="background: black; color: white; width: 13%" /></a>
		</div>		
	<table  class="table table-striped">
		<caption>WONJUN_CARD</caption>
		<thead>
			<tr>
				<th scope="col">번호</th>
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
				<!-- <td><a href="<%=request.getContextPath() %>/detail.replydo?bno=${item.no}" >${item.name}</a></td>  -->
					<td>${item.name}</td>
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

</div>
</body>
</html>