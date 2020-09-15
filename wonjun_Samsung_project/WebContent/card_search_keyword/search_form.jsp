<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include  file="../inc/header_1.jsp" %>
<hr style="font-weight:bolder">
	<!--  -->
	<!--  -->	
	<div class="container"  style="margin-top:2%; min-height:500px">
	<h3>키워드를 선택해주세요</h3>
	<!-- 카드번호 -->
	<div class="well">
	<div class="row" style="text-align: center;">
	<input type="button" value="삼성카드" 	id="card_id1" 	name ="samsung001" 		class="col-sm-2 btn btn-default idnum_keyword" />
	<input type="button" value="신한카드" 	id="card_id2"  	name ="sinhan" 			class="col-sm-2 btn btn-default idnum_keyword" />
	<input type="button" value="NH농협" 		id="card_id3"	name ="NH" 				class="col-sm-2 btn btn-default idnum_keyword" />
	<input type="button" value="롯데카드" 	id="card_id4"  	name ="LOTTE" 			class="col-sm-2 btn btn-default idnum_keyword" />
	<input type="button" value="우리카드"		id="card_id5" 	name ="woorie" 			class="col-sm-2 btn btn-default idnum_keyword" />
	<input type="button" value="현대카드" 	id="card_id6"  	name ="hyndai" 			class="col-sm-2 btn btn-default idnum_keyword" />
	<input type="button" value="우체국" 		id="card_id7" 	name ="post" 			class="col-sm-2 btn btn-default idnum_keyword" />
	<input type="button" value="카카오뱅크" 	id="card_id8"  	name ="kakao" 			class="col-sm-2 btn btn-default idnum_keyword" />
	<input type="button" value="KB국민" 		id="card_id9" 	name ="KB" 				class="col-sm-2 btn btn-default idnum_keyword" />			
	</div>
	</div>
	<!-- 성별 -->
	<div class="well">
	<div class="row" style="text-align: center;">
	<input type="button" value="전체" 	id="card_all" 	name ="전체" 	class="col-sm-2 btn btn-default gender_keyword" />
	<input type="button" value="남자" 	id="card_man"  	name ="남자" 	class="col-sm-2 btn btn-default gender_keyword" />
	<input type="button" value="여자" 	id="card_woman"	name ="여자" 	class="col-sm-2 btn btn-default gender_keyword" />
	</div>
	</div>
	<!-- 연령대 -->
	<div class="well">
	<div class="row" style="text-align: center;">
	<input type="button" value="20대" 		id="age_20" 	name ="20대" 		class="col-sm-2 btn btn-default age_keyword" />
	<input type="button" value="30대" 		id="age_30"  	name ="30대" 		class="col-sm-2 btn btn-default age_keyword" />
	<input type="button" value="40대이상" 	id="age_40"		name ="40대이상" 		class="col-sm-2 btn btn-default age_keyword" />	
	</div>
	</div>
	<!--신용 체크  -->
	<div class="well">
	<div class="row" style="text-align: center;">
	<input type="button" value="체크카드" 	id="check" 		name ="체크카드" 		class="col-sm-2 btn btn-default type1_keyword" />
	<input type="button" value="신용카드" 	id="credit"  	name ="신용카드" 		class="col-sm-2 btn btn-default type1_keyword" />
	</div>
	</div>
	<!--전체 할인 포인트 -->
	<div class="well">
	<div class="row" style="text-align: center;">
	<input type="button" value="전체" 	id="type2_all" 		name ="전체" 		class="col-sm-2 btn btn-default  type2_keyword" />
	<input type="button" value="할인" 	id="type2_dis"  	name ="할인" 		class="col-sm-2 btn btn-default  type2_keyword" />
	<input type="button" value="포인트" 	id="type2_point"	name ="포인트"		class="col-sm-2 btn btn-default type2_keyword" />
	</div>
	</div>
	<!-- 혜택 -->
		
	<!--  -->
	<table class="table table-striped db1">
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">카드이름</th>
			    <th scope="col">카드번호</th>
			    <th scope="col">성별</th>
			    <th scope="col">연령대</th>
			    <th scope="col">신용/체크</th>
			    <th scope="col">전체/할인/포인트</th>
			    <th scope="col">혜택</th>
			    <th scope="col">날짜</th>
			</tr>
		</thead>
		<caption>카드리스트</caption>
	<div class="form-group" style="text-align: right">
		<input type="button" class="btn btn-default" value="메인페이지" style="color:white; background:#ff6e61;" onclick="location.href='<%=request.getContextPath()%>/start.customer'" /> 
		<input type="button" class="btn btn-default " value="초기화" style="color:white; background:#ff6e61;" onclick="window.location.reload()" />
	</div>			
			<tbody>
			<!-- 키워드 검색 결과값 -->			
			</tbody>
	</table>						
