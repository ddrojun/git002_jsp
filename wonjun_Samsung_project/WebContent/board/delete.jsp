<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header_1.jsp" %>

<div class="container"  style="margin-top:2%; min-height:500px">
		<h3>자유게시판</h3>
		<form action="<%=request.getContextPath()%>/delete.do?bno=<%=request.getParameter("bno")%>" method="post"   id="deleteForm"> 
			<div class="form-group">
			  <label for="bpass"  >비밀번호</label>
			  <input type="password"   name="bpass"   id="bpass"   class="form-control" > 
			  <span>(*) 삭제시 필수입니다. </span>
			</div>
			<div class="form-group">
				<input type="submit" value=" 확인 "   class="btn btn-default" style="color:white; background:#ff6e61;" />
				<input type="reset"   onclick="history.go(-1);" value="취소" class="btn btn-default" style="color:white; background:#ff6e61;"  >  
			</div>	
		</form>
</div>
<script>
	jQuery(document).ready(function(){
		jQuery("#deleteForm").submit(function(){
			if(jQuery("#bpass").val()==""){
				alert("비밀번호을 입력해주세요");
				jQuery("#bpass").focus();
				return false;
			}
		});
	});
</script>
<%@ include file="../inc/footer.jsp" %>