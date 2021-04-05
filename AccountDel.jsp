<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Delete</title>
</head>
<body>
<form action="AccountDelServe" method="post">
<table>
<tr>
<td><label>ACCOUNT NO.</label></td>
<td><input type="text" name="accno" required="true"></td>
</tr>
<tr>
<td><label>CID</label></td>
<td><input type="text" name="cid" required="true"></td>
</tr>
<tr>
<td>
<input type="submit" value="DELETE ACCOUNT" name="DelAcc">
</td></tr>
</table>
</form>
</body>
</html>