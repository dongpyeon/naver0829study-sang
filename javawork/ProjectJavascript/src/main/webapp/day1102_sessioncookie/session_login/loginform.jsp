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
	//로그인 상태인지 세셔값을 얻는다. (loginid가 체크되어있는지)
	String loginid = (String)session.getAttribute("loginid");
	String savestatus = (String)session.getAttribute("savestatus");
	boolean bCheck;
	if(savestatus==null || savestatus.equals("no")){
		bCheck = false; //체크를 안했을 경우		
	}else{
		loginid = (String)session.getAttribute("loginid");
		bCheck = true; //체크를 했을 경우
	}
	
	//체크를 안햇을 경우는 아이디를 업앤다.
	if(!bCheck) loginid="";
%>
<body>
	<div style="margin:30px 100px">
		<form action="loginaction.jsp" method="post">
			<table class="table table-bordered" style="width:200px;border:5px groove gray;">
				<caption align="top">
					<label><input type="checkbox" name="saveid"
					<%=bCheck?"checked":"" %>>아이디저장</label>
				</caption>
				<tr>
					<td width=150>
						<input type="text" class="form-control" autofocus required
						 placeholder="아이디" name="loginid" value=<%=loginid %>>
					</td>
					<td rowspan="2" width=100>
						<button type="submit" style="width:100%;height:100px">로그인</button>
					</td>
				</tr>
				<tr>
					<td width=150>
						<input type="password" class="form-control" required
						 placeholder="비밀번호" name="loginpass">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>