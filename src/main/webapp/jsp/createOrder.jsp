
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
<title>Order</title>
</head>
<body>
<div class="container">
<h1>New Order</h1>


<form:form method="POST"  modelAttribute="info"  class="form-horizontal">
  <div class="form-group">
    <label class="control-label col-sm-2" for="shipname">Ship Name:</label>
    <div class="col-sm-10">
    
      <form:select path="ship" items="${shipList}" class="form-control" id="shipname" />
    
      
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-2" for="shipcom">Shipping Company:</label>
    <div class="col-sm-10"> 
    

  		<form:select path="shippingCompany" items="${shipCompList}" class="form-control" id="shipcom" />
      
    </div>
  </div>



  <div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Order Ship</button>
    </div>
  </div>
</form:form>
<div >
<a href="/index.html">Home</a>
</div>
</div>
</body>
</html>