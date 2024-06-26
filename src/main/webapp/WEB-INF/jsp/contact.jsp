<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CarBuddy | Contact</title>
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
    input, textarea {
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
        <h1>Contact Us - Hi-fi Cars Pte Ltd</h1>
    </header>
    <main>
        <h2>We'd Love to Hear from You!</h2>
        <p>If you have any questions, feedback, or need assistance, please feel free to contact us using the form below. Our team is here to help you with any inquiries you may have.</p>

        <form:form action="/contact" method="post" modelattribute="message">
            <label for="name">Name:</label>
            <input type="text" id="sender" name="sender" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="subject">Subject:</label>
            <input type="text" id="subject" name="subject" required>

            <label for="message">Message:</label>
            <textarea id="textmessage" name="textmessage" rows="6" required></textarea>

            <button type="submit">Send Message</button>
        </form:form>
    </main>
    <footer>
        <p>&copy; 2024 <a href="/">Hi-fi Cars Pte Ltd</a>. All rights reserved.</p>
    </footer>
</body>
</html>