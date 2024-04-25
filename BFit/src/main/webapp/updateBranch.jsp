<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Update Branch</title>
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
	    <h2 class="mb-4">Update Branch</h2>
	    <form:form action="updateBranch" modelAttribute="updateB1">
	    	
	    	 <div class="form-group">
                <label for="branchId">Enter Branch ID:</label>
                <input id="branchId" class="form-control" placeholder="Branch ID" type="number" name="bid" value="<%=request.getParameter("id") %>"/>
            </div>	        
	        <div class="form-group">
	            <label for="loc">Location:</label>
	            <input type="text" class="form-control" id="loc" name="loc" placeholder="Enter Location" required>
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
	        
	        <button type="submit" class="btn btn-primary">Update</button>
   
		</form:form>
	  
	</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</html>