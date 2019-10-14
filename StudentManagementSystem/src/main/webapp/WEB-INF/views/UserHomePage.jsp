<%@page import="com.capg.sms.beans.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"></head>

</head>
<body>
	<jsp:include page="userNavbar.jsp"></jsp:include>

	<%
		Student student = (Student) session.getAttribute("student");
		if (student != null) {
			out.print("<br><br>");
			out.print("<h1 align=center>Hello " + student.getFname() + "</h1>");
		} else {
			out.print(student);
			 response.sendRedirect("./login"); 
		}
	%>






</body>
</html>
