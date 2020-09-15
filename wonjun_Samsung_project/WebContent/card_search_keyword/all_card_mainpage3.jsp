<%@page import="com.alex0517.keywordDao.KeywordDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>    
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>  
 <%--
 <%
	KeywordDao dao = new KeywordDao();
	//request.setAttribute("list", dao.listAll());	//테이블 리스트
	request.setAttribute("list", dao.listcnt());	//테이블 리스트
 %>
  --%>
 <div class="cardrank_wrap"> 
  <h3  class="cardrank rank3">CARD 랭킹 남자</h3>
 <table class="table table-striped">	
		<thead>
			<tr>
				<th scope="col">순위</th>
				<th scope="col">카드이름</th>
			    <th scope="col">카드번호</th>
			</tr>
		</thead>
		<tbody>
		
			
				<tr>
					<td>1</td>
					<td><a href="/wonjun_Samsung_project/search_detail.keyword?no=2">LIKIT FUN카드</a></td>
					<td>롯데카드001</td>
				</tr>
			
				<tr>
					<td>2</td>
					<td><a href="/wonjun_Samsung_project/search_detail.keyword?no=5">taptap 카드</a></td>
					<td>삼성카드001</td>
				</tr>
			
				<tr>
					<td>3</td>
					<td><a href="/wonjun_Samsung_project/search_detail.keyword?no=7">ZERO카드</a></td>
					<td>현대카드001</td>			
				</tr>
			
				<tr>
					<td>4</td>
					<td><a href="/wonjun_Samsung_project/search_detail.keyword?no=10">카드의정석 COOKIE CHECK</a></td>
					<td>우리카드002</td>
				</tr>		
				<tr>
					<td>5</td>
					<td><a href="/wonjun_Samsung_project/search_detail.keyword?no=13">노리체크카드</a></td>
					<td>KB국민003</td>
				</tr>
			
				<tr>
					<td>6</td>
					<td><a href="/wonjun_Samsung_project/search_detail.keyword?no=17">카드의정석 SS03 CHECK</a></td>
					<td>우리카드003</td>
				</tr>
			
				<tr>
					<td>7</td>
					<td><a href="/wonjun_Samsung_project/search_detail.keyword?no=19">삼성카드4</a></td>
					<td>삼성카드002</td>
				</tr>	
				<tr>
					<td>8</td>
					<td><a href="/wonjun_Samsung_project/search_detail.keyword?no=20">PAYCO 플래티넘 롯데카드</a></td>
					<td>롯데카드002</td>
				</tr>			
				<tr>
					<td>9</td>
					<td><a href="/wonjun_Samsung_project/search_detail.keyword?no=22">다드림 체크카드</a></td>
					<td>우체국003</td>
				</tr>
				<tr>
					<td>10</td>
					<td><a href="/wonjun_Samsung_project/search_detail.keyword?no=23">현대카드M3</a></td>
					<td>현대카드002</td>
				</tr>				
			
		</tbody>	
	</table>
	</div>
 <!-- sample end -->
<%-- 	<h3>CARD 랭킹</h3>
	<table  class="table table-striped">	
		<thead>
			<tr>
				<th scope="col">순위</th>
				<th scope="col">카드이름</th>
			    <th scope="col">카드번호</th>

		<!-- 	    <th scope="col">혜택</th>    -->
		<!-- 	    <th scope="col">날짜</th>	-->
			</tr>
		</thead>
		<tbody>
		<c:set var="sum" value="${total}"></c:set>
			<c:forEach var="item" items="${list}" varStatus="status"  begin="0" end="5">
				<tr>
					<td>${item.no}</td>
					<td><a href="<%=request.getContextPath() %>/search_detail.keyword?no=${item.no}">${item.name}</a></td>
					<td>${item.idnum}</td>

		<!-- 			<td>${item.benefit}</td>	 -->
		<!--			<td>${item.date}</td>		-->
			<c:set var="sum" value="${sum-1}"></c:set>
				</tr>
			</c:forEach>
		</tbody>	
	</table>--%>
<!-- +"</td><td><a href='"+request.getContextPath()+"/search_detail.keyword?no="+rset.getInt("no")+"'>"+rset.getString("name") -->

