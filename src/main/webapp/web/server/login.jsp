<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%
	String result= "";
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");	 
	String textarea = request.getParameter("textarea");
	

	
	if (id.equals("ppusari")) // id == "ppusari" 이렇게 사용하면 안된다.
	{
		if (pwd.equals("1234"))
		{
			result = "LOGIN_OK";		
		}	
	}
	else{
		result = "해당 아이디가 없습니다.";	
	}
	
	result = "okokok";

	out.print(result);
%>
 