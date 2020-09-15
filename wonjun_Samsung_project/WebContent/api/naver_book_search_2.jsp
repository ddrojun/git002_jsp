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
	<div class="container">
	<h3 class="panel-heading">NAVER BOOK / CARD SEARCH</h3>
		<div class="form-group">
			<label for="search_book">책 검색</label>
			<input type="text"  id="search_book" name="search_book" placeholder="검색어를 적어주세요" class="form-control" />
		</div> <!--  end group -->
		<div class="form-group  text-right">
			<input type="button"  class="btn btn-info" id="search_btn" name="search_btn" value="검색" style="background:#ff6e61; color:white; " />
		</div> <!--  end group -->
	<div class="r1">	
		 
	</div>	
<!-- 	<div id="test"></div>	 -->
	<script>
		$(function(){
			$("#search_btn").on("click", function(){
				$.ajax({
					url:"${pageContext.request.contextPath}/Naver_Search_Book", type:"get", dataType:"json",
					data: { "search_book" : $("#search_book").val() },
					success:function(data){
					console.log(data);
					$(".r1").empty();
						//console.log(data.items);
						var items = data.items;
						console.log(items);
						for(var i=0; i<items.length; i++){
							var row = $('<div class="row">');
							var div4 =$('<div class="col-sm-4">').html('<img src="'+items[i].image+'" alt="" /> ');
							var div8 =$('<div class="col-sm-8">').html(
								'<a href="#"><p>'+items[i].title 
								+'</p><p>'+items[i].author
								+'</p><p>'+items[i].pubdate
								+'</p><p>'+items[i].price
								+'</p></a>');
							row.append(div4).append(div8); 
							$(".r1").append(row);

						}//end for
					}, //end success
					error:function(xhr, textStatus, errorThrown){
						//$(".r2").html(textStatus + "(HTTP-"+xhr.status +"/" +errorThrown);
					}//end error
			});
		});
	});
	</script>	
		
		
	</div>	<!-- end container -->
</body>
</html>