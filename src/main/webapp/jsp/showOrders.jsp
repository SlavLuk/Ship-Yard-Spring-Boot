
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

table,tr,th,td{
 border:1px solid black;
 border-collapse: collapse;
}
th,td{
padding: 10px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders</title>
</head>
<body>

<h1>Orders</h1>
<table>
  <tr>
   <th>Order Number</th>
   <th>Shipping Company Name</th>
   <th>Ship Name</th>
   <th>Order Date</th>
   
  </tr>
  <tr>
    <c:forEach items="${orders}" 
                 var="order">
      <tr> 
      	<td>${order.oid}</td>
        <td>${order.shippingCompany.name}</td>
        <td>${order.ship.name}</td>
        <td>${order.date}</td>       
        
      </tr>
    </c:forEach>
  </tr>
</table>
<a href="/index.html">Home</a>
</body>
</html>