
<%@ taglib uri="/WEB-INF/DBTag.tld" prefix="coda" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Shop 3</title>
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
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<header>
      <div class="bg-dark collapse" id="navbarHeader" style="">

      </div>
      <div class="navbar navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
          <a href="#" class="navbar-brand d-flex align-items-center">
            <strong>Grocery Shop</strong>
          </a>
          <!-- 
          <button class="navbar-toggler collapsed" type="button"  aria-label="Toggle navigation" onclick="document.forms['logoutForm'].submit()">
			Logout
          </button>
           -->
        </div>
      </div>
    </header>
    
	<div class="container">
	
	<br>

	<form method="POST" action="/doshop">
	
		<input type="hidden" name="formid" value="shop">
		<input type="hidden" name="shopid" value="shop3">
		
		<div class="row">
		
		<coda:DBTag itemtype="grocery"/>
		
		</div>
		
		 <br>
		 
		 <div class="row">
		 
		 	  <div class="col-md-4">
		 	  	Enter your email :<input type="text" name="useremail">
	          </div>
	          
	          <div class="col-md-4">
	          	Enter your phone :<input type="text" name="userphone">
	          </div>
	          
	     </div>
	     		 
		 <br>
		 
		 <div class="row">
		 
		 	  <div class="col-md-4">
	          </div>
	          
	          <div class="col-md-4">
	          </div>
	          
	          <div class="col-md-4">
	          	<button class="btn btn-primary my-2 enlargable" style="float:right;" value="Generate Invoice" onclick="loginclick()" ><i id="loginbuttonicon" class=""></i>Generate Invoice <i class="bi bi-box-arrow-up-right"></i>
	          	</button>
	          </div>
          
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
	
</body>
</html>