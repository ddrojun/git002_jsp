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
<%@ include  file="/inc/header_1.jsp" %>
		<%
		    String mid = (String)session.getAttribute("cid");
			String remember = "";
			String id = "";
			//1. 쿠키존재하는지확인
		    String cookie = request.getHeader("Cookie");
			//2. 쿠키값가져오기
			if(  cookie != null){
				Cookie  []cookies = request.getCookies();  
				for(int i=0;  i<cookies.length;  i++){   
					if(cookies[i].getName().equals("remember")){  
						remember = cookies[i].getValue();  
					}
					if(cookies[i].getName().equals("cid")){  
						id = cookies[i].getValue();  
					}				
				}
			}
		%>	
		<%
		session.setAttribute("mid", mid);
		%>
	<div class="container"   style="margin-top:5%">	
		<form action="<%=request.getContextPath()%>/write.cardinfo"  method="post"  id="add">
			<fieldset>
			<legend>카드추가</legend>
				<div class="form-group">
					<label for="name">NAME</label>
					<input type="text"  id="name"  name="name"  placeholder="카드이름 입력하세요"   class="form-control" />
				</div> <!--  end group -->
				<div class="form-group">
					<label for="idnum">IdNUM</label>
					<input type="text"  id="idnum"  name="idnum"  placeholder="ex)카드회사명001"   class="form-control" />
				</div> <!--  end group -->
				<div class="form-group">
					<label for="gender">Gender</label>
					<input type="text"  id="gender"  name="gender"  placeholder="ex)전체,남자,여자"   class="form-control" />
				</div> <!--  end group -->	
				<div class="form-group">
					<label for="age">Age</label>
					<input type="text"  id="age"  name="age"  placeholder="ex)20대,30대,40대이상"   class="form-control" />
				</div> <!--  end group -->
				<div class="form-group">
					<label for="type1">Type1</label>
					<input type="text"  id="type1"  name="type1"  placeholder="ex)체크카드,신용카드"   class="form-control" />
				</div> <!--  end group -->
				<div class="form-group">
					<label for="type2">Type2</label>
					<input type="text"  id="type2"  name="type2"  placeholder="ex)전체,할인,포인트"   class="form-control" />
				</div> <!--  end group -->	
				<div class="form-group">
					<label for="benefit">Benefit</label>
					<input type="text"  id="benefit"  name="benefit"  placeholder="ex)1,2,3..."   class="form-control" />
				</div> <!--  end group -->		
	<!-- 			<div class="form-group">
					<label for="ip">Ip</label>
					<input type="text"  id="ip"  name="ip"  placeholder="ex) 127.0.0.0"   class="form-control" />
				</div> <!--  end group -->   
				 
				<div class="form-group">
					<label for="writer">Writer</label>
					<input type="text"  id="writer"  name="writer"  placeholder="ex)admin"   class="form-control" />
				</div> <!--  end group -->		
				<div class="form-group">
					<label for="pic">Pic</label>
					<input type="text"  id="pic"  name="pic"  placeholder="ex)card_1.png, card_2.png"   class="form-control" />
				</div> <!--  end group -->																											
				<div class="form-group  text-right">
					<input type="submit"  class="btn btn-dark"  style="background: black; color: white;" value="카드추가"  />
					<a href="<%=request.getContextPath()%>/list.cardinfo"  class="btn btn-dark" style="background: black; color: white;">뒤로</a>  
				</div> <!--  end group -->
			</fieldset>
		</form>
	</div>
	<script>
	$(document).ready(function(){
		$("#add").submit(function(){
			if( $("#name").val() ==""   ){  alert("빈칸입니다\n확인해주세요");   $("#name").focus();  return false; }
			if( $("#idnum").val() ==""   ){  alert("빈칸입니다\n확인해주세요");   $("#idnum").focus();  return false; } 
			if( $("#gender").val() ==""   ){  alert("빈칸입니다\n확인해주세요");   $("#gender").focus();  return false; } 
			if( $("#age").val() ==""   ){  alert("빈칸입니다\n확인해주세요");   $("#age").focus();  return false; } 
			if( $("#type1").val() ==""   ){  alert("빈칸입니다\n확인해주세요");   $("#type1").focus();  return false; } 
			if( $("#type2").val() ==""   ){  alert("빈칸입니다\n확인해주세요");   $("#type2").focus();  return false; } 
			if( $("#benefit").val() ==""   ){  alert("빈칸입니다\n확인해주세요");   $("#benefit").focus();  return false; } 
			if( $("#writer").val() ==""   ){  alert("빈칸입니다\n확인해주세요");   $("#writer").focus();  return false; } 
			
		});
	});
</script>	
<%@ include  file="/inc/footer.jsp" %>
</body>
</html>