<%@page import="java.util.Enumeration"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<h1>Invoice Page....</h1>

	<%@ include file="logout.jsp" %>

	<%
	Enumeration<String> e=session.getAttributeNames();
	while(e.hasMoreElements()){
		String name=e.nextElement();
		if(name.equals("rb")){
			
		}else{
			String value=(String)session.getAttribute(name);
			out.println(name+":"+value);
		}	
	}
	%>

	<form>
		<input type="submit" value="Download PDF" name="download" onclick="window.print()" /> 
	</form>
	
</body>
</html>