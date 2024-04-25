<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<title>Admin Portal</title>
<style>
    /* Custom styles for the form */
    
    body {
        background: #CBC3E3; /* Background color */
        color: #fff; /* Text color */
        font-family: Arial, sans-serif;
        display: flex;
        align-items: center;
        justify-content: center;
        min-height: 100vh;
        margin: 0;
    }

    .container {
        max-width: 400px;
        background-color: #FF7F50;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
        text-align: center;
    }

    .form-group {
        margin-bottom: 20px;
    }

    .btn-primary {
        background-color: #007bff;
        border-color: #007bff;
        color: #fff;
        text-transform: uppercase;
    }

    .btn-primary:hover {
        background-color: #0056b3;
        border-color: #0056b3;
    }
</style>
</head>
<body>

<div class="container">
    <h2 class="mb-4">Welcome to Admin Portal</h2>
    <br><br>
    <div class="form-group">
        <a href="addS">
            <button class="btn btn-primary btn-lg btn-block" type="submit" name="signup">Sign Up</button>
        </a>
    </div>
    <br>
    <div class="form-group">
        <a href="addL">
            <button class="btn btn-primary btn-lg btn-block" type="submit" name="login">Log In</button>
        </a>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
