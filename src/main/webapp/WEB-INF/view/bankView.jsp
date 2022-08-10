<%@page import="com.gang.start.bankbook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankView Page</h1>
	<%
		ArrayList<BankBookDTO> ar = (ArrayList<BankBookDTO>)request.getAttribute("list");
	
	%>
	<% for(BankBookDTO bankBookDTO : ar) { %>
		<h3>BookNum : <%=bankBookDTO.getBooknum() %></h3>
		<h3>BookName : <%=bankBookDTO.getBookname() %></h3>
		<h3>BookRate : <%=bankBookDTO.getBookrate() %></h3>
		<h3>BookSale : <%=bankBookDTO.getBooksale() %></h3>
		<hr><hr>
	<% } %>

</body>
</html>