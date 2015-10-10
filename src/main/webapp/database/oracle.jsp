<!-- http://localhost:8888/my/database/oracle.jsp -->

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%!
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "ppusari";
	String upw = "oraclepw";
	String query = "select * from member";			
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%	
		try {		
			Class.forName(driver);
			connection = DriverManager.getConnection(url, uid, upw);
			statement = connection.createStatement();
			resultSet =  statement.executeQuery(query);
			
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String pw = resultSet.getString("pw");
				String name = resultSet.getString("name");
				String phone = resultSet.getString("phone");
				
				out.println("아이디: " + id + ", 비밀번호: " + pw + "이름:" + name + "전화본호" + phone + "<br/>"); 
			}						
		}
		catch (Exception e){
			e.printStackTrace();
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