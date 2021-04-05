<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>FundTransfer</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&display=swap" rel="stylesheet">
	<!-- Stylesheets -->
	<link rel="stylesheet" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" href="fonts/font-awesome.min.css"/>
	<!-- Main Stylesheets -->
	<link rel="stylesheet" href="css/FundTransfer.css"/>
</head>
<body>
	<!-- Hero Section end -->
	<section class="hero-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-6" >
					<form class="hero-form" action="FundTransferServe" method="post">
						<input type="hidden" name="saccno" value="<%= request.getQueryString() %>"  />
						<input type="text" name="acc" value="<%= request.getQueryString() %>" readonly="readonly">
						<input type="text" placeholder="Beneficiary Account Number" name="baccno" required="true">
						<input type="text" placeholder="IFSC code" name="ifcs" required="true">
						
						<select name="bname">
							<option>Select Bank</option>
							<option>MD Bank</option>
							<option>State Bank of India</option>
							<option>HDFC Bank</option>
							<option>UCO Bank</option>
							<option>AXIS Bank</option>
							<option>ICICI Bank</option>
							<option>South Indian Bank</option>
							<option>Punjab National Bank</option>
							<option>Union Bank</option>
							<option>Allahabad Bank</option>
							<option>Bank of Baroda</option>
						</select>
						<input type="text" placeholder="Amount" name="amt" required="true">
						<input type="date" placeholder="Date of Transfer" name="dot" required="true">
						<button class="site-btn" type="submit">Click to Transfer</button>
					</form>
				</div>
			</div>
		</div>
	</section>
	
	<!--====== Javascripts & Jquery ======-->
	<script src="js/Refresh.js"></script>

	</body>
</html>
