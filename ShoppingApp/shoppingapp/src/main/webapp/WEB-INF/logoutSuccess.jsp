<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registration Success</title>
    <link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<!-- 
    <div class="container text-center">
        <h3>You have signed up successfully!</h3>
        <h4><a th:href="/@{/login}">Click here to Login</a></h4>
    </div>
      -->
      
      <h3>You have been logged out</h3>
      
      <p>Click below button to re-login</p>
      
      <form method = "GET" action = "/login">
         <table>
            <tr>
               <td>
                  <input type = "submit" value = "Redirect Page"/>
               </td>
            </tr>
         </table>  
      </form>
   
</body>
</html>