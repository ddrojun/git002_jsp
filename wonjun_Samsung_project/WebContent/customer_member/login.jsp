<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<h3>CARD</h3>	
		<p class="text-center"><img src="<%=request.getContextPath()%>/images/card_16.png"  alt="로그인화면입니다." /></p>
		<form action="<%=request.getContextPath()%>/login.customer"  method="post"  id="login">
			<fieldset>
			<legend>LOGIN</legend>
				<div class="form-group">
					<label for="cid">아이디</label>
					<input type="text"  id="cid"  name="cid"  placeholder="아이디를입력하세요"   class="form-control" 
						<% if(remember.equals("remember")){ %> value="<%=id%>"  <% } %>
					 />
				</div> <!--  end group -->
				<div class="form-group">
					<label for="cpass">비밀번호</label>
					<input type="password"  id="cpass"    name="cpass"  placeholder="비밀번호를 입력해주세요"   class="form-control"  />
				</div> <!--  end group -->
				<div class="form-group">
					<input type="checkbox"  id="remember"    name="remember" 
						<% if(remember.equals("remember")){ %> checked <% } %> />
					<label for="remember">아이디기억하기</label>
				</div> <!--  end group -->
				<div class="form-group  text-right">
					<input type="submit"  value="로그인"  class="btn btn-default" style="color:white; background:#ff6e61;" />
					<input type="button" value="회원가입"   class="btn btn-default" style="color:white; background:#ff6e61;" onclick="location.href='<%=request.getContextPath()%>/join_agree.customer'"  />
		<!-- <a href="<%=request.getContextPath()%>/join_agree.customer"  class="btn btn-default" style="background:#ff6e61;">회원가입</a>  	 -->
				</div> <!--  end group -->
			</fieldset>
		</form>
	</div>
	<script>
	$(document).ready(function(){
		$("#login").submit(function(){
			if( $("#cid").val() ==""   ){  alert("빈칸입니다\n확인해주세요");   $("#mid").focus();  return false; }
			if( $("#cpass").val() ==""   ){  alert("빈칸입니다\n확인해주세요");   $("#mpass").focus();  return false; } 
		});
	});
</script>	
<%@ include  file="/inc/footer.jsp" %>

