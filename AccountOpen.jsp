<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>online account register </title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="vendor/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/onlineAcStyle.css">
    <script>
    if(!!window.performance && window.performance.navigation.type == 2)
    {
        window.location.reload();
    }
    </script>
</head>
<body>
 <div class="main">
        <div class="container">
            <div class="signup-content">
                <div class="signup-1">
                    <h2>Online Account Registration</h2>
                       <form  action="AccountOpenServe" method="POST"> 
                            <div class="form-group">
                                <label for="name">Name :</label>
                                <input type="text" name="name" id="name" required/>
                            </div>
                             <div class="form-radio">
                            <label for="gender" class="radio-label">Gender :</label>
                            <div class="form-radio-item">
                                <input type="radio" name="gender" id="male" value="male" >
                                <label for="male">Male</label>
                                <span class="check"></span>
                            </div>
                            <div class="form-radio-item">
                                <input type="radio" name="gender" id="female" value="female" >
                                <label for="female">Female</label>
                                <span class="check"></span>
                            </div>
                             <div class="form-radio-item">
                                <input type="radio" name="gender" id="transgender" value="transgender">
                                <label for="transgender">Transgender</label>
                                <span class="check"></span>
                            </div>
                        </div>
                    
                        <div class="form-group">
                            <label for="dob">DOB :</label>
                            <input type="text" name="dob" id="dob" placeholder="dd-mm-yyyy" required="true"/>
                        </div>    
                        
                        <div class="form-group">
                                <label for="idProof">ID Proof & Number:</label>
                                <div class="form-select">
                                    <select name="idProof" id="idProof">
                                        <option value="Select"></option>
                                        <option value="Aaadhar">Aaadhar Card</option>
                                        <option value="Voter">Voter Id</option>
                                        <option value="Passport">Passport</option>
                                        <option value="Driving Lic.">Driving License</option>
                                    </select>
                                </div><br>
                                 <input type="text" name="idno" id="idno"  maxlength="16" required/>
                        </div>
                        <div class="form-group">
                            <label for="address">Address :</label>
                            <input type="text" name="address" id="address" required/>
                        </div>

                        <div class="form-group">
                            <label for="pincode">Pincode :</label>
                            <input type="text" name="pincode" id="pincode">
                        </div>
                       
                </div>
                <div class="signup-2">
                 		 <div class="form-group">
                            <label for="phone">Phone :</label>
                            <input type="text" name="phone" maxlength="12" id="phone">
                        </div>
                        <div class="form-group">
                            <label for="email">Email :</label>
                            <input type="text" name="email" id="email">
                        </div>
                			
                            <h2>Account Details</h2>
                            <div class="form-group">
                                <label for="acctype">Account Type :</label>
                                <div class="form-select">
                                    <select name="acctype" id="acctype">
                                        <option value="select"></option>
                                        <option value="Savings">Savings Account</option>
                                        <option value="Current">Current Account</option>
                                    </select>
                                </div>
                            </div>
                            
                        
                     <!--   <div class="form-group">// as account number is auto increasing
                            <label for="accno">Account Number:</label>
                            <input type="text" name="accno" id="accno" />
                            
                        </div> -->
                        
                        <div class="form-group">
                            <label for="cid">User Id:</label>
                            <input type="text" name="cid" id="cid" maxlength="20" />
                        </div>
                        
                        <div class="form-group">
                            <label for="bal">Opening Balance:</label>
                            <input type="number" name="bal" id="bal" />
                        </div>
                    
                        <div class="form-submit">
                           <input type="submit" value="Reset All" class="submit" name="reset" id="reset" />
                            <input type="submit" value="Submit Form" class="submit" name="submit" id="submit" />
                        </div>
                    </div>

                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- JS -->
    <script src="vendor/jquery2/jquery.min.js"></script>
    <script src="js/onlineAc.js"></script>
</body>
</html>