<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Welcome to CMS</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background: #F0F8FF; /* Background color */
            font-family: Arial, sans-serif;
            color: #fff; /* Text color */
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            background-color: #19003f;       
        }

        .container {
            max-width: 800px; /* Increased container size */
            background-color: #FF7F50;
            padding: 40px; /* Increased padding */
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        h2 {
            text-align: center;
            color: #007bff;
        }

        .form-group {
            text-align: center;
        }

        .btn-primary {
            background-color: 	#008000;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            text-transform: uppercase;
            font-weight: bold;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="container mt-5">
    <h2 class="mb-4">Lets be Fit..</h2>
    
    <div class="form-group">
        <a href="adminH">
            <button class="btn btn-primary form-control" name="admin">Admin</button>
        </a>
    </div>
    <div class="form-group">
        <a href="managerH">
            <button class="btn btn-primary form-control" name="manager">Manager</button>
        </a>
    </div>
    <div class="form-group">
        <a href="userH">
            <button class="btn btn-primary form-control" name="user">User</button>
        </a>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
