<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include  file="../inc/header_1.jsp" %>
<div class="container"   style="margin-top: 5%"> 
  <h3>약관 및 개인정보 필수, 선택 동의</h3>  
		<h4  class="col-sm-11">WONJUN_CARD 서비스 약관 동의</h4>
		<div class="col-sm-1  text-right">
			<input type="checkbox" name="agree" id="agree1" title="Company 서비스 약관 동의 체크박스입니다." class="form-control">
		</div> 
		<div>	
		  <textarea cols="60" rows="10" id="agreement1" class="form-control" title=" 이용약관동의입니다." 
		  readonly="readonly" disabled="disabled"><%@ include  file="agree1.txt" %></textarea>
		</div><!-- form-group  END -->
 		<hr/>
		<h4   class="col-sm-11"> WONJUN_CARD 개인정보 수집 및 이용 동의</h4> 
		<div class="col-sm-1 text-right">
			<input type="checkbox" name="agree" id="agree2" title="Company 개인정보 수집 및 이용 동의 체크박스입니다." class="form-control">
		</div> 
		<div>	
		  <textarea cols="60" rows="10" id="agreement2" class="form-control" title=" 이용약관동의입니다." 
		  readonly="readonly" disabled="disabled"> <%@ include  file="agree2.txt" %></textarea>
		 </div>	 
	 
	<!--  -->
</div>	
<br/>
<br/>
	<div class="container" >
		<form  action="<%=request.getContextPath()%>/join.customer" method="post"  id="join2">
			<fieldset>
			<legend>필수정보입력</legend>
			<div class="form-group">
				<div class="form-group">
					<label for="cname" style="font-size: 18px">이름</label> <%if(request.getAttribute("nickname")!=null) {%> <input type="text" id="cname" name="cname" placeholder="이름 입력해주세요" class="form-control" value="<%=request.getAttribute("nickname")%>"/><% } else {%>
												<input type="text" id="cname" name="cname" placeholder="이름 입력해주세요" class="form-control" /> <% } %>
				</div> <!-- end group -->
				<!--  -->					
					<label for="cid" style="font-size: 18px">아이디</label> <input type="text"  id="cid"  name="cid"  placeholder="아이디를입력해주세요." class="form-control" />
					<input type="button"  class="btn btn-default" style="color:white; background:#ff6e61;"  value="중복체크" id="idtest"  /> <P id="iddouble" style="font-weight: bold; color:green;" >아이디 중복확인 여부를 하셔야합니다.</P>
				</div> <!-- end group -->
		<!-- 		<div id="iddouble" >아이디 중복확인 여부를 하셔야합니다.</div>   -->
				<!--  -->
				<div class="form-group">
					<label for="cpass" style="font-size: 18px">비밀번호</label> <input type="password"  id="cpass"  name="cpass"  placeholder="비밀번호를 입력해주세요" class="form-control"/>
				</div> <!-- end group -->
				<div class="form-group">
					<label for="cpassre" style="font-size: 18px">비밀번호 확인</label> <input type="password"  id="cpassre"  name="cpassre"  placeholder="비밀번호를 입력해주세요"  class="form-control"/>
				</div> <!-- end group -->
				<div class="form-group">
					<label for="cbirth" style="font-size: 18px">생년월일</label> <input type="date"  id="cbirth"  name="cbirth"  placeholder="생년월일을 입력해주세요."  class="form-control" />
				</div> <!-- end group -->
				<div class="form-group">
					<label for="cphone" style="font-size: 18px">휴대전화번호</label> <input type="tel" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"  maxlength="13" id="cphone"  name="cphone" 
					 placeholder="예) 010-1234-5678"  class="form-control" />
				</div> <!-- end group -->								
				<div class="form-group">
					<label for="cemail" style="font-size: 18px">이메일</label><%if(request.getAttribute("email")!=null) {%><input type="email"  id="cemail"  name="cemail"  placeholder="이메일을 입력해주세요 "  class="form-control" value="<%=request.getAttribute("email")%>" /> <% } else {%> 
										 <input type="email"  id="cemail"  name="cemail"  placeholder="이메일을 입력해주세요 "  class="form-control" />   <%} %>
				</div> <!-- end group -->
				<!--  -->
				<h3>우편번호 검색</h3>
			<div class="row">	
				<div class="col-sm-2">
					<label for="postcode">우편번호</label>		
				</div>
				<div class="col-sm-4">
					<input type="text" id="postcode" name="postcode" class="form-control" placeholder="우편번호 입력해주세요" />
				</div>
				<div class="col-sm-6">
					<input type="button" id="post" value="우편번호" class="btn btn-default" style="color:white; background:#ff6e61;"  />
				</div>
			</div> <!-- end row -->
			<div class="row">
		<div class="col-sm-2">
			<label for="address">상세주소</label>		
		</div>
		<div class="col-sm-4">
			<input type="text" id="address" name="address" class="form-control" placeholder="주소" />
		</div>
		<div class="col-sm-6">
			<input type="text" id="address2" name="address2" class="form-control" placeholder="상세주소 입력해주세요" />
		</div>
	</div> <!-- end row -->		
				<br/>
				
				<!--  -->
				<div class="form-group"> 
					<input type="submit" value="회원가입하러가기" class="btn btn-default form-control" style="color:white; background:#ff6e61;"/>
				</div> <!-- end group -->
				<div class="form-group text-center"> 
					<input type="button"   onclick="history.go(-1);" value="뒤로가기" class="btn btn-default form-control" style="color:white; background:#ff6e61;"  >
				</div> <!-- end group -->				
			</fieldset>
			</form>
		</div>
	<script>
	$(document).ready(function(){
		$("#join2").submit(function(){
			if( $("#agree1:checked").length == 0 ){ alert("약관에 동의하셔야합니다.");  $("#agree1").focus(); return false; }
			if( $("#agree2:checked").length == 0 ){ alert("약관에 동의하셔야합니다."); $("#agree2").focus(); return false; }
			///
			if( $("#cname").val() ==""   ){  alert("[이름]빈칸입니다\n확인해주세요");   $("#cid").focus();  return false; }
			//if( $("#cid").val() ==""   ){  alert("[아이디]빈칸입니다\n확인해주세요");   $("#cname").focus();  return false; }
			if( $("#cpass").val() ==""   ){  alert("[비밀번호]빈칸입니다\n확인해주세요");   $("#cpass").focus();  return false; }
			if( $("#cpassre").val() ==""   ){  alert("[비밀번호 확인]빈칸입니다\n확인해주세요");   $("#cpassre").focus();  return false; }
			if( $("#cbirth").val() ==""   ){  alert("[생년원일]빈칸입니다\n확인해주세요");   $("#cpassre").focus();  return false; }
			if( $("#cphone").val() ==""   ){  alert("[휴대전화번호]빈칸입니다\n확인해주세요");   $("#cpassre").focus();  return false; }
			if( $("#cpass").val() !=   $("#cpassre").val() ){  alert("비밀번호가 다릅니다.\n확인해주세요");   $("#cpass").focus();  return false; }
			if( $("#cemail").val() ==""   ){  alert("[이메일]빈칸입니다\n확인해주세요");   $("#cemail").focus();  return false; }
			if( $("#postcode").val() ==""   ){  alert("[우편번호]빈칸입니다\n확인해주세요");   $("#postcode").focus();  return false; }
			if( $("#address").val() ==""   ){  alert("[주소]빈칸입니다\n확인해주세요");   $("#address2").focus();  return false; }
			if( $("#address2").val() ==""   ){  alert("[상세주소]빈칸입니다\n확인해주세요");   $("#address2").focus();  return false; }
		});
	});
