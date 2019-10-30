package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.ContactUs;

import com.oop.service.ContactUsServiceImpl;
import com.oop.service.IContactUsService;

/**
 * Servlet implementation class AddContactUsServlet
 */
@WebServlet("/AddContactUsServlet")
public class AddContactUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddContactUsServlet() {
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

		ContactUs contactus = new ContactUs();

		contactus.setName(request.getParameter("name"));
		contactus.setEmail(request.getParameter("email"));
		contactus.setPhoneNumber(request.getParameter("phoneNumber"));
		contactus.setMessage(request.getParameter("message"));

		IContactUsService iContactUsService = new ContactUsServiceImpl();
		iContactUsService.addContactUs(contactus);

		request.setAttribute("contactus", contactus);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

}
