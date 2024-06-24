<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CarBuddy | Register</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
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
    }
    h1 {
        color: white;
    }
    form {
        display: flex;
        flex-direction: column;
    }
    label {
        margin-bottom: 5px;
        font-weight: bold;
    }
    input {
        margin-bottom: 15px;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    button {
        padding: 10px;
        background-color: #333;
        color: #fff;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    button:hover {
        background-color: #555;
    }
</style>
</head>
<body>
    <header>
        <h1>Register - Hi-fi Cars Pte Ltd</h1>
    </header>
    <main>
        <h2>Create Your Account</h2>
        <p>Fill out the form below to create your account.</p>

        <form:form action="/register/new" method="post" modelattribute="user">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>

            <button type="submit">Register</button>
        </form:form>
    </main>
    <footer>
        <p>&copy; 2024 <a href="/">Hi-fi Cars Pte Ltd</a>. All rights reserved.</p>
    </footer>
    <script>
	    function checkPasswordMatch() {
	        var password = document.getElementById("password").value;
	        var confirmPassword = document.getElementById("confirmPassword").value;
	        if (password !== confirmPassword) {
	            document.getElementById("passwordMismatchMessage").style.display = "block";
	        } else {
	            document.getElementById("passwordMismatchMessage").style.display = "none";
	        }
	    }
	</script>
</body>
</html>