<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CarBuddy | Add Item</title>
</head>
<body>
    <h1>Edit Item</h1>
    
	<form:form action="/add-item" method="POST" modelattribute="item">
		<label for="name">Item Name: </label>
		<input type="text" id="name" name="name" value="${item.name }" required></input><br><br>
		
		<label for="description">Description: </label>
		<input type="text" id="description" name="description" value="${item.description}" required></input><br><br>
		
		<label for="originalPrice">Price (*min MYR): </label>
		<input type="number" step="any" id="originalPrice" name="originalPrice" value="${item.originalPrice}" required></input><br><br>
				
		<button type="button" onclick="location.href='/items'">Cancel</button>
		<input type="submit" value="Update">
	</form:form>
    
</body>
</html>