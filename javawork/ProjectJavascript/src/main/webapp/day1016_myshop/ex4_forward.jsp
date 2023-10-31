<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Black+Han+Sans&family=Dongle&family=Gamja+Flower&family=Jua&family=Lobster&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
	body * {
		font-family: 'Jua';
	}
</style>
<script>

</script>
</head>
<body>
<h3 class="alert alert-danger">ex4_forward파일입니다.</h3>
<%
	request.setCharacterEncoding("utf-8");
	//jsp:param데이터는 getParameter로 읽는다.
	String photo = request.getParameter("photo");
	String msg = request.getParameter("msg");
%>
<img src = "<%=photo %>">
<h2><%=msg %></h2>
</body>
</html>