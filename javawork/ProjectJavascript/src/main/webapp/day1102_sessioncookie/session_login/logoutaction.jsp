<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//loginok 세션 제거 - 개별적으로 지울수 있도록 removeAttribute를 넣는다.
	session.removeAttribute("loginok");
	//mainpage로 이동
	response.sendRedirect("loginmain.jsp");
%>