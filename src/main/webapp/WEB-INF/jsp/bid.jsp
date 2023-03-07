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
		<input type="number" step="any" id="currentBid" name="currentBid" value="${item.currentBid}" readonly></input><br><br>
	
		<c:if test="${empty bidder}"><p>Status: No one has bid this item.</c:if>
		<c:if test="${not empty bidder}"><label for="username">Current Highest bidder:</label> <span>${bidder.username}</span></c:if>
		
		</br></br><label>Auction time created: ${item.endTime}</br>
		
		</label>
		<c:if test="${not empty timeleft}"><p>Auction time left: ${timeleft} minutes</p></c:if>
		<c:if test="${empty timeleft}"><p>Status: Auction expired.</p>
			<form:form action="/extend-auction/${item.id}" method="post">
			<button>Extend Auction</button>
			</form:form>
		</c:if>
		
	</c:if>
	
	</br></br></br></br>
	<h1>Place Your Bid</h1>
	<form:form action="/bid/${item.id}" method="post" modelAttribute="bid">
		
		<label for="username">Username: </label>
		<input type="text" id="username" name="username" required></br></br>
		
		<label for="amount">Your bid: </label>
		<input type="number" step="any" id="amount" name="amount" required/></br>
		<p style="font-size: 12px;"><i>Place your bid here, and make sure that your bid is higher than current bid.</i></p>
		</br>
	
		<button type="button" onclick="location.href='/items'">Cancel</button>
		<button type="submit" id="submit" name="submit">Submit</button>
	</form:form>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js" integrity="sha512-STof4xm1wgkfm7heWqFJVn58Hm3EtS31XFaagaa8VMReCXAkQnJZ+jEy8PCC/iT18dFy95WcExNHFTqLyp72eQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script>
    	$('#submit').prop("disabled", true);
    	
    	$('input').on("change", function() {
    		verifyAmount("amount");
    	});
    	
    	function verifyAmount(element) {
    		var submitBtn = document.getElementById("submit");
    		var amountInput = document.getElementById("amount");
    		
    		if(amountInput.value > ${item.currentBid}) {
    			submitBtn.removeAttribute("disabled");
    		} else {
    			submitBtn.setAttribute("disabled", "disabled");
    		}
    	}
    </script>
</body>
</html>