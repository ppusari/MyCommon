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
%>

<%
	id = request.getParameter("id");
	pw = request.getParameter("pw");
			
	if (id.equals("test"))
	{
		if (pw.equals("1234"))
		{
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(5); /* 쿠키 유효기간을 설정 */
			response.addCookie(cookie);						
			response.sendRedirect("welcome.jsp");
		}
		else {
			response.sendRedirect("login.html");			
		}
	}
	else{
		response.sendRedirect("login.html");
	}		
		
%>
 

</body>
</html>