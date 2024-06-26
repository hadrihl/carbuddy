<header><h1>Welcome to CarBuddy Hi-fi Cars Pte Ltd Portal</h1></header>
<nav>
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/about">About</a></li>	
        <li><a href="/register">Register</a></li>
        <li><a href="/contact">Contact Us</a></li>
        
        <c:if test="${empty pageContext.request.remoteUser}">
        <li><a href="/login">Login</a></li>
        
        </c:if>
        
        <c:if test="${not empty pageContext.request.remoteUser}">
        <li><a href="/cars">Browse Cars</a></li>
        <li><a href="/appointments">Appointments</a></li>
        
        <li><a href="#" id="logout-link">Logout</a></li>
        </c:if>
        
        
    </ul>
</nav>
<form:form id="logout-form" action="/logout" method="post"></form:form>
<script>
    document.getElementById('logout-link').addEventListener('click', function(event) {
        event.preventDefault(); // Prevent the default link behavior
        document.getElementById('logout-form').submit(); // Submit the hidden form
    });
</script>