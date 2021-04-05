<%@page import="master.DAO.FixedDepositDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="master.DTO.FixedDepositDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DisplayPg</title>
<style type="text/css">
.boxx{
       
       background-color: lightblue;
       border:3px black;
       outline-style: solid;
	   outline-color: black;
	   outline-width:thin;
        margin-right: 150px;
        margin-left: 150px;
        margin-bottom:150px;
       
			}
p {
  font-family: verdana;
  font-size: 20px;
  margin-right: 150px;
  margin-left: 80px;
  margin-bottom:40px;
  padding-bottom: 20px;
}
h2{
   text-align:center;
   margin-bottom:80px;
}

.t1{
     margin-top: 40px;
  margin-right: 80px;
  margin-left: 80px;
  margin-bottom:10px;
  
}

</style>
</head>
<body>

<div class='boxx'>
<h2><u>Fixed Deposit Receipt</u></h2>
<p>Dear Sir/Madam,<br>
<br>
We have pleasure in confirming details of the following amount held in deposit with us.
Here are your details, please go through it :</p>

<%
String accno=request.getParameter("accno");
FixedDepositDao fdao=new FixedDepositDao();
ResultSet rs=fdao.getInterest(accno);
if(rs.next())
{
%>
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
%>

</table>
<br><p>
For any inconvenience,contact us through our official website.
Thank you for Banking with us.
</p>
</div>
</body>
</html>