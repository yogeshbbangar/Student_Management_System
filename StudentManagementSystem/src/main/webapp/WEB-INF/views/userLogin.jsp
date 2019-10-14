<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"></head>

<title>Login</title>
</head>
<body>
	<jsp:include page="userNavbar.jsp"></jsp:include>

	<div class="col-md-4 offset-4 mt-4 card">
		<div class="card-body">
			<h1 class="h1 text-center">Login</h1>
			<form action="./userLogin" method="post">
			<div class="form-group">
				<label for="username">Reg no.</label>
				<div class="form-group">
					<input type="text" class="form-control" name="regno" required>

				</div>
				</div>
				<label for="password">Password</label>
				<div class="form-group">
					<input type="password" class="form-control" id="password"
						name="password" required>

				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-lg btn-block">Login User</button>

				</div>
				<div class="mt-4">
					<div class="d-flex justify-content-center links">
						New User? SignUp Here <a href="./register" class="ml-2">Sign Up</a>
					</div>
			</form>
		</div>

	</div>




</body>
</html>