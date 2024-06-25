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
<style>
    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
        padding: 8px;
    }
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }
    header, footer {
        background-color: #333;
        color: #fff;
        padding: 10px 20px;
        text-align: center;
    }
    main {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        margin: 20px;
    }
    h2, h3 {
        color: #333;
    }
    nav {
        background-color: #333;
        overflow: hidden;
    }
    nav ul {
        list-style-type: none;
        margin: 0;
        padding: 0;
        display: flex;
    }
    nav ul li {
        flex: 1;
    }
    nav ul li a {
        display: block;
        color: white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }
    nav ul li a:hover {
        background-color: #ddd;
        color: black;
    }
    h1 {
        color: #fff;
    }
    form {
    	margin-bottom: 30px;
    }
</style>
</head>
<body>
	<%@ include file="components/nav.jsp" %>
	
	<main>
		<h2>Cars list</h2>
		
		<!-- Search form -->
	     <form:form action="/search" method="post">
	         <input type="text" name="keyword" placeholder="Search cars by brand, model, year...">
	         <button type="submit">Search</button>
	     </form:form>
		
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
				
				<c:forEach var="car" items="${cars}" varStatus="row">
				<tr>
					<td>${row.index + 1}</td>
					<td>${car.brand}</td>
					<td>${car.model}</td>
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
	</main>
	
	<footer style="margin-top: 50px;"><a href="/">CarBuddy</a> &copy; 2024. Made with love in Penang.</footer>
</body>
</html>