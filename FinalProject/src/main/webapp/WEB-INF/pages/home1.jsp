<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  max-width: 300px;
  margin: auto;
  text-align: center;
  font-family: arial;
  background-color: #FFFFFF;
  border-radius: 8px;
}

.title {
  color: grey;
  font-size: 18px;
}

button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

a {
  text-decoration: none;
  font-size: 22px;
  color: black;
}

button:hover, a:hover {
  opacity: 0.7;
}

body{
		background-image: url('https://papers.co/wallpaper/papers.co-vy29-digital-abstract-blue-pattern-background-35-3840x2160-4k-wallpaper.jpg');
		background-repeat: no-repeat;
	}
	
	
</style>
</head>
<body>

<h2 style="text-align:center" ><font color="white"><b><c:out value="${customer.name}"/>'s Profile</b> </font></h2>
<br>
<div class="card">
 
  <h3>
Id: &nbsp; <c:out value="${customer.id}"/><br></h3>

<h3>
    Mobile No : &nbsp; <c:out value="${customer.mobileNo}"/><br>
  </h3>
  
    
    <h3>
    Balance : &nbsp;<c:out value="${customer.balance}"/><br>
  </h3>
  
  <h3>
      Account Type : &nbsp;<c:out value="${customer.accountType}"/><br>
    </h3>
  
  
  
  
</div>
<center>
<p><u><a href="/recharge"><font color="white">Recharge amount</font></a></u></p></center>
<p><u><center><a href="/signout"><font color="white">Sign Out</font></a></u></p></center>
</body>
</html>
  