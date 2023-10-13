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
<h5>폼태그 post방식으로 읽기</h5>
<form action="./ex7_dataread.jsp" method="post">
	이름 : <input type="text" name="irum"><br>
	운전면허 : <label><input type="checkbox" name="license">운전면허</label><br>
	성별 : <label><input type="radio" name="gender" value="남자" checked="checked">남자</label>
		   &nbsp;&nbsp;
		   <label><input type="radio" name="gender" value="여자">여자</label>
	주거지:
		<select name="home">
			<option>서울</option>
			<option>부산</option>
			<option>제주</option>
			<option>대구</option>
			<option>전주</option>
		</select>
		<br><br>
	<button type="submit">서버로 전송</button>
</form>
</body>
</html>