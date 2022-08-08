<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Member Search</h1>

<form action="search" method="post">
	<input type="text" name="search" placeholder="id값을 입력하세요">
	<input type="button" name="b1" value="search">
	<input type="reset" name="r1" value="초기화">
	<input type="submit"  value="SUBMIT">
	
	<!-- type을 생략하면 submit이 기본 -->
	<button type="submit">BUTTON</button>

</form>

</body>
</html>