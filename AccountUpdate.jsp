<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AccountUpdate</title>
</head>
<body>
<form action="AccountUpdateServe" method="post">
<table>
<tr>
<td><label>ACCOUNT NO.</label></td>
<td><input type="text" name="accno" required="true"></td>
</tr>
<tr>
<td><label>BALANCE</label></td>
<td><input type="text" name="balance" required="true"></td>
</tr>
<tr>
<td><label>DEPOSIT BY</label></td>
<td> <select name="depomethod" required="true" >
               <option value=""></option>
               <option value="By CASH">By Cash</option>
               <option value="By Cheque">By Cheque</option>
      </select></td>
</tr>
<tr>
<td><label>Date of Deposit</label></td>
<td><input type="date" name="dodeposit" required="true"></td>
</tr>
<tr>
<td>
<input type="submit" value="UPDATE" name="update">
</td></tr>
</table>
</form>
</body>
</html>