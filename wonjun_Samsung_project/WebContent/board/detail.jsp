<%@page import="com.alex0517.BoardDto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header_1.jsp" %>
<%@page import="java.sql.*"%>

<div class="container"  style="margin-top:2%; min-height:500px">
	<%
	BoardDto dto = (BoardDto)request.getAttribute("dto");
	%>
<% pageContext.setAttribute("newLineChar", "\n"); %>
	
	<h3>자유게시판</h3>
	<span class="glyphicon glyphicon-plus">  조회수</span> 					
	<div class="form-group" >
	  	<p class="form-control"><%=dto.getBhit()%></p>
	</div>	
	<span class="glyphicon glyphicon-plus">  이름</span> 
	  <div  class="form-group">
		<p class="form-control"><%=dto.getBname()%></p>
	</div>				
	  <span class="glyphicon glyphicon-plus">  제목</span> 	
	  <div  class="form-group">
	     <p class="form-control"><%=dto.getBtitle()%></p>
	  </div>	
	  <span class="glyphicon glyphicon-plus">  내용</span>	  
	<div  class="form-group">
	  	<p class="form-control" style="height: 400px"><%=dto.getBcontent().replace("\r\n", "<br>")%></p>
	</div>	
	<!--  -->
 	<span class="glyphicon glyphicon-plus">  첨부파일/이미지</span> 	
	  <div  class="form-group">
	  <p>이미지 &nbsp; : <img src="${pageContext.request.contextPath}/upload/${dto.bfile}" alt="${dto.bfile}"/></p>   
	   
	<%--	<p>이미지 &nbsp; : <img src="/upload/${dto.bfile}" alt="${dto.bfile}"/></p>  --%>
	  </div>		
	<div class="text-right"    >
		 <a href="<%=request.getContextPath()%>/edit_view.do?bno=<%=dto.getBno()%>"  class="btn btn-default" style="color:white; background:#ff6e61;" >수정</a> 
		 <a href="<%=request.getContextPath()%>/delete_view.do?bno=<%=dto.getBno()%>"  class="btn btn-default" style="color:white; background:#ff6e61;" >삭제</a>    
		 <a href="<%=request.getContextPath()%>/list.do" class="btn btn-default" style="color:white; background:#ff6e61;" >목록보기</a> 
	</div>						 
</div>	
<%@ include file="../inc/footer.jsp" %>
