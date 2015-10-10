<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	Date d = new Date();
	d.setSeconds(d.getSeconds()+2);  /* 2초 추가후 출력하기 위해. */
	out.print(d.toString());	
%>
 