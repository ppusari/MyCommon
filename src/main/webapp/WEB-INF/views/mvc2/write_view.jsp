<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="write" method="post">
			<input type="hidden" name="bId" value="${content_view.bId}">
			<tr>
				<td>이름2</td>
				<td><input type="text" name="bName" value="${content_view.bName}"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" value="${content_view.bTitle}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="bContent" value="${content_view.bContent}"></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="입력">
				<a href="list">목록보기</a>				
			</tr>
			
		</form>
	</table>

</body>
</html>