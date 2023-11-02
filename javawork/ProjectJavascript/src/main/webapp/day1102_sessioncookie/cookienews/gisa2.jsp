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
[OSEN=최나영 기자] 걸그룹 브브걸(BBGIRLS) 유정이 배우 이규한과의 러브스토리를 공개했다.

지난 1일 오후 10시 30분 방송된 MBC ‘라디오스타’가 ‘선남선녀’ 특집으로 꾸며진 가운데, 이날 유정은 처음으로 출연해 다양한 에피소드를 방출했다.

유정은 전 소속사 대표인 용감한 형제에게 서운한 점이 있다고 고백, “그때 대표님(용감한 형제)이 사무엘이라는 친구랑 같이 나왔었다. 
한 번쯤 ‘저희를 데리고 나와주셔야 했던 거 아닌가’라고 서운했었다”라고 말하는 동시에 “‘라디오스타’에서 대표님(용감한 형제) 이야기 잘하겠다고 
했다”라며 여전히 돈독한 관계임을 보여줬다.
		
		</pre>
		<br><br>
		<a href="loginmain.jsp">메인페이지로 이동</a>
	<%}
%>
</body>
</html>