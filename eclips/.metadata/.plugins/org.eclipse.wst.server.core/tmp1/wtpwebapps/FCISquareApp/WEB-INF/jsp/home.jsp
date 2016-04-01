<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>HomePage</title>
</head>

<body>

	<center>
		<h1>
			Welcome :-
			<%=session.getAttribute("name")   %>
		</h1>
	</center>

	<h3>
		Show/Update Your Location ( <a href="/FCISquareApp/app/showLocation">My
			Location </a>)
	</h3>
	<h3>
		if you want to follow someone press ( <a
			href="/FCISquareApp/app/follow">Follow</a> )
	</h3>
	<h3>
		if you want to un_follow someone( <a href="/FCISquareApp/app/unfollow">
			UnFollow</a> )
	</h3>
	<h3>
		<form action="doGetFollowers" method="post">
			<input type="hidden" value="<%=session.getAttribute("email")%>"
				name="email" /> if you want to get all Followers Press <input
				type="submit" value="GetFollowers" /><br>
		</form>

	</h3>
	<h3>
		<form action="getLastPositionOfUser" method="post">
			<input type="hidden" value="<%=session.getAttribute("email")%>"
				name="email" /> if you want to get all Followers Press <input
				type="submit" value="GetLastPosition" /><br>
		</form>
	</h3>

	<h3>
		return to Home ( <a href="/FCISquareApp/app/">Home</a> )
	</h3>



</body>
</html>