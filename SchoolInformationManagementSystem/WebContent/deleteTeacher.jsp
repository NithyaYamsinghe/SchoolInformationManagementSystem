<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Southbank | Delete Teacher</title>
    <!-- Footer-CSS -->
	<link href="css/footer.css" rel='stylesheet' type='text/css' />
	<!-- header-CSS -->
	<link rel="stylesheet" href="css/header.css">
	<link rel="stylesheet" href="css/fontawesome/css/all.css"
		type="text/css">
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"
		media="all" />
	<link href="//fonts.googleapis.com/css?family=Alegreya+Sans"
		rel="stylesheet">
    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/deleteStudent.css" rel="stylesheet" media="all">
</head>

<body>
	<!--header-->
	<div id='cssmenu'>
		<ul>
			<li><a><span>Welcome ${userName}</span></a></li>
			<li class='active'><a href='homeCategory.jsp'><span>Home</span></a></li>
			<li><a href="homeTeacher.jsp"><span>Teacher Management</span></a></li>
			<li><a href='addTeacher.jsp'><span>Add New Teachers</span></a></li>
			<li><a href="updateAdmin.jsp"><span>Profile</span></a></li>
			<li><a href="LogOutServlet"><span>LogOut</span></a></li>
		</ul>
	</div>
	<!--//header-->
    <div class="page-wrapper bg-gra-02 p-t-130 p-b-100 font-poppins">
        <div class="wrapper wrapper--w680">
            <div class="card card-4">
                <div class="card-body">
                    <h2 class="title">Search Teacher</h2>
                    <form method="POST" action="DeleteTeacherServlet">
                        <div class="row row-space">
                            <div class="col-2">
                                <div class="input-group">
                                    <label class="label">Teacher ID</label>
                                    <input class="input--style-4" type="text" name="teacherID" >
                                </div>
                            </div>
                         </div>
                        
                        <div class="p-t-15">
                            <button class="btn btn--radius-2 btn--blue" type="submit">Delete Teacher</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!--footer-->
	<div class="main-agile">
		<div class="footer-top-agileinfo">
			<div class="footer-top-grids-wthree ftl-w3">
				<h3>About</h3>
				<p>Southbank International School gives world class education for students.Our
					mission,simply put, is to prepare students lives of
					purpose,achievement, and generosity of spirit.</p>
			</div>
			<div class="footer-top-grids-wthree ftm-w3">
				<h3>Navigation</h3>
				<ul>
					<li><a href="homeCategory.jsp">Home</a></li>
					<li><a href="homeTeacher.jsp">Teacher Management</a></li>
					<li><a href="addTeacher.jsp">Add New Teachers</a></li>
				</ul>
			</div>
			<div class="footer-top-grids-wthree ftr-w3">
				<h3>Resources</h3>
				<ul>
					<li><a href="aboutUs.jsp">Spread the world</a></li>
					<li><a href="contactUs.jsp">Contact Us</a></li>
					<li><a href="gallery.jsp">Gallery</a></li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
		<div class="footer-bottom-agileits">
			<div class="footer-btm-grids-wthree fbl-w3">
				<h3>Follow us</h3>
				<ul>
					<li><a href="https://twitter.com/login?lang=en"><i class="fa fa-twitter"
							aria-hidden="true"></i></a></li>
					<li><a href="https://en-gb.facebook.com/login/"><i class="fa fa-facebook"
							aria-hidden="true"></i></a></li>
					<li><a href="https://www.linkedin.com/login"><i class="fa fa-linkedin"
							aria-hidden="true"></i></a></li>
				</ul>
			</div>
			<div class="footer-btm-grids-wthree fbm-w3">
				<h3>Our Apps</h3>
				<ul>
					<li><a href="https://www.apple.com/ios/app-store/"><i class="fa fa-apple" aria-hidden="true"></i></a></li>
					<li><a href="https://www.microsoft.com/en-us/store/apps/windows"><i class="fa fa-windows"
							aria-hidden="true"></i></a></li>
					<li><a href="https://play.google.com/store/apps?hl=en"><i class="fa fa-android"
							aria-hidden="true"></i></a></li>
				</ul>
			</div>
			<div class="footer-btm-grids-wthree fbr-w3">
				<h3>Subscribe</h3>
				<form action="#" method="post">
					<input type="email" class="email" name="email"
						placeholder="Enter Your Email" required="required"> <input
						type="submit" value="Subscribe">
				</form>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="footer-w3l">
		<p class="agileinfo">
			&copy; 2019 All Rights Reserved | Southbank International School
		</p>
	</div>
	<!--footer-->

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/global.js"></script>

</body>

</html>
