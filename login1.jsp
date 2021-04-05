<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>LoginPg</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<script type="text/javascript">
    if(!!window.performance && window.performance.navigation.type == 2)
    {
        window.location.reload();
    }
    </script>
</head>
<body> 
    <div>
       <header>
         <!-- Navbar -->
         <nav class="navbar navbar-expand-md navbar navbar-light bg-light sticky-top" >
         <div class="container-fluid">
         <a href="#" class="navbar-brand"><img src="Photos1/logo.png" alt="" width="220px" height="70px"></a>

		 <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		 <span class="navbar-toggler-icon"></span>
		 </button>

   <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item">
        <a class="nav-link" href="MainIndex.jsp">Home<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <div class="dropdown">
     <a class="nav-link " class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
      Contact Us
     </a>
    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    <a class="dropdown-item" href="#"><span class="fa fa-address-book"></span>1800 102 9888</a>
    <a class="dropdown-item" href="#"><span class="fa fa-address-book"></span>1800 102 0000</a>
    <a class="dropdown-item" href="https://www.google.com/intl/en_in/gmail/about/"><span class="fa fa-envelope"></span>customercare@mdb.co.in  </a>
   </div>
    </div>
    </li>
    </ul>
         <form class="form-inline">
           <div class="md-form my-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
             <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
           </div>
          </form>
        </div>
      </div>
     </nav>
 <!-- Navbar -->
          <!-- Full Page Intro -->
          <div class="view" style="background-image: url('https://mdbootstrap.com/img/Photos/Others/images/91.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
            <!-- Mask & flexbox options-->
            <div class="mask rgba-gradient align-items-center">
              <!-- Content -->
              <div class="container">
                <!--Grid row-->
                <div class="row mt-5">
                  <!--Grid column-->
                  <div class="col-md-6 mb-5 mt-md-0 mt-5 white-text text-center text-md-left">
                    <h1 class="h6-responsive font-weight-bold wow fadeInLeft" data-wow-delay="0.3s">Login to Net Banking </h1>
                    <hr class="hr-light wow fadeInLeft" data-wow-delay="0.3s">
                   
                  </div>
                  <!--Grid column-->
                  <!--Grid column-->
                  <div class="col-md-6 col-xl-5 mb-4">
                    <!--Form-->
                    <form action="CustomerLoginServe" method="post">
                    <div class="card wow fadeInRight" data-wow-delay="0.3s">
                      <div class="card-body" style="background-color: #C4DBE0;">
                        <!--Header-->
                        <div class="text-center">
                          <h3 class="white-text">
                            <i class="fas fa-user white-text"></i> Login:</h3>
                          <hr class="hr-light">
                        </div>
                        <!--Body-->
                        <div class="md-form">
                          <i class="fas fa-user prefix white-text active"></i>
                          <input type="text" name="cid" id="form3" class="white-text form-control"  required="true">
                          <label for="form3" class="active"><b>Enter Your CustomerID</b></label>
                        </div>
              
                        <div class="md-form">
                          <i class="fas fa-lock prefix white-text active"></i>
                          <input type="password" id="form4" class="white-text form-control" name="pass" required="true">
                          <label for="form4"><b>Your password</b></label>
                        </div>
                        <div class="text-center mt-3">
                          <button class="btn btn-outline-primary" type="submit" name="log">Login</button><br>
                          <a href="CustomerRegistration.jsp"><b>Not yet registered?Register Now</b></a>

                          <hr class="hr-light mb-3 mt-4">
                          <div class="inline-ul text-center">
                            <a class="p-2 m-2 tw-ic">
                              <i class="fab fa-twitter white-text"></i>
                            </a>
                            <a class="p-2 m-2 li-ic">
                              <i class="fab fa-linkedin-in white-text"> </i>
                            </a>
                            <a class="p-2 m-2 ins-ic">
                              <i class="fas fa-instagram white-text"> </i>
                            </a>
                          </div>
                        </div>
                      </div>
                    </div>
                    </form>                   
                     <!--/.Form-->
                  </div>
                  <!--Grid column-->
                </div>
                <!--Grid row-->
              </div>
              <!-- Content -->
            </div>
            <!-- Mask & flexbox options-->
          </div>
          <!-- Full Page Intro -->
        </header>
        <!-- Main navigation -->
      

  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</div>
</body>
</html>