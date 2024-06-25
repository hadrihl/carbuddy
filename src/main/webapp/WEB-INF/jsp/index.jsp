<!DOCTYPE html>
<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
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
    <style>
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
        h1, h2, h3 {
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
        	color: white;
        }
    </style>
</head>
<body>
	<%@ include file="components/nav.jsp" %>

    <main>
        <h2>Your Trusted Platform for Buying and Selling Used Cars</h2>
        <p>At Hi-fi Cars Pte Ltd, we provide a seamless experience for both car buyers and sellers. Explore our features to make the most out of our platform.</p>
        
        <h3>Our Features</h3>
        <ul>
            <li>Browse and search for cars by make, model, year, and price.</li>
            <li>Register and login to post or manage your car listings.</li>
            <li>Book appointments for test drives.</li>
            <li>Contact sellers directly through the platform.</li>
        </ul>
        
        <p>Whether you're looking to buy your next car or sell your current one, Hi-fi Cars Pte Ltd has got you covered.</p>
    </main>
    
    <footer>
        <p>&copy; 2024 <a href="/">Hi-fi Cars Pte Ltd</a>. All rights reserved.</p>
    </footer>
</body>
</html>
