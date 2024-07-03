<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<h1>congrats you have sucessfully login</h1>
	<div class="container">
		<table class=table>
			<thead>
				<tr>
					<td>NAME</td>
					<td>PASSWORD</td>
					<td>NAME</td>
					<td>EMAIL</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${userDto.username}</td>
					<td>${userDto.password}</td>
					<td>${userDto.name}</td>
					<td>${userDto.email}</td>
				</tr>
			</tbody>
		</table>
		<a href="showAllRecordServlet"><button type="button"
				class="btn btn-primary">Click here to Show All Records</button></a>

	</div>

</body>
</html>