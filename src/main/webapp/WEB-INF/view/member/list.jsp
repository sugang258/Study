<%@page import="com.gang.members.BankMembersDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%ArrayList<BankMembersDTO> ar = (ArrayList<BankMembersDTO>) request.getAttribute("list"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Member List Page</h1>

	<table border = "1">
	<thead>
	
	<tr>
	<th>username</th>
	<th>pw</th>
	<th>name</th>
	<th>email</th>
	<th>phone</th>
	</tr>
	</thead>
	<tbody>
	<tr>
	<%for (BankMembersDTO bankMembersDTO : ar) { %>
		
	<td><%= bankMembersDTO.getUserName() %> </td>
	<td><%= bankMembersDTO.getPassword() %> </td>
	<td><%= bankMembersDTO.getName() %></td>
	<td><%= bankMembersDTO.getEmail() %></td>
	<td><%= bankMembersDTO.getPhone() %></td>
	</tr>
	<% } %>
	</tbody>
	
</table>

</body>
</html>