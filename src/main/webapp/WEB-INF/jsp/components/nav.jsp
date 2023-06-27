<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar">
	
	<div class="container">
		<ul>	
			<c:if test="${not empty pageContext.request.remoteUser }">
			<li><a href="/auction">Auction</a></li>
			
			<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
		    <sec:authorize access="hasAuthority('ROLE_ADMIN')">
			<li><a href="/users">Users</a></li>
			</sec:authorize>
			
			<li><a href="/items">Items</a></li>
			<li>${pageContext.request.remoteUser }</li>
			<li>
				<form:form action="${pageContext.request.contextPath}/logout"><button>Logout</button></form:form>
			</li>
			</c:if>

			<c:if test="${empty pageContext.request.remoteUser }">
			<li><a href="/signin">Signin</a></li>
			<li><a href="/signup">Signup</a></li>
			</c:if>
			
			<li><a href="/">Homepage</a></li>	
		</ul>
	</div>
            
</nav>