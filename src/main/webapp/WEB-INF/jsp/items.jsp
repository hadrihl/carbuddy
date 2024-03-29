<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CarBuddy | Items</title>
    <style>
    	table, th, td {
    		border: 1px solid black;
    		border-collapse: collapse;
    	}
    </style>
</head>
<body>
	<%@ include file="components/nav.jsp" %>
    <h1>Manage Items</h1>
    
    <c:if test="${empty items}">
    <div class="container"><p>No items found.</p></div>
    <a href="/add-item"><button>Add Item</button></a>
    </c:if>
    
    <c:if test="${not empty items}">
    <div class="container">
    	<table>
    		<tr>
    			<th>#</th>
    			<th>Item Name</th>
    			<th>Description</th>
    			<th>Price (MYR)</th>
    			<th>#Action</th>
    		</tr>
    		
    		<c:forEach var="item" items="${items}" varStatus="row">
    		<tr>
    			<td>${row.index + 1}</td>
    			<td>${item.name}</td>
    			<td>${item.description}</td>
    			<td>${item.originalPrice}</td>
    			
    			<td>
    			<a href="/edit-item/${item.id}">Edit</a> &nbsp;
    			<a href="/delete-item/${item.id}">Delete</a></td>
    		</tr>
    		</c:forEach>
    	</table>
    	
    	</br></br><a href="/add-item"><button>Add Item</button></a>
    </div>
    </c:if>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-timeago/1.6.7/jquery.timeago.min.js" type="text/javascript"></script>
     	<script>
     		jQuery(document).ready(function() {
     		  jQuery("time.timeago").timeago();
     		});
     	</script>
</body>
</html>