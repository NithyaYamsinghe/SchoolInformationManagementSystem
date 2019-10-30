<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<!--meta tags-->
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<!--font-styles-css-->
	<link rel="stylesheet" href="css/fontawesome/css/all.css"
		type="text/css" />
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"
		media="all" />
	<link href="//fonts.googleapis.com/css?family=Alegreya+Sans"
		rel="stylesheet">
	<!-- styles-css-->
	<link rel="stylesheet" href="css/homeCategory.css" type="text/css">
	<!--footer-css-->
	<link href="css/footer.css" rel='stylesheet' type='text/css' />
	<!--header-css-->
	<link rel="stylesheet" href="css/header.css">
	<title>Southbank | Home Management</title>
</head>
<body>
<%
	if(session.getAttribute("userName")== null || session.getAttribute("password")== null)
	{
		request.getRequestDispatcher("login.jsp").forward(request,response);
		
		//response.sendRedirect("login.jsp");
	}
%>

	<!--header-->
	<div id='cssmenu'>
		<ul>
			<li><a><span>Welcome ${userName}</span></a></li>
			<li><a href="homeStudent.jsp"><span>Student Management</span></a></li>
			<li><a href='homeTeacher.jsp'><span>Teacher Management</span></a></li>
			<li><a href='homeSubject.jsp'><span>Subject Management</span></a></li>
			<li><a href='homeMarks.jsp'><span>Marks Management</span></a></li>
			<li><a href="updateAdmin.jsp"><span>Profile</span></a></li>
			<li><a href="LogOutServlet"><span>LogOut</span></a></li>
			<!-- <li class='last'><form action="LogOutServlet" method="post"><input  type="submit" value="LogOut"></form>-->
			<!--  <li class='last'><form action="updateAdmin.jsp" method="post"><input type="hidden" name="userName" value="${userName}"/><input  type="submit" value="Profile"></form>-->
			
		</ul>
	</div>
	<!--//header>
	<!- Page Content Appear Here-->
	<div class="main_content">
		<div class="container">
			<h1>School Information Management System</h1>
			<a href="homeStudent.jsp" class="button"> Student Management </a><br>
			<br>
			<br>
			<br> <a href="homeTeacher.jsp" class="button"> Teacher Management </a><br>
			<br>
			<br>
			<br> <a href="homeSubject.jsp" class="button"> Subject Management </a><br>
			<br>
			<br>
			<br> <a href="homeMarks.jsp" class="button"> Marks management</a><br>
			<br>
			<br>
			<br><form method="post" action="ListContactUsServlet">
				<button class="button">View Contact Us Messages</button>
			</form>
			</div>
	</div>
	<br>
	<br>
	<!-- Page Content Appear Here-->
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
					<li><a href="homeStudent.jsp">Student Management</a></li>
					<li><a href="homeTeacher.jsp">Teacher Management</a></li>
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
					<li><a href="https://www.linkedin.com/login"><i class="fa fa-android"
							aria-hidden="true"></i></a></li>
				</ul>
			</div>
			<div class="footer-btm-grids-wthree fbr-w3">
				<h3>Subscribe</h3>
				<form action="#" method="post">
					<input type="email" class="email" name="email"
						placeholder="Enter Your Email" required=""> <input
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
</body>
</html>