<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<!-- jstl.jar 과 standard.jar 두 개 라이브러리 로드필수 (pom.xml 에 기록해도 됨 -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="varName" value="varValue"/>
	varName: <c:out value="${varName }"/>
	
	<c:remove var="varName"/>
	varName: <c:out value="${varName }"/>
	
	<hr>
	
	<c:catch var="error">
		<%= 2/0 %>
	</c:catch>
	<br>
	<c:out value="${error }"/>
	
	<hr>
	
	<c:if test="${1+2 == 3 }">
		1 + 2 = 3
	</c:if>
	
	<hr>
	
	<c:forEach var="i" begin="0" end="10" step="1">
		${i }
	</c:forEach>
	
	


	

</body>
</html>