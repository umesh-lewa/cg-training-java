<%@page import="com.LoginForm"%>
<%-- <%
	String uname=request.getParameter("uname");
	String upass=request.getParameter("upass");
	
	LoginForm lForm=new LoginForm();
	lForm.setUname(uname);
	lForm.setUpass(upass);
	
	session.setAttribute("loginform",lForm);
	RequestDispatcher rd=request.getRequestDispatcher("next.jsp");
	rd.forward(request, response);
%> --%>
<jsp:useBean id="lForm" class="com.LoginForm" scope="session">
	<jsp:setProperty name="lForm" property="*" />
<%-- 	<jsp:setProperty name="lForm" property="upass" /> --%>
</jsp:useBean>

<%@page import="com.LoginForm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		LoginForm lForm=(LoginForm)session.getAttribute("lForm");
	%>
<h1>	
	<%
		out.println(lForm.getUname()+":"+lForm.getUpass());
	%>
</h1>
</body>
</html>