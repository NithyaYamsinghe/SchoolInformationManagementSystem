<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
	<title>Southbank | Join Us</title>
	<!-- meta-tags -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Soft Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!-- //meta-tags -->
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<!-- font-awesome -->
	<link href="css/font-awesome.css" rel="stylesheet">
	<!-- fonts -->
	<link href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i"
	    rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
	<!-- Calendar -->
	<link rel="stylesheet" href="css/jquery-ui.css" />
</head>

<body>
	<!-- header -->
	<div class="header-top">
		<div class="container">
			<div class="bottom_header_left">
				<p>
					<span class="fa fa-map-marker" aria-hidden="true"></span>New Kampshire Mshinon, USA
				</p>
			</div>
			<div class="bottom_header_right">
				<div class="bottom-social-icons">
					<a class="facebook" href="https://en-gb.facebook.com/login/"> <span class="fa fa-facebook"></span>
					</a> <a class="twitter" href="https://twitter.com/login?lang=en"> <span class="fa fa-twitter"></span>
					</a> <a class="pinterest" href="https://www.pinterest.com/login/"> <span class="fa fa-pinterest-p"></span>
					</a> <a class="linkedin" href="https://www.linkedin.com/login"> <span class="fa fa-linkedin"></span>
					</a>
				</div>
				<div class="header-top-righ">
					<a href="login.jsp">
						<span class="fa fa-sign-out" aria-hidden="true"></span>Login</a>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<div class="header">
		<div class="content white">
			<nav class="navbar navbar-default">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="index.jsp">
							<h1>
								<span class="fa fa-leanpub" aria-hidden="true"></span>Southbank
								<label>International School</label>
							</h1>
						</a>
					</div>
					<!--/.navbar-header-->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<nav class="link-effect-2" id="link-effect-2">
							<ul class="nav navbar-nav">
								<li class="active"><a href="index.jsp" class="effect-3">Home</a>
								</li>
								<li><a href="aboutUs.jsp" class="effect-3">About Us</a></li>
								<li><a href="subjects.jsp" class="effect-3">Subjects</a></li>
								<li><a href="join.jsp" class="effect-3">Join Us</a></li>
								<li><a href="gallery.jsp" class="effect-3">Gallery</a></li>
								<li><a href="contactUs.jsp" class="effect-3">Contact Us</a>
								</li>
							</ul>
						</nav>
					</div>
					<!--/.navbar-collapse-->
					<!--/.navbar-->
				</div>
			</nav>
		</div>
	</div>
	<!-- banner -->
	<div class="inner_page_agile">

	</div>
	<!--//banner -->
	<!-- short-->
	<div class="services-breadcrumb">
		<div class="inner_breadcrumb">
			<ul class="short_ls">
				<li>
					<a href="index.jsp">Home</a>
					<span>| |</span>
				</li>
				<li>Join Us</li>
			</ul>
		</div>
	</div>
	<!-- //short-->
	<div class="register-form-main">
		<div class="container">
			<div class="title-div">
				<h3 class="tittle">
					<span>A</span>dmission
					<span>F</span>orm
					<span>F</span>or
					<span>A</span>ptitude 
					<span>T</span>est 
				</h3>
				<div class="tittle-style">

				</div>
			</div>
			<div class="register-form">
				<form action="AddJoinServlet" method="post">
					<div class="fields-grid">
						<div class="styled-input">
							<input type="text" placeholder="Your Name" name="name" required="required">
						</div>
						<div class="styled-input">
							<input id="datepicker" placeholder="Birth Date" name="birthDate" type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'mm/dd/yyyy';}"
							    required="required">
						</div>
						<div class="styled-input agile-styled-input-top">
							<select class="category2" required="required" name="gender">
								<option value="" >Gender</option>
								<option value="Female">Female</option>
								<option value="Male">Male</option>
							</select>
						</div>
						<div class="styled-input">
							<input type="email" placeholder="Your E-mail" name="email" required="required">
						</div>
						<div class="styled-input">
							<input type="text" placeholder="Phone Number" name="phoneNumber" required="required">
						</div>
						
						<div class="styled-input">
							<label class="header">Your Address</label>
							<div class="">
								<input type="text" name="address" placeholder="Address" title="Please enter your Address" required="required">
							</div>
							<div class="">
								<input type="text" name="city" placeholder="City" title="Please enter your City" required="required">
							</div>
							
						</div>
						<div class="clearfix"> </div>
					</div>
					<input type="submit" value="Submit">
				</form>
			</div>
		</div>
	</div>

	<!-- footer -->
	<div class="mkl_footer">
		<div class="sub-footer">
			<div class="container">
				<div class="mkls_footer_grid">
					<div class="col-xs-4 mkls_footer_grid_left">
						<h4>Location:</h4>
						<p>New Kampshire Mshinon,
							<br> Foxhall Road, USA</p>
					</div>
					<div class="col-xs-4 mkls_footer_grid_left">
						<h4>Mail Us:</h4>
						<p>
							<span>Phone : </span>001 234 5678</p>
						<p>
							<span>Email : </span>
							<a href="mailto:Southbank@info.com">Southbank@info.com</a>
						</p>
					</div>
					<div class="col-xs-4 mkls_footer_grid_left">
						<h4>Opening Hours:</h4>
						<p>Working days : 8am-10pm</p>
						<p>Sunday
							<span>(closed)</span>
						</p>
					</div>
					<div class="clearfix"> </div>
				</div>
				<div class="botttom-nav-allah">
					<ul>
						<li><a href="index.jsp">Home</a></li>
						<li><a href="aboutUs.jsp">About Us</a></li>
						<li><a href="subjects.jsp">Subjects</a></li>
						<li><a href="join.jsp">Join Us</a></li>
						<li><a href="contactUs.jsp">Contact Us</a></li>
					</ul>
				</div>
				<!-- footer-button-info -->
				<div class="footer-middle-thanks">
					<h2>Path To Best Education</h2>
				</div>
				<!-- footer-button-info -->
			</div>
		</div>
		<div class="footer-copy-right">
			<div class="container">
				<div class="allah-copy">
					<p>� 2019 | SouthBank International School. All rights reserved </p>
				</div>
				<div class="footercopy-social">
					<ul>
						<li><a href="https://en-gb.facebook.com/login/"> <span class="fa fa-facebook"></span>
						</a></li>
						<li><a href="https://twitter.com/login?lang=en"> <span class="fa fa-twitter"></span>
						</a></li>
						<li><a href="#"> <span class="fa fa-rss"></span>
						</a></li>
						<li><a href="https://vk.com"> <span class="fa fa-vk"></span>
						</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--/footer -->

	<!-- js files -->
	<!-- js -->
	<script src="js/jquery-2.1.4.min.js"></script>
	<!-- bootstrap -->
	<script src="js/bootstrap.js"></script>
	
	<script src="js/jquery-ui.js"></script>
	<script>
		$(function () {
			$("#datepicker,#datepicker1,#datepicker2,#datepicker3").datepicker();
		});
	</script>
	<!-- //Calendar -->
	<!-- smooth scrolling -->
	<script src="js/SmoothScroll.min.js"></script>
	<script src="js/move-top.js"></script>
	<script src="js/easing.js"></script>
	<!-- here stars scrolling icon -->
	<script>
		$(document).ready(function () {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/

			$().UItoTop({
				easingType: 'easeOutQuart'
			});

		});
	</script>
	<!-- //here ends scrolling icon -->
	<!-- smooth scrolling -->
	<!-- //js-files -->

</body>

</html>