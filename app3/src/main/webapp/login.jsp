<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<label><center>${msgFromRegister}</center></label>

	<form action="Login2" method="post">
		<div class="form-group">
			<label for="username"> USERNAME</label> <input type="text"
				class="form-control" name="username" id="username"
				placeholder="enter your username"> <br> <br> <label
				for="pwd">PASSWORD</label> <input type="Password"
				class="form-control" name="password" id="pwd"
				placeholder="enter your password"> <input type="submit"
				value="login">
		</div>
	</form>
	<span>${msg}</span>
	<br>
	<label><span>New User Register Here</span></label>
	<a href="register.jsp"> Register</a>


</body>
</html>