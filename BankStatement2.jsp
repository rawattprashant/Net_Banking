<%@page import="java.io.PrintWriter"%>
<%@page import="master.DTO.UpdateAccDto"%>
<%@page import="master.DAO.UpdateAccDao"%>
<%@page import="master.DTO.FundTransferDto"%>
<%@page import="master.DAO.FundTransferDao"%>
<%@page import="master.DTO.AccountDto"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="master.DAO.AccountDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BankStatement</title>
<style>	
button{
width:137px;
height:40px;
font-size:14px;
font-weight:400px;
border-radius: 50px;
text-transform: uppercase;
background-color: lightblue;
}
table, td {

  width:50%;
  border: 1px solid black;
  border-collapse: collapse;
}
 td {
  padding: 25px;
}
.t1{
 background-color: lightblue;
  border:2px black;
  outline-style: solid;
  outline-color: black;
   margin-top: 50px;
  margin-right: 300px;
  margin-left: 300px;
  margin-bottom:200px;
  
}
</style>
</head>
<body>
<form name="f1" action="" method="post">
<%
     
     if(request.getQueryString()!=null )
     {
       String acc=request.getQueryString();
       AccountDao adao=new AccountDao();
       ArrayList list=adao.getBDetails(acc);
       Iterator itr1=list.iterator();
  %>
<h3><label><b> VIEW BANK STATEMENT</b></label><br></h3>
  <table border=1>
           <%
               while(itr1.hasNext())
               {
                AccountDto  odto=(AccountDto)itr1.next();
             
            %>
                <tr><td><label><b>Account Type :</b></label><%=  odto.getAcctype() %></td></tr>
                <tr><td><label><b>Account Number :</b></label><%=  odto.getAccno()%></td></tr>
               <tr><td><label><b>Account Holder's Name :</b></label><%= odto.getName() %> </td></tr>
                <tr><td><label><b>Available Balance : </b></label><%= odto.getBal() %></td></tr>
                <tr><td><label><b>Select Period : </b></label>
                <label><b>From </b> </label><input type="date" name="d1" required="true" >
                 <label><b>To </b> </label><input type="date" name="d2" required="true" >
							</td></tr>
            <%          
               }
           %>  
 
 
  </table><br>
<button type="submit" name="button1" style="width: 137px color:blue";><b>View</b></button>

<%
if(request.getParameter("button1")!=null)
{
response.setContentType("text/html");
PrintWriter outp=response.getWriter();
String d1=request.getParameter("d1");
String d2=request.getParameter("d2");
FundTransferDao fdao=new FundTransferDao();
ArrayList list2=fdao.getTransactionDetails(acc, d1, d2);
Iterator itr2=list2.iterator();
if(itr2.hasNext())
{
%>
<h4><b>WITHDRAWALS</b></h4>
<table border="1" class='t1' cellspacing="10" cellpadding="10">
         <tr>
             <th><b>Beneficiary Account Number</b> </th>
             <th><b>Beneficiary Bank Name</b> </th>
             <th><b>Amount Transferred</b></th>
             <th><b>Ifsc Number</b></th>
             <th><b>Date of Transfer</b></th>        
        </tr>
        
<% 
 while(itr2.hasNext())
    {
     FundTransferDto  fdto=(FundTransferDto)itr2.next(); 
    %>
     <tr>
         <td><%=fdto.getBaccno() %></td>
         <td><%=fdto.getBanknm() %></td>
         <td><%=fdto.getBalance() %></td>
         <td><%=fdto.getIfcs() %></td>
         <td><%=fdto.getDot() %></td>
      </tr>
  <%         
    }
}
else{
	outp.println("\n<b> There are no withdrawals in the mentioned period</b>");
}
%>
</table>
<%
UpdateAccDao udao=new UpdateAccDao();
ArrayList list3=udao.getUpdateDetails(acc, d1, d2);
Iterator itr3=list3.iterator();
if(itr3.hasNext())
{
%>
<h4><b>DEPOSITS</b></h4>
 <table border="1" class="t1" cellspacing="10" cellpadding="10">
  <tr>
  <th><b>Account Number</b></th>
  <th><b>Amount Deposited</b></th>
  <th><b>Deposited </b></th>
  <th><b>Date of Deposit</b></th>
  </tr>
 <% while(itr3.hasNext())
  {
	  UpdateAccDto udto=(UpdateAccDto)itr3.next();
  %> 
 
  <tr>
   <td><%= udto.getAccno() %></td>
   <td><%=udto.getBal() %></td>
   <td><%=udto.getDepositby() %></td>
   <td><%=udto.getDateofDeposit() %></td>
   </tr>
   <%
    }

}
else
{   outp.println("\n");
	outp.println("<b> There are no deposits in the mentioned period.</b>");
      }
    }
 }
%>
</table>      
</form>
</body>
</html>
