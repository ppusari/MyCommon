<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

이 메시지는 출력되지 않습니다.

<!-- forward.jsp 페이지로 넘어가서 이 페이지 내용은 전혀 출력되지 않는다. -->
<jsp:forward page="forward.jsp">
	<jsp:param value="ppusari" name="id"/>
	<jsp:param value="1234" name="pw"/>
</jsp:forward>

이 메시지는 출력되지 않습니다.

</body>
</html>