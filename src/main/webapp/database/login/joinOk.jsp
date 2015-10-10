<%@page import="com.ppusari.database.login.MemberDto"%>
<%@page import="com.ppusari.database.login.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="dto" class="com.ppusari.database.login.MemberDto"/>
<jsp:setProperty property="*" name="dto"/>
 
<%
	MemberDao dao = MemberDao.getInstance();
	if (dao.confirmId(dto.getId()) == MemberDao.MEMBER_EXISTENT){	
%>
		<script language="javascript">
			alert("아이디가 이미 존재합니다.");
			history.back();
		</script>
<%
	} else {
		int ri = dao.insertMember(dto);
		
		if (ri == MemberDao.MEMBER_JOIN_SUCCESS) {
			session.setAttribute("id", dto.getId());
%>
			<script language="javascript">
				alert("회원가입을 축하합니다.");
				document.location.href="login.jsp";
			</script>
<%
		} else {
%>
			<script language="javascript">
				alert("회원가입에 실패했습니다.");
			</script>
<%			
		}
	}		
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>