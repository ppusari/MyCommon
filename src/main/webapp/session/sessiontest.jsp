<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

세션 리스트를 목록<p>

<%
	Enumeration enumeration = session.getAttributeNames();

	boolean bChk = false;
	while(enumeration.hasMoreElements()){
			
		String sName = enumeration.nextElement().toString();
		String sValue = (String)session.getAttribute(sName);
		
		out.println("sName: " + sName + "<br>");
		out.println("sValue: " + sValue + "<p>");
		bChk = true;
	}
	
	if (bChk == false)
		out.println("세션이 하나도 없습니다.");
%>

</body>
</html>