<%@page import="java.util.Enumeration"%>

<%@ taglib uri="/WEB-INF/DBTagInvoice.tld" prefix="coda" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Invoice List</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
	<style>
	
	.enlargable:hover{
	  transform: scale(1.2);
	  border:2px solid white;
	  z-index: 2;
	}
	
	#myInput {
	  background-image: url('/css/searchicon.png'); /* Add a search icon to input */
	  background-position: 10px 12px; /* Position the search icon */
	  background-repeat: no-repeat; /* Do not repeat the icon image */
	  width: 100%; /* Full-width */
	  font-size: 16px; /* Increase font-size */
	  padding: 12px 20px 12px 40px; /* Add some padding */
	  border: 1px solid #ddd; /* Add a grey border */
	  margin-bottom: 12px; /* Add some space below the input */
	}
	
	#myTable {
	  border-collapse: collapse; /* Collapse borders */
	  width: 100%; /* Full-width */
	  border: 1px solid #ddd; /* Add a grey border */
	  font-size: 18px; /* Increase font-size */
	}
	
	#myTable th, #myTable td {
	  text-align: left; /* Left-align text */
	  padding: 12px; /* Add padding */
	}
	
	#myTable tr {
	  /* Add a bottom border to all table rows */
	  border-bottom: 1px solid #ddd;
	}
	
	#myTable tr.header, #myTable tr:hover {
	  /* Add a grey background color to the table header and on hover */
	  background-color: #f1f1f1;
	}

	</style>
</head>
<body>

	<header>
      <div class="bg-dark collapse" id="navbarHeader" style="">

      </div>
      <div class="navbar navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
          <a href="#" class="navbar-brand d-flex align-items-center">
            <strong>Invoice List</strong>
          </a>
          <button class="navbar-toggler collapsed enlargable" type="button"  aria-label="Toggle navigation" onclick="document.forms['logoutForm'].submit()">
			Logout
          </button>
        </div>
      </div>
    </header>

	<div class="container">
	
	<br>
	
	<div class="row">
		
		<div class="col-md-10">
		
		<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search by Invoice ID or Date...">
		
		</div>
		
   		<div class="col-md-2 text-right">
   			
   			<div id="backbutton" >
	
	    	 <a href="welcome" class="float-right "><button
			  type="button"
			   name="submit"
			  class="btn btn-outline-info btn-rounded enlargable"
			  data-mdb-ripple-color="dark">
			  Go Back Home		  
			</button></a>
			
		</div>

		</div>
		
	</div>
	
	<br>

	<script type="text/javascript">
		function redirect(elem){
		     elem.setAttribute("action","somepage.jsp");
		     elem.submit();
		}
	</script>
	
	<table class="table" id="myTable">
	  <thead>
	    <tr>
	      <th scope="col">Invoice ID</th>
	      <th scope="col">Invoice Date</th>
	      <th scope="col">Customer ID</th>
	      <th scope="col">Invoice Object</th>
	    </tr>
	  </thead>
	  <tbody>
	  
	  	<coda:DBTagInvoice />
	  	<!-- 
	    <tr>
	      <th scope="row">3</th>
	      <td>Larry</td>
	      <td>the Bird</td>
	      <td>@twitter</td>
	    </tr>
	     -->
	  </tbody>
	</table>
	
	</div>
	
	<script>
		function myFunction() {
		  // Declare variables
		  var input, filter, table, tr, td, i, txtValue, td1, txtValue1, tb;
		  input = document.getElementById("myInput");
		  filter = input.value.toUpperCase();
		  table = document.getElementById("myTable");
		  tb = table.getElementsByTagName("tbody")[0];
		  
		  tr = tb.getElementsByTagName("tr");
		
		  // Loop through all table rows, and hide those who don't match the search query
		  for (i = 0; i < tr.length; i++) {
		    td = tr[i].getElementsByTagName("th")[0];
		    td1 = tr[i].getElementsByTagName("td")[0];
		    console.log("td : "+td);
		    console.log("td1 : "+td1);
		    if (td) {
		      txtValue = td.textContent || td.innerText;
		      txtValue1 = td1.innerText;
		      if (txtValue.toUpperCase().indexOf(filter) > -1) {
		        tr[i].style.display = "";
		      } else if(txtValue1.toUpperCase().indexOf(filter) > -1){
		         tr[i].style.display = "";
		      } else {
		      
		        tr[i].style.display = "none";
		      }
		    }
		  }
		}
	</script>

	
</body>
</html>