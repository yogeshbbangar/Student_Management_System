<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Data</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"></head>

</head>
<body>
	
<br>
	<h1 align=center>Sign Up</h1>
	<div class="col-md-4 offset-4 mt-4 card">
		<div class="card-body">
			<form action="./userRegister" method="post">
				<label for="regno">Reg no.</label>
				<div class="form-group">
					<input type="text" class="form-control" name="regno">
				</div>
				<label for="password">Password</label>
				<div class="form-group">
					<input type="password" class="form-control" name="password">
				</div>
				<label for="fname">First Name</label>
				<div class="form-group">
					<input type="text" class="form-control" name="fname">
				</div>
				<label for="lname">Last Name</label>
				<div class="form-group">
					<input type="text" class="form-control" name="lname">
				</div>
				<label for="email">Email Id</label>
				<div class="form-group">
					<input type="text" class="form-control" name="email">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-lg btn-block" value="Register User">Register User</button>
				</div>
				<p>
					Already a member? <a href="./login">Login</a>
				</p>
			</form>
		</div>
	</div>
	<br>
	
	<h1 align="center">${msg}</h1>
</body>
</html>