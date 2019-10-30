package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Subject;
import com.oop.service.ISubjectService;
import com.oop.service.SubjectServiceImpl;

/**
 * Servlet implementation class UpdateSubjectServlet
 */
@WebServlet("/UpdateSubjectServlet")
public class UpdateSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateSubjectServlet() {
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

		Subject subject = new Subject();
		String subjectID = request.getParameter("subjectID");
		subject.setSubjectID(subjectID);

		subject.setSubjectName(request.getParameter("subjectName"));
		subject.setTeacherID(request.getParameter("teacherID"));
		subject.setTeacherName(request.getParameter("teacherName"));
		subject.setCredits(request.getParameter("credits"));
		subject.setDeliveringGrade(request.getParameter("deliveringGrade"));
		subject.setDepartment(request.getParameter("department"));

		ISubjectService iSubjectService = new SubjectServiceImpl();
		iSubjectService.updateSubject(subjectID, subject);

		request.setAttribute("successfullyUpdatedSubject", "Subject details has successfully updated!");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/viewSubjects.jsp");
		dispatcher.forward(request, response);

	}

}
