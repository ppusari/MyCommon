<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="com.ppusari.database.dto.MemberDto" scope="page"/>
<jsp:setProperty name="member" property="name" value="조병국"/>
<jsp:setProperty name="member" property="id" value="ppusari"/>
<jsp:setProperty name="member" property="pw" value="1234"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름: <jsp:getProperty property="name" name="member"/><br>
	아이디: <jsp:getProperty property="id" name="member"/><br>
	비밀번호: <jsp:getProperty property="pw" name="member"/><br>
	
	<hr>	
	이름: <%= member.getName() %><br>
	아이디: <%= member.getId() %><br>
	패스워드: <%= member.getPw() %><br>
	
	<hr>	
	이름: ${member.name}<br>
	아이디: ${member.id}<br>
	패스워드: ${member.pw}<br>
	
	<hr>
	${(1>2) ? 1:2 }
	
</body>
</html>