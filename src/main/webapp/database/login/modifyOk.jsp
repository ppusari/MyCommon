<%@page import="com.ppusari.database.login.MemberDto"%>
<%@page import="com.ppusari.database.login.MemberDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="com.ppusari.database.login.MemberDto"/>
<jsp:setProperty property="*" name="dto"/>
 
<%
	String id = (String)session.getAttribute("id");
	String name = (String)session.getAttribute("name");
	dto.setId(id);
	dto.setName(name);
	
	MemberDao dao = MemberDao.getInstance();
	dao.updateMember(dto);	
%>

	<script language="javascript">
		alert("수정완료");
		document.location.href="login.jsp";
	</script>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>