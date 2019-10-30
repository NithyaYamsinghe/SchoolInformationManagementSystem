package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Student;
import com.oop.service.StudentServiceImpl;
import com.oop.service.IStudentService;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddStudentServlet() {
		super();

	}

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

		Student student = new Student();

		student.setName(request.getParameter("studentName"));
		student.setDateOfAdmission(request.getParameter("dateOfAdmission"));
		student.setAddress(request.getParameter("address"));
		student.setDateOfBirth(request.getParameter("dateOfBirth"));
		student.setGuardianName(request.getParameter("guardianName"));
		student.setStream(request.getParameter("stream"));
		student.setGrade(request.getParameter("grade"));
		student.setDivision(request.getParameter("division"));
		student.setAge(request.getParameter("age"));
		student.setGender(request.getParameter("gender"));
		student.setEmail(request.getParameter("email"));

		IStudentService iStudentService = new StudentServiceImpl();
		iStudentService.addStudent(student);

		request.setAttribute("student", student);
		request.setAttribute("successfullyAdded", "New student has successfully added!");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/viewStudents.jsp");
		dispatcher.forward(request, response);

	}

}
