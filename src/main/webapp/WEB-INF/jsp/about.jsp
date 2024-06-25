<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About Us - Hi-fi Cars Pte Ltd</title>
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
        <h2>Welcome to Hi-fi Cars Pte Ltd</h2>
        <p>We are dedicated to providing a comprehensive and user-friendly platform for buying and selling used cars. Our portal offers a wide range of features to ensure a smooth and efficient experience for both buyers and sellers.</p>

        <h3>Features for Users</h3>
        <ul>
            <li>Register in the Portal &#x2705</li>
            <li>Login to the Portal &#x2705</li>
            <li>Post a Car for Sale along with Picture upload &#x2705</li>
            <li>Deactivate an Existing car sale</li>
            <li>Update their Profile after logging in</li>
            <li>Book an appointment for a test drive</li>
            <li>Post the bidding price</li>
        </ul>

        <h3>Features for Administrators</h3>
        <ul>
            <li>Register in the Portal &#x2705</li>
            <li>Login to the Portal &#x2705</li>
            <li>View List of Registered Users</li>
            <li>Mark a User as Administrator</li>
            <li>Activate / Deactivate a Car post</li>
            <li>Update their profile</li>
            <li>Approve or Deny the users appointment based on the bidding</li>
            <li>Transact the sales if the price is right</li>
        </ul>

        <h3>Common Features</h3>
        <ul>
            <li>Visit Home Page &#x2705</li>
            <li>View Car Listing &#x2705</li>
            <li>Search for a Car by Make, Model, Registration Year & Price Range &#x2705</li>
            <li>About Us Page &#x2705</li>
            <li>Contact Us Page &#x2705</li>
        </ul>

        <h3>Project Overview</h3>
        <p>As a freelance Web Developer, I have been tasked with developing this Used Car Sales portal. The portal is designed to cater to the needs of both regular users and administrators, providing a seamless experience for all involved parties. Whether you are looking to buy or sell a used car, Hi-fi Cars Pte Ltd is your go-to platform.</p>
    </main>
    <footer>
        <p>&copy; 2024 <a href="/">Hi-fi Cars Pte Ltd</a>. All rights reserved.</p>
    </footer>
</body>
</html>