package com.project1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project1.beans.Reimbursement;
import com.project1.dao.EmployeeDAO;
import com.project1.dao.EmployeeDAOImpl;
import com.project1.dao.ReimbursementDAO;
import com.project1.dao.ReimbursementDAOImpl;

@WebServlet("/submittedReimbursementMan")
public class ManSubmittedReimbursementServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		EmployeeDAO e = new EmployeeDAOImpl();
		ReimbursementDAO reimburse = new ReimbursementDAOImpl();
		int id = e.getEmployeeIdFromFirstAndLastName(req.getParameter("firstnameinput"), req.getParameter("lastnameinput"));
		Reimbursement r = new Reimbursement(1,id, req.getParameter("description"), Double.parseDouble(req.getParameter("amount")),"pending",0);
		reimburse.addReimbursement(r);
		resp.sendRedirect("manager_profile");
	}
	
}