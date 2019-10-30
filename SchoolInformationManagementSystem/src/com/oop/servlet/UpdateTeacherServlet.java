package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Teacher;
import com.oop.service.ITeacherService;
import com.oop.service.TeacherServiceImpl;

/**
 * Servlet implementation class UpdateTeacherServlet
 */
@WebServlet("/UpdateTeacherServlet")
public class UpdateTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateTeacherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		Teacher teacher = new Teacher();

		String teacherID = request.getParameter("teacherID");
		teacher.setTeacherID(teacherID);

		teacher.setName(request.getParameter("teacherName"));
		teacher.setDateOfRegistration(request.getParameter("dateOfRegistration"));
		teacher.setAddress(request.getParameter("address"));
		teacher.setDateOfBirth(request.getParameter("dateOfBirth"));
		teacher.setSpecialization(request.getParameter("specialization"));
		teacher.setQualification(request.getParameter("qualification"));
		teacher.setDepartment(request.getParameter("department"));
		teacher.setTelephoneNo(request.getParameter("telephoneNo"));
		teacher.setAge(request.getParameter("age"));
		teacher.setGender(request.getParameter("gender"));
		teacher.setEmail(request.getParameter("email"));

		ITeacherService iTeacherService = new TeacherServiceImpl();
		iTeacherService.updateTeacher(teacherID, teacher);

		request.setAttribute("successfullyUpdatedTeacher", "Teacher details has successfully updated!");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/viewTeachers.jsp");
		dispatcher.forward(request, response);

	}

}
