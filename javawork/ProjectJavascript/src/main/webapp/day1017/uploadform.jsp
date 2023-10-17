<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Black+Han+Sans&family=Dongle&family=Gamja+Flower&family=Jua&family=Lobster&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
	body * {
		font-family: 'Jua';
	}
</style>
<script type="text/javascript">
	$(function(){
		//file tag는 안보이게 처리
		$("#upload").hide();
		
		//카메라 아이콘을 클릭시 파일태그 클릭효과 주기
		$(".uploadcamera").click(function(){
			$("#upload").trigger("click"); //강제 이벤트 발생
		});
	});

</script>
</head>
<body>
	<h3>파일 업로드 연습</h3>
	<form action="./uploadaction.jsp" method="post" enctype="multipart/form-data">
		제목 : <input type="text" name="title"><br>
		파일 : <input type="file" name="upload" id="upload">
		<i class="bi bi-camera-fill uploadcamera"></i><br>
		<button type="submit">서버 전송</button>
	</form>
</body>
</html>