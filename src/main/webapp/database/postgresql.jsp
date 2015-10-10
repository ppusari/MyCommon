<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
 <%!
	Connection connection = null;
	Statement statement = null;	
	ResultSet resultSet = null;
	String driver = "org.postgresql.Driver";
	String url = "jdbc:postgresql://localhost:5432/postgres";
	String user = "postgres";
	String upw = "1234";
	String sql = "SELECT * FROM member";
%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 
<%
	try
	{
		Class.forName(driver);
		connection = DriverManager.getConnection(url, user, upw);
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()){			
			String id = resultSet.getString("id");
			String pw = resultSet.getString("pass");
			String name = resultSet.getString("name");
						
			out.println("아이디: " + id + ", 비밀번호: " + pw + " 이름: " + name + "<br/>");			
		}
	}
	catch(Exception e){
		System.out.println("ERROR: " + e.getMessage());		
	}
	finally {
	try{
		if (resultSet != null) resultSet.close();
		if (statement != null) statement.close();
		if (connection != null) connection.close();
	}
	catch(Exception e2) {
		e2.printStackTrace();
	}
}		
%>

</body>
</html>