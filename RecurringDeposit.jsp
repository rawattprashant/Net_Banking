<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>RecurringDeposit</title>
	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap" rel="stylesheet">
	<!-- Stylesheets -->
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" href="fonts/font-awesome.min.css"/>
	<!-- Main Stylesheets -->
	<link rel="stylesheet" href="css/RecurringDeposit.css"/>
</head>
<body>
	<!-- Hero Section end -->
	<section class="hero-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-6" >
					<form class="hero-form" action="RecrringDepositServe" method="post">
						<h4><b>RECURRING DEPOSIT</b></h4>
						<input type="text" placeholder="Enter Recurring Deposit Amount" name="rdamt" required="true">
						<input type="text" placeholder="No. of Months" name="month" required="true" >
						<input type="hidden" value="<%= request.getQueryString() %>" name="accno"/>
						<input type="text" value="<%= request.getQueryString() %>" name="acc" readonly="true">
						<input type="date" placeholder="Date of Opening" name="dopen" required="true">
						<button class="site-btn" type="submit">Create Recurring Deposit</button>
					</form>
				</div>
			</div>
	
	<!--====== Javascripts & Jquery ======-->
	<script src="js/Refresh.js"></script>

	</body>
</html>
