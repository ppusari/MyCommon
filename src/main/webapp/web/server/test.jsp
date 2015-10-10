<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%
	String result= "";
	String textarea = request.getParameter("textarea");
	
	result = textarea;

	out.print(result);
%>
 