<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> <!-- body에서 exception 객체를 사용하기 위해 선언해야함. -->
<% response.setStatus(200); %> <!-- 나는 정상적인 페이지 입니다 라고 200을 강제로 바꿔준다. -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

사용자가 만든 에러 페이지 입니다.
<%= exception.getMessage() %>

</body>
</html>