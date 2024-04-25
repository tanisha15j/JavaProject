<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Manager SignUp</title>
    <style>
        /* Custom styles for the form */
        body{
        background-color: #CBC3E3;
        }
        .container {
            max-width: 500px;
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
        }
        .form-group {
            margin-bottom: 20px;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
    </style>
</head>
<body>

	<div class="container mt-5">
	    <h2 class="mb-4">Manager SignUp</h2>
	    <form:form action="mgmsignup" modelAttribute="mgms1">
	    	
	        
	        <div class="form-group">
	            <label for="name">Name:</label>
	            <input type="text" class="form-control" id="name" name="name" placeholder="Enter Name" required>
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
	            <label for="username">UserName:</label>
	            <input type="text" class="form-control" id="username" name="username" placeholder="Enter UserName" required>
	        </div>
	        <div class="form-group">
	            <label for="password">Password:</label>
	            <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
	        </div>
	     	<div class="form-group">
	            <label for="branch">Branch Id:</label>
	            <input type="number" class="form-control" id="branch" name="bid" placeholder="Enter Branch" required>
	        </div>
	        
	        <button type="submit" class="btn btn-primary"> <a href="managerLogin"></a> Submit</button>
   
		</form:form>
	  
	</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</html>