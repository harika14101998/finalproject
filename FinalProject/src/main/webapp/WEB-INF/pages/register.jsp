<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<body>
<form method="get" action="processregister">

<div>
<span>Mobile No </span>
<input name="mobileNo" type="text" />
</div>

<div>
<span>Name </span>
<input name="name" type="text" />
</div>

<div>
<span>Password </span>
<input name="password" type="password" />
</div>

<div>
<span>Account Type </span>
<input name="accountType" type="text" />
</div>

<div>
<span>Balance </span>
<input name="balance" type="number" />
</div>
<input type="submit" value="Submit"/>
</form>
</body>
</html>