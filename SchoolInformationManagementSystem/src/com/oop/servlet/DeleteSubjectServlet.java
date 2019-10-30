package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.service.ISubjectService;
import com.oop.service.SubjectServiceImpl;

/**
 * Servlet implementation class DeleteSubjectServlet
 */
@WebServlet("/DeleteSubjectServlet")
public class DeleteSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteSubjectServlet() {
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

		String subjectID = request.getParameter("subjectID");

		ISubjectService iSubjectService = new SubjectServiceImpl();

		if (SubjectServiceImpl.checkIDAvailable(subjectID)) {
			iSubjectService.removeSubject(subjectID);
			request.setAttribute("successfullyDeletedSubject", "Subject has successfully deleted!");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/viewSubjects.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("subjectNotFound", "Subject details not found!");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/viewSubjects.jsp");
			dispatcher.forward(request, response);

		}

	}

}
