<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container main_index"  style="position:relative">
	<div class="row r1">
		<div class="col-sm-9">
			<h3>카드검색</h3>
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
				<input type="button" 	value="주유" 		id="benefit_1" 	name ="주유" 	class="col-sm-2 btn btn-default oil_condition" />		
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
						<!-- class="btn-btn-default form-control" value="로그아웃" style="color:white; background:#ff6e61;" -->
			</div>	<!-- end col-sm-9 -->
		<div class="col-sm-3">
			<h3>검색 결과 </h3>
			<div>
				<input type="button" class="btn-btn-default form-control" value="초기화" style="color:white; background:#ff6e61;" onclick="window.location.reload()" />   <!-- onclick="history.go(-1);" -->
	<!-- 			<input type="button" class="btn-btn-default form-control" value="비교하기" style="color:white; background:#1b2838;" onclick="location.href='<%=request.getContextPath()%>/start.customer'" />   -->  
			</div>
			<div class="result_card"   style="height: 1136px; padding: 4px; overflow: scroll; width: 450px">			
				<!-- <div>
				 <p><img alt="" src="">	</p>
				 <p></p>
				 <p><span class="btn btn-default"></span></p>
				 </div> -->
				 
			</div>	
		</div> <!-- end col-sm-3 -->					
	</div>
