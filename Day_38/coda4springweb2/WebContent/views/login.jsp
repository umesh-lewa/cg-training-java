<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<spring:form method="post" action="submitform" commandName="loginForm">
	
		UserName:<spring:input path="uname"/>
		<spring:errors path="uname"/>
		PassWord:<spring:password path="upass"/>
		<spring:errors path="upass"/>
		<input type="submit" value="login..">
	</spring:form>
</body>
</html>