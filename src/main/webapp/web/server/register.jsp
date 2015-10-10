<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	
	String result = id+"님 가입 완료";	
	out.print(result);	
%>
 