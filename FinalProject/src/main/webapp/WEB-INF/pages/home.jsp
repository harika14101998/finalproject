<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<body bgcolor="lightblue">
<center>
  <h1>Customer Details</h1>
  <div style="background-color:rgb(194, 178, 178);height:30px;width: 250px;">
<h3>
Id: &nbsp; <c:out value="${customer.id}"/><br>
</h3></div>

<div style="background-color:rgb(194, 178, 178);height:30px;width: 250px;">
  <h3>
    Mobile No : &nbsp; <c:out value="${customer.mobileNo}"/><br>
  </h3></div>

  <div style="background-color:rgb(194, 178, 178);height:30px;width: 250px;">
    <h3>
      Name :  &nbsp;<c:out value="${customer.name}"/><br>
    </h3></div>

<div style="background-color:rgb(194, 178, 178);height:30px;width: 250px;">
  <h3>
    Balance : &nbsp;<c:out value="${customer.balance}"/><br>
  </h3></div>

  <div style="background-color:rgb(194, 178, 178);height:30px;width: 250px;">
    <h3>
      Account Type : &nbsp;<c:out value="${customer.accountType}"/><br>
    </h3></div>
<br>
<a href="/signout">Sign out</a>

</center>

</body>
</html>