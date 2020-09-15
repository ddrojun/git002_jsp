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
<!-- 
	<div class="container panel panel-warning">
	<h3 class="panel-heading">지도</h3>
	1. https://developers.kakao.com
	2. JavaScript 키 :  30b50d6c9537f6b10dfd54d073d1d218
	</div>   
	 -->
	 
<!-- 지도를 표시할 div 입니다 -->
<!--  -->
<!--  -->
<!--  -->
<div class="container">
<h3>Alex_CARD 위치</h3>
</div>
<div id="map" style="width:100%;  height:500px; max-height: 500px"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=30b50d6c9537f6b10dfd54d073d1d218"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.5125, 127.102778), // 지도의 중심좌표   //위도,경도
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(37.5125, 127.102778); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
// marker.setMap(null);    
</script>
</body>
</html>