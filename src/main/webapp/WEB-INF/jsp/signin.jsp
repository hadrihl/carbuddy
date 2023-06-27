<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Signin</title>
</head>
<body>
	<%@ include file="components/nav.jsp" %>
    <h1>Signin</h1>
    
    <div class="container">
    <form:form action="/login" method="post">
    	
    		<input type="text" id="username" name="username" placeholder="Enter username" autofocus required /> </br></br>
    		<input type="password" id="password" name="password" placeholder="Enter password" required /> </br></br>
    		
    		<input type="submit" value="Signin">
    	</form:form>
    </div>
    
    <c:if test="${not empty str_err}">
    <div class="container" style="margin-top: 10px;">
    	${str_err}
    </div>
    </c:if>
    
    <c:if test="${not empty str_success}">
    	<br><br>${str_success}<br><br>
    </c:if>

</body>
</html>