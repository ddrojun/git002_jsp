<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../inc/header_1.jsp" %>
<body>
<div class="container" style="margin-top: 5%">
		<div>
		<h3>공식이용 메뉴얼</h3>	
		  <textarea cols="200" rows="20" id="agreement1" class="form-control" title="공식이용 메뉴얼" 
		  readonly="readonly" disabled="disabled"><%@ include file="agree1.txt" %></textarea>
		</div><!-- form-group  END -->	
</div> <!-- end container -->
<%@ include  file="../inc/footer.jsp" %>
</body>