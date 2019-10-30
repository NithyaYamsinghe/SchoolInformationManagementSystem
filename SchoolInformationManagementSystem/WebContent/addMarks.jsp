<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
	<title>Southbank | Add Marks</title>
	<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8" />
	<!-- Footer-CSS -->
	<link href="css/footer.css" rel='stylesheet' type='text/css' />
	<!-- Bootstrap-Core-CSS -->
	<link rel="stylesheet" href="css/bootstrapstudent.css">
	<!-- Style-CSS -->
	<link rel="stylesheet" href="css/studentform.css" type="text/css"media="all" />
	<!-- Font-Awesome-Icons-CSS -->
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="css/fontawesome/css/all.css"type="text/css">
	<!-- header-CSS -->
	<link rel="stylesheet" href="css/header.css">
	<!-- Web-Fonts -->
	<link href="//fonts.googleapis.com/css?family=Alegreya+Sans"rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Crimson+Text:400,400i,600,600i,700,700i" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Oxygen:300,400,700&amp;subset=latin-ext" rel="stylesheet">
	<!-- //Web-Fonts -->
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
			<li><a href='homeCategory.jsp'><span>Home</span></a></li>
			<li><a href="homeMarks.jsp"><span>Marks Management</span></a></li>
			<li><a href='addMarks.jsp'><span>Add Marks</span></a></li>
			
			<li><a href="updateAdmin.jsp"><span>Profile</span></a></li>
			<li><a href="LogOutServlet"><span>LogOut</span></a></li>
		</ul>
	</div>
	<!--//header-->
	<!-- content -->
	<section class="contact py-5" id="contact">
		<div class="container py-xl-5 py-lg-3">
			<div class="register-w3 py-5">
				<div class="container py-xl-5 py-lg-3">
					<h3 class="tittle text-center text-bl font-weight-bold">Add Student
						Marks</h3>
					<div class="comment-top mt-5">
						<div class="comment-bottom mobamuinfo_mail_grid_right">
							<form action="AddStudentMarksServlet" method="POST">
							<div class="row">
							<div class="col-lg-6 form-group">
									<div class="row">
											<div class="col-lg-6 form-group">
											
											<h5>Examination Details</h5>
											<hr>
												
												<label for="class">Class</label>
												<!-- <input class="form-control" type="text" name="studentName" placeholder="Student Name" required="required">  -->
												<select id="class" name="class" class="form-control">
													<option value="Grade 12 - A">Grade 12 - A</option>
													<option value="Grade 12 - B">Grade 12 - B</option>
													<option value="Grade 12 - C">Grade 12 - C</option>
													<option value="Grade 13 - A">Grade 13 - A</option>
													<option value="Grade 13 - B">Grade 13 - B</option>
													<option value="Grade 13 - C">Grade 13 - C</option>
												</select>
											</div>
											</div>
											<div class="row">
											<div class="col-lg-6 form-group">
												<label for="exam">Examination</label>
											    <select id="exam" name="examName" class="form-control">
											      <option value="1st term test">1st Term Test</option>
											      <option value="2nd term test">2nd Term Test</option>
											      <option value="3rd term test">3rd Term Test</option>
											    </select>
											</div>
											</div>
											<div class="row">
											<div class="col-lg-6 form-group">
											<label for="year">Year</label>
											<input type="text" id="year" name="examYear" class="form-control" placeholder="Year of the Examination.." required="required">
										</div>
										</div>
									
									<div class="row">
										<div class="col-lg-6 form-group">								
									  			<label for="subjectName">Name  of the Subject/ Module</label>
										    <select id="subjectName" name="subjectName" class="form-control">
										      <option value="Economics">Economics</option>
										      <option value="Accounting">Accounting</option>
										      <option value="Business Studies">Business Studies</option>
									  		      <option value="General English">General English</option>
										    </select>
										</div>
										
									</div>
									</div>
									<div class="col-lg-6 form-group">
									<div class="row">
										<div class="col-lg-6 form-group">
										
											<h5>Examination Details Of The Student</h5>
											<hr>
												
										    <label for="stdID">Student ID</label>
										    <input type="text" id="stdID" name="stdID" class="form-control" placeholder="Student ID.." required="required">
												
										</div>
										</div>
										<div class="row">
										<div class="col-lg-6 form-group">	
										    <label for="marks">Marks</label>
										    <input type="text" id="marks" name="marks" class="form-control" placeholder="Obatained Marks.." required="required">
											
										</div>
									</div>
									<div class="row">
										<div class="col-lg-6 form-group">
										
									  		    <label for="remarks">Remarks (Optional)</label>
										    <input type="text" id="marks" name="remarks" class="form-control" placeholder="If any remarks..">
																			
										</div>
										
									</div>
									</div>
									
									<div class="col-lg-6 form-group">	
									<div class="row">
									
										<div class="col-lg-6 form-group">
											<button type="submit" class="btn submit mt-3" onclick="notifyYesOrNoFunction()" value="Add Record">Add Record</button>
										</div>
										
										
									</div>
									</div>
									<div class="row">
									<div class="col-lg-6 form-group">
											<button type="reset" class="btn submit mt-3" value="Reset">Reset</button>
										</div>
									</div>
							
							</form>	
							<div class="row">
									<div class="col-lg-6 form-group">
									<form method="post" action=ListStudentMarksServlet>
										<button type="submit" class="btn submit mt-3" value="List All Students Marks">View All Students Marks</button>
									</form>
									</div>

								</div>

							</div>
						</div>
					</div>
			</div>
		</div>
	</section>
	
					
	<!-- //content-->
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
					<li><a href="homeMarks.jsp">Marks Management</a></li>
					<li><a href="addMarks.jsp">Add Marks</a></li>
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
</body>
</html>