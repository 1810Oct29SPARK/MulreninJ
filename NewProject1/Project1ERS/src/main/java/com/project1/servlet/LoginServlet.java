package com.project1.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project1.beans.Employee;
import com.project1.beans.LoginInfo;
import com.project1.dao.EmployeeDAO;
import com.project1.dao.EmployeeDAOImpl;
import com.project1.service.AuthenticationService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	AuthenticationService authService = new AuthenticationService();

	//return Login Page for GET request
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("LoginPage.html").forward(req, resp);
	}
	
	//handle post request from form on login page
	//(or anywhere else)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("handling request...");
		//checks whether a session exists, otherwise creates a new one.
		//overloaded version takes a boolean create param, if false, it returns null.
		//if no session exists for the current request.
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		//attempting to authenticate the user,
		Employee u = authService.isValidUser(req.getParameter("username"),req.getParameter("password"));
		//set user information as session attributes
		if(u != null) {
			session.setAttribute("empId",u.getId());
			session.setAttribute("firstname",u.getFirstName());
			session.setAttribute("lastname",u.getLastName());
			session.setAttribute("title",u.getTitle());
			session.setAttribute("address",u.getAddress());
			session.setAttribute("phonenumber",u.getPhoneNumber());
			session.setAttribute("zipcode",u.getZipCode());
			session.setAttribute("ismanager", u.isManager());
			session.setAttribute("age", u.getAge());
			session.setAttribute("reportsto", u.getReportsTo());
			if(!u.isManager()) {
			resp.sendRedirect("employee_profile");
			}else {
				/*EmployeeDAO dao = new EmployeeDAOImpl();
				List<Employee> managedEmps = dao.getAllManagedEmployees(u);
				session.setAttribute("managedEmps", managedEmps);*/
				resp.sendRedirect("manager_profile");
			}
		}else {
			session.setAttribute("problem", "invalid credentials");
			///redirect to login page if authenitcation fails
			resp.sendRedirect("login");
		}
	}
}