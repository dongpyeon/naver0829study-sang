<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="studentsql.data.StudentDto"%>
<%@page import="java.util.List"%>
<%@page import="studentsql.data.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String search = request.getParameter("search");
	
	//dao 선언
	StudentDao dao = new StudentDao();
	
	//search 단어가 포함된 목록 열기
	List<StudentDto> list = dao.getSearchStudent(search);
	
	//날짜 포맷 지정
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	//위으 리스트 목록을 JSONArry로 배열 형태의 json으로 구현
	JSONArray arr = new JSONArray();
	//for 문
	for(StudentDto dto:list)
	{
		JSONObject ob = new JSONObject();
		ob.put("num", dto.getNum());
		ob.put("name", dto.getName());
		ob.put("blood", dto.getBlood());
		ob.put("phone", dto.getPhone());
		ob.put("writeday",dto.getWriteday());
		
		arr.add(ob);
	}
%>
<%= arr.toString()%>