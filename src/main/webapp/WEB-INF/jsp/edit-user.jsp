<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CarBuddy | Edit User Profile</title>
</head>
<body>
    <h1>Add User</h1>
    
	<form:form action="/edit-user/${user.id}" method="POST" modelattribute="user">
		<label for="username">Username: </label>
		<input type="text" id="username" name="username" value="${user.username}" required></input><br><br>
		
		<label for="email">Email:</label>
		<input type="email" id="email" name="email" value="${user.email}" required></input><br><br>
				
		<button type="button" onclick="location.href='/users'">Cancel</button>
		<input type="submit" value="Submit">
	</form:form>
    
</body>
</html>