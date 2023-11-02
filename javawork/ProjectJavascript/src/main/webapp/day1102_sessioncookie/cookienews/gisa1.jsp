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
1일 방송된 tvN '유 퀴즈 온 더 블럭'에는 JYP 박진영 CCO, 하이브 방시혁 의장이 함께 출연해 이야기를 나눴다.
이날 유재석은 "축하해야할 일이 있다. BTS 전원이 재계약을 했다"고 언급했다. 이에 방시혁은 "BTS 정도 아티스트한테는 선택지가 많지 않나. 
근데 그들이 저희랑 재계약을 선택해줬다는 자체가 제가 매니지먼트 수장으로서, 음반 만드는 레이블 수장으로서 BTS와 일해왔던 역사 인정해주고, 
저희가 BTS와 잘했다는 걸 충분히 받아들여주신거라서 저한테는 치하 같았다"고 말했다.
		
		</pre>
		<br><br>
		<a href="loginmain.jsp">메인페이지로 이동</a>
	<%}
%>
</body>
</html>