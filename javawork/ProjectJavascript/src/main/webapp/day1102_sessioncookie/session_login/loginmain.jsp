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
<%
	//로그인 상태인지 세션값을 얻는다. (loginok가 있는지)
	String loginok = (String)session.getAttribute("loginok");
%>
<body>
	<div style="margin:50px;">
		<%
		if(loginok==null){%>
			<jsp:include page="loginform.jsp"/>
			<br><br>
			<h3><b>멤버 정보를 확인하려면 먼저 로그인을 해주세요.</b></h3>
		<%}else {%>
			<jsp:include page="logoutform.jsp"/>
			<br><br>
			<img src="mainpage.png">
		<%}
		%>
	</div>
</body>
</html>