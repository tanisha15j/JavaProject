<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>User Login</title>
    <style>
        /* Custom styles for the form */
          body{
        background-color: #468499;
        }
        .container {
            max-width: 500px;
            background-color: #F0F8FF;
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
	    <h2 class="mb-4">User Login</h2>
	    <form:form action="userlogin" modelAttribute="user1">
	    	
	    	<div class="form-group">
	            <label for="id">Id:</label>
	            <input type="number" class="form-control" id="password" name="id" placeholder="Enter Id" required>
	        </div>	        
	        <div class="form-group">
	            <label for="username">UserName:</label>
	            <input type="text" class="form-control" id="username" name="username" placeholder="Enter UserName" required>
	        </div>
	        <div class="form-group">
	            <label for="password">Password:</label>
	            <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
	        </div>
	        
	        <button type="submit" class="btn btn-primary"><a href="userDashBoard"></a>Submit</button>
	        
	        <h3>${saved}</h3>
	        
   
		</form:form>
	  
	</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</html>