<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>BFit Pro Plan</title>
    <style>
        /* Custom styles for the form */
        body {
            background-color: #87CEEB;
            font-family: Arial, sans-serif;
            color: #fff;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }

        .container {
            max-width: 800px;
            background-color: #FFD580;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
        }

        .form-group {
            margin-bottom: 20px;
        }

        .btn-primary {
            background-color: #fff;
            border-color: #007bff;
            color: #fff;
            font-weight: bold;
        }

        .btn-primary:hover {
            background-color: #fff;
            border-color: #0056b3;
            color: #0056b3;
        }

        h2 {
            text-align: center;
            color: #007bff;
        }

        h3 {
            color: #007bff;
            text-align: center;
            margin-top: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #007bff;
            padding: 8px;
            text-align: left;
        }

        tr {
            background-color: #ADD8E6;
        }

        a {
            text-decoration: none;
            color: #007bff;
        }

        a:hover {
            color: #0056b3;
        }

        button a {
            text-decoration: none;
            color: #fff;
        }

        button {
            background-color: #007bff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            font-weight: bold;
            color: #fff;
            cursor: pointer;
        }

        button:hover {
            background-color: #fff;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">BFit Pro Plan</h2>
        <div class="form-group">
            <h3>List Of All Events</h3>
            <table>
                <tr>
                    <th>ID</th>
                    <th>EVENT NAME</th>
                    <th>STATUS</th>
                    <th>BRANCH ID</th>
                    <th>SUBSCRIPTION ID</th>
                </tr>
                <c:forEach var="e" items="${events}">
                    <tr>
                        <td>${e.getId()}</td>
                        <td>${e.getName()}</td>
                        <td>${e.getStatus()}</td>
                        <td>${e.branch.getId()}</td>
                        <td>${e.subscription.getId()}</td>
                    </tr>
                </c:forEach>
            </table>
            <br><br>
            <button><a href="buyH">Buy BFit Home Plan</a></button>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
