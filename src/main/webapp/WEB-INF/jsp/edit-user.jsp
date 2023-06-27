<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Manage User</title>
</head>
<body>
    <h1>Manage User</h1>
    
	<form:form action="/edit-user/${user.id}" method="POST" modelattribute="user">
		<label for="username">Username: </label>
		<input type="text" id="username" name="username" value="${user.username}" required></input><br><br>
		
		<label for="email">Email:</label>
		<input type="email" id="email" name="email" value="${user.email}" required></input><br><br>
		
		<input type="checkbox" id="role_admin" name="role_admin">
		<label for="role-admin">Role-admin</label><br><br>

		<button type="button" onclick="location.href='/users'">Cancel</button>
		<input type="submit" value="Update">
	</form:form>
	
	<c:forEach var="role" items="${user.roles}">
	<c:if test="${role.name ==  'ROLE_ADMIN'}">
	<script>
		document.getElementById('role_admin').checked = true;
	</script>
	</c:if>
	</c:forEach>
</body>
</html>