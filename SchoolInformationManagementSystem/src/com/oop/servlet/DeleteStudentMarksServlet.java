package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.IStudentMarkService;
import com.oop.service.IStudentMarkServiceImpl;

/**
 * Servlet implementation class DeleteStudentMarksServlet
 */
@WebServlet("/DeleteStudentMarksServlet")
public class DeleteStudentMarksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteStudentMarksServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");

		String markID = request.getParameter("markID");

		IStudentMarkService iEmployeeService = new IStudentMarkServiceImpl();
		iEmployeeService.removeMark(markID);

		request.setAttribute("successfullyDeleted", "Student marks details has successfully deleted!");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListStudentsAll.jsp");
		dispatcher.forward(request, response);
	}

}
