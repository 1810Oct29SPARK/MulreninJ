package com.project1.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/employee_profile")
public class EmployeeProfileServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//check whether a session exists for the incoming request
		HttpSession session = request.getSession(false);
		System.out.println(session);
		if(session != null && session.getAttribute("firstname") != null) {
			request.getRequestDispatcher("EmployeePage.html").forward(request,response);
		}else {
			response.sendRedirect("login");
		}
	}
}
