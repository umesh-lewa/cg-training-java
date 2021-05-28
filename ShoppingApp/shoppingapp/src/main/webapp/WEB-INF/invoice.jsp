<%@page import="java.util.Enumeration"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Invoice</title>
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
</head>
<body>

	<header>
      <div class="bg-dark collapse" id="navbarHeader" style="">

      </div>
      <div class="navbar navbar-dark bg-dark box-shadow">
        <div class="container d-flex justify-content-between">
          <a href="#" class="navbar-brand d-flex align-items-center">
            <strong>Invoice Page</strong>
          </a>
          <button class="navbar-toggler collapsed enlargable" type="button"  aria-label="Toggle navigation" onclick="document.forms['logoutForm'].submit()">
			Logout
          </button>
        </div>
      </div>
    </header>
	
	<br>

	<div class="container">
	
	<div class="row">
	
		<div class="row">
		
		<div class="col-md-10"></div>
   		<div class="col-md-2 text-right">
   			
   			<div id="backbutton" >
	
	    	 <a href="welcome" class="float-right"><button
			  type="button"
			   name="submit"
			  class="btn btn-outline-info btn-rounded enlargable"
			  data-mdb-ripple-color="dark">
			  Go Back Home		  
			</button></a>
			
		</div>

		</div>
		
	</div>
	
	</div>
	
	<br>
	
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">ItemID</th>
	      <th scope="col">Item Name</th>
	      <th scope="col">Unit</th>
	      <th scope="col">Price</th>
	    </tr>
	  </thead>
	  <tbody>
	  
	  	<%
		Enumeration<String> e=session.getAttributeNames();
		while(e.hasMoreElements()){
			
			String name=e.nextElement();
			
			//out.println("sesion element name : "+name);
			
			if(name.equals("SPRING_SECURITY_CONTEXT") || name.equals("Invoice ID") || name.equals("Invoice Total") || name.equals("Invoice Date")){
				
		    }else{
		    	
		    	String value=(String)session.getAttribute(name);
		
				//out.println(name+":"+value);
				String split[] = value.split(",");
		    	out.println("<tr>"
					      +"<th scope='row'>"+name+"</th>"
					      +"<td>"+split[0]+"</td>"
					      +"<td>"+split[1]+"</td>"
					      +"<td>"+split[2]+"</td>"
					      +"</tr>");
			    		    	
			}
			
		}
		%>
		
		<% 
		Enumeration<String> e1=session.getAttributeNames();
		while(e1.hasMoreElements()){
			
			String name=e1.nextElement();		
			//out.println("sesion element name : "+name);
			
			if(name.equals("SPRING_SECURITY_CONTEXT")){
				
		    }else{
		    	
		    	if(name.equals("Invoice ID") || name.equals("Invoice Total") || name.equals("Invoice Date")){
					
		    		//out.println("name"+name);
		    		
		    		String value=(String)session.getAttribute(name).toString();
		    		
		    		out.println("<tr>"
						      +"<th scope='row'>"+""+"</th>"
						      +"<td>"+""+"</td>"
						      +"<td>"+""+"</td>"
						      +"<td>"+""+"</td>"
						      +"</tr>");
		    		
		    		out.println("<tr>"
						      +"<th scope='row'>"+name+"</th>"
						      +"<td>"+""+"</td>"
						      +"<td>"+""+"</td>"
						      +"<td>"+value+"</td>"
						      +"</tr>");
		    		
		    	}
			
			}
		}
		%>
		
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

	<div class="row">
		
		<div class="col-md-6"></div>
   		<div class="col-md-2 text-right">
			<form>
				<input type="submit" value="Download PDF" name="download" onclick="window.print()" /> 
			</form>
		</div>
		<div class="col-md-4"></div>
	</div>	
	
	</div>
	
</body>
</html>