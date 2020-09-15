<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="direct_search_card">
<div class="container">
		<div class="row">
		<div class="col-sm-9">
		<input type="text"  id="search"  name="search"  placeholder="검색어를 입력 ex)삼성,현대, ...회사명" class="form-control"  />
		</div>
		<div class="col-sm-3">
		<input type="button" class="btn btn-default btn-lg" style="background-color: #1b2838; color:white; width:256px;" id ="direct_btn" data-toggle="modal" data-target="#myModal" value="카드 직접검색"/>
		</div>
		</div>
<!--  -->
<script>
		$("#direct_btn").on("click",function(){
			console.log($("#search").val());
			$(".result_direct").empty();
			$.ajax({
				url:"${pageContext.request.contextPath}/search.direct", type:"get", dataType:"json",
				data: { "search" : $("#search").val()  },
				success:function(data){ 
					//$(".result_direct").empty();3
					
					console.log(data);
					for(var i=0; i<data.length; i++){
						console.log(data[i]);
						var p =$("<p>");
						var imgLink = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no);
						var img = $("<img>").attr( "src" , "images/"+data[i].pic).css("width","300px");	//.css("height", "150px")
						var name = $("<a>").attr("href", "<%=request.getContextPath()%>/search_detail.keyword?no="+data[i].no).html("<h4>" + data[i].name + "</h4>").addClass("text-danger");
						var idnum = $("<p>").html("<p>카드번호 : "+data[i].idnum+"</p>"+ 
											"<p>성별 : "+data[i].gender+"</p>" +	
											"<p>나이대 : "+data[i].age+"</p>" +
											"<p>신용/체크카드 : "+data[i].type1+"</p>"  +
											"<p>할인유형 : "+data[i].type2+
											"<p>"+"====================================================================="+
											"</p>" 
						); 					
						imgLink.append(img);
						p.append(name).append(imgLink).append(idnum);
						$(".result_direct").append(p);
					}
					
				},
				error:function(xhr, textStatus, errorThrown ){
					alert("실패");
					//$(".db1 tbody").html(textStatus + "(HTTP-" +xhr.status +"/" +errorThrown);
				}	
			});//end ajax
		});//end click
		//////////////////		
//	});//end ready

</script>
<!--  -->
<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title" style="font-weight: bold">카드 검색 결과</h4>
      </div>
      <div class="modal-body result_direct">
		<!-- 결과창 -->   
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" style="background-color: #1b2838; color:white;"  data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div> 
</div>
</div>