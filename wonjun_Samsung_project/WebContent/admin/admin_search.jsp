<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang ="ko">
<head>
<meta charset="UTF-8">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" 
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>     
</head>
<body>
<%@ include  file="../inc/header_1.jsp" %>
<div class="container panel panel-info">
	<h3>회원정보 검색</h3>
	<div class="form-group row pull-right">
		<div class="col-sm-7">
		<input type="text"  id="search_name"  name="search_name" class="form-control" placeholder="이름을 입력하세요"  />
		</div>
		<div class="col-sm-5">
		<input type="button" class="btn btn-default" style="color:white; background:#ff6e61;" id ="search_name_btn"  value="검색"/>
		</div>
		<div class="col-sm-7">
		<input type="text"  id="search_id"  name="search_id" class="form-control" placeholder="아이디 입력하세요"  />
		</div>
		<div class="col-sm-5">
		<input type="button" class="btn btn-default" style="color:white; background:#ff6e61;" id ="search_id_btn"  value="검색"/>
		</div>		
	</div>
	<table class="table table-striped db1">
		<thead>
			<tr>
				<th scope="col">이름</th>
				<th scope="col">아이디</th>
				<th scope="col">이메일</th>
				<th scope="col">생년월일</th>
				<th scope="col">핸드폰번호</th>
				<th scope="col">우편번호</th>
				<th scope="col">주소</th>
				<th scope="col">가입날짜</th>
				
			</tr>
		</thead>
		<tbody>
		
		
		</tbody>		
	</table>
	<script>
	$(function(){
		$("#search_name_btn").on("click",function(){
			$(".db1 tbody").empty();
			$.ajax({
				url:"${pageContext.request.contextPath}/search.admin", type:"get", dataType:"json",
				data: { "search_name" : $("#search_name").val()  },
				
				success:function(data){ 
					//$(".result_direct").empty();3
					
					console.log('확인 : '+data);
					for(var i=0; i<data.length; i++){
						console.log(data[i]);
						var tr =$("<tr>");
						var td1 = $("<td>").html(data[i].name);						
						//var td2 = $("<td>").html(data[i].id);
						var td2 = $("<a>").attr("href", "<%=request.getContextPath()%>/detail.admin?cno="+data[i].no).html("<td>" + data[i].id);			
						//var td2 = $("<a href='<%=request.getContextPath()%>/detail.admin?cno="+data[i].no+"'>+"+"<td>").html(data[i].id);
						var td3 = $("<td>").html(data[i].email);
						var td4 = $("<td>").html(data[i].birth);	
						var td5 = $("<td>").html(data[i].phone);
						var td6 = $("<td>").html(data[i].postcode);
						var td7 = $("<td>").html(data[i].post1+" "+data[i].post2);
						var td8 = $("<td>").html(data[i].date);
						  //end for
										
						tr.append(td1).append(td2).append(td3).append(td4).append(td5).append(td6).append(td7).append(td8);
						$(".db1 tbody").append(tr); 
					}//end for
					
				},
				error:function(xhr, textStatus, errorThrown ){  
					$(".db1 tbody").html(textStatus + "(HTTP-" +xhr.status +"/" +errorThrown);
				}	
	
			});//end ajax
		});//end click
	});//end ready
	$(function(){
		$("#search_id_btn").on("click",function(){
			$(".db1 tbody").empty();
			$.ajax({
				url:"${pageContext.request.contextPath}/search_id.admin", type:"get", dataType:"json",
				data: { "search_id" : $("#search_id").val()  },
				
				success:function(data){ 
					//$(".result_direct").empty();3
					console.log('확인 : '+data);
					for(var i=0; i<data.length; i++){
						console.log(data[i]);
						var tr =$("<tr>");
						var td1 = $("<td>").html(data[i].name);
						var td2 = $("<td>").html(data[i].id);
						var td3 = $("<td>").html(data[i].email);
						var td4 = $("<td>").html(data[i].birth);	
						var td5 = $("<td>").html(data[i].phone);
						var td6 = $("<td>").html(data[i].postcode);
						var td7 = $("<td>").html(data[i].post1+" "+data[i].post2);
						var td8 = $("<td>").html(data[i].date);
						  //end for
										
						tr.append(td1).append(td2).append(td3).append(td4).append(td5).append(td6).append(td7).append(td8);
						$(".db1 tbody").append(tr); 
					}//end for
					
				},
				error:function(xhr, textStatus, errorThrown ){  
					$(".db1 tbody").html(textStatus + "(HTTP-" +xhr.status +"/" +errorThrown);
				}	
	
			});//end ajax
		});//end click
	});//end ready	
	</script>
	<div align="center">
	<a href="<%=request.getContextPath()%>/start.customer" class="btn btn-default" style="color:white; background:#ff6e61;text-align: right;">메인페이지</a>
	</div>
</div>	<!-- end container -->

<%@ include  file="../inc/footer.jsp" %>
</body>
</html>