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
import com.oop.service.IStudentMarkService;;

/**
 * Servlet implementation class UpdateStudentMarksServlet
 */
@WebServlet("/UpdateStudentMarksServlet")
public class UpdateStudentMarksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStudentMarksServlet() {
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
		// TODO Auto-generated method stub

		response.setContentType("text/html");

		Mark mark = new Mark();
		String markID = request.getParameter("markID");
		mark.setExamID(markID);
		mark.setStudentID(request.getParameter("stdID"));
		mark.setExamName(request.getParameter("examName"));
		mark.setYear(Integer.parseInt(request.getParameter("year")));
		mark.setSubjectName(request.getParameter("subjectName"));
		mark.setMarks(Double.parseDouble(request.getParameter("marks")));
		// mark.setGrade(request.getParameter("grade"));
		mark.setRemark(request.getParameter("remark"));
		// mark.setPassFail(request.getParameter("passFail"));

		IStudentMarkService iStudentMarkService = new IStudentMarkServiceImpl();
		iStudentMarkService.updateMark(markID, mark);

		request.setAttribute("successfullyUpdated", "New record has successfully updated!");

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListStudentsAll.jsp");
		dispatcher.forward(request, response);

	}

}
