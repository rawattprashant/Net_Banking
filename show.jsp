<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AccountRegistered</title>
</head>
<body>
You have successfully created your account.
your Account number: <br>

<b><%= request.getAttribute("accnum") %></b>
<br>
<a href="CustomerRegistration.jsp">Create your net banking id</a>
</body>
</html>