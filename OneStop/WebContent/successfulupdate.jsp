<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Card Insert Successful</title>
		<meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Home</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/home.css" />
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
        href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
        rel="stylesheet"
        />

	<style>
	.alert {
	  padding: 20px;
	  background-color: #f44336;
	  color: white;
	  opacity: 1;
	  transition: opacity 0.6s;
	  margin-bottom: 15px;
	}
	
	.alert.success {background-color: #04AA6D;}
	.alert.info {background-color: #2196F3;}
	.alert.warning {background-color: #ff9800;}
	
	.closebtn {
	  margin-left: 15px;
	  color: white;
	  font-weight: bold;
	  float: right;
	  font-size: 22px;
	  line-height: 20px;
	  cursor: pointer;
	  transition: 0.3s;
	}
	
	.closebtn:hover {
	  color: black;
	}
	</style>
</head>
<body>

		<div class="headersection">
            <div class="header">
                <h2 class="headerTitle">OneStop Grocery</h2>
            </div>
            <div class="headerdetailcontainer">
                <div class="headerdetailheader">
                    <div class="headerdetail">
                        <ul class="menuitems">
                            <li class="menu"><i class="fa fa-user" aria-hidden="true"><a href="useraccount.jsp"> Welcome,Profile </a></i></li>
                            <li class="menu"> <i class="fa fa-truck" aria-hidden="true"><a href=""> Shipping Method </a></i></li>
                            <li class="menu"><i class="fa fa-sign-out" aria-hidden="true"> <a href="customerlogin.jsp"> Log Out</a></i></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="bottomheader">
            <div class="bottomheaderdetail">
                <div class="leftitem">
                    <div class="imagediv">
                        <img src="./images/logo.png" alt=""/>
                    </div>
                </div>
                <div class="navigationbar">
                    <ul class="navbar">
                        <li class="nav"><a href="">Home</a></li>
                        <li class="nav"><a href="">Products</a></li>
                        <li class="nav"><a href="">Promotions</a></li>
                        <li class="nav"><a href="">Loyalty Points</a></li>
                    </ul>
                </div>
                <form class="example" action="action_page.php">
                    <input type="text" placeholder="Search for products" name="search">
                    <button type="submit"><i class="fa fa-search"></i></button>
                </form>
                
                </div>
            </div>
        </div>
        <div class="productsection">
            <div class="productdetail">
                <div class="dropdown">
                    <button class="dropbtn">Categories</button>
                    <div class="dropdown-content">
                      <a href="#">Link 1</a>
                      <a href="#">Link 2</a>
                      <a href="#">Link 3</a>
                    </div>
                </div>
                <div class="productbar">
                    <ul class="product">
                        <li class="prod"><a href="">Personal Care</a></li>
                        <li class="prod"><a href="">Beverages</a></li>
                        <li class="prod"><a href="">Personal Safety</a></li>
                        <li class="prod"><a href="">Baby Products</a></li>
                    </ul>
                </div>
            </div>
        </div>
	
	
	
	

		<div class="alert success">
		  <span class="closebtn">&times;</span>  
		  <strong>Card Successfully Updated!</strong> 
		</div>
		
		<script>
		var close = document.getElementsByClassName("closebtn");
		var i;
		
		for (i = 0; i < close.length; i++) {
		  close[i].onclick = function(){
		    var div = this.parentElement;
		    div.style.opacity = "0";
		    setTimeout(function(){ div.style.display = "none"; }, 600);
		  }
		}
		</script>
		
		
		
		<div class="bodysection">

            <div class="slideshow-container">

                <div class="homeSlides fade">
                  <img src="images\veg.png" style="width:100%">
                </div>
                
                <div class="homeSlides fade">
                  <img src="images\personal care.png" style="width:100%">
                </div>
                
                <div class="homeSlides fade">
                  <img src="images\beverages.png" style="width:100%">
                </div>

                <div class="homeSlides fade">
                    <img src="images\babycare.png" style="width:100%">
                </div>

                <div class="homeSlides fade">
                    <img src="images\deals.png" style="width:100%">
                </div>
                
                
                <br>
                
                <div style="text-align:center">
                  <span class="dot"></span> 
                  <span class="dot"></span> 
                  <span class="dot"></span> 
                  <span class="dot"></span> 
                  <span class="dot"></span> 
                </div>
            </div>
                
                <script>
                let slideIndex = 0;
                showSlides();
                
                function showSlides() {
                  let i;
                  let slides = document.getElementsByClassName("homeSlides");
                  let dots = document.getElementsByClassName("dot");
                  for (i = 0; i < slides.length; i++) {
                    slides[i].style.display = "none";  
                  }
                  slideIndex++;
                  if (slideIndex > slides.length) {slideIndex = 1}    
                  for (i = 0; i < dots.length; i++) {
                    dots[i].className = dots[i].className.replace(" active", "");
                  }
                  slides[slideIndex-1].style.display = "block";  
                  dots[slideIndex-1].className += " active";
                  setTimeout(showSlides, 2000); // Change image every 2 seconds
                }
                </script>
            
        </div>

        <div class="footersection">
            <div class="bottomitem">
                <div class="image2div">
                    <img src="images/logo.png" alt=""/>
                </div>
            </div>
            <form class="example2" action="action_page.php">
                <input type="text" placeholder="Enter your email to subscribe to our newsletter" name="submit">
                <button type="submit">Submit</button>
            </form>
            <div class="socialbar">
            <div class="socialMediaIcons">
                <a href="https://www.facebook.com">
                  <i class="fa fa-facebook-square" aria-hidden="true"></i>
                </a>
                <a href="https://www.instagram.com">
                  <i class="fa fa-instagram" aria-hidden="true"></i>
                </a>
                <a href="https://www.instagram.com">
                  <i class="fa fa-twitter" aria-hidden="true"></i>
                </a>
                <a href="https://www.google.com">
                    <i class="fa fa-google" aria-hidden="true"></i>
                </a>
              </div>
            </div>
            <div class="footertext">
                <p style="color: white ;">Jaykay marketing Services Pvt Ltd.</p>
                <p style="color: white ;">No : 148, Vauxhall Street, Colombo 2, Sri Lanka.</p>
                <br><br>
                <p style="color: white ;"><i class="fa fa-phone" aria-hidden="true"> +94 112303500 </i></p>
                <p style="color: white ;">(Daily operating hours 8.00a.m to 8.00p.m)</p>
            </div>
            <div class="quicklinkcontainer">
                <ul class="quicklinkcontaineritem" style="color: rgb(172, 4, 147);">Quick Links</ul>
                <li class="first"><a href = "">Home</a></li>
                <br>
                <li class="first"><a href = "">Catalogue & Deals</a></li>
                <br>
                <li class="first"><a href = "">Utility bill payments</a></li>
                <br>
                <li class="first"><a href = "">Track my order</a></li>
            </div>
            <div class="usefullinkcontainer">
                <ul class="usefullinkcontaineritem" style="color: rgb(172, 4, 147);">Useful Links</ul>
                <li class="second"><a href = "">Privacy Policy</a></li>
                <br>
                <li class="second"><a href = "">FAQ</a></li>
                <br>
                <li class="second"><a href = "">Terms and conditions</a></li>
                <br>
                <li class="second"><a href = "">Stores</a></li>
                <br>
                <li class="second"><a href = "">Delivery grid</a></li>
            </div>
            <div class="categorycontainer">
                <ul class="categorycontaineritem" style="color: rgb(172, 4, 147);">Categories</ul>
                <li class="third"><a href = "">Grocery</a></li>
                <br>
                <li class="third"><a href = "">Beverages</a></li>
                <br>
                <li class="third"><a href = "">Fruits</a></li>
                <br>
                <li class="third"><a href= "https://www.keellssuper.com/TermsAndConditions">Vegetables</a></li>
            </div>
            <div class="customerservicecontainer">
                <ul class="customerservicecontaineritem" style="color: rgb(172, 4, 147);">Customer Service</ul>
                <li class="fourth"><a href = "">Contact Us</a></li>
                <br>
                <li class="fourth"><a href = "">About Us</a></li>
            </div>
        </div>
        <div class="endfooter">
            <br>
            <h3 style="color: white; font: 1em sans-serif;" >Copyright © 2022 OneStop Grocery(Pvt) Ltd. All Rights Reserved</h3>
            <div class="cardArea">
                <img src="./images/americanExpress.jpeg" alt="imageVisaCard">
                <img src="./images/visa.jpeg" alt="imagevisaCard">
                <img src="./images/master.jpeg" alt="imageMasterCard">
                <img src="./images/discover.jpeg" alt="imageDiscoverCard">
          </div>
        </div>	
</body>
</html>