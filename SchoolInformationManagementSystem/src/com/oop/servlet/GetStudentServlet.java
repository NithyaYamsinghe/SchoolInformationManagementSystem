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
 * Servlet implementation class GetStudentServlet
 */
@WebServlet("/GetStudentServlet")
public class GetStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetStudentServlet() {
		super();

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

		String studentID = request.getParameter("studentID");
		IStudentService iStudentService = new StudentServiceImpl();

		if (StudentServiceImpl.checkIDAvailable(studentID)) {
			Student student = iStudentService.getStudentByID(studentID);

			request.setAttribute("student", student);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/updateStudent.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("studentNotFound", "Student details not found!");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/viewStudents.jsp");
			dispatcher.forward(request, response);

		}

	}

}
