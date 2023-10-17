<%@page import="simpleboarddata.SimpleBoardDto"%>
<%@page import="simpleboarddata.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//num 얻기
	String num = request.getParameter("num");
	//dao 선언
	SimpleBoardDao dao = new SimpleBoardDao();
	//delete 메서드 호출 글만 지워진다.
	dao.deleteBoard(num);
	
	//list.jsp로 리다이렉트 이동
	response.sendRedirect("list.jsp");
%>