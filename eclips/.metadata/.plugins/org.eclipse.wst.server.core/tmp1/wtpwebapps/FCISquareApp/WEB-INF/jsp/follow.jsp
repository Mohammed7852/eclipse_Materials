<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Follow Page</title>
</head>
<center>
	<h1>Follow Page</h1>
</center>
<body>
	<form action="dofollow" method="post">
 	    <input type="hidden"   value="<%=session.getAttribute("email") %>" name="email1" />
		UserEmail<input type="text" name="email2">
 		<input type="submit" value="Follow" />
	
		</form>
		<br>
	<a href="/FCISquareApp/app/home.jsp">Back</a>
		
</body>
</html>