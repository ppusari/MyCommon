<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
	String id;
	String pw;
	String result;
%>
<%
	id = request.getParameter("id");
	pw = request.getParameter("pw");
			
	if (id.equals("root"))
	{
		if (pw.equals("1234"))
		{
			response.sendRedirect("pass.jsp?id=" + id );			
		}
		else {
			response.sendRedirect("fail.jsp?id=" + id );			
		}
	}
	else{
		response.sendRedirect("fail.jsp?id=" + id );
	}		
%>
 

</body>
</html>