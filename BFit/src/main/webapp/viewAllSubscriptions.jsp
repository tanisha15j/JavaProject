<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Of Subscriptions</title>
</head>
<body>
<h1>List Of Subscription Plans</h1>

	<table border="1px" style="border-collapse: collapse;">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>TYPE</th>
			<th>PRICE</th>
		</tr>
		<c:forEach var="s" items="${subs}">
			
			<tr>
				<td>${s.getId()}</td>
				<td>${s.getName()}</td>
				<td>${s.getType()}</td>
				<td>${s.getPrice()}</td>
				<td><a href="buy?id=${s.getId()}">Buy Plan</a></td>
			</tr>
			
		</c:forEach>
	</table>

</body>
</html>