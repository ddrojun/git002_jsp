<%@page import="com.alex0517.BoardDto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include  file="../inc/header_1.jsp" %>
<!--  END HEADER -->
<!--  END HEADER -->

<div class="container"   style="margin-top:2%; min-height:500px">
	<h3>자유게시판</h3>
	<table  class="table table-striped">
		<caption>WONJUN_CARD</caption>
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">글 제목</th>
			    <th scope="col">작성자</th>
			    <th scope="col">작성 날짜 /시간</th>
			    <th scope="col">조회수</th>
			</tr>
		</thead>
		<tbody>
			<%
				/*
				request.setCharacterEncoding("utf-8");
				@SuppressWarnings("unchecked")			
				ArrayList<BoardDto> list = (ArrayList<BoardDto>) request.getAttribute("item");
				//ArrayList<BoardDto> list = (ArrayList<BoardDto>) request.getAttribute("list");
				int total = (int)request.getAttribute("total");
				for(BoardDto dto : list){
					out.println("<tr><td>"+(total--)+
							"</td><td><a href='"+request.getContextPath()+"/detail.do?bno="+dto.getBno()+"'>"+dto.getBtitle()+
							"</a></td><td>"+dto.getBname()+
							"</td><td>"+dto.getBdate()+
							"</td><td>"+dto.getBhit()+
							"</td></tr>");
				}
				*/
			%>
			<c:set var="sum" value="${total}"></c:set>
			<c:forEach var="item" items="${item}" varStatus="status">
				<tr>
					<td>${sum}</td>
					<td><a href="<%=request.getContextPath() %>/detail.do?bno=${item.bno}">${item.btitle}</a></td>
					<td>${item.bname}</td>
					<td>${item.bdate}</td>
					<td><span class="badge bg-red">${item.bhit}</span></td>
					<c:set var="sum" value="${sum-1}"></c:set>
				</tr>
			</c:forEach>
		</tbody>
		<!--  -->
		<!--  -->
	<tfoot>
		<tr>
			<td colspan="5" class="text-center">
				<ul class="pagination">
		<li><a href ="${pageContext.request.contextPath}/list.do?pstartno=${0}" class="btn btn-danger" style="color: green">맨처음</a></li>
				<c:if test="${items.bottom_start>items.bottomList }"><li><a href="${pageContext.request.contextPath}/list.do?pstartno=${param.pstartno-100}" class="active">이전</a></li></c:if>
					<c:forEach var="i" begin="${items.bottom_start }" end="${items.bottom_end }">
						<li><a href="${pageContext.request.contextPath}/list.do?pstartno=${(i-1)*items.onepageLimit}">${i }</a></li>	  
					</c:forEach>
				<c:if test="${items.pageAll > items.bottom_end }"><li><a href="${pageContext.request.contextPath}/list.do?pstartno=${param.pstartno+100}" class="active">다음</a></li></c:if>
		<li><a href ="${pageContext.request.contextPath}/list.do?pstartno=${(items.pageAll - 1) * 10}" class="btn btn-danger" style="color: green">마지막</a></li>
						</ul>
					</td>
				</tr>
			</tfoot>		
	</table>
		<div class="form-group" style="text-align: right">
			<a href="<%=request.getContextPath()%>/write_view.do">
			<input type="button" value="글쓰기" class="btn btn-default" style="color:white; background:#ff6e61; width: 13%;" /></a>
		</div>	
</div>

<!-- END FOOTER -->
<!-- END FOOTER -->
<%@ include  file="../inc/footer.jsp" %>







