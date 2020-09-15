<%@page import="com.alex0517.BoardDto.ReplyDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include  file="../inc/header_1.jsp" %>
<!--  END HEADER -->
<!--  END HEADER -->
<!--  END HEADER -->
	<%	
	ReplyDto dto = (ReplyDto)request.getAttribute("dto");
	%>
<%@page import="java.sql.*"%>

<div class="container"  style="margin-top:2%; min-height:500px"   >
	<h3>고객센터 </h3>
		<form action="<%=request.getContextPath()%>/reply.replydo?bno=${dto.bno}" method="post"  id="reply_Form" >
		   <fieldset>
		   <legend>	답변글 달기</legend>
			<div class="form-group">
			  <label for="bname"  >이름</label>
			  <input type="text"   name="bname"   id="bname"   class="form-control"  value="${dto.bname}">   
			</div>			
			<div class="form-group">
			  <label for="bpass"  >비밀번호</label>
			  <input type="password"   name="bpass"   id="bpass"   class="form-control" > 
			  <span>(*) 수정, 삭제시 필수</span>
			</div>																
			<div class="form-group">
			  <label for="btitle"  >제목</label>
			  <input type="text"   name="btitle"   id="btitle"   class="form-control"   value="${dto.btitle}"> 
			</div>	
			<div class="form-group">
			  <label for="bcontent"  >내용</label>
			  <textarea name="bcontent"  id="bcontent"  cols="60"  rows="10"   class="form-control" >${dto.bcontent}</textarea>
			</div>								
			<div class="form-group  text-right">
				<input type="submit"   value="입력"   class="btn btn-default" style="color:white; background:#ff6e61;"  >  
				<input type="reset"    value="취소"  class="btn btn-default" style="color:white; background:#ff6e61;"    >  
				<a href="<%=request.getContextPath()%>/list.replydo" class="btn btn-default" style="color:white; background:#ff6e61;" >목록보기</a>
			</div>
		 </fieldset>		
		</form> <!-- end form -->	
</div>
<script>	
	jQuery(document).ready(function(){
		jQuery("#reply_Form").submit(function(){
			if(jQuery("#bname").val()==""){
				alert("이름을 입력하세요");
				$("#bname").focus();
				return false;
			}			
			if(jQuery("#bpass").val()==""){
				alert("비밀번호를 입력하세요");
				$("#bpass").focus();
				return false;
			}
			if(jQuery("#btitle").val()==""){
				alert("제목을 입력하세요");
				$("#btitle").focus();
				return false;
			}
			if(jQuery("#bcontent").val()==""){
				alert("내용을 입력하세요");
				$("#bcontent").focus();
				return false;
			}
		});
	});
</script>
<!-- END FOOTER -->
<!-- END FOOTER -->
<!-- END FOOTER -->
<!-- END FOOTER -->



