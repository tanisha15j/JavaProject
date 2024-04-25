<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Manager Portal</title>
    <style>
        /* Custom styles for the form */
        body{
        background-color: #CBC3E3;
        }
        .container {
            max-width: 500px;
            background-color: #b3cee5;
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
        }
     	.btn-primary:hover {
            background-color: #D7E5CA;
            border-color: #0056b3;
       	}
       	
       	 /* table {
        border-collapse: collapse;
        width: 50%;
    } */
   /*  th, td {
        border: 1px solid #000;
        padding: 8px;
        text-align: left;
    } */
    th {
        background-color: #007bff;
        color: #F0F8FF;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    </style>
</head>
<body>

	<div class="container mt-5">
	    <h2 class="mb-4">Welcome to Manager Portal</h2>
	    <br><br>
	    
	    <h3>List Of All Branches</h3>

			<table border="1px" style="border-collapse: collapse;">
				<tr>
					<th>ID</th>
					<th>LOCATION</th>
					<th>EMAIL</th>
					<th>CONTACT NO</th>
					<th>CAPACITY</th>
				</tr>
				<c:forEach var="b" items="${branches}">
					
					<tr>
						<td>${b.getId()}</td>
						<td>${b.getLoc()}</td>
						<td>${b.getEmail()}</td>
						<td>${b.getCno()}</td>
						<td>${b.getCapacity()}</td>		
				
					</tr>
					
				</c:forEach>
			</table>
			
			<br><br><br><br>
	   
	     <div class="form-group">
                <button class="btn btn-primary btn-lg btn-block" type="submit" name="signup"><a href="mgmS">Sign Up</a></button>
	        </div>
	        <br>
	        <div class="form-group">
	             <button class="btn btn-primary btn-lg btn-block" type="submit" name="login"><a href="mgmL">Log In</a></button>
	        </div>
	    
	</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
</html>