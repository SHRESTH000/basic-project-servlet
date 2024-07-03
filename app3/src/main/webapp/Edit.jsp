<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<form action="updateRecordServlet" method="post">
<label>UserName</label><br>
<input type="hidden" name="username" class="username" value="${userDto.username}"><br>
<label>Password</label><br>
<input type="text" name="password" class="password" value="${userDto.password}"><br>
<label>Name</label><br>
<input type="text" name="name" class="name" value="${userDto.name}"><br>
<label>Email</label><br>
<input type="text" name="email" class="email" value="${userDto.email}"><br>
<!-- <button type="submit">Edit</button> -->
<input type="Submit" class="submit" value="Update">
</form>
</div>

</body>
</html>