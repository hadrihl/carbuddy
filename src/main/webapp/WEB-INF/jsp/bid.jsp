<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CarBuddy | Bid</title>
</head>
<body>
    <h1>Bid Item</h1>
    
    <c:if test="${not empty item}">
		<label for="name">Item Name: </label>
		<input type="text" id="name" name="name" value="${item.name}" readonly></input><br><br>
		
		<label for="description">Description: </label>
		<input type="text" id="description" name="description" value="${item.description}" readonly></input><br><br>
		
		<label for="currentBid">Bid (*min MYR): </label>
		<input type="number" step="any" id="currentBid" name="currentBid" value="${item.currentBid}" required></input><br><br>
	</c:if>
	
	</br></br>
	<form:form action="/bid/${item.id}" method="post" modelAttribute="bid">
		
		<label for="username">Username: </label>
		<input type="text" id="username" name="username" required></br></br>
		
		<label for="amount">Place your bid here: </label>
		<input type="number" step="any" id="amount" name="amount" required /></br></br>
	
		<button type="button" onclick="location.href='/items'">Cancel</button>
		<input type="submit" value="Submit">
	</form:form>
    
</body>
</html>