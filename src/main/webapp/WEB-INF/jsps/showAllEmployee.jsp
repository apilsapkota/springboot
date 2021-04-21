<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>


	<div class="container">
		<h1>Employee Data.............</h1>
		<br> <br>

		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Password</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${empList}" var="employee">
					<tr>
						<td>${employee.id}</td>
						<td>${employee.name}</td>
						<td>${employee.email}</td>
						<td>${employee.password}</td>
						<td><a href="updateEmployee?employeeId=${employee.id}"
							class="btn btn-primary">Update</a></td>
						<td><a href="register" class="btn btn-primary">Delete</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>


</body>
</html>
