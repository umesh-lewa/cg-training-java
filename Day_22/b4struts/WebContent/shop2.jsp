<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
//String id = request.getParameter("userid");
String driver = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://lrwqyh5q0i7hd9or:mwf3vy3d4aljd4st@lyn7gfxo996yjjco.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/";
String database = "beqm0guzzjfj6e07";
String userid = "lrwqyh5q0i7hd9or";
String password = "mwf3vy3d4aljd4st";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Fruit Shop</h1>
<%@ include file="logout.jsp" %>

	<form action="shop.do" method="post">
	<input type="hidden" name="formid" value="shop">
	<input type="hidden" name="shopid" value="shop2">
	
		<%
		try{
		connection = DriverManager.getConnection(connectionUrl+database, userid, password);
		statement=connection.createStatement();
		String sql ="select * from itemmaster where itemtype = 'fruit'";
		resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
		%>
		<%=resultSet.getString("itemname") %>:<input type="checkbox" name="<%=resultSet.getString("itemid") %>" value="<%=resultSet.getString("itemname") %>">
		<%
		}
		connection.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		%>
		
		<!-- 
		Mango:<input type="checkbox" name="c4" value="mango">
		Banana:<input type="checkbox" name="c5" value="banana">
		PineApple:<input type="checkbox" name="c6" value="pineapple">
		 -->
		 
		<input type="submit" value="Next shop..">
	</form>
	
</body>
</html>