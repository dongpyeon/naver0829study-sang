 <%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
   body * {
       font-family: 'Jua';
   }
  
</style>
</head>
<body>
	<h2 class="alert alert-info">TestController로부터 포워드됨</h2>
	<hr>
	<h3>${message}</h3>
	<h5>고독하구만</h5>
	<!-- <img src="../photo/gun1.png" width="300">
	<img src="../res/image/lonely.jpg" width="300"> -->
	<!-- 절대경로 -->
	<img src="${root}/photo/gun1.png" width="300">
	<img src="${root}/res/image/lonely.jpg" width="300">
</body>
</html>