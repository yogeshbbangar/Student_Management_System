<%@page import="com.capg.sms.beans.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"></head>

<title>User Data</title>
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
	<h1 align=center>Grade: ${grade}</h1>

	<div class="col-md-4 offset-4 mt-4 card">
		<div class="card-body">
			<form action="./getResult" method="post">
				<label for="email">Monthly Marks</label>
				<div class="form-group">
					<input type="text" class="form-control" name="monthly"
						value="${student.getMonthlyMarks()}">
				</div>
				<label for="email">Quaterly Marks</label>
				<div class="form-group">
					<input type="text" class="form-control" name="quatery"
						value="${student.getQuaterlyMarks()}">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-lg btn-block"
						value="Update">Update Marks</button>
				</div>
			</form>
		</div>
	</div>
	</div>
	<h1 align=center>${msg}</h1>
</body>
</html>