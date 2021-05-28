<!DOCTYPE html>

<%@ taglib uri="DBTag.tld" prefix="coda" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!--<c:url value="/doShop" var="doShop"/>-->


<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Shop 1</title>
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
            <strong>Vegetable Shop</strong>
          </a>
          <button class="navbar-toggler collapsed" type="button"  aria-label="Toggle navigation" onclick="document.forms['logoutForm'].submit()">
			Logout
          </button>
        </div>
      </div>
    </header>
    
    <div class="container">
	
	<br>	

	<form method="POST" action="/doshop">
	
	    <input type="hidden" name="formid" value="shop">
		<input type="hidden" name="shopid" value="shop1">
		 	
		<!-- 
		Brinjal:<input type="checkbox" name="c1" value="brinjal">
		Potato:<input type="checkbox" name="c2" value="potato">
		Carrot:<input type="checkbox" name="c1" value="carrot">
		 -->
		 
		 <div class="row">
		 
		 <coda:DBTag itemtype="vegetable"/>
		 	
		 	<!-- 
            <div class="col-md-4">
              <div class="card mb-4 box-shadow">
                <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22348%22%20height%3D%22225%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20348%20225%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_179a3792810%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A17pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_179a3792810%22%3E%3Crect%20width%3D%22348%22%20height%3D%22225%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22116.7109375%22%20y%3D%22120.15%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">
                <div class="card-body">
                  <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                      <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                      <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                    </div>
                    <small class="text-muted">9 mins</small>
                  </div>
                </div>
              </div>
            </div>
			-->
          </div>
          
          <br>
          
          <div class="row">
          
	          <div class="col-md-4">
	          </div>
	          
	          <div class="col-md-4">
	          </div>
	          
	          <div class="col-md-4">
	          	<button class="btn btn-primary my-2 enlargable" style="float:right;" type="submit" value="Next shop"> Next Shop <i class="bi bi-arrow-right-square"></i>
	          	</button>
	          </div>
	          
	       </div>
          	
	</form>
	
    </div>
    
	
	
</body>
</html>