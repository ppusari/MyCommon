<!-- http://localhost:8888/my/database/oracleConnectionPool.jsp -->

<!-- Servers-> context.xml 에 들어가서 아래 Resource 부분을 카피해야함 --> 
<!-- <Resource 
   	auth = "Container"
   	driverClassName = "oracle.jdbc.driver.OracleDriver"
   	url = "jdbc:oracle:thin:@localhost:1521:xe"
   	username = "ppusari"
   	password = "oraclepw"
   	name = "jdbc/Oracle11g"
   	type = "javax.sql.DataSource"
   	maxActive = "50"
   	maxWait = "1000"
/> -->

<%@page import="java.util.ArrayList"%>
<%@page import="com.ppusari.database.dto.MemberDto"%>
<%@page import="com.ppusari.database.connectionPool.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	MemberDao dao = new MemberDao();
	ArrayList<MemberDto> dtos = dao.memberSelect();

	for (int i=0; i<dtos.size(); i++){
		MemberDto dto = dtos.get(i);
		String name = dto.getName();
		String id = dto.getId();
		String pw = dto.getPw();
		String phone = dto.getPhone();
	
	out.println("이름: " + name + ", 아이디: " + id + ", 비밀번호: " + pw + ", 연락처: " + phone + "<br>");
} 	
%>

</body>
</html>