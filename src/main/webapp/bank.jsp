<%@page import="com.gang.bankbook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.gang.bankbook.BankBookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bank Page</h1>
	<%
		BankBookDAO bankBookDAO = new BankBookDAO();
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
	%>


	<h1>Book List</h1>
	<% for(BankBookDTO bankBookDTO : ar) { %>
		<h3>BookNum : <%=bankBookDTO.getBooknum() %></h3>
		<h3>BookName : <%=bankBookDTO.getBookname() %></h3>
		<h3>BookRate : <%=bankBookDTO.getBookrate() %></h3>
		<h3>BookSale : <%=bankBookDTO.getBooksale() %></h3>
		<hr>
	<% } %>
</body>
</html>