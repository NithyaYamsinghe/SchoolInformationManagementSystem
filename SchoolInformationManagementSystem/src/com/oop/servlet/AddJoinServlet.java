package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Join;
import com.oop.service.JoinServiceImpl;
import com.oop.service.IJoinService;

/**
 * Servlet implementation class AddJoinServlet
 */
@WebServlet("/AddJoinServlet")
public class AddJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddJoinServlet() {
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

		Join join = new Join();

		join.setName(request.getParameter("name"));
		join.setBirthDate(request.getParameter("birthDate"));
		join.setGender(request.getParameter("gender"));
		join.setEmail(request.getParameter("email"));
		join.setPhoneNumber(request.getParameter("phoneNumber"));
		join.setAddress(request.getParameter("address"));
		join.setCity(request.getParameter("city"));

		IJoinService iJoinService = new JoinServiceImpl();
		iJoinService.addJoin(join);

		request.setAttribute("join", join);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);

	}

}
