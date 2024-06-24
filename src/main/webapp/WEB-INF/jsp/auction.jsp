<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>CarBuddy | Auction</title>
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
            margin: 20px 0;
        }
        h1 {
			color: white;
        }
        h2, h3 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
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
        .container {
            padding: 20px;
        }
    </style>
</head>
<body>
	<header>
        <h1>Auctions - Hi-fi Cars Pte Ltd</h1>
    </header>
    
    <main>
        <c:if test="${empty items}">
            <div class="container">
                <p>No items found.</p>
                <a href="/add-item"><button>Add Item</button></a>
            </div>
        </c:if>
        
        <c:if test="${not empty items}">
            <div class="container">
                <table>
                    <tr>
                        <th>#</th>
                        <th>Item Name</th>
                        <th>Description</th>
                        <th>Current Bid</th>
                        <th>Action</th>
                    </tr>
                    
                    <c:forEach var="item" items="${items}" varStatus="row">
                    <tr>
                        <td>${row.index + 1}</td>
                        <td>${item.name}</td>
                        <td>${item.description}</td>
                        <td>${item.currentBid}</td>
                        <td><a href="/bid/${item.id}"><button>Bid</button></a></td>
                    </tr>
                    </c:forEach>
                </table>
                
                <br><br><a href="/add-item"><button>Add Item</button></a>
            </div>
        </c:if>
    </main>
    
    <footer>
        <p>&copy; 2024 <a href="/">Hi-fi Cars Pte Ltd</a>. All rights reserved.</p>
    </footer>

</body>
</html>