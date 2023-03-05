<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CarBuddy | Add User</title>
</head>
<body>
    <h1>Add User</h1>
    
	<form:form action="/add-user" method="POST" modelattribute="bidder">
		<label for="username">Username: </label>
		<input type="text" id="username" name="username" required></input><br><br>
		
		<label for="email">Email: </label>
		<input type="email" id="email" name="email" required></input><br><br>
		
		<label for="password">Password</label>
		<input type="password" id="password" name="password" required></input><br><br>
				
		<button type="button" onclick="location.href='/users'">Cancel</button>
		<input type="submit" value="Submit">
	</form:form>
    
</body>
</html>