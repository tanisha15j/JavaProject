<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Update Event</title>
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
	    <h2 class="mb-4">Update Event</h2>
	    <form:form action="updateEvent" modelAttribute="updateE1">
	    
	    	<div class="form-group">
	            <label for="eventid">Event Id:</label>
	            <input type="number" class="form-control" id="event" name="eid" placeholder="Enter Event Id" required>
	        </div>
	    	
	         <div class="form-group">
	            <label for="name">Event Name:</label>
	            <input type="text" class="form-control" id="name" name="name" placeholder="Enter Event Name" required>
	        </div>	        
	           
	        <div class="form-group">
	            <label for="sub">Subscription Id:</label>
	            <input type="number" class="form-control" id="sub" name="sid" placeholder="Enter Subscription Id" required>
	        </div>
	      
	        <button type="submit" class="btn btn-primary">Update</button>
   
		</form:form>
	  
	</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</html>