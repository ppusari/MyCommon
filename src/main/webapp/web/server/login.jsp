<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%
	String result= "";
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");	 
	String textarea = request.getParameter("textarea");
	

	
	if (id.equals("ppusari")) // id == "ppusari" �̷��� ����ϸ� �ȵȴ�.
	{
		if (pwd.equals("1234"))
		{
			result = "LOGIN_OK";		
		}	
	}
	else{
		result = "�ش� ���̵� �����ϴ�.";	
	}
	
	result = "okokok";

	out.print(result);
%>
 