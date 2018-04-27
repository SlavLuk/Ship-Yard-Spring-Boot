
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ships</title>
</head>
<body>
<div class="container">
<h1>Ships</h1>
<table class="table table-striped">
  <tr>
   <th>Name</th>
   <th>Passengers</th>
   <th>Cost</th>
   <th>Length(Metres)</th>
   <th>Shipping Company</th>
  </tr>
  <tr>
    <c:forEach items="${ships}" 
                 var="ship">
      <tr> 
      	<td>${ship.name}</td>
        <td>${ship.passengers}</td>
        <td>${ship.cost}</td>
        <td>${ship.metres}</td>       
        <td>${ship.shippingCompany.name}</td>
      </tr>
    </c:forEach>
  </tr>

</table>
<div>
<a href="/index.html">Home</a>
</div>
</div>
</body>
</html>