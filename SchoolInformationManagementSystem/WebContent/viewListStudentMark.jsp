<%@page import="com.oop.model.Mark"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.IStudentMarkService"%>
<%@page import="com.oop.service.IStudentMarkServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String studentID = (String) request.getParameter("stdID");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Southbank | View Student Marks</title>
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"
		media="all" />
	
	<link href="css/footer.css" rel='stylesheet' type='text/css' />
	<link href="//fonts.googleapis.com/css?family=Alegreya+Sans"
		rel="stylesheet">
	<link rel="stylesheet" href="css/header.css">
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style type="text/css">
	body {
		color: #566787;
		background-color: #ecf0f1;
		font-family: 'Roboto', sans-serif;
		background-color: #ecf0f1;
	}
	
	.table-wrapper {
		background: #fff;
		padding: 20px 25px;
		margin: 30px auto;
		border-radius: 3px;
		box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
	}
	
	.table-title {
		color: #fff;
		background: #40b2cd;
		padding: 16px 25px;
		margin: -20px -25px 10px;
		border-radius: 3px 3px 0 0;
	}
	
	.table-title h2 {
		margin: 5px 0 0;
		font-size: 24px;
	}
	
	.search-box {
		position: relative;
		float: right;
	}
	
	.search-box .input-group {
		min-width: 300px;
		position: absolute;
		right: 0;
	}
	
	.search-box .input-group-addon, .search-box input {
		border-color: #ddd;
		border-radius: 0;
	}
	
	.search-box input {
		height: 34px;
		padding-right: 35px;
		background: #f4fcfd;
		border: none;
		border-radius: 2px !important;
	}
	
	.search-box input:focus {
		background: #fff;
	}
	
	.search-box input::placeholder {
		font-style: italic;
	}
	
	.search-box .input-group-addon {
		min-width: 35px;
		border: none;
		background: transparent;
		position: absolute;
		right: 0;
		z-index: 9;
		padding: 6px 0;
	}
	
	.search-box i {
		color: #a0a5b1;
		font-size: 19px;
		position: relative;
		top: 2px;
	}
	
	table.table {
		table-layout: fixed;
		margin-top: 15px;
	}
	
	table.table tr th, table.table tr td {
		border-color: #e9e9e9;
	}
	
	table.table th i {
		font-size: 13px;
		margin: 0 5px;
		cursor: pointer;
	}
	
	table.table th:first-child {
		width: 60px;
	}
	
	table.table th:last-child {
		width: 120px;
	}
	
	table.table td a {
		color: #a0a5b1;
		display: inline-block;
		margin: 0 5px;
	}
	
	table.table td a.view {
		color: #03A9F4;
	}
	
	table.table td a.edit {
		color: #FFC107;
	}
	
	table.table td a.delete {
		color: #E34724;
	}
	
	table.table td i {
		font-size: 19px;
	}
	
	button {
		background-color: #67809f;
		color: #fff;
		margin-top: 20px;
		margin-right: 20px;
		margin-left: 20px;
	}
	
	.select-button{
	
		background-color: #67809f;
		color: #fff;
		margin-top: 10px;
		margin-right: 60px;
		margin-left: 0px;
		border-radius:3px;
	
	}
	</style>
</head>
<body>


	<%
	if(session.getAttribute("userName")== null || session.getAttribute("password")== null)
	{
		request.getRequestDispatcher("login.jsp").forward(request,response);
		
		//response.sendRedirect("login.jsp");
	}
%>



	<div id='cssmenu'>
		<ul>
			<li><a><span>Welcome ${userName}</span></a></li>
			<li class='active'><a href='homeCategory.jsp'><span>Home</span></a></li>
			<li><a href="homeMarks.jsp"><span>Marks Management</span></a></li>
			<li><a href='addMarks.jsp'><span>Add Marks</span></a></li>
			<li><a href="updateAdmin.jsp"><span>Profile</span></a></li>
			<li><a href="LogOutServlet"><span>LogOut</span></a></li>
		</ul>
	</div>
	<div>
		<center><h3 style="color: green;">${successfullyAdded}</h3></center>
		<center><h3 style="color: green;">${successfullyUpdated}</h3></center>
		<center><h3 style="color: green;">${successfullyDeleted}</h3></center>
		<center><h3 style="color: red;">${studentNotFound}</h3></center>
		<!--  <a href="addMarks.jsp"><button type="submit" class="btn submit mt-3" value="">Add New Mark</button></a>-->
			
	</div>
	<div class="container">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>
							Student <b>Marks Details</b>
						</h2>
					</div>

				</div>
			</div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th style="width: 30%;">Exam ID</th>
						<th style="width: 45%;">Student ID</th>
						<th style="width: 45%;">Exam Name</th>
						<th style="width: 35%;">Year</th>
						<th style="width: 55%;">Subject Name</th>
						<th style="width: 45%;">Marks</th>
						<th style="width: 45%;">Grade</th>
						<th style="width: 35%;">Remark</th>
						<th style="width: 35%;">Pass Fail</th>
						<th style="width: 35%;">Select</th>
		
					</tr>
				</thead>
             <%              
    
            IStudentMarkService iStudentMarkService = new IStudentMarkServiceImpl();
     		ArrayList<Mark> arrayList = iStudentMarkService.getAllMarkByID(studentID);
			
			
			for(Mark mark : arrayList){
			%>
				<tbody>
					<tr>
						<td><%=mark.getExamID() %></td>
						<td> <%=mark.getStudentID() %></td>
						<td><%=mark.getExamName() %></td>
						<td><%=mark.getYear() %></td>
						<td> <%=mark.getSubjectName() %></td>
						<td><%=mark.getMarks() %></td>
						<td><%=mark.getGrade() %></td>
						<td> <%=mark.getRemark() %></td>
						<td><%=mark.getPassFail() %></td>
						<td>
						<form method="POST" action="GetStudentMarksServlet">
						<input type="hidden" name="studentID" value="<%=mark.getExamID()%>"/>
						<input type="submit" value= "Select" class="select-button" /> 
						 </form>
						 </td>
					</tr>
				</tbody>
				<%
				}
			%>
			</table>
		</div>
	</div>

	<!--footer-->
	<div class="main-agile">
		<div class="footer-top-agileinfo">
			<div class="footer-top-grids-wthree ftl-w3">
				<h3>About</h3>
				<p>Best Study is a gives world class education for students.Our
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
					<li><a href="https://twitter.com/login?lang=en"><i
							class="fa fa-twitter" aria-hidden="true"></i></a></li>
					<li><a href="https://en-gb.facebook.com/login/"><i
							class="fa fa-facebook" aria-hidden="true"></i></a></li>
					<li><a href="https://www.linkedin.com/login"><i
							class="fa fa-linkedin" aria-hidden="true"></i></a></li>
				</ul>
			</div>
			<div class="footer-btm-grids-wthree fbm-w3">
				<h3>Our Apps</h3>
				<ul>
					<li><a href="https://www.apple.com/ios/app-store/"><i
							class="fa fa-apple" aria-hidden="true"></i></a></li>
					<li><a
						href="https://www.microsoft.com/en-us/store/apps/windows"><i
							class="fa fa-windows" aria-hidden="true"></i></a></li>
					<li><a href="https://play.google.com/store/apps?hl=en"><i
							class="fa fa-android" aria-hidden="true"></i></a></li>		
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
</body>
</html>
