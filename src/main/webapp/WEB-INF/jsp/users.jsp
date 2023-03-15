<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CarBuddy | Users</title>
    <style>
    	table, th, td {
    		border: 1px solid black;
    		border-collapse: collapse;
    	}
    </style>
</head>
<body>
	
	<%@ include file="components/nav.jsp" %>

    <h1>Manage Users</h1>
    
    <c:if test="${empty users}">
    <div class="container"><p>No user(s) found.</p></div>
    </c:if>
    
    <c:if test="${not empty users}">
    <div class="container">
    	<table>
    		<tr>
    			<th>#</th>
    			<th>Username</th>
    			<th>Email</th>
    			<th>#Action</th>
    		</tr>
    		
    		<c:forEach var="user" items="${users}" varStatus="row">
    		<tr>
    			<td>${row.index + 1}</td>
    			<td>${user.username}</td>
    			<td>${user.email}</td>
    			<td><a href="/edit-user/${user.id}">Edit</a>&nbsp;
    			<a href="/delete-user/${user.id}">Delete</a></td>
    		</tr>
    		</c:forEach>
    	</table>
    </div>
    </c:if>

	</br></br><a href="/add-user"><button>Add User</button></a>
    
</body>
</html>