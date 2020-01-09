<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<style>
body{
		background-image: url('https://previews.123rf.com/images/microphoto1981/microphoto19811809/microphoto1981180900035/109882983-falling-dollar-banknotes-money-rain-flat-vector-illustration-isolated-on-white-background-american-d.jpg');
		background-repeat: no-repeat;
	}

</style>

</head>
<body>
<center>
<h1>Recharge Amount</h1>
<form method="get" action="processrecharge">

<div>
<span>Amount </span>
<input name="amount" type="number" />
</div><br>
<input type="submit" value="Recharge"/>
<center>
</form>
</body>
</html>