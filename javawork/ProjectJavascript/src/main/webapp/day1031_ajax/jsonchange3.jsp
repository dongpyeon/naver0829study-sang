<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name1="김기자";
	String addr1="서울";
	String name2="이영자";
	String addr2="부산";
	String name3="강호동";
	String addr3="마산";
	String name4="김무스";
	String addr4="춘천";
	
	JSONObject ob1 = new JSONObject();
	ob1.put("name", name1);
	ob1.put("addr",addr1);

	JSONObject ob2 = new JSONObject();
	ob2.put("name", name2);
	ob2.put("addr",addr2);
	
	JSONObject ob3 = new JSONObject();
	ob3.put("name", name3);
	ob3.put("addr",addr3);
	
	JSONObject ob4 = new JSONObject();
	ob4.put("name", name4);
	ob4.put("addr",addr1);
	
	JSONArray arr = new JSONArray();
	arr.add(ob1);
	arr.add(ob2);
	arr.add(ob3);
	arr.add(ob4);
	
%>
<%=arr.toString() %>