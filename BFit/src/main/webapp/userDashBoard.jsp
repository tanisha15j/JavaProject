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
    <title>User Dashboard</title>
    <style>
        body {
            background-color: #468499;
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
            background-color: #D2E0FB;
            border-color: #007bff;
            color: #007bff;
            font-weight: bold;
        }

        .btn-primary:hover {
            background-color: #D7E5CA;
            border-color: #0056b3;
            color: #0056b3;
        }
        .head{
       		background-color: #2f0484;
        }

        h2 {
            text-align: center;
            color: #FF0000;
        }

        h4 {
            color: #007bff;
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
    </style>
</head>
<body>
    <div class="container mt-5">
    <div class="head">
        <h2 class="mb-4">Do not fret, level up your health and fitness.</h2>
      </div>  
        <h4>List Of All Branches</h4>

        <table>
            <tr>
                <th>ID</th>
                <th>LOCATION</th>
                <th>EMAIL</th>
                <th>CONTACT NO</th>
                <th>CAPACITY</th>
            </tr>
            <c:forEach var="b" items="${branchs}">
                <tr>
                    <td>${b.id}</td>
                    <td>${b.loc}</td>
                    <td>${b.email}</td>
                    <td>${b.cno}</td>
                    <td>${b.capacity}</td>
                </tr>
            </c:forEach>
        </table>
        
        <br> <br>
        
        <h4>List Of All Events</h4>
        <table>
            <tr>
                <th>ID</th>
                <th>EVENT NAME</th>
                <th>BRANCH ID</th>
                <th>SUBSCRIPTION ID</th>
            </tr>
            <c:forEach var="e" items="${events}">
                <tr>
                    <td>${e.id}</td>
                    <td><a href="bookE">${e.name}</a></td>
                    <td>${e.branch.id}</td>
                    <td>${e.subscription.id}</td>
                </tr>
            </c:forEach>
        </table>
        
        <br> <br>
        
        <h4>List Of Subscription Plans</h4>
        <table>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>TYPE</th>
                <th>PRICE</th>
                <th>BUY</th>
            </tr>
            <c:forEach var="s" items="${subs}">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>${s.type}</td>
                    <td>${s.price}</td>
                    <td>
                        <c:choose>
                            <c:when test="${s.id == 1}">
                                <a href="buy1?id=${s.id}">Buy</a>
                            </c:when>
                            <c:when test="${s.id == 2}">
                                <a href="buy2?id=${s.id}">Buy</a>
                            </c:when>
                            <c:when test="${s.id == 3}">
                                <a href="buy3?id=${s.id}">Buy</a>
                            </c:when>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
        <br> <br>
        
        <div class="form-group">
            <button class="btn btn-primary btn-lg btn-block" type="submit" name="logout"><a href="logoutU">Logout</a></button>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
