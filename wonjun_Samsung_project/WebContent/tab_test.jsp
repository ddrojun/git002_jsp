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
<div class="container panel panel-info">
  <h3 class="panel-heading">TAB</h3>
  <ul class="nav nav-tabs">
    <li><a href="#menu1">${item.get(0).name}</a></li>
    <li><a href="#menu2">${item.get(1).name}</a></li>
    <li><a href="#menu3">${item.get(2).name}</a></li>
  </ul>
  <div class="tab-content">
  <c:forEach begin="0" end="${item.size()}" step="1" var="i" items="${item}" varStatus="status">
    <div id="menu${status.count}" class="tab-pane fade">
      <p>NO : ${i.no}</p>
      <p>NAME :${i.name}</p>
      <p>AGE : ${i.age}</p>
    </div>
    
    </c:forEach>
  </div>

</div>

<script>
$(document).ready(function(){
  $(".nav-tabs a").click(function(){
    $(this).tab('show');
  });
});
</script>
</body>
</html>