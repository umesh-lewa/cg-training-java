<!DOCTYPE html>

<%@page import="java.util.ResourceBundle" buffer="8kb" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="login.do" method="post">
	
		<%
		ResourceBundle rb=(ResourceBundle)session.getAttribute("rb");
		%>
		
		<input type="hidden" name="formid" value="login">
		
		<%=rb.getString("username") %>:<input type="text" name="uname" placeholder="somu">
		<%=rb.getString("password") %>:<input type="password" name="upass" placeholder="123">
		
		<!-- 
		UserName:<input type="text" name="uname">
		PassWord:<input type="password" name="upass">
		 -->
		 
		<input type="submit" value="Login..">
	</form>
</body>
</html>