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
			<%=session.getAttribute("name")%>
			<%=session.getAttribute("id")%>
			
		</h1>
	</center>
	<h3>


		<form action="doGetFollowers" method="post">
			<input type="hidden" value="<%=session.getAttribute("email")%>"
				name="email" /> <input type="submit" value="GetFollowers" />
				</form>
			<form action="getLastPositionOfUser" method="post">
				<input type="hidden" value="<%=session.getAttribute("email")%>"
					name="email" /> <input type="submit" value="GetLastPosition" /> 
				</form>
				
				
				
					<form action="dohomepage" method="post">
			<input type="hidden" value="<%=session.getAttribute("email")%>"
				name="email" /> <input type="submit" value="HomePage" />
				</form>
				
				
					(
				<a href="/FCISquareApp/app/checkinClass/checkin">checkIn</a> ) ( <a
					href="/FCISquareApp/app/placeclass/addnewplace">Add_New_Place</a> )
				( <a
					href="/FCISquareApp/app/showLocation">MyLocation </a>) ( <a
					href="/FCISquareApp/app/follow">Follow</a> ) ( <a
					href="/FCISquareApp/app/unfollow"> UnFollow</a> )
					( <a href="/FCISquareApp/app/">Logout</a> ) 
					(<a href="/FCISquareApp/app/placeclass/savenewplace">SavePlace </a>)
	</h3>
 <h1>${it}</h1>

<br>
<br>
------------------------------------------------------------------------------------------------<br>
<%=session.getAttribute("checkintime") %><br>
------------------------------------------------------------------------------------------------<br>
<%=session.getAttribute("checkintext") %>
<br>
<br>

</body>
</html>