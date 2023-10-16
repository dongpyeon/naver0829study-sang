<%@page import="java.text.SimpleDateFormat"%>
<%@page import="myshop.data.MyShopDto"%>
<%@page import="java.util.List"%>
<%@page import="myshop.data.MyShopDao"%>
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
	.shoptb thead tr th{
	background-color: #ccf;
	text-align: center;
	}
</style>
<script>

</script>
</head>
<body>
<%
	//dao 선언
	MyShopDao dao=new MyShopDao();
	//list 가져오기
	List<MyShopDto> list=dao.getAllSangpums();
	//날짜 출력하기 위한 형식
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH시");
%>
<div class="input-group" style="width:600px;">
  <h5 class="alert alert-danger" style="width:600px;">총 <%=list.size()%>개의 상품이 있습니다
  <button type="button" class="btn btn-outline-info btn-sm" style="float: right"
    onclick="location.href='myshopinform.jsp'">상품등록</button>
  </h5>  
</div>
<table class="table table-bordered shoptb" style="width:600px;">
	<thead>
		<tr>
			<th width="50">번호</th>
			<th width="150">상품명</th>
			<th width="80">색상</th>
			<th width="100">가격</th>
			<th width="100">등록일</th>
			<th width="50">삭제</th>			
		</tr>
	</thead>
	<tbody>

	</tbody>
</table>
</body>
</html>