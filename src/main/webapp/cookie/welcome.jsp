<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 
 <h3> 5초 후에 F5 키를 누르면 로그아웃 된것을 확인할 수 있습니다.</h3>
<%
	boolean bChk = false;

	Cookie[] cookies = request.getCookies();
	
	for(int i=0; i<cookies.length; i++){
		
		String id = cookies[i].getValue();
		
		if (id.equals("test")){
			out.println(id + "님 안녕하세요~~" + "<br>");
			bChk = true;
		}
	}
	
	if (bChk == false)
		out.println("로그아웃 되었습니다." + "<br>");
		
%>

<a href="logout.jsp"> 로그아웃하기</a>
 

</body>
</html>