<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if (id.equals("test") && pw.equals("1234")){		
		session.setAttribute("id", id); /* 사용자가 입력한 세션을 저장하는 부분 */
		response.sendRedirect("welcome.jsp");
	}
	else {
		response.sendRedirect("login.jsp");
	}
%>

</body>
</html>