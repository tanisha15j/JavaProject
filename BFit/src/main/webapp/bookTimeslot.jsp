<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Timeslot</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    body {
        background-color: #19003f;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
    }
    .container {
        margin-top: 100px;
        max-width: 400px;
        background-color: #FFD580;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
        padding: 20px;
    }
    .form-title {
        text-align: center;
        font-size: 24px;
        margin-bottom: 20px;
        color: #333;
    }
    .form-group label {
        font-weight: bold;
    }
    .form-control {
        border-radius: 5px;
    }
    .btn-primary {
        background-color: #007bff;
        border: none;
        width: 100%;
        color: #fff;
    }
    .btn-primary:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <div class="container">
        <div class="form-title">Book Timeslot</div>
       
       <form:form action="bookTS" modelAttribute="bookTS1">
            <div class="form-group">
                <label for="timeId">Enter Timeslot ID:</label>
                <input id="timeId" class="form-control" placeholder="Timeslot ID" type="number" name="tid" />
            </div>

            <div class="form-group">
                <label for="userId">Enter User ID:</label>
                <input id="userId" class="form-control" placeholder="User ID" type="number" name="uid"/>
            </div>

            <button type="submit" class="btn btn-primary">Book</button>
        </form:form>
    </div>
</body>
</html>
