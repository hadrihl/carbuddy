<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Signin</title>
</head>
<body>
    <h1>Signin</h1>
    
    <div class="container">
    <form:form action="/login" method="post">
    	
    		<label for="username">Username:</label>
    		<input type="text" id="username" name="username" autofocus required /> </br>
    		
    		<label for="password">Password:</label>
    		<input type="password" id="password" name="password" required /> </br>
    		
    		<input type="submit" value="Signin">
    	</form:form>
    </div>
    
    <c:if test="${not empty error_string}">
    <div class="container" style="margin-top: 10px;">
    	${error_string}
    </div>
    </c:if>

</body>
</html>