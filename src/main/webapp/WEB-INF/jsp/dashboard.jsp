<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head><title>Admin Dashboard</title>
	<style>
    	table, th, td {
    		border: 1px solid black;
    		border-collapse: collapse;
    	}
    </style>
</head>
<body>
	<%@ include file="components/nav.jsp" %>
	<h1>Admin Dashboard</h1>
	<div>
		<h3>Manage Items</h3>
		
		<c:if test="${not empty items }">
		<table>
		<tr>
			<th>#</th>
			<th>name</th>
			<th>description</th>
			<th>price (MYR)</th>
			<th>item_owner</th>
			<th>Action</th>
		</tr>
		<c:forEach var="item" items="${items}" varStatus="row">
		<tr>
			<td>${row.index+1 }</td>
			<td>${item.name }</td>
			<td>${item.description }</td>
			<td>${item.originalPrice }</td>
			<td>${item.user.username }</td>
			<td>
				<a href="#">Edit</a>&nbsp;
				<a href="#">Delete</a>
			</td>
		</tr>
		</c:forEach>
		</table>
		</c:if>
	</div>
	
	<c:if test="${not empty users}">
	<h3>Manage Users</h3>
    <div class="container">
    	<table>
    		<tr>
    			<th>#</th>
    			<th>Username</th>
    			<th>Email</th>
    			<th>Role</th>
    			<th>#Action</th>
    		</tr>
    		
    		<c:forEach var="user" items="${users}" varStatus="row">
    		<tr>
    			<td>${row.index + 1}</td>
    			<td>${user.username}</td>
    			<td>${user.email}</td>
    			
    			<td>
				<c:forEach var="role" items="${user.roles}">
				<c:if test="${role.name == 'ROLE_ADMIN'}">admin&nbsp;</c:if>
				<c:if test="${role.name == 'ROLE_USER'}">user&nbsp;</c:if>
				</c:forEach>
				</td>

    			<td><a href="/edit-user/${user.id}">Edit</a>&nbsp;
    			<a href="/delete-user/${user.id}">Delete</a></td>
    		</tr>
    		</c:forEach>
    	</table>
    </div>
    </c:if>
	
	<div>
		<h3>Manage Auctions</h3>
		<c:if test="${empty items}">
		<div><p>No Item(s) found.</p></div>
		</c:if>
		
		<c:if test="${not empty items }">
		<table>
		<tr>
			<th>#</th>
			<th>Name</th>
			<th>Contact</th>
			<th>Price (MYR)</th>
			<th>currentBid (MYR)</th>
			<th>Action</th>
		</tr>
		<c:forEach var="item" items="${items}" varStatus="row">
		<tr>
			<td>${row.index+1 }</td>
			<td>${item.name }</td>
			<td>${item.user.username }</td>
			<td>${item.originalPrice }</td>
			<td>${item.currentBid }</td>
			<td>
				<a href="#">Manage</a>&nbsp;
				<a href="#">Delete</a>
			</td>
		</tr>
		</c:forEach>
		</table>
		</c:if>
	</div>
</body>
</html>