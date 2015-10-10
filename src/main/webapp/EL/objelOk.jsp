<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
%>

아이디: <%= id %><br>
비밀번호: <%= pw %><br>

<hr>

아이디: ${param.id}<br>
비밀번호: ${param.pw }<br>

아이디: ${param["id"]}<br>
비밀번호: ${param["pw"]}

<!-- paramValues 요청 파라미터(배열)를 참조하는 객체 (추가예정) -->

<hr>

application scope: ${applicationScope.application_name }<br>
session scope: ${sessionScope.session_name }<br>
page scope: ${pageScope.page_name }<br>
request scope: ${requestScope.request_name }
<p>page scope 가 출력이 안되는 이유는 같은 페이지가 아닌 okel.jsp와 okelOk.jsp로 다른 페이지 이기 때문이다.
<br>request scope가 출력 안되는 이유는 같은 request 객체가 아니기 때문이다. 

<hr>

context 초기화 파라미터 (Web.xml 에서 데이터 가져오기) <br>
School: ${initParam.school }<br>
animans: ${initParam.animals }

<hr>
<!-- cookie 객체를 참조하는 객체 (추가예정)--> 






</body>
</html>