<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include  file="../inc/header_1.jsp" %>

<br/>
<br/>
<br/>
<br/>
<hr style="font-weight:bolder">
	<div class="container">
		<div class="row r1">
		<div class="col-sm-9">
			<h3>카드검색</h3>
		</div>
		<div class="col-sm-3">
		</div>
		</div>
	<!--  -->	
	<div class="well">
		<h3>성별을 선택하세요 (*필수)</h3> 
		<div class="row r2" style="margin-top:5%;">
			<input type="button" value="전체" 	id="all_gender" name ="전체" class="col-sm-2 btn btn-default gender_condition" />
			<input type="button" value="남자" 	id="man" 		name ="남자" class="col-sm-2 btn btn-default gender_condition" />
			<input type="button" value="여자" 	id="woman"	 	name ="여지" class="col-sm-2 btn btn-default gender_condition" />
			<input type="hidden" id="gender_hidden" name="gender_hidden"   />
		</div>
	</div>	
	<div class="well">
		<h3>연령대를 선택하세요 (*필수)</h3>
		<div class="row r2" style="margin-top:5%;">
			<input type="button" value="20대" 		id="age_20" name ="20대" 	class="col-sm-2 btn btn-default age_condition" />
			<input type="button" value="30대" 		id="age_30" name ="30대" 	class="col-sm-2 btn btn-default age_condition" />
			<input type="button" value="40대이상" 	id="age_40" name ="40대이상" class="col-sm-2 btn btn-default age_condition" />	
			<input type ="hidden" id="age_hidden" name="age_hidden"/>	
		</div> 
	</div>
	<div class="well">
		<h3>카드사 선택하세요 (*필수)</h3>
		<div class="row r2" style="margin-top:5%">
			<input type="button" value="삼성카드" 	id="card_id1" 	name ="삼성카드" 		class="col-sm-2 btn btn-default idnum_condition" />
			<input type="button" value="신한카드" 	id="card_id2"  	name ="신한카드" 		class="col-sm-2 btn btn-default idnum_condition" />
			<input type="button" value="NH농협" 		id="card_id3"	name ="NH농협" 		class="col-sm-2 btn btn-default idnum_condition" />
			<input type="button" value="롯데카드" 	id="card_id4"  	name ="롯데카드" 		class="col-sm-2 btn btn-default idnum_condition" />
			<input type="button" value="우리카드"		id="card_id5" 	name ="우리카드" 		class="col-sm-2 btn btn-default idnum_condition" />
			<input type="button" value="현대카드" 	id="card_id6"  	name ="현대카드" 		class="col-sm-2 btn btn-default idnum_condition" />
			<input type="button" value="우체국" 		id="card_id7" 	name ="우체국" 		class="col-sm-2 btn btn-default idnum_condition" />
			<input type="button" value="카카오뱅크" 	id="card_id8"  	name ="카카오뱅크" 	class="col-sm-2 btn btn-default idnum_condition" />
			<input type="button" value="KB국민" 		id="card_id9" 	name ="KB국민" 		class="col-sm-2 btn btn-default idnum_condition" />	
			<input type="hidden" id="idnum_hidden" name="idnum_hidden" />		
		</div>						
	</div>		
	<div class="well">
		<h3>어떤종류의 카드를 원하시나요 (*필수)</h3>
		<div class="row r2" style="margin-top:5%">
		<input type="button" value="신용카드" 	id="check" name ="신용카드" 	class="col-sm-2 btn btn-default type1_condition" />
		<input type="button" value="체크카드" 	id="credit" name ="체크카드" 	class="col-sm-2 btn btn-default type1_condition" />
		<input type="hidden" id="type1_hidden" name="type1_hidden"   />
		</div>
	</div>	
	<div class="well">
		<h3>어떤 타입의 카드를 찾으시나요? (*필수)</h3>
		<div class="row r2" style="margin-top:5%">
		<input type="button" value="전체" 	id="type2_1" 	name ="신용카드" 	class="col-sm-2 btn btn-default type2_condition" />
		<input type="button" value="할인" 	id="type2_2" 	name ="할인" 	class="col-sm-2 btn btn-default type2_condition" />
		<input type="button" value="포인트" 	id="type2_3" 	name ="포인트" 	class="col-sm-2 btn btn-default type2_condition" />	
		<input type="hidden" id="type2_hidden" name="type2_hidden"  />	
		</div>
	</div>
	<div class="well">
		<h3>어떤 타입의 카드를 찾으시나요? (중복선택 가능)</h3>  <!-- benefit_condition -->
		<div class="row r2" style="margin-top:5%">
		<input type="button" value="주유" 		id="benefit_1" 	name ="주유" 	class="col-sm-2 btn btn-default oil_condition" />
		<input type="hidden" id="oil_hidden" name="oil_hidden" /> <!-- oil hidden -->
		<input type="button" value="영화" 		id="benefit_2" 	name ="영화" 	class="col-sm-2 btn btn-default movie_condition" />
		<input type ="hidden" id="movie_hidden"  name="movie_hidden"    />
		<input type="button" value="커피" 		id="benefit_3" 	name ="커피" 	class="col-sm-2 btn btn-default coffee_condition" />	
		<input type ="hidden" id="coffee_hidden"  name="coffee_hidden"    />
		<input type="button" value="교통" 	id="benefit_4" 	name ="교통" 	class="col-sm-2 btn btn-default transportation_condition" />
		<input type ="hidden" id="transportation_hidden"  name="transportation_hidden"    />
		<input type="button" value="항공" 		id="benefit_5" 	name ="항공" 	class="col-sm-2 btn btn-default air_condition" />
		<input type ="hidden" id="air_hidden"  name="air_hidden"    />
		<input type="button" value="쇼핑" 		id="benefit_6" 	name ="쇼핑" 	class="col-sm-2 btn btn-default shopping_condition" />	
		<input type ="hidden" id="shopping_hidden"  name="shopping_hidden"    />
		<input type="button" value="패스트푸드" 	id="benefit_7" 	name ="패스트푸드" class="col-sm-2 btn btn-default fastfood_condition" />
		<input type ="hidden" id="fastfood_hidden"  name="fastfood_hidden"    />
		<input type="button" value="휴대전화" 	id="benefit_8" 	name ="휴대전화" 	class="col-sm-2 btn btn-default phone_condition" />
		<input type ="hidden" id="phone_hidden"  name="phone_hidden"    />
		<input type="button" value="마트" 		id="benefit_9" 	name ="마트" 	class="col-sm-2 btn btn-default mart_condition" />		
		<input type ="hidden" id="mart_hidden"  name="mart_hidden"    />							
		</div>
	</div>	
	<div class="form-group  text-right">
