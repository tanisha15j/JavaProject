<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Of Users</title>
<style>
    body {
        background-color: #b3cee5;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }
    h1 {
        text-align: center;
        color: #007bff;
    }
    table {
        width: 100%;
        border-collapse: collapse;
    }
    th, td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #007bff;
        color: white;
    }
    tr:hover {
        background-color: #f5f5f5;
    }
    a {
        text-decoration: none;
        color: #007bff;
    }
</style>
</head>
<body>
<h1>List Of All Users</h1>

	<table border="1px" style="border-collapse: collapse;">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>CONTACT NO</th>
			<th>USERNAME</th>
			<th>STATUS</th>
		</tr>
		<c:forEach var="u" items="${users}">
			
			<tr>
				<td>${u.getId()}</td>
				<td>${u.getName()}</td>
				<td>${u.getEmail()}</td>		
				<td>${u.getCno()}</td>
				<td>${u.getUsername()}</td>	
				<td>${u.getStatus()}</td>	
			</tr>
			
		</c:forEach>
	</table>

</body>
</html>