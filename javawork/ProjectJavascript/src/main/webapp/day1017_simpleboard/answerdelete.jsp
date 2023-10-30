<%@page import="simpleboarddata.AnswerBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//idx 얻기, num 읽기(컨텐트돌아가기위해 필요)
	String idx = request.getParameter("idx");
	String num = request.getParameter("num");
	//dao 선언
	AnswerBoardDao adao = new AnswerBoardDao();
	//delete 메서드 호출
	adao.deleteAnswer(idx);
	
	//content돌아가기
	response.sendRedirect("content.jsp?num="+num);
%>