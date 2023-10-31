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
	div.myshopicon{
		margin: 30px 100px;
	}
	div.myshopicon *{
		cursor: pointer;
		margin-right:30xp;
		font-size:30px;
	}
	div.myshoplist{
		margin: 30px 50px;
	}
	div.box{
		width:150px;
		height: 250px;
		text-align: center;
		border: 5px solid;
		border-radius: 20px;
		float: left;
		margin-right: 30px;
		margin-bottom: 20px;
	}
	div.box figure img{
		width:130px;
		height: 140px;
	}
	.day{
		color:gray;
		font-size:0.8em;
		margin-right:20px;
	}
</style>
<script type="text/javascript">
	$(function(){
		grid();
		$(".myshopgrid").css("color:red");
		
		$(".myshopgrid").click(function(){
			$(this).css("color","red");
			$(".myshoplist").css("color","black");
			grid();
		});
		
		$(".myshoplist").click(function(){
			$(this).css("color","red");
			$(".myshopgrid").css("color","black");
			list();
		});
	});
	function grid()
	{
		$.ajax({
			type:"get",
			dataType:"xml",
			url:"myshoptoxml.jsp",
			success:function(res){
				let s ="";
				$(res).find("myshop").each(function(idx,item){
					let sangpum=$(item).find("sangpum").text();
					let price=$(item).find("price").text();
					let photo=$(item).find("photo").text();
					let color=$(item).find("color").text();
					let writeday=$(item).find("writeday").text();
					
					s+=
						`
						<div class="box">
							<figure>
								<img src="../image/shop/${photo}"
							</figure>
						</div>
						`;
					
				});
				
				$(".myshoplist").html(s);
			},
			statusCode:{
				404:function(){
					alert("json파일을 찾을수 없어요!")
				},
				500:function(){
					alert("서버오류..코드를 다시 한번 확인해보세요.")
				}
			}
		});
	}
	function list()
	{
		
	}
	
</script>
</head>
<body>
	<div class="myshopicon">
		<i class="bi bi-grid myshopgrid"></i>
		<i class="bi bi-card-list myshoplist"></i>
	</div>
	
	<div class="myshoplist">
		123
	</div>
</body>
</html>