<%@page import="com.ppusari.database.login.MemberDto"%>
<%@page import="com.ppusari.database.login.MemberDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MemberDao dao = MemberDao.getInstance();
	
	int checkNum = dao.userCheck(id, pw);	
	if (checkNum == -1){
%>
	<script language="javascropt">
		alert("아이디가 존재하지 않습니다.");
		history.go(-1);
	</script>
<%
	} else if (checkNum == 0){	
%>
		<script language= "javascriot">
			alert("비밀번호가 틀립니다.");
			history.go(-1);
		</script>
<% 
	} else if (checkNum == 1){
		
		MemberDto dto = dao.getMember(id);
		 
		if (dto == null){
%>
			<script language="javascript">
				alert("존재하지 않는 회원 입니다.");
				history.go(-1);
			</script>	
<%		
		} else{
			String name = dto.getName();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("ValidMem", "yes");
			response.sendRedirect("com.ppusari.database.login.main.jsp");
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
loginOk.jsp
</body>
</html>