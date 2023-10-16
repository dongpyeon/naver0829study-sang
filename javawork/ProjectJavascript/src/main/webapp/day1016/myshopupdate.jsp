<%@page import="myshop.data.MyShopDto"%>
<%@page import="myshop.data.MyShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	//한글 
	request.setCharacterEncoding("utf-8");
	
	//dao,dto 선언
	MyShopDao dao = new MyShopDao();
	MyShopDto dto = new MyShopDto();
	
	//num포함 모든 데이터 읽기
	String sangpum=request.getParameter("sangpum");
	int price=Integer.parseInt(request.getParameter("price"));
	int num = Integer.parseInt(request.getParameter("num"));
	String photo=request.getParameter("photo");
	String color=request.getParameter("color");
	
	//dto에 담기
	dto.setSangpum(sangpum);
	dto.setPrice(price);
	dto.setPhoto(photo);
	dto.setColor(color);
	dto.setNum(num);
	
	//update메서드 호출
	dao.updateShop(dto);
	
	//myshop.jsp로 리다이렉트로 이동
	response.sendRedirect("myshop.jsp");
%>