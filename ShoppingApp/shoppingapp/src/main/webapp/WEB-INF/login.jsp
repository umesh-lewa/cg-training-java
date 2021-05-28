<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Log in with your account</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
      <style>
	
		.enlargable:hover{
		  transform: scale(1.2);
		  border:2px solid white;
		  z-index: 2;
		}
		
		.fa {
		  margin-left: -12px;
		  margin-right: 8px;
		}
		</style>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  </head>

  <body>

    <div class="container">
      <form method="POST" action="/login" class="form-signin">
      
      	<!-- 
      	<h2 class="form-heading">WEB-INF loginPage</h2>
      	 -->
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button id="loginbutton" class="btn btn-lg btn-primary btn-block enlargable" type="submit" onclick="loginclick()"><i id="loginbuttonicon" class=""></i>Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>
      </form>
    </div>
	
	<script>
	function loginclick() {
		document.getElementById("loginbuttonicon").classList.add("fa");
		document.getElementById("loginbuttonicon").classList.add("fa-refresh");
		document.getElementById("loginbuttonicon").classList.add("fa-spin");
	}
	</script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>