</div> <!-- end container -->
	<!--  -->
	<script>
	$(function(){		
		$.ajax({
			url:"${pageContext.request.contextPath}/search_gender.condition", type:"get", dataType:"json",
			data: { "gender_condition" : '전체'  },
			success:function(data){ 	
				$(".result_card").empty();
				console.log(data);
				for(var i=0; i<data.length; i++){
					console.log(data[i]);
					/// name                       | idnum         | gender | age      | type1    | type2
					var div =$("<div  class='panel panel-info'>");
					var imgLink = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no);
					var img = $("<img>").attr( "src" , "images/"+data[i].pic).css("width","300px");	//.css("height", "150px")
					//var name = $("<a href='http://localhost:8080/wonjun_Samsung_project/search_detail.keyword?no="+data[i].no+"'>+"+"<p>").html(data[i].name);
					//var name = $("<h4>").html(data[i].name).addClass("text-danger");
					var name = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no).html("<h4>" + data[i].name + "</h4>").addClass("text-danger");
					var idnum = $("<p>").html("<span class='btn btn-default'>"+data[i].idnum+"</span>   "  + 
										"<span class='btn btn-default'>"+data[i].gender+"</span>   "  +	
										"<span class='btn btn-default'>"+data[i].age+"</span>   "  +
										"<span class='btn btn-default'>"+data[i].type1+"</span>  "  +
										"<span class='btn btn-default'>"+data[i].type2+"</span>  " ); 
					imgLink.append(img);
					div.append(imgLink).append(name).append(idnum);
					$(".result_card").append(div);
				}
			},
			error:function(xhr, textStatus, errorThrown ){  
				//$(".db1 tbody").html(textStatus + "(HTTP-" +xhr.status +"/" +errorThrown);
			}	
		});//end ajax
		
		
		var gender = "";
		$(".gender_condition").on("click",function(){
			console.log($(this).val());
			$(".gender_condition").removeClass("wj_active");	//추가	클릭했을때  색변화
			$(this).addClass("wj_active");						//추가	클릭했을땨 색변화
			$("#gender_hidden").val($(this).val() );
		////////////////////////////////////////////////////		
			$.ajax({
				url:"${pageContext.request.contextPath}/search_gender.condition", type:"get", dataType:"json",
				data: { "gender_condition" : $(this).val()  },
				success:function(data){ 	
					$(".result_card").empty();
					console.log(data);
					for(var i=0; i<data.length; i++){
						console.log(data[i]);
						/// name                       | idnum         | gender | age      | type1    | type2
						//var div =$("<div  class='panel panel-info'>");
						//var img = $("<img>").attr( "src" , "images/"+data[i].pic).css("width","300px");			//	.css("height", "150px")
						///var name = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no).html(data[i].name);
						var div =$("<div  class='panel panel-info'>");
						var imgLink = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no);
						var img = $("<img>").attr( "src" , "images/"+data[i].pic).css("width","300px");	//.css("height", "150px")
						var name = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no).html("<h4>" + data[i].name + "</h4>").addClass("text-danger");
						var idnum = $("<p>").html("<span class='btn btn-default'>"+data[i].idnum+"</span>   "  + 
											"<span class='btn btn-default'>"+data[i].gender+"</span>   "  +	
											"<span class='btn btn-default'>"+data[i].age+"</span>   "  +
											"<span class='btn btn-default'>"+data[i].type1+"</span>  "  +
											"<span class='btn btn-default'>"+data[i].type2+"</span>  " ); 
						imgLink.append(img);
						div.append(imgLink).append(name).append(idnum);
						$(".result_card").append(div);
					}
					
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
				url:"${pageContext.request.contextPath}/search_age.condition", type:"get", dataType:"json",
				data: { "age_condition" : $(this).val(), "gender_condition" : $("#gender_hidden").val()   },
				success:function(data){
					$(".result_card").empty();
					console.log(data);
					for(var i=0; i<data.length; i++){
						console.log(data[i]);
						/// name                       | idnum         | gender | age      | type1    | type2
						var div =$("<div  class='panel panel-info'>");
						var imgLink = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no);
						var img = $("<img>").attr( "src" , "images/"+data[i].pic).css("width","300px");	//.css("height", "150px")
						//var name = $("<a href='http://localhost:8080/wonjun_Samsung_project/search_detail.keyword?no="+data[i].no+"'>+"+"<p>").html(data[i].name);
						//var name = $("<h4>").html(data[i].name).addClass("text-danger");
						var name = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no).html("<h4>" + data[i].name + "</h4>").addClass("text-danger");
						var idnum = $("<p>").html("<span class='btn btn-default'>"+data[i].idnum+"</span>   "  + 
											"<span class='btn btn-default'>"+data[i].gender+"</span>   "  +	
											"<span class='btn btn-default'>"+data[i].age+"</span>   "  +
											"<span class='btn btn-default'>"+data[i].type1+"</span>  "  +
											"<span class='btn btn-default'>"+data[i].type2+"</span>  " ); 
						imgLink.append(img);
						div.append(imgLink).append(name).append(idnum);
						$(".result_card").append(div);
					}
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
				url:"${pageContext.request.contextPath}/search_company.condition", type:"get", dataType:"json",
				data: { "idnum_condition" : $(this).val(), "gender_condition" : $("#gender_hidden").val(), 
						"age_condition" : $("#age_hidden").val()
				},
				success:function(data){
					$(".result_card").empty();
					console.log(data);
					for(var i=0; i<data.length; i++){
						console.log(data[i]);
						/// name                       | idnum         | gender | age      | type1    | type2
						var div =$("<div  class='panel panel-info'>");
						var imgLink = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no);
						var img = $("<img>").attr( "src" , "images/"+data[i].pic).css("width","300px");	//.css("height", "150px")
						//var name = $("<a href='http://localhost:8080/wonjun_Samsung_project/search_detail.keyword?no="+data[i].no+"'>+"+"<p>").html(data[i].name);
						//var name = $("<h4>").html(data[i].name).addClass("text-danger");
						var name = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no).html("<h4>" + data[i].name + "</h4>").addClass("text-danger");
						var idnum = $("<p>").html("<span class='btn btn-default'>"+data[i].idnum+"</span>   "  + 
											"<span class='btn btn-default'>"+data[i].gender+"</span>   "  +	
											"<span class='btn btn-default'>"+data[i].age+"</span>   "  +
											"<span class='btn btn-default'>"+data[i].type1+"</span>  "  +
											"<span class='btn btn-default'>"+data[i].type2+"</span>  " ); 
						imgLink.append(img);
						div.append(imgLink).append(name).append(idnum);
						$(".result_card").append(div);
					}
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
				url:"${pageContext.request.contextPath}/search_type1.condition", type:"get", dataType:"json",
				data: { "type1_condition" : $(this).val(), "gender_condition" : $("#gender_hidden").val(), 
						"age_condition" : $("#age_hidden").val(), "idnum_condition" : $("#idnum_hidden").val()
				},
				success:function(data){
					$(".result_card").empty();
					console.log(data);
					for(var i=0; i<data.length; i++){
						console.log(data[i]);
						/// name                       | idnum         | gender | age      | type1    | type2
						var div =$("<div  class='panel panel-info'>");
						var imgLink = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no);
						var img = $("<img>").attr( "src" , "images/"+data[i].pic).css("width","300px");	//.css("height", "150px")
						//var name = $("<a href='http://localhost:8080/wonjun_Samsung_project/search_detail.keyword?no="+data[i].no+"'>+"+"<p>").html(data[i].name);
						//var name = $("<h4>").html(data[i].name).addClass("text-danger");
						var name = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no).html("<h4>" + data[i].name + "</h4>").addClass("text-danger");
						var idnum = $("<p>").html("<span class='btn btn-default'>"+data[i].idnum+"</span>   "  + 
											"<span class='btn btn-default'>"+data[i].gender+"</span>   "  +	
											"<span class='btn btn-default'>"+data[i].age+"</span>   "  +
											"<span class='btn btn-default'>"+data[i].type1+"</span>  "  +
											"<span class='btn btn-default'>"+data[i].type2+"</span>  " ); 
						imgLink.append(img);
						div.append(imgLink).append(name).append(idnum);
						$(".result_card").append(div);
					}
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
				url:"${pageContext.request.contextPath}/search_type2.condition", type:"get", dataType:"json",
				data: { "type2_condition" : $(this).val(), "gender_condition" : $("#gender_hidden").val(), 
						"age_condition" : $("#age_hidden").val(), "idnum_condition" : $("#idnum_hidden").val(),
						"type1_condition" : $("#type1_hidden").val()
				},
				success:function(data){
					$(".result_card").empty();
					console.log(data);
					for(var i=0; i<data.length; i++){
						console.log(data[i]);
						/// name                       | idnum         | gender | age      | type1    | type2
						var div =$("<div  class='panel panel-info'>");
						var imgLink = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no);
						var img = $("<img>").attr( "src" , "images/"+data[i].pic).css("width","300px");	//.css("height", "150px")
						//var name = $("<a href='http://localhost:8080/wonjun_Samsung_project/search_detail.keyword?no="+data[i].no+"'>+"+"<p>").html(data[i].name);
						//var name = $("<h4>").html(data[i].name).addClass("text-danger");
						var name = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no).html("<h4>" + data[i].name + "</h4>").addClass("text-danger");
						var idnum = $("<p>").html("<span class='btn btn-default'>"+data[i].idnum+"</span>   "  + 
											"<span class='btn btn-default'>"+data[i].gender+"</span>   "  +	
											"<span class='btn btn-default'>"+data[i].age+"</span>   "  +
											"<span class='btn btn-default'>"+data[i].type1+"</span>  "  +
											"<span class='btn btn-default'>"+data[i].type2+"</span>  " ); 
						imgLink.append(img);
						div.append(imgLink).append(name).append(idnum);
						$(".result_card").append(div);
					}
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
				url:"${pageContext.request.contextPath}/search_oil.condition", type:"get", dataType:"json",
				//url:"${pageContext.request.contextPath}/search_benefit.condition", type:"get", dataType:"json",
				data: { "oil_condition" : $(this).val(), "movie_condition":$("#movie_hidden").val(),
						"coffee_condition":$("#coffee_hidden").val(), "transportation_condition":$("#transportation_hidden").val(),
						"air_condition":$("#air_hidden").val(), "shopping_condition":$("#shopping_hidden").val(),
						"fastfood_condition":$("#fastfood_hidden").val(), "phone_condition":$("#phone_hidden").val(),
						
						"mart_condition":$("#mart_hidden").val(),
						"type2_condition" : $("#type2_hidden").val(), "gender_condition" : $("#gender_hidden").val(), 
						"age_condition" : $("#age_hidden").val(), "idnum_condition" : $("#idnum_hidden").val(),
						"type1_condition" : $("#type1_hidden").val()
				},
				success:function(data){
					$(".result_card").empty();
					console.log(data);
					for(var i=0; i<data.length; i++){
						console.log(data[i]);
						/// name                       | idnum         | gender | age      | type1    | type2
						var div =$("<div  class='panel panel-info'>");
						var imgLink = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no);
						var img = $("<img>").attr( "src" , "images/"+data[i].pic).css("width","300px");	//.css("height", "150px")
						//var name = $("<a href='http://localhost:8080/wonjun_Samsung_project/search_detail.keyword?no="+data[i].no+"'>+"+"<p>").html(data[i].name);
						//var name = $("<h4>").html(data[i].name).addClass("text-danger");
						var name = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no).html("<h4>" + data[i].name + "</h4>").addClass("text-danger");
						var idnum = $("<p>").html("<span class='btn btn-default'>"+data[i].idnum+"</span>   "  + 
											"<span class='btn btn-default'>"+data[i].gender+"</span>   "  +	
											"<span class='btn btn-default'>"+data[i].age+"</span>   "  +
											"<span class='btn btn-default'>"+data[i].type1+"</span>  "  +
											"<span class='btn btn-default'>"+data[i].type2+"</span>  " ); 
						imgLink.append(img);
						div.append(imgLink).append(name).append(idnum);
						$(".result_card").append(div);
					}
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
				url:"${pageContext.request.contextPath}/search_movie.condition", type:"get", dataType:"json",
				data: { "movie_condition" : $(this).val(), "oil_condition":$("#oil_hidden").val(),
						"coffee_condition":$("#coffee_hidden").val(), "transportation_condition":$("#transportation_hidden").val(),
						"air_condition":$("#air_hidden").val(), "shopping_condition":$("#shopping_hidden").val(),
						"fastfood_condition":$("#fastfood_hidden").val(), "phone_condition":$("#phone_hidden").val(),
						"mart_condition":$("#mart_hidden").val(),
						"type2_condition" : $("#type2_hidden").val(), "gender_condition" : $("#gender_hidden").val(), 
						"age_condition" : $("#age_hidden").val(), "idnum_condition" : $("#idnum_hidden").val(),
						"type1_condition" : $("#type1_hidden").val()
				},
				success:function(data){
					$(".result_card").empty();
					console.log(data);
					for(var i=0; i<data.length; i++){
						console.log(data[i]);
						/// name                       | idnum         | gender | age      | type1    | type2
						var div =$("<div  class='panel panel-info'>");
						var imgLink = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no);
						var img = $("<img>").attr( "src" , "images/"+data[i].pic).css("width","300px");	//.css("height", "150px")
						//var name = $("<a href='http://localhost:8080/wonjun_Samsung_project/search_detail.keyword?no="+data[i].no+"'>+"+"<p>").html(data[i].name);
						//var name = $("<h4>").html(data[i].name).addClass("text-danger");
						var name = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no).html("<h4>" + data[i].name + "</h4>").addClass("text-danger");
						var idnum = $("<p>").html("<span class='btn btn-default'>"+data[i].idnum+"</span>   "  + 
											"<span class='btn btn-default'>"+data[i].gender+"</span>   "  +	
											"<span class='btn btn-default'>"+data[i].age+"</span>   "  +
											"<span class='btn btn-default'>"+data[i].type1+"</span>  "  +
											"<span class='btn btn-default'>"+data[i].type2+"</span>  " ); 
						imgLink.append(img);
						div.append(imgLink).append(name).append(idnum);
						$(".result_card").append(div);
					}
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
				url:"${pageContext.request.contextPath}/search_coffee.condition", type:"get", dataType:"json",
				data: { "coffee_condition" : $(this).val(), "oil_condition":$("#oil_hidden").val(),
						"movie_condition":$("#movie_hidden").val(), "transportation_condition":$("#transportation_hidden").val(),
						"air_condition":$("#air_hidden").val(), "shopping_condition":$("#shopping_hidden").val(),
						"fastfood_condition":$("#fastfood_hidden").val(), "#phone_condition":$("#phone_hidden").val(),
						"mart_condition":$("#mart_hidden").val(),
						"type2_condition" : $("#type2_hidden").val(), "gender_condition" : $("#gender_hidden").val(), 
						"age_condition" : $("#age_hidden").val(), "idnum_condition" : $("#idnum_hidden").val(),
						"type1_condition" : $("#type1_hidden").val()
				},
				success:function(data){
					$(".result_card").empty();
					console.log(data);
					for(var i=0; i<data.length; i++){
						console.log(data[i]);
						/// name                       | idnum         | gender | age      | type1    | type2
						var div =$("<div  class='panel panel-info'>");
						var imgLink = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no);
						var img = $("<img>").attr( "src" , "images/"+data[i].pic).css("width","300px");	//.css("height", "150px")
						//var name = $("<a href='http://localhost:8080/wonjun_Samsung_project/search_detail.keyword?no="+data[i].no+"'>+"+"<p>").html(data[i].name);
						//var name = $("<h4>").html(data[i].name).addClass("text-danger");
						var name = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no).html("<h4>" + data[i].name + "</h4>").addClass("text-danger");
						var idnum = $("<p>").html("<span class='btn btn-default'>"+data[i].idnum+"</span>   "  + 
											"<span class='btn btn-default'>"+data[i].gender+"</span>   "  +	
											"<span class='btn btn-default'>"+data[i].age+"</span>   "  +
											"<span class='btn btn-default'>"+data[i].type1+"</span>  "  +
											"<span class='btn btn-default'>"+data[i].type2+"</span>  " ); 
						imgLink.append(img);
						div.append(imgLink).append(name).append(idnum);
						$(".result_card").append(div);
					}
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
				url:"${pageContext.request.contextPath}/search_transportation.condition", type:"get", dataType:"json",
				data: { "transportation_condition" : $(this).val(), "oil_condition":$("#oil_hidden").val(),	
					"coffee_condition":$("#coffee_hidden").val(), "movie_condition":$("#movie_hidden").val(),
					"air_condition":$("#air_hidden").val(), "shopping_condition":$("#shopping_hidden").val(),
					"fastfood_condition":$("#fastfood_hidden").val(), "phone_condition":$("#phone_hidden").val(),
					"mart_condition":$("#mart_hidden").val(),
					"type2_condition" : $("#type2_hidden").val(), "gender_condition" : $("#gender_hidden").val(), 
					"age_condition" : $("#age_hidden").val(), "idnum_condition" : $("#idnum_hidden").val(),
					"type1_condition" : $("#type1_hidden").val()
				},
				success:function(data){
					$(".result_card").empty();
					console.log(data);
					for(var i=0; i<data.length; i++){
						console.log(data[i]);
						/// name                       | idnum         | gender | age      | type1    | type2
						var div =$("<div  class='panel panel-info'>");
						var imgLink = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no);
						var img = $("<img>").attr( "src" , "images/"+data[i].pic).css("width","300px");	//.css("height", "150px")
						//var name = $("<a href='http://localhost:8080/wonjun_Samsung_project/search_detail.keyword?no="+data[i].no+"'>+"+"<p>").html(data[i].name);
						//var name = $("<h4>").html(data[i].name).addClass("text-danger");
						var name = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no).html("<h4>" + data[i].name + "</h4>").addClass("text-danger");
						var idnum = $("<p>").html("<span class='btn btn-default'>"+data[i].idnum+"</span>   "  + 
											"<span class='btn btn-default'>"+data[i].gender+"</span>   "  +	
											"<span class='btn btn-default'>"+data[i].age+"</span>   "  +
											"<span class='btn btn-default'>"+data[i].type1+"</span>  "  +
											"<span class='btn btn-default'>"+data[i].type2+"</span>  " ); 
						imgLink.append(img);
						div.append(imgLink).append(name).append(idnum);
						$(".result_card").append(div);
					}
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
				url:"${pageContext.request.contextPath}/search_air.condition", type:"get", dataType:"json",
				data: { "air_condition" : $(this).val(),  "oil_condition":$("#oil_hidden").val(),
						"coffee_condition":$("#coffee_hidden").val(), "movie_condition":$("#movie_hidden").val(),
						"transportation_condition":$("#transportation_hidden").val(), "shopping_condition":$("#shopping_hidden").val(),
						"fastfood_condition":$("#fastfood_hidden").val(), "phone_condition":$("#phone_hidden").val(),
						"mart_condition":$("#mart_hidden").val(),
						"type2_condition" : $("#type2_hidden").val(), "gender_condition" : $("#gender_hidden").val(), 
						"age_condition" : $("#age_hidden").val(), "idnum_condition" : $("#idnum_hidden").val(),
						"type1_condition" : $("#type1_hidden").val()
				},
				success:function(data){
					$(".result_card").empty();
					console.log(data);
					for(var i=0; i<data.length; i++){
						console.log(data[i]);
						/// name                       | idnum         | gender | age      | type1    | type2
						var div =$("<div  class='panel panel-info'>");
						var imgLink = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no);
						var img = $("<img>").attr( "src" , "images/"+data[i].pic).css("width","300px");	//.css("height", "150px")
						//var name = $("<a href='http://localhost:8080/wonjun_Samsung_project/search_detail.keyword?no="+data[i].no+"'>+"+"<p>").html(data[i].name);
						//var name = $("<h4>").html(data[i].name).addClass("text-danger");
						var name = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no).html("<h4>" + data[i].name + "</h4>").addClass("text-danger");
						var idnum = $("<p>").html("<span class='btn btn-default'>"+data[i].idnum+"</span>   "  + 
											"<span class='btn btn-default'>"+data[i].gender+"</span>   "  +	
											"<span class='btn btn-default'>"+data[i].age+"</span>   "  +
											"<span class='btn btn-default'>"+data[i].type1+"</span>  "  +
											"<span class='btn btn-default'>"+data[i].type2+"</span>  " ); 
						imgLink.append(img);
						div.append(imgLink).append(name).append(idnum);
						$(".result_card").append(div);
					}
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
				url:"${pageContext.request.contextPath}/search_shopping.condition", type:"get", dataType:"json",
				data: { "shopping_condition" : $(this).val(), "oil_condition":$("#oil_hidden").val(),
						"coffee_condition":$("#coffee_hidden").val(), "movie_condition":$("#movie_hidden").val(),
						"transportation_condition":$("#transportation_hidden").val(), "#air_condition":$("#air_hidden").val(),
						"fastfood_condition":$("#fastfood_hidden").val(), "phone_condition":$("#phone_hidden").val(),
						"mart_condition":$("#mart_hidden").val(),
						"type2_condition" : $("#type2_hidden").val(), "gender_condition" : $("#gender_hidden").val(), 
						"age_condition" : $("#age_hidden").val(), "idnum_condition" : $("#idnum_hidden").val(),
						"type1_condition" : $("#type1_hidden").val()
				},
				success:function(data){
					$(".result_card").empty();
					console.log(data);
					for(var i=0; i<data.length; i++){
						console.log(data[i]);
						/// name                       | idnum         | gender | age      | type1    | type2
						var div =$("<div  class='panel panel-info'>");
						var imgLink = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no);
						var img = $("<img>").attr( "src" , "images/"+data[i].pic).css("width","300px");	//.css("height", "150px")
						//var name = $("<a href='http://localhost:8080/wonjun_Samsung_project/search_detail.keyword?no="+data[i].no+"'>+"+"<p>").html(data[i].name);
						//var name = $("<h4>").html(data[i].name).addClass("text-danger");
						var name = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no).html("<h4>" + data[i].name + "</h4>").addClass("text-danger");
						var idnum = $("<p>").html("<span class='btn btn-default'>"+data[i].idnum+"</span>   "  + 
											"<span class='btn btn-default'>"+data[i].gender+"</span>   "  +	
											"<span class='btn btn-default'>"+data[i].age+"</span>   "  +
											"<span class='btn btn-default'>"+data[i].type1+"</span>  "  +
											"<span class='btn btn-default'>"+data[i].type2+"</span>  " ); 
						imgLink.append(img);
						div.append(imgLink).append(name).append(idnum);
						$(".result_card").append(div);
					}
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
				url:"${pageContext.request.contextPath}/search_fastfood.condition", type:"get", dataType:"json",
				data: { "fastfood_condition" : $(this).val(), "oil_condition":$("#oil_hidden").val(),
						"coffee_condition":$("#coffee_hidden").val(), "movie_condition":$("#movie_hidden").val(),
						"transportation_condition":$("#transportation_hidden").val(), "#air_condition":$("#air_hidden").val(),
						"phone_condition":$("#phone_hidden").val(), "shopping_condition":$("#shopping_hidden").val(),
						"mart_condition":$("#mart_hidden").val(),
						"type2_condition" : $("#type2_hidden").val(), "gender_condition" : $("#gender_hidden").val(), 
						"age_condition" : $("#age_hidden").val(), "idnum_condition" : $("#idnum_hidden").val(),
						"type1_condition" : $("#type1_hidden").val()
				},
				success:function(data){
					$(".result_card").empty();
					console.log(data);
					for(var i=0; i<data.length; i++){
						console.log(data[i]);
						/// name                       | idnum         | gender | age      | type1    | type2
						var div =$("<div  class='panel panel-info'>");
						var imgLink = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no);
						var img = $("<img>").attr( "src" , "images/"+data[i].pic).css("width","300px");	//.css("height", "150px")
						//var name = $("<a href='http://localhost:8080/wonjun_Samsung_project/search_detail.keyword?no="+data[i].no+"'>+"+"<p>").html(data[i].name);
						//var name = $("<h4>").html(data[i].name).addClass("text-danger");
						var name = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no).html("<h4>" + data[i].name + "</h4>").addClass("text-danger");
						var idnum = $("<p>").html("<span class='btn btn-default'>"+data[i].idnum+"</span>   "  + 
											"<span class='btn btn-default'>"+data[i].gender+"</span>   "  +	
											"<span class='btn btn-default'>"+data[i].age+"</span>   "  +
											"<span class='btn btn-default'>"+data[i].type1+"</span>  "  +
											"<span class='btn btn-default'>"+data[i].type2+"</span>  " ); 
						imgLink.append(img);
						div.append(imgLink).append(name).append(idnum);
						$(".result_card").append(div);
					}
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
				url:"${pageContext.request.contextPath}/search_phone.condition", type:"get", dataType:"json",
				data: { "phone_condition" : $(this).val(), "oil_condition":$("#oil_hidden").val(),
						"coffee_condition":$("#coffee_hidden").val(), "movie_condition":$("#movie_hidden").val(),
						"transportation_condition":$("#transportation_hidden").val(), "air_condition":$("#air_hidden").val(),
						"fastfood_condition":$("#fastfood_hidden").val(), "shopping_condition":$("#shopping_hidden").val(),
						"mart_condition":$("#mart_hidden").val(),
						"type2_condition" : $("#type2_hidden").val(), "gender_condition" : $("#gender_hidden").val(), 
						"age_condition" : $("#age_hidden").val(), "idnum_condition" : $("#idnum_hidden").val(),
						"type1_condition" : $("#type1_hidden").val()
				},
				success:function(data){
					$(".result_card").empty();
					console.log(data);
					for(var i=0; i<data.length; i++){
						console.log(data[i]);
						/// name                       | idnum         | gender | age      | type1    | type2
						var div =$("<div  class='panel panel-info'>");
						var imgLink = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no);
						var img = $("<img>").attr( "src" , "images/"+data[i].pic).css("width","300px");	//.css("height", "150px")
						//var name = $("<a href='http://localhost:8080/wonjun_Samsung_project/search_detail.keyword?no="+data[i].no+"'>+"+"<p>").html(data[i].name);
						//var name = $("<h4>").html(data[i].name).addClass("text-danger");
						var name = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no).html("<h4>" + data[i].name + "</h4>").addClass("text-danger");
						var idnum = $("<p>").html("<span class='btn btn-default'>"+data[i].idnum+"</span>   "  + 
											"<span class='btn btn-default'>"+data[i].gender+"</span>   "  +	
											"<span class='btn btn-default'>"+data[i].age+"</span>   "  +
											"<span class='btn btn-default'>"+data[i].type1+"</span>  "  +
											"<span class='btn btn-default'>"+data[i].type2+"</span>  " ); 
						imgLink.append(img);
						div.append(imgLink).append(name).append(idnum);
						$(".result_card").append(div);
					}
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
				url:"${pageContext.request.contextPath}/search_mart.condition", type:"get", dataType:"json",
				data: { "mart_condition" : $(this).val(), "oil_condition":$("#oil_hidden").val(),
						"coffee_condition":$("#coffee_hidden").val(), "movie_condition":$("#movie_hidden").val(),
						"transportation_condition":$("#transportation_hidden").val(), "air_condition":$("#air_hidden").val(),
						"fastfood_condition":$("#fastfood_hidden").val(), "phone_condition":$("#phone_hidden").val(),
						"shopping_condition":$("#shopping_hidden").val(),
						"type2_condition" : $("#type2_hidden").val(), "gender_condition" : $("#gender_hidden").val(), 
						"age_condition" : $("#age_hidden").val(), "idnum_condition" : $("#idnum_hidden").val(),
						"type1_condition" : $("#type1_hidden").val()
						
				},
				success:function(data){
					$(".result_card").empty();
					console.log(data);
					for(var i=0; i<data.length; i++){
						console.log(data[i]);
						/// name                       | idnum         | gender | age      | type1    | type2
						var div =$("<div  class='panel panel-info'>");
						var imgLink = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no);
						var img = $("<img>").attr( "src" , "images/"+data[i].pic).css("width","300px");	//.css("height", "150px")
						//var name = $("<a href='http://localhost:8080/wonjun_Samsung_project/search_detail.keyword?no="+data[i].no+"'>+"+"<p>").html(data[i].name);
						//var name = $("<h4>").html(data[i].name).addClass("text-danger");
						var name = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no).html("<h4>" + data[i].name + "</h4>").addClass("text-danger");
						var idnum = $("<p>").html("<span class='btn btn-default'>"+data[i].idnum+"</span>   "  + 
											"<span class='btn btn-default'>"+data[i].gender+"</span>   "  +	
											"<span class='btn btn-default'>"+data[i].age+"</span>   "  +
											"<span class='btn btn-default'>"+data[i].type1+"</span>  "  +
											"<span class='btn btn-default'>"+data[i].type2+"</span>  " ); 
						imgLink.append(img);
						div.append(imgLink).append(name).append(idnum);
						$(".result_card").append(div);
					}					
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



