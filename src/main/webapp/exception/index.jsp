<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ page errorPage="errorPage.jsp" web.xml 에 기술할면 이 부분은 필요없음 %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
	int i = 4/0;	/* 0으로 나눌 수 없는 오류를 강제로 발생시킨다. */ 
%>	

</body>
</html>