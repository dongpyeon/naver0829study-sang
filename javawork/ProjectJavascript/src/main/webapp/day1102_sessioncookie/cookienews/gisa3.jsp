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
	Cookie []cookies = request.getCookies();
	boolean find = false;
	if(cookies != null)
	{
		for(Cookie ck:cookies)
		{
			//저장된 쿠키 이름을 얻는다.
			String name = ck.getName();
			if(name.equals("loginok")){
				find=true;//해당 쿠키가 존재하면 true
				
			}
		}
	}
%>
<body>
<%
	if(!find){%>
		<script type="text/javascript">
			alert("먼저 로그인을 해주세요");
			history.back();
		</script>
		<%}else{%>
			<pre style="width:500px">
[스포츠조선 백지은 기자] 그룹 빅뱅 지드래곤이 마약 의혹과 관련 초강경 대응을 이어가고 있다.

지드래곤은 10월 25일 마약류 관리에 관한 법률 위반 혐의로 불구속 입건됐다. 이후 지드래곤은 "마약을 투약한 사실이 없다"고 해명했으며, 
두 차례에 걸쳐 모발 소변 검사를 비롯한 경찰 수사에 적극적으로 협조할 것이고 헌법재판관 출신 변호사를 20억원에 선임했다는 등의 
허위 루머와 명예훼손에 대해서는 강경 대응하겠다는 입장을 밝혔다. 
또 6일 경찰에 자진출석해 조사를 받겠다고 선언했다.
		
		</pre>
		<br><br>
		<a href="loginmain.jsp">메인페이지로 이동</a>
	<%}
%>
</body>
</html>