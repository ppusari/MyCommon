<%@page import="com.ppusari.database.login.MemberDto"%>
<%@page import="com.ppusari.database.login.MemberDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% 
	request.setCharacterEncoding("UTF-8");
	String id = (String)session.getAttribute("id");
	
	MemberDao dao = MemberDao.getInstance();
	MemberDto dto = dao.getMember(id);	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javaScript" src="members.js"></script>
</head>
<body>

	<form action="modifyOk.jsp" method="post" name="reg_frm">
		아이디: <%= dto.getId() %> <br>		
		비밀번호: <input type="password" name="pw" size="20"><br>
		비밀번호확인: <input type="password" name="pw_check" size="20"><br>
		이름: <%= dto.getName() %><br>
		전화번호: <input type="text" name="phone" size="20" value="<%= dto.getPhone()%>"><br>
		<input type="button" value="수정" onclick="updateInfoConfirm()">
		<input type="reset" value="취소" onclick="javascript:window.location='login.jsp'"> 
	</form>
	
</body>
</html>