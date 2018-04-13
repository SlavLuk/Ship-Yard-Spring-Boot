
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
<title>Insert title here</title>
</head>
<body>

<h1>Ships</h1>
<table>
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
<a href="/index.html">Home</a>
</body>
</html>