<!-- <button onclick="location.href='<%=request.getContextPath()%>/search_result.condition'">카드검색</button>  -->
	<!-- 	<input type="submit"  class="btn btn-dark"  style="background: black; color: white;" value="카드검색"  />    -->
 <!--  	<a href="<%=request.getContextPath()%>/search_result.condition" class="btn btn-dark" style="background: black; color: white;">카드검색</a> 	  -->
	<input type="button" id="result" name="result" class="btn btn-default result_condition" value="추천결과"    />		
		<a href="<%=request.getContextPath()%>/start.customer"  class="btn btn-dark" style="background: black; color: white;">처음으로</a>  
		<a href="<%=request.getContextPath()%>/list.condition" class="btn btn-dark" style="background: black; color: white;" >초기화</a> 
	</div> 				
	
	<!--  -->
	<script>
	$(function(){
		var gender = "";
		$(".gender_condition").on("click",function(){
			console.log($(this).val());
			$(".gender_condition").removeClass("wj_active");
			$(this).addClass("wj_active");
			$("#gender_hidden").val($(this).val() );
		////////////////////////////////////////////////////		
			$.ajax({
				url:"${pageContext.request.contextPath}/search_gender.condition", type:"get", dataType:"text",
				data: { "gender_condition" : $(this).val()  },
				success:function(data){ 			
					
				},
				error:function(xhr, textStatus, errorThrown ){  
					//$(".db1 tbody").html(textStatus + "(HTTP-" +xhr.status +"/" +errorThrown);
				}	
			});//end ajax
		});//end click
		//////////////////		
	});//end ready
	$(function(){
		//var age=""
		$(".age_condition").on("click",function(){
			console.log($(this).val() );
			$(".age_condition").removeClass("wj_active");
			$(this).addClass("wj_active");
			$("#age_hidden").val($(this).val() );
			///////////
			$.ajax({
				url:"${pageContext.request.contextPath}/search_age.condition", type:"get", dataType:"text",
				data: { "age_condition" : $(this).val(), "gender_condition" : $("#gender_hidden").val()   },
				success:function(data){

				},
				error:function(xhr, textStatus, errorThrown ){  
					
				}	
			});//end ajax
		});//end click
		//////////////////		
	});//end ready	
	$(function(){
		var company=""
		$(".idnum_condition").on("click",function(){
			$(".idnum_condition").removeClass("wj_active");
			$(this).addClass("wj_active");
			$("#idnum_hidden").val($(this).val() );
			///////////
			$.ajax({
				url:"${pageContext.request.contextPath}/search_company.condition", type:"get", dataType:"text",
				data: { "idnum_condition" : $(this).val(), "gender_condition" : $("#gender_hidden").val(), 
						"age_condition" : $("#age_hidden").val()
				},
				success:function(data){

				},
				error:function(xhr, textStatus, errorThrown ){  
					//$(".db1 tbody").html(textStatus + "(HTTP-" +xhr.status +"/" +errorThrown);
				}	
			
			});//end ajax
		});//end click
		//////////////////		
	});//end ready	
	$(function(){
		var type1=""
		$(".type1_condition").on("click",function(){
			$(".type1_condition").removeClass("wj_active");
			$(this).addClass("wj_active");
			$("#type1_hidden").val($(this).val() );
			///////////
			$.ajax({
				url:"${pageContext.request.contextPath}/search_type1.condition", type:"get", dataType:"text",
				data: { "type1_condition" : $(this).val(), "gender_condition" : $("#gender_hidden").val(), 
						"age_condition" : $("#age_hidden").val(), "idnum_condition" : $("#idnum_hidden").val()
				},
				success:function(data){

				},
				error:function(xhr, textStatus, errorThrown ){  
					//$(".db1 tbody").html(textStatus + "(HTTP-" +xhr.status +"/" +errorThrown);
				}	
			
			});//end ajax
		});//end click
		//////////////////		
	});//end ready	
	$(function(){
		var type2=""
		$(".type2_condition").on("click",function(){
			$(".type2_condition").removeClass("wj_active");
			$(this).addClass("wj_active");
			$("#type2_hidden").val($(this).val() );
			///////////
			$.ajax({
				url:"${pageContext.request.contextPath}/search_type2.condition", type:"get", dataType:"text",
				data: { "type2_condition" : $(this).val(), "gender_condition" : $("#gender_hidden").val(), 
						"age_condition" : $("#age_hidden").val(), "idnum_condition" : $("#idnum_hidden").val(),
						"type1_condition" : $("#type1_hidden").val()
				},
				success:function(data){

				},
				error:function(xhr, textStatus, errorThrown ){  
					//$(".db1 tbody").html(textStatus + "(HTTP-" +xhr.status +"/" +errorThrown);
				}	
			
			});//end ajax
		});//end click
		//////////////////		
	});//end ready		
	//////////////////////////////////////////////혜택 선택
	$(function(){
		$(".oil_condition").on("click",function(){
			$(".oil_condition").removeClass("wj_active");
			$(this).addClass("wj_active");
			$("#oil_hidden").val($(this).val() );
			///////////
			$.ajax({
				//url:"${pageContext.request.contextPath}/search_oil.condition", type:"get", dataType:"text",
				url:"${pageContext.request.contextPath}/search_benefit.condition", type:"get", dataType:"text",
				data: { "oil_condition" : $(this).val(), "movie_condition":$("#movie_hidden").val(),
						"coffee_condition":$("#coffee_hidden").val(), "transportation_condition":$("#transportation_hidden").val(),
						"air_condition":$("#air_hidden").val(), "shopping_condition":$("#shopping_hidden").val(),
						"fastfood_condition":$("#fastfood_hidden").val(), "phone_condition":$("#phone_hidden").val(),
						"mart_condition":$("#mart_hidden").val()
				},
				success:function(data){

				},
				error:function(xhr, textStatus, errorThrown ){  
					//$(".db1 tbody").html(textStatus + "(HTTP-" +xhr.status +"/" +errorThrown);
				}	
			});
		});		
	});
	$(function(){
		$(".movie_condition").on("click",function(){
			$(".movie_condition").removeClass("wj_active");
			$(this).addClass("wj_active");
			$("#moive_hidden").val($(this).val() );
			///////////
			$.ajax({
				url:"${pageContext.request.contextPath}/search_benefit.condition", type:"get", dataType:"text",
				data: { "movie_condition" : $(this).val(), "oil_condition":$("#oil_hidden").val(),
						"coffee_condition":$("#coffee_hidden").val(), "transportation_condition":$("#transportation_hidden").val(),
						"air_condition":$("#air_hidden").val(), "shopping_condition":$("#shopping_hidden").val(),
						"fastfood_condition":$("#fastfood_hidden").val(), "phone_condition":$("#phone_hidden").val(),
						"mart_condition":$("#mart_hidden").val()
				},
				success:function(data){

				},
				error:function(xhr, textStatus, errorThrown ){  			
				}	
			});
		});
	});		
	$(function(){
		$(".coffee_condition").on("click",function(){
			$(".coffee_condition").removeClass("wj_active");
			$(this).addClass("wj_active");
			$("#coffee_hidden").val($(this).val() );
			///////////
			$.ajax({
				url:"${pageContext.request.contextPath}/search_benefit.condition", type:"get", dataType:"text",
				data: { "coffee_condition" : $(this).val(), "oil_condition":$("#oil_hidden").val(),
						"movie_condition":$("#movie_hidden").val(), "transportation_condition":$("#transportation_hidden").val(),
						"air_condition":$("#air_hidden").val(), "shopping_condition":$("#shopping_hidden").val(),
						"fastfood_condition":$("#fastfood_hidden").val(), "#phone_condition":$("#phone_hidden").val(),
						"mart_condition":$("#mart_hidden").val()
				},
				success:function(data){

				},
				error:function(xhr, textStatus, errorThrown ){  				
				}	
			});
		});
	});
	$(function(){
		$(".transportation_condition").on("click",function(){
			$(".transportation_condition").removeClass("wj_active");
			$(this).addClass("wj_active");
			$("#transportation_hidden").val($(this).val() );
			///////////
			$.ajax({
				url:"${pageContext.request.contextPath}/search_benefit.condition", type:"get", dataType:"text",
				data: { "transportation_condition" : $(this).val(), "oil_condition":$("#oil_hidden").val(),	
					"coffee_condition":$("#coffee_hidden").val(), "movie_condition":$("#movie_hidden").val(),
					"air_condition":$("#air_hidden").val(), "shopping_condition":$("#shopping_hidden").val(),
					"fastfood_condition":$("#fastfood_hidden").val(), "phone_condition":$("#phone_hidden").val(),
					"mart_condition":$("#mart_hidden").val()
				},
				success:function(data){

				},
				error:function(xhr, textStatus, errorThrown ){  
				}	
			});
		});		
	});	
	$(function(){
		$(".air_condition").on("click",function(){
			$(".air_condition").removeClass("wj_active");
			$(this).addClass("wj_active");
			$("#air_hidden").val($(this).val() );
			///////////
			$.ajax({
				url:"${pageContext.request.contextPath}/search_benefit.condition", type:"get", dataType:"text",
				data: { "air_condition" : $(this).val(),  "oil_condition":$("#oil_hidden").val(),
						"coffee_condition":$("#coffee_hidden").val(), "movie_condition":$("#movie_hidden").val(),
						"transportation_condition":$("#transportation_hidden").val(), "shopping_condition":$("#shopping_hidden").val(),
						"fastfood_condition":$("#fastfood_hidden").val(), "phone_condition":$("#phone_hidden").val(),
						"mart_condition":$("#mart_hidden").val()
				},
				success:function(data){

				},
				error:function(xhr, textStatus, errorThrown ){  
				}	
			});
		});	
	});//end ready	
	$(function(){
		$(".shopping_condition").on("click",function(){
			$(".shopping_condition").removeClass("wj_active");
			$(this).addClass("wj_active");
			$("#shopping_hidden").val($(this).val() );
			///////////
			$.ajax({
				url:"${pageContext.request.contextPath}/search_benefit.condition", type:"get", dataType:"text",
				data: { "shopping_condition" : $(this).val(), "oil_condition":$("#oil_hidden").val(),
						"coffee_condition":$("#coffee_hidden").val(), "movie_condition":$("#movie_hidden").val(),
						"transportation_condition":$("#transportation_hidden").val(), "#air_condition":$("#air_hidden").val(),
						"fastfood_condition":$("#fastfood_hidden").val(), "phone_condition":$("#phone_hidden").val(),
						"mart_condition":$("#mart_hidden").val()
				},
				success:function(data){

				},
				error:function(xhr, textStatus, errorThrown ){  
					
				}	
			});
		});
	});//end ready		
	$(function(){
		$(".fastfood_condition").on("click",function(){
			$(".fastfood_condition").removeClass("wj_active");
			$(this).addClass("wj_active");
			$("#fastfood_hidden").val($(this).val() );
			///////////
			$.ajax({
				url:"${pageContext.request.contextPath}/search_benefit.condition", type:"get", dataType:"text",
				data: { "fastfood_condition" : $(this).val(), "oil_condition":$("#oil_hidden").val(),
						"coffee_condition":$("#coffee_hidden").val(), "movie_condition":$("#movie_hidden").val(),
						"transportation_condition":$("#transportation_hidden").val(), "#air_condition":$("#air_hidden").val(),
						"phone_condition":$("#phone_hidden").val(), "shopping_condition":$("#shopping_hidden").val(),
						"mart_condition":$("#mart_hidden").val() 
				},
				success:function(data){

				},
				error:function(xhr, textStatus, errorThrown ){  
					
				}	
			});
		});
		//////////////////		
	});//end ready		
	$(function(){
		$(".phone_condition").on("click",function(){
			$(".phone_condition").removeClass("wj_active");
			$(this).addClass("wj_active");
			$("#phone_hidden").val($(this).val() );
			///////////
			$.ajax({
				url:"${pageContext.request.contextPath}/search_benefit.condition", type:"get", dataType:"text",
				data: { "phone_condition" : $(this).val(), "oil_condition":$("#oil_hidden").val(),
						"coffee_condition":$("#coffee_hidden").val(), "movie_condition":$("#movie_hidden").val(),
						"transportation_condition":$("#transportation_hidden").val(), "air_condition":$("#air_hidden").val(),
						"fastfood_condition":$("#fastfood_hidden").val(), "shopping_condition":$("#shopping_hidden").val(),
						"mart_condition":$("#mart_hidden").val()  
				},
				success:function(data){

				},
				error:function(xhr, textStatus, errorThrown ){  
					
				}	
			});//end ajax
		});//end click
		//////////////////		
	});//end ready	
	$(function(){
		$(".mart_condition").on("click",function(){
			$(".mart_condition").removeClass("wj_active");
			$(this).addClass("wj_active");
			$("#mart_hidden").val($(this).val() );
			///////////
			$.ajax({
				url:"${pageContext.request.contextPath}/search_benefit.condition", type:"get", dataType:"text",
				data: { "mart_condition" : $(this).val(), "oil_condition":$("#oil_hidden").val(),
						"coffee_condition":$("#coffee_hidden").val(), "movie_condition":$("#movie_hidden").val(),
						"transportation_condition":$("#transportation_hidden").val(), "air_condition":$("#air_hidden").val(),
						"fastfood_condition":$("#fastfood_hidden").val(), "phone_condition":$("#phone_hidden").val(),
						"shopping_condition":$("#shopping_hidden").val()
						
				},
				success:function(data){
					
				},
				error:function(xhr, textStatus, errorThrown ){  
					
				}	
			});//end ajax
		});//end click
		//////////////////		
	});//end ready	
/////////////////////////////////

	</script>
	<!--  -->
	</div> <!-- end container -->
</body>
</html>


