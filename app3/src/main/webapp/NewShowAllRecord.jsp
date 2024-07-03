<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show All Record</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style type="text/css">
  table, th, td {
	border: 1px solid black;
}
  </style>
</head>
<body>
<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<td>NAME</td>
					<td>PASSWORD</td>
					<td>NAME</td>
					<td>EMAIL <a href="sortRecordByEmailServlet"><button type="button" class="btn btn-sucess">Sort AS</button></a></td>
					<td>ACTION</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userlist}" var="user">
					<tr>
					  <td>${user.username}</td>
					  <td>${user.password}</td>
					  <td>${user.name}</td>
					  <td>${user.email}</td>
					  <td><a href="deleteRecordServlet?username=${user.username}"><button type="button" class="btn btn-danger">Delete</button></a>			
					  <a href="editRecordServlet?username=${user.username}"><button type="button" class="btn btn-sucess">Update</button></a></td>	
				</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	
	<label><span>${msg}</span></label>

	<div class="container">
	${link}
		<table class="table table-hover">
			<thead>
				<tr>
					<td>NAME</td>
					<td>PASSWORD</td>
					<td>NAME</td>
					<td>EMAIL</td>
					<td>ACTION</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userDtolist}" var="user1">
					<tr>
					  <td>${user1.username}</td>
					  <td>${user1.password}</td>
					  <td>${user1.name}</td>
					  <td>${user1.email}</td>
					  <td><a href="deleteRecordServlet?username=${user.username}"><button type="button" class="btn btn-danger">Delete</button></a>			
					  <a href="editRecordServlet?username=${user.username}"><button type="button" class="btn btn-sucess">Update</button></a></td>	
				</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	



</body>
</html>