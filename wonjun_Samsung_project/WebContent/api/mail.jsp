<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../inc/header_1.jsp"%>
<body>
<div class="container panel panel-warning" style="margin-top: 2%">
	<h2>고객문의 접수</h2>
<!-- 	
	<pre>
	1.naver - 환경설정 : smtp
	2. javax.mail api - http://www.javadoc.io/doc/javax.mail/javax.mail-api/1.4.7/index.html
	3. https://mvnrepository.com/artifact/javax.mail/mail/1.4.7   -	[lib]
	3. https://ckeditor.com/ckeditor-4/download/
	</pre>  -->
 
	<form action="${pageContext.request.contextPath}/MyMail" method="post" >
	<fieldset>
	<legend>관리자에게 메일보내기 (alex0517@hanmail.net)</legend>
	<div>
<%--	<a href="<%=request.getContextPath()%>/start.customer" class="btn btn-default" style="color:white; background:#ff6e61;" >◀</a>	 --%>
	</div>
	<div class="row form-group">
		<div class="col-sm-3">
			<label for="email">답변받을 EMAIL</label>
		</div>
		<div class="col-sm-9">
			<input type="text" id="email" name="email" class="form-control"  />
		</div>		
	</div> <!-- end row -->		
	<div class="row form-group">
		<div class="col-sm-3">
			<label for="subject">TITLE</label>
		</div>
		<div class="col-sm-9">
			<input type="text" id="subject" name="subject" class="form-control"  />
		</div>		
	</div> <!-- end row -->	
	<div class="row form-group">
		<div class="col-sm-3">
			<label for="content">CONTENT</label>
		</div>
		<div class="col-sm-9">
			<textarea id="content" name="content" class="form-control" rows="10" cols="80" ></textarea>
		</div>			
	</div> <!-- end row -->
	<div class="row form-group">
		<div class="col-sm-3">
			
		</div>
		<div class="col-sm-9">
			<input type="submit" value="메일발송하기" class="form-control btn btn-default" style="color:white; background:#ff6e61;"  />
		</div>			
	</div> <!-- end row -->	
	</fieldset>
	</form>
	<script src="https://cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>	
	 <script>CKEDITOR.replace('content');</script>	
	
</div> <!-- end container -->	
<%@ include  file="../inc/footer.jsp" %>
</body>