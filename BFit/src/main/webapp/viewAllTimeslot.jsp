<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Of Timeslots</title>
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
<h1>List Of All Timeslots</h1>

<table>
    <tr>
        <th>ID</th>
        <th>TIMESLOT</th>
        <th>COUNT</th>
        <th>STATUS</th>
        <th>EVENT ID</th>
        <th>Book</th>
    </tr>
    <c:forEach var="t" items="${timeslot}">
        <tr>
            <td>${t.getId()}</td>
            <td>${t.getTime_slot()}</td>
            <td>${t.getCount()}</td>
            <td>${t.getStatus()}</td>
            <td>${t.event.getId()}</td>
            <td><a href="bookT?id=${t.getId()}">Book</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
