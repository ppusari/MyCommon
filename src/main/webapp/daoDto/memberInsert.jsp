<%@page import="com.ppusari.database.dto.MemberDto"%>
<%@page import="com.ppusari.database.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
	MemberDto dto = new MemberDto("testid", "1234", "고양이", "010-5555-5555");
	
	MemberDao dao = new MemberDao();
	dao.memberInsert(dto);
	
	out.println("데이터가 삽입 되엇습니다.");
%>
	<p><a href="memberSelect.jsp">확인하러 가기</a>

</body>
</html>