<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UnFollowPage</title>
</head>
<body>
	<center>
		<h1>UnFollowPage</h1>
	</center>
 	<form action="dounfollow" method="post">
 	    <input type="hidden"   value="<%=session.getAttribute("email") %>" name="email1" />
		UserEmail<input type="text" name="email2">
		
		<input type="submit" value="Unfollow" />
 		</form>
	 
</body>
</html>