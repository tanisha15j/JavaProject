<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Approve Subscription</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    body {
        background-color: #f2f2f2;
    }
    .container {
        margin-top: 50px;
        max-width: 400px;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
        padding: 20px;
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
    }
    .btn-primary:hover {
        background-color: #0056b3;
    }
    .form-title {
        text-align: center;
        font-size: 24px;
        margin-bottom: 20px;
        color: #333;
    }
</style>
</head>
<body>
    <div class="container">Approve Subscription</div>
       
       <form:form action="approveS" modelAttribute="appS1">
       		<div class="form-group">
                <label for="eventId">Enter Subscription ID:</label>
                <input id="eventId" class="form-control" placeholder="Event ID" type="number" name="eventid" />
            </div>

            <div class="form-group">
                <label for="mgmId">Enter Manager ID:</label>
                <input id="mgmId" class="form-control" placeholder="Manager ID" type="number" name="mgmid" value="<%=request.getParameter("id") %>"/>
            </div>

            <button type="submit" class="btn btn-primary">Approve</button>
    
		</form:form>
       
    </div>
</body>
</html>