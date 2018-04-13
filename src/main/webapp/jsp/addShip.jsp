
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
<title>Insert title here</title>
</head>
<body>

<h1>Add Ship</h1>


<form:form method="POST" modelAttribute="ship">
<table>

<tr>
  <td>Ship Name:</td>
  <td><form:input path="name"></form:input></td>
  <td><form:errors path="name"></form:errors></td>
 
</tr>
  <tr>
  <td>Passengers:</td>
  <td><form:input path="passengers"></form:input></td>
  <td><form:errors path="passengers"></form:errors></td> 
</tr>
 <tr>
  <td>Cost:</td>
  <td><form:input path="cost"></form:input></td>
  <td><form:errors path="cost"></form:errors></td> 
</tr>

 <tr>
  <td>Metres:</td>
  <td><form:input path="metres"></form:input></td>
  <td><form:errors path="metres"></form:errors></td> 
</tr>

 <tr>
        <td colspan="1"><input type="submit" value="Add"></td>
    </tr>

</table>
</form:form>
<a href="/index.html">Home</a>
</body>
</html>