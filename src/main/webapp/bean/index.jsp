<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:useBean id="student" class="com.ppusari.bean.Student" scope="page"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:setProperty property="name" name="student" value="조병국"/>
	<jsp:setProperty property="age" name="student" value="10"/>
	<jsp:setProperty property="grade" name="student" value="3"/>
	<jsp:setProperty property="school" name="student" value="월송초"/>
	
	이름: <jsp:getProperty property="name" name="student"/><br>
	나이: <jsp:getProperty property="age" name="student"/><br>
	학년: <jsp:getProperty property="grade" name="student"/><br>
	학교: <jsp:getProperty property="school" name="student"/><br>
	
</body>
</html>