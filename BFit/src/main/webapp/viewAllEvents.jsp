<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Of Events</title>
<style>
    body {
        background-color: #87CEEB;
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
<h1>List Of All Events</h1>

	<h3>${saved}</h3>
	
	<table border="1px" style="border-collapse: collapse;">
		<tr>
			<th>ID</th>
			<th>EVENT NAME</th>
			<th>STATUS</th>
			<th>ADMIN ID</th>
			<th>BRANCH ID</th>
			<th>SUBSCRIPTION ID</th>
		</tr>
		
		<c:forEach var="e" items="${events}">
			
			<tr>
				<td>${e.getId()}</td>
				<td>${e.getName()}</td>
				<td>${e.getStatus()}</td>	
				<td>${e.admin.getId()}</td>		
				<td>${e.branch.getId()}</td>	
				<td>${e.subscription.getId()}</td>	
				<td><a href="updateE?id=${e.getId()}">Update</a></td> 
			</tr>
			
		</c:forEach>
	</table>

</body>
</html>