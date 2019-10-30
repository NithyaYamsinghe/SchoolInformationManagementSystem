package com.oop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oop.model.Admin;
import com.oop.service.AdminServiceImpl;

/**
 * Servlet implementation class LoginAdminServlet
 */
@WebServlet("/LoginAdminServlet")
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAdminServlet() {
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

		Admin admin = new Admin();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		if (AdminServiceImpl.validateLogin(userName, password)) {

			String[] data = { "s1", "s2", "s3", "s4" };

			data = AdminServiceImpl.getname(userName);
			// session
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			session.setAttribute("password", password);
			session.setAttribute("name", data[0]);
			session.setAttribute("email", data[1]);
			session.setAttribute("pass", data[2]);
			session.setAttribute("confirmPassword", data[3]);

			request.setAttribute("message", admin.getUserName());
			request.getRequestDispatcher("homeCategory.jsp").forward(request, response);

		}

		else {

			request.setAttribute("message", "Data Not Found Click on register!!!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
