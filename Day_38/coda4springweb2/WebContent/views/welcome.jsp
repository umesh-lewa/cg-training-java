<%@page import="controllers.LoginForm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- <h1><%=request.getAttribute("msg") %></h1>
	
	<h1><%=request.getAttribute("msgtwo") %></h1> --%>
	
	<%
		LoginForm loginForm=(LoginForm)request.getAttribute("loginBean");
	
		out.println("<h1>"+loginForm.getUname()+"</h1>");
		out.println("<h1>"+loginForm.getUpass()+"</h1>");
	%>
</body>
</html>