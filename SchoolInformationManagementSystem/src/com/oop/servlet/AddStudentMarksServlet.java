package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Mark;
import com.oop.service.IStudentMarkServiceImpl;
import com.oop.service.IStudentMarkService;

/**
 * Servlet implementation class AddStudentMarksServlet
 */
@WebServlet("/AddStudentMarksServlet")
public class AddStudentMarksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AddStudentMarksServlet() {
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

		Mark mark = new Mark();

		// mark.setExamID(request.getParameter("employeeName"));
		mark.setStudentID(request.getParameter("stdID"));
		// mark.setExamName(request.getParameter("examName"));
		mark.setExamName(request.getParameter("examName"));
		mark.setYear(Integer.parseInt(request.getParameter("examYear")));
		mark.setSubjectName(request.getParameter("subjectName"));
		mark.setMarks(Double.parseDouble(request.getParameter("marks")));
		// mark.setGrade()
		mark.setRemark(request.getParameter("remarks"));
		// mark.passFail()

		IStudentMarkService iStudentMarkService = new IStudentMarkServiceImpl();
		iStudentMarkService.addMark(mark);

		request.setAttribute("mark", mark);
		request.setAttribute("successfullyAdded", "New student marks has successfully added!");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListStudentsAll.jsp");
		dispatcher.forward(request, response);
	}

}
