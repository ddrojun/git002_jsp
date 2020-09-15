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
	<h3>NAVER Shopping / 카드로 쇼핑할시간</h3>
		<div class="form-group">
			<label for="search_shopping">쇼핑 검색</label>
			<input type="text"  id="search_shopping" name="search_shopping" placeholder="OO을 검색해보세요." class="form-control" />
		</div> <!--  end group -->
		<div class="form-group text-right">
			<input type="button"  class="btn-btn-default form-control" value="쇼핑검색" style="color:white; background:#ff6e61;" id="shopping_btn" name="shopping_btn"/>
		</div> <!--  end group -->
	<div class="r10">	
		
	</div>	
	</div>	<!-- end container -->
<!-- 	<div id="test"></div>	 -->
	<script>
		$(function(){
			$("#shopping_btn").on("click", function(){
				$.ajax({
					url:"${pageContext.request.contextPath}/Naver_Search_Shopping", type:"get", dataType:"json",
					data: { "search_shopping" : $("#search_shopping").val() },
					success:function(data){
					console.log(data);
					$(".r10").empty();
						//console.log(data.items);
						var items = data.items;
						console.log(items);
						for(var i=0; i<items.length; i++){
							var row = $('<div class="container row col-sm-6">').css({"border":"1px solid #ddd"})						
							var div4 =$('<div class="col-sm-4">').css({"height":"150px"}).html('<img src="'+items[i].image+'" alt=" "  style="width:150px; height:150px;"/>');
							var div8 =$('<div class="col-sm-8">').css({"height":"150px"}).html(
								+'<p></p>'+"쇼핑몰 : "+items[i].mallName
								+'<a href='+items[i].link+'><p>'+items[i].link +'</a></p>'
								+'<p></p>'+"최고가격 : "+items[i].hprice		
								+'<p></p>'+"최저가격 : "+items[i].lprice
								+'<p></p>'+"상품ID : "+items[i].productId
									
								);
	//								+("<a>").attr("href", items[i].mallName).html("<p>" + items[i].mallName + "</p>")	
	//								+'</p><p>'+"상품ID : "+items[i].productId
							row.append(div4).append(div8); 
							$(".r10").append(row);

						}//end for
					}, //end success
					error:function(xhr, textStatus, errorThrown){
						//$(".r2").html(textStatus + "(HTTP-"+xhr.status +"/" +errorThrown);
					}//end error
			});
		});
	});
	</script>	
		
		
	
</body>
</html>