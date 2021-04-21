<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="update" method="post">
		<label><b>Employee ID: </b></label> <input type="text" name="id"
			value="${employeeToUpdate.id}" readonly> <br>
		<br> <label><b>Full Name: </b></label> <input type="text"
			name="name" value="${employeeToUpdate.name}"> <br>
		<br> <label><b>Email: </b></label> <input type="text"
			name="email" value="${employeeToUpdate.email}"> <br>
		<br> <label><b>Password: </b></label> <input type="password"
			name="password" value="${employeeToUpdate.password}"> <br>
		<br> <input type="submit"
			style="background-color: #75C3E9; font-weight: bold">
	</form>

</body>
</html>