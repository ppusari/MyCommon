<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	Enumeration enumeration = session.getAttributeNames();

	while (enumeration.hasMoreElements()){
		String sName = enumeration.nextElement().toString();
		String sValue = (String)session.getAttribute(sName);
		
		if (sValue.equals("test")){
			session.removeAttribute(sName);  /* 세션을 삭제하는 부분 */
			out.println(sValue + " 님 로그아웃 되었습니다.<p>");
		}
	}
	
	/* session.invalidate(); 모든 세션을 삭제하는 명령어 */	
%>

<a href="sessiontest.jsp">sessionTest</a>

</body>
</html>