<!--  -->
<!--  -->	
	<script>
	$(function(){
		$(".idnum_keyword").click(function(){
			$(".idnum_keyword").removeClass("wj_active");	//추가	클릭했을때  색변화
			$(this).addClass("wj_active");						//추가	클릭했을땨 색변화
			$.ajax({
				url:"${pageContext.request.contextPath}/search.keyword", type:"get", dataType:"text",
				data: { card_id : $(this).val()  },
				success:function(data){
					$(".db1 tbody").html(data); 
				},
				error:function(xhr, textStatus, errorThrown ){  
					$(".db1 tbody").html(textStatus + "(HTTP-" +xhr.status +"/" +errorThrown);
				}	
	
			});//end ajax
		});//end click
		//////////////////		
	});//end ready
	$(function(){
		$(".gender_keyword").click(function(){
			$(".gender_keyword").removeClass("wj_active");	//추가	클릭했을때  색변화
			$(this).addClass("wj_active");						//추가	클릭했을땨 색변화
			$.ajax({
				url:"${pageContext.request.contextPath}/search_gender.keyword", type:"get", dataType:"text",
				data: { gender : $(this).val()  },
				success:function(data){
					$(".db1 tbody").html(data); 
				},
				error:function(xhr, textStatus, errorThrown ){  
					$(".db1 tbody").html(textStatus + "(HTTP-" +xhr.status +"/" +errorThrown);
				}	
	
			});//end ajax
		});//end click	
		//////////////////		
	});//end ready	
	$(function(){
		$(".age_keyword").click(function(){
			$(".age_keyword").removeClass("wj_active");	//추가	클릭했을때  색변화
			$(this).addClass("wj_active");						//추가	클릭했을땨 색변화
			$.ajax({
				url:"${pageContext.request.contextPath}/search_age.keyword", type:"get", dataType:"text",
				data: { age : $(this).val()  },
				success:function(data){
					$(".db1 tbody").html(data); 
				},
				error:function(xhr, textStatus, errorThrown ){  
					$(".db1 tbody").html(textStatus + "(HTTP-" +xhr.status +"/" +errorThrown);
				}	
	
			});//end ajax
		});//end click	
		//////////////////		
	});//end ready	
	$(function(){
		$(".type1_keyword").click(function(){
			$(".type1_keyword").removeClass("wj_active");	//추가	클릭했을때  색변화
			$(this).addClass("wj_active");						//추가	클릭했을땨 색변화
			$.ajax({
				url:"${pageContext.request.contextPath}/search_type1.keyword", type:"get", dataType:"text",
				data: { type1 : $(this).val()  },
				success:function(data){
					$(".db1 tbody").html(data); 
				},
				error:function(xhr, textStatus, errorThrown ){  
					$(".db1 tbody").html(textStatus + "(HTTP-" +xhr.status +"/" +errorThrown);
				}	
	
			});//end ajax
		});//end click	
		//////////////////		
	});//end ready	
	$(function(){
		$(".type2_keyword").click(function(){
			$(".type2_keyword").removeClass("wj_active");		//추가	클릭했을때  색변화
			$(this).addClass("wj_active");						//추가	클릭했을땨 색변화
			$.ajax({
				url:"${pageContext.request.contextPath}/search_type2.keyword", type:"get", dataType:"text",
				data: { type2 : $(this).val()  },
				success:function(data){
					$(".db1 tbody").html(data); 
				},
				error:function(xhr, textStatus, errorThrown ){  
					$(".db1 tbody").html(textStatus + "(HTTP-" +xhr.status +"/" +errorThrown);
				}	
	
			});//end ajax
		});//end click	
		//////////////////		
	});//end ready		
	</script>
	</div> <!-- end container -->
	
 <%@ include file="../inc/footer.jsp" %>

</html>

