<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="doSavingPlace" method="post">
		<input type="hidden" value="<%=session.getAttribute("email")%>"
			name="email" />
		<h3>
			Enter place name: <input type="text" name="placename" />
		</h3>

		<input type="submit" value="Save" />
	</form>
	<br>

</body>
</html>