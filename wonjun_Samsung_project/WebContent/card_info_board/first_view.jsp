<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Latest compiled and minified CSS -->
<%@ include file="../inc/header_1.jsp" %>
<body>

<div class="container" style="margin-top:5%; text-align:center; min-height:500px">
	<h3 class="panel">투자정보</h3>
	<div >
		<div class="form-group" style="text-align: center">
			<a href="<%=request.getContextPath()%>/list.cardinfo">
			<input type="button" value="신용카드 상품약관" class="btn btn-default" style="color: black; font-weight:bold; 
			font-size: 2em; width: 60%" /></a>
		</div>	
		<!--  -->
		<div class="form-group" style="text-align: center">
			<a href="<%=request.getContextPath()%>/menual.cardinfo">
			<input type="button" value="공식이용 메뉴얼" class="btn btn-default" style="color: black;
			font-size: 2em; font-weight:bold; width: 60%" /></a>
		</div>	
		<!--  -->
		<div class="form-group" style="text-align: center">
			<a href="<%=request.getContextPath()%>/card_info_board/menual2.jsp">
			<input type="button" value="상품별 수수료율" class="btn btn-default" style="color: black;
			font-size: 2em;  font-weight:bold; width: 60%" /></a>
		</div>		
		<div class="form-group" style="text-align: center">
			<a href="<%=request.getContextPath()%>/card_info_board/menual3.jsp">
			<input type="button" value="신용카드 개인회원 약관" class="btn btn-default" style="color: black;
			font-size: 2em;  font-weight:bold; width: 60%" /></a>
		</div>		
		<div class="form-group" style="text-align: center">
			<a href="<%=request.getContextPath()%>/card_info_board/menual4.jsp">
			<input type="button" value="신용카드 가맹점 약관" class="btn btn-default" style="color: black;
			font-size: 2em;  font-weight:bold; width: 60%" /></a>
		</div>		
		<div class="form-group" style="text-align: center">
			<a href="<%=request.getContextPath()%>/card_info_board/menual5.jsp">
			<input type="button" value="신용카드 회원 분표 현황" class="btn btn-default" style="color: black;
			font-size: 2em;  font-weight:bold; width: 60%" /></a>
		</div>								
	</div> <!-- end container -->
</div>
<%@ include file="../inc/footer.jsp" %>
</body>
</html>