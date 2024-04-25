<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Of Events</title>
</head>
<body>
<h1>List Of All Events</h1>

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
		
			</tr>
			
		</c:forEach>
	</table>

</body>
</html>