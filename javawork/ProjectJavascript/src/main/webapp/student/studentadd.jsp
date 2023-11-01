<%@page import="studentsql.data.StudentDto"%>
<%@page import="studentsql.data.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//내용 읽어오기
	String name = request.getParameter("name");
	String blood = request.getParameter("blood");
	String phone = request.getParameter("phone");
	
	//dao, dto 선언
	StudentDao dao = new StudentDao();
	StudentDto dto = new StudentDto();
	
	//내용 넣기
	dto.setName(name);
	dto.setBlood(blood);
	dto.setPhone(phone);
	
	//insert 메서드 호출
	dao.insertStudent(dto);
%>