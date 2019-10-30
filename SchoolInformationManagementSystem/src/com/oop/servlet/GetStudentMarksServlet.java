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
 * Servlet implementation class GetStudentMarksServlet
 */
@WebServlet("/GetStudentMarksServlet")
public class GetStudentMarksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetStudentMarksServlet() {
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

		IStudentMarkService iStudentMarkService = new IStudentMarkServiceImpl();
		request.setAttribute("mark", iStudentMarkService.getMarkByID(markID));
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GetStudentMarks.jsp");
		dispatcher.forward(request, response);
	}

}
