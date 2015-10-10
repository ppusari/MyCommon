<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3> 아이디는 test 비밀번호는 1234로 테스트 하세요.</h3>

	<form action="loginOk.jsp" method="post">
		아이디: <input type="text" name="id" size="10">
		비밀번호: <input type="text" name="pw" size="10">
		<input type="submit" value="Login">	
	</form>

</body>
</html>