///////////////////////
	$(function(){
		$("#idtest").click(function() {
			if($("#cid").val()=="" ){
				$("#cid").focus();
				return false;
			}//end if
			else{
			$.ajax({
				url:"${pageContext.request.contextPath}/Gson_id_double_1", type:"get", dataType:"json",
				data : {"cid" : $("#cid").val()  },
				success:function(db){
					var data ="<span style='color:blue'>" +db.data +"</span>";
					if(db.data =="사용불가"){
						data = "<span style='color:red'>" +db.data +"</span>";
						}//end if
						$("#iddouble").html(data);
				},  //end success
				error:function(xhr, textStatus, errorThrown ){
					$("#iddouble").html(textStatus + "(HTTP-" +xhr.status +"/" +errorThrown);
					
				}});//end error
			}//end ajax 
			
		});//end click
	});//end ready
	
	
</script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	$(function(){
		$("#post").click(function(){
			new daum.Postcode({
				oncomplete: function(data){			//oncomplete : 우편번호 검색 목록에서 특정항목 클린한 경우 콜백 함수를 정의하는 부분
					console.log(data);
					console.log(data.zonecode);
					console.log(data.address);
					$("#postcode").val(data.zonecode);
					$("#address").val(data.address);
					$("#address2").focus();
				}
			}).open();
		});
	});

</script>
<%@ include  file="../inc/footer.jsp" %>

