<%@page import="master.DAO.AccountDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">

  <title>HomePage</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/Customerbootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Merriweather:300,300i,400,400i,700,700i,900,900i" rel="stylesheet">
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="css/Customer.css" rel="stylesheet">

</head>

<body>
  <div class="overlay"></div>
  <video playsinline="playsinline" autoplay="autoplay" muted="muted" loop="loop">
    <source src="mp4/onlineBank.mp4" type="video/mp4">
  </video>
  <div class="masthead">
    <div class="masthead-bg"></div>
    <div class="container h-100">
      <div class="row h-100">
        <div class="col-12 my-auto">
          <div class="masthead-content text-white py-5 py-md-0">
            <h1 class="mb-3">Welcome!!</h1>
            <p class="mb-5">We're working hard to provide you all the banking facilities at your
              <strong>finger tip</strong>. </p>
              <br>
			
			   <%String cid=request.getParameter("cid");
			   AccountDao adao=new AccountDao();
			   String acck=adao.getAcc(cid);//getting accno corresponding to cid
			   %>
			
				<p><a class="links" href="FundTransfer.jsp?<%=acck%>"><strong>Fund Transfer</strong></a></p>
				<p><a class="links" href="FixedDeposit.jsp?<%=acck%>"><strong>Create Fixed Deposit</strong></a></p>
				<p><a class="links" href="RecurringDeposit.jsp?<%=acck%>"><strong>Create Recurring Deposit</strong></a></p>
				<p><a class="links" href="BankStatement2.jsp?<%=acck%>"><strong>View Bank Statement</strong></a></p>
				<p><a class="links" href="Displayfixed.jsp?<%=acck%>"><strong>FD Report</strong></a></p>
				<p><a class="links" href="Displayrecurring.jsp?<%=acck%>"><strong>RD Report</strong></a></p>
				<p><a class="links" href="ChangePass.jsp?<%=cid%>"><strong>Change Password</strong></a></p>
				<br>
				<br>
				<br>
				<p><a  class="text-warning" href="MainIndex.jsp"><i>Log out</i></a></p>
          </div>
        </div>
      </div>
  </div>

  <div class="social-icons">
    <ul class="list-unstyled text-center mb-0">
      <li class="list-unstyled-item">
        <a href="#">
          <i class="fab fa-twitter"></i>
        </a>
      </li>
      <li class="list-unstyled-item">
        <a href="#">
          <i class="fab fa-facebook-f"></i>
        </a>
      </li>
      <li class="list-unstyled-item">
        <a href="#">
          <i class="fab fa-instagram"></i>
        </a>
      </li>
    </ul>
  </div>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/Customerjquery/jquery.min.js"></script>
  <script src="vendor/Customerbootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js/coming-soon.min.js"></script>


</body>
</html>