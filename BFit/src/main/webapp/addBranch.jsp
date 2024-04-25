<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Add Branch</title>
    <style>
        body {
            background-color: #005A9C; /* Background color */
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 500px;
            background-color: #fffdd0;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
            margin: 0 auto;
            margin-top: 50px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
            color: #fff;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="mb-4">Add Branch</h2>
    <form:form action="addbranch" modelAttribute="addbranch1">
        <div class="form-group">
            <label for="loc">Location:</label>
            <input type="text" class="form-control" id="loc" name="loc" placeholder="Enter Location" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Enter Email" required>
        </div>
        <div class="form-group">
            <label for="cno">Contact No:</label>
            <input type="number" class="form-control" id="cno" name="cno" placeholder="Enter Contact No" required>
        </div>
        <div class="form-group">
            <label for="capacity">Capacity:</label>
            <input type="number" class="form-control" id="capacity" name="capacity" placeholder="Enter Capacity" required>
        </div>
        <div class="form-group">
            <label for="adminId">Enter Admin ID:</label>
            <input id="adminId" class="form-control" placeholder="Admin ID" type="number" name="adminid" value="<%=request.getParameter("id") %>"/>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
