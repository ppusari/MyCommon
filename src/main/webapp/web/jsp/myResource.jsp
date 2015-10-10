<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Resource</title>
</head>
<body>

<!-- 기본 이미지 경로는 아래와 같이 패키지명(my) 부터 시작한다. -->
<p> <img src="/my/resources/cat.jpg">

<!-- "#myResource" 을 처리했기 때문에 myResource를 사용할 수 있음 -->
<p> <img src="/my/myResources/cat.jpg">

</body>
</html>