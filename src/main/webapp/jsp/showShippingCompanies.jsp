
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
<title>Shipping Companies</title>
</head>
<body>

<h1>Shipping Companies</h1>
<table>
  <tr>
   <th>Name</th>
   <th>Home Port</th>
   <th>Balance</th>
   <th>Ships</th>
  
  </tr>
  <tr>
    <c:forEach items="${shippingCompany}" 
                 var="shipCompany">
      <tr> 
      	<td>${shipCompany.name}</td>
        <td>${shipCompany.homePort}</td>
        <td>${shipCompany.balance}</td>
        <td>
        	<c:forEach items="${shipCompany.ships}" var="ship">
       		 <ul>
       			 <li>${ship}</li>
        
       			 </ul>
        
       		 </c:forEach>
                
        </td>       
       
      </tr>
    </c:forEach>
  </tr>
</table>
<a href="/index.html">Home</a>
</body>
</html>