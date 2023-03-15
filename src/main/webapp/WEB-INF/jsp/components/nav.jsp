<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<nav class="navbar">
	
	<div class="container">
		<ul>	
			<c:if test="${not empty pageContext.request.remoteUser }">
			<li><a href="/auction">Auction</a></li>
			
			<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
		    <sec:authorize access="hasAuthority('ROLE_ADMIN')">
			<li><a href="/users">Users</a></li>
			</sec:authorize>
			
			<li>${username }</li>
			<li>
				<form:form action="${pageContext.request.contextPath}/logout"><button>Logout</button></form:form>
			</li>
			</c:if>

			<c:if test="${empty pageContext.request.remoteUser }">
			<li><a href="/signin">Signin</a></li>
			</c:if>		
		</ul>
	</div>
            
</nav>