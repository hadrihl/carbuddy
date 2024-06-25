<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CarBuddy | Add Car</title>
</head>
<body>
	<%@ include file="components/nav.jsp" %>
    <h1>Add Car <span>&#x1F697</span></h1>
    
	<form:form action="/cars/new" method="POST" modelattribute="item">
		<div class="form-group">
			<label for="name" style="padding-right:37px;">Brand Name: </label>
			<input type="text" id="brand" name="brand" required></input><br><br>
		</div>
		
		<div class="form-group">
			<label for="name" style="padding-right: 77px;">Model: </label>
			<input type="text" id="model" name="model" required></input><br><br>
		</div>	
		
		<div class="form-group">
			<label for="name" style="padding-right: 45px">Description: </label>
			<textarea id="description" name="description" rows="10" cols="50" required></textarea><br><br>
		</div>
		
		<div class="form-group">
			<label for="name" style="padding-right: 91px;">Year: </label>
			<input type="text" id="year" name="year" required></input><br><br>
		</div>
		
		<div class="form-group">
			<label for="name" style="padding-right: 75px;">Variant: </label>
			<input type="text" id="variant" name="variant" required></input><br><br>
		</div>
		
		<div class="form-group">
			<label for="name" style="padding-right: 35px;">Transmission: </label>
			<input type="text" id="transmission" name="transmission" required></input><br><br>
		</div>
		
		<div class="form-group">
			<label for="name" style="padding-right: 57px;">Fuel Type: </label>
			<input type="text" id="fueltype" name="fueltype" required></input><br><br>
		</div>
		
		<div class="form-group">
			<label for="description" style="padding-right: 64px;">Location: </label>
			<input type="text" id="location" name="location" required /><br><br>
		</div>
		
		<div class="form-group">
			<label for="originalPrice">Price (*min MYR): </label>
			<input type="number" id="price" name="price" required></input><br><br>
		</div>
				
		<div class="form-group">
			<button type="button" onclick="location.href=/cars">Cancel</button>
			<input type="submit" value="Submit">
		</div>
	</form:form>
    
    <footer style="margin-top: 50px;"><a href="/">CarBuddy</a> &copy; 2024. Made with love in Penang.</footer>
</body>
</html>