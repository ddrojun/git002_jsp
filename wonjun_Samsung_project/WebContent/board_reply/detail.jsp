<%@page import="com.alex0517.BoardDto.ReplyDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header_1.jsp" %>
<%@page import="java.sql.*"%>

<div class="container"  style="margin-top:2%; min-height:500px">
	<%
	ReplyDto dto = (ReplyDto)request.getAttribute("dto");
	%>
<% pageContext.setAttribute("newLineChar", "\n"); %>
	
	<h3>고객센터</h3>
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
	  	<p class="form-control" style="height: 400px"><%=dto.getBcontent().replace("\r\n", "<br>")%></p>   <!-- .replace("\r\n", "<br>")  -->
	</div>	
	<!--  -->		
	<div class="text-right" >
		 <a href="<%=request.getContextPath()%>/edit_view.replydo?bno=<%=dto.getBno()%>"  class="btn btn-default" style="color:white; background:#ff6e61;" >수정</a> 
		 <a href="<%=request.getContextPath()%>/delete_view.replydo?bno=<%=dto.getBno()%>"  class="btn btn-default" style="color:white; background:#ff6e61;" >삭제</a>    
	
 	<%--
      	if(session.getAttribute("aid") !=null){ --%>
		<%--  <a href="<%=request.getContextPath()%>/reply_view.replydo?bno=<%=dto.getBno()%>" class="btn btn-dark" style="background: black; color: white;" >답변</a> --%>
		<%--} --%>
		 <c:if test="${empty sessionScope.aid}">
		 	<script>
		 		$(function(){
		 			$("#replyBtn").on("click", function(){
		 				alert("관리자만 가능합니다.");
		 				return false;
		 			});
		 		});
		 	</script>
		 </c:if>
		 <a id="replyBtn" href="<%=request.getContextPath()%>/reply_view.replydo?bno=<%=dto.getBno()%>" class="btn btn-default" style="color:white; background:#ff6e61;" >답변</a> 
		 <a href="<%=request.getContextPath()%>/list.replydo" class="btn btn-default" style="color:white; background:#ff6e61;" >목록보기</a> 
	</div>						 
</div>	

