<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

main.jsp 로부터 넘어온 forward.jsp 페이지 입니다.<br>
forward 기능의 특징은 URL 주소가 바뀌지 않고 호출한 쪽의 URL 이라는 것입니다.<br><p>

<%! String id, pw; %>
<%
	id = request.getParameter("id");
	pw = request.getParameter("pw");
%>

아이디: <%= id %> <br/>
패스워드: <%= pw %>

</body>
</html>