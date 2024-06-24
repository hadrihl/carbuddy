<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CarBuddy | Cars</title>
</head>
<body>
	<div class="container">
		<h1>Cars list</h1>
		
		<div class="container">
			<c:if test="${empty cars}">
			<p>No car(s) found.</p>
			
			<a href="/cars/new">Add new car</a>
			</c:if>
		
			<c:if test="${not empty cars}">
			<table>
				<tr>
					<th>#</th>
					<th>Brand</th>
					<th>Model</th>
					<th>Year</th>
					<th>Price</th>
					<th>#Action</th>
				</tr>
				
				<c:forEach var="car" items="cars" varStatus="row">
				<tr>
					<td>${row.index + 1}</td>
					<td>${car.brand}</td>
					<td>${car.mode}</td>
					<td>${car.year}</td>
					<td>${car.price}</td>
					<td>
						<a href="/cars/${car.id}">bid</a>
					</td>
				</tr>
				</c:forEach>
				
			</table>
			</c:if>
			
		</div>
	</div>
	
	<footer style="margin-top: 50px;"><a href="/">CarBuddy</a> &copy; 2024. Made with love in Penang.</footer>
</body>
</html>