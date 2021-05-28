<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
	<!-- 
	<meta charset="ISO-8859-1">
	-->
	<title>Welcome</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
	<style>
	
	.enlargable:hover{
	  transform: scale(1.2);
	  border:2px solid white;
	  z-index: 2;
	}
	</style>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>

	<header>
      <div class="bg-dark collapse" id="navbarHeader" style="">

      </div>
      <div class="navbar navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
          <a href="#" class="navbar-brand d-flex align-items-center">
            <strong>About</strong>
          </a>
          <button class="navbar-toggler collapsed enlargable" type="button"  aria-label="Toggle navigation" onclick="document.forms['logoutForm'].submit()">
			Logout
          </button>
        </div>
      </div>
    </header>
      
      <section class="jumbotron text-center">
        <div class="container">

          <c:if test="${pageContext.request.userPrincipal.name != null}">
	        <form id="logoutForm" method="POST" action="${contextPath}/logout">
	            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        </form>
	        
	        <br>
			<!-- 
	        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
	         -->
	        <h2>Welcome ${pageContext.request.userPrincipal.name} !</h2>
	      </c:if>
	      
          <p class="lead text-muted">Something short and leading about the collection below—its contents, the creator, etc. Make it short and sweet, but not too short so folks don't simply skip over it entirely.</p>
          <p>
          	<form action="/" method="GET">
				<input type="hidden" name="formid" value="goshop">
				<input type="submit" value="What would you like to do ?" class="btn btn-primary my-2">
			</form>
			          
            <a href="#" class="btn btn-secondary my-2 enlargable">
            <form action="/viewinvoices" method="GET">
            	<i class="bi bi-files"></i>
				<input type="hidden" name="formid" value="goshop">
				<input type="submit" value="View Invoices" class="btn btn-secondary my-2 ">
			</form></a>

            <a href="#" class="btn btn-primary my-2 enlargable">
          	<form action="/doshop" method="GET">
				<input type="hidden" name="formid" value="goshop">
				<input type="submit" value="Go Shopping" class="btn btn-primary my-2 ">
				<i class="bi bi-cart4"></i>
			</form></a>
          </p>
        </div>
      </section>
      
      <hr>
      
      <!-- 
	<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
    </c:if>
    </div>
  
 
	<h1>Welcome...........To our Shopping Site....<%=session.getAttribute("uname") %></h1>
	 
	<hr>
	
	<h1>Go Shopping....</h1>
	 -->

</body>
</html>