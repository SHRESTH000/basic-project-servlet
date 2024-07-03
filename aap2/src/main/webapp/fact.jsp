<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="index.css">
<title>PARADOX CALCULATOR</title>
</head>
<body>
<header>
<h1> Welcome to PARADOX Calculator </h1>
</header>
<div class="cal">
<form  action="Calculator1" method="get">
<h2>Arthimetic Calculator Section</h2>
<input type="text" name="num1" placeholder="Enter your first number"><br>
<input type="text" name="num2" placeholder="Enter your second number"><br>
<input type="text" name="operator" placeholder=" Enter symbol('+','-','*','/')">
<!-- <span> Symbol are= "+","-","*","/"</span> <br> -->
<br>
<input type="button" name="+" value="+">
<input type="submit" value="calculate">
</form>
</div>
<div class="fact">
<form   action="factorialservlet">
<h2>Factorial Section</h2>
<input type="text" name="num" placeholder="Enter your number"><br>
<input type="submit" value="calculate  factorial">
</form>
</div>

</body>
</html>