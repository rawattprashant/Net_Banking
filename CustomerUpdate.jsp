<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CustomerUpdate</title>
</head>
<body>
<form action="CustomerUpdateServe" method="post">
<table>
<tr>
<td><label>CID</label></td>
<td><input type="text" name="cid"></td>
</tr>
<tr>
<td><label>PhoneNo.</label></td>
<td><input type="text" name="phno"></td>
</tr>
<tr>
<td><label>Email</label></td>
<td><input type="text" name="email"></td>
</tr>
<tr>
<td>
<input type="submit" value="UPDATE" name="update">
</td></tr>
</table>
</form>
</body>
</html>