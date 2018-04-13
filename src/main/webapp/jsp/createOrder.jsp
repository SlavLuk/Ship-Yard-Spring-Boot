
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>


</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order</title>
</head>
<body>

<h1>New Order</h1>


<form:form  modelAttribute="info">
<table>

<tr>
  <td>Ship Name:</td>
 
  <td><form:select path="ship" items="${shipList}" /></td>
  
 
</tr>
<tr>
  <td>Shipping Company:</td>
 
  <td><form:select path="shippingCompany" items="${shipCompList}" /></td>
  
 
</tr>


 <tr>
        <td colspan="1"><input type="submit" value="Order Ship"></td>
    </tr>

</table>
</form:form>
<a href="/index.html">Home</a>
</body>
</html>