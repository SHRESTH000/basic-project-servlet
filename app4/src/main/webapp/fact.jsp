<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${email}
<hr>
<div class="container">

<form action="factorialServlet" method="post">

<label>Enter your Number</label>
<input type="text" name="num" class="number" placeholder="Enter your number">
<input type="submit" value="Find factorial">
<a href="scopedata1.jsp">Click here to another page</a>

</form>
<h1>the answer is : ${result}</h1>
</div>

</body>
</html>