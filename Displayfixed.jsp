<%@page import="java.io.PrintWriter"%>
<%@page import="master.DAO.FixedDepositDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="master.DTO.FixedDepositDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FixedDeposit</title>
<style type="text/css">
.boxx{
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
h2{
   text-align:center;
   margin-bottom:80px;
}

.t1{
  margin-right: 80px;
  margin-left: 80px;
  margin-bottom:30px;  
}

</style>
</head>
<body>
<%
response.setContentType("text/html");
PrintWriter outp=response.getWriter();
String accno=request.getQueryString();
FixedDepositDao fdao=new FixedDepositDao();
ResultSet rs=fdao.getInterest(accno);
if(rs.next())
{
%>
<div class='boxx'>
<h2><u>Your Fixed Deposit Details</u></h2>
<br>
<table border="2" class='t1' cellspacing="5" cellpadding="10">
<tr>
<td><b>Account Number</b></td>
<td><b>Opening Date</b></td>
<td><b>Deposit Period</b></td>
<td><b>Deposit Amount</b></td>
<td><b>Interest @7% p.a.</b></td>
<td><b>Maturity Amount</b></td>
</tr>
<% 
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
}
else
	outp.println("<div class='boxx'><br><b>You have not created any fixed deposit yet.</b><br><br></div>");
%>
</table>
</div>
</body>
</html>