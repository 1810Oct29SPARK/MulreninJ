package com.project1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project1.beans.Employee;
import com.project1.dao.EmployeeDAO;
import com.project1.dao.EmployeeDAOImpl;

@WebServlet("/infoChange")
public class InfoChangeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("EmployeePage.html").forward(req, resp);
	}
	
	//handle post request from form on login page
	//(or anywhere else)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		EmployeeDAO e = new EmployeeDAOImpl();
		Employee employee = new Employee();
		int id = e.getEmployeeIdFromFirstAndLastName(req.getParameter("firstnameinput"), req.getParameter("lastnameinput"));
		employee = e.getEmployeeById(id);
		Employee changedEmployee = new Employee(employee.getId(), req.getParameter("firstnameinput"), req.getParameter("lastnameinput"), req.getParameter("titleinput"), req.getParameter("phonenumberinput"),employee.getAge(),employee.getReportsTo(), req.getParameter("addressinput"),employee.getZipCode(), employee.isManager());
		e.updateEmployee(changedEmployee, employee.getId());
		resp.sendRedirect("EmployeePage.html");
	}
}
