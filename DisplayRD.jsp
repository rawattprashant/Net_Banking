<%@page import="java.sql.ResultSet"%>
<%@page import="master.DAO.RecurringDepositDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RDreceipt</title>
<style>
.boxx2{
       border:0.7px solid black;
       background-color: lightblue;
	   outline-style: solid;
	   outline-color: black;
	   outline-width:thin;
	   margin-top:40px;
        margin-right: 150px;
        margin-left: 150px;
        margin-bottom:150px;
			}
p {
  font-family: verdana;
  font-size: 20px;
  margin-right: 150px;
  margin-left: 80px;
  
}
h2{
   text-align:center;
   margin-bottom:80px;
}

.t2{
  margin-right: 80px;
  margin-left: 80px;
  margin-bottom:30px;
  
  
}
</style>
</head>
<body>
<div class='boxx2'>
<h2><u>Recurring Deposit Receipt</u></h2>
<p>You have successfully created your Recurring Deposit.<br>
<br>
<b>Recurring Deposit Details:</b></p>
<table border="2" class='t2' cellspacing="5" cellpadding="10">
<tr>
<td><b>Account Number</b></td>
<td><b>Opening Date</b></td>
<td><b>Deposit Period(in months)</b></td>
<td><b>Deposit Amount</b></td>
<td><b>Interest @6.5% p.a.</b></td>
<td><b>Maturity Amount</b></td>
</tr>

<%
String accno=request.getParameter("accno");
RecurringDepositDao rdao=new RecurringDepositDao();
ResultSet rs=rdao.getRDMaturity(accno);
while(rs.next())
{
%>
 <tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getDouble(4) %></td>
<td><%=rs.getDouble(5)%></td>
<td><%=rs.getDouble(6)%></td>
</tr>
<%
}
%>
</table>
<br><p>
For any inconvenience,contact us through our official website.
Thank you for Banking with us.
</p>
</div>
</body>
</html>