<%@page import="com.capg.sms.beans.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/bootstrap.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"></head>




<title>Delete User</title>
</head>
<body>
	<jsp:include page="userNavbar.jsp"></jsp:include>

	<%
		Student student = (Student) session.getAttribute("student");
		if (student != null) {
		} else {
			out.print(student);
			 response.sendRedirect("./login"); 
		}
	%>

	<div class="col-md-4 offset-4 mt-4 card">
		<div class="card-body">
			<form action="./userDelete" method="post"">
				<label for="password">Password</label>
				<div class="form-group">
					<input type="password" class="form-control" id="password"
						name="password" required>

				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-lg btn-block" value="Delete Profile">Delete User</button>

				</div>
			</form>
		</div>

	</div>
	<h1 align=center>${msg}</h1>




</body>
</html>