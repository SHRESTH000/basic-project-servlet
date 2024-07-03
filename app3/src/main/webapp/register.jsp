<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<label>${msg}</label>
	<div class=container>
		<form action="registrationServlet" class="form-control" method="post">

			<label>UserName</label> <input type="text"
				placeholder="Enter your Username" name="username" class="username"><br>
			<label>Password</label> <input type="password"
				placeholder="Enter your Password" class="password" name="password"><br>
			<label>Name</label> <input type="text" placeholder="Enter your name"
				class="name" name="name"><br> 
				<label>Email</label> 
				<input type="text" placeholder="Enter your email" class="email"
				name="email"> <br> <input type="submit"
				value="Register">
				<a href="login.jsp"> <button type="submit" class="btn btn-primary]"> Click here to Login</button></a>
		</form>

	</div>

</body>
</html>