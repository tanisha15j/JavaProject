<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Of Branches</title>
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
<h1>List Of All Branches</h1>

	<h3>${saved}</h3>

	<table border="1px" style="border-collapse: collapse;">
		<tr>
			<th>ID</th>
			<th>LOCATION</th>
			<th>EMAIL</th>
			<th>CONTACT NO</th>
			<th>CAPACITY</th>
		</tr>
		<c:forEach var="b" items="${branches}">
			
			<tr>
				<td>${b.getId()}</td>
				<td>${b.getLoc()}</td>
				<td>${b.getEmail()}</td>
				<td>${b.getCno()}</td>
				<td>${b.getCapacity()}</td>		
				<td><a href="deleteB?id=${b.getId()}">Delete</a></td>
				<td><a href="updateB?id=${b.getId()}">Update</a></td> 
			</tr>
			
		</c:forEach>
	</table>

</body>
</html>