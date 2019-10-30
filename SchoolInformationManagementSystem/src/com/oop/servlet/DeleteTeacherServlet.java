package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.ITeacherService;
import com.oop.service.TeacherServiceImpl;

/**
 * Servlet implementation class DeleteTeacherServlet
 */
@WebServlet("/DeleteTeacherServlet")
public class DeleteTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteTeacherServlet() {
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

		String teacherID = request.getParameter("teacherID");

		ITeacherService iTeacherService = new TeacherServiceImpl();

		if (TeacherServiceImpl.checkIDAvailable(teacherID)) {
			iTeacherService.removeTeacher(teacherID);
			request.setAttribute("successfullyDeletedTeacher", "Teacher has successfully deleted!");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/viewTeachers.jsp");
			dispatcher.forward(request, response);

		} else {
			request.setAttribute("teacherNotFound", "Teacher details not found!");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/viewTeachers.jsp");
			dispatcher.forward(request, response);

		}
	}

}
