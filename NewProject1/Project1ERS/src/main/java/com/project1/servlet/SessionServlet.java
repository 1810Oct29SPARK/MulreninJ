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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project1.beans.Employee;
import com.project1.beans.Reimbursement;
import com.project1.dao.EmployeeDAO;
import com.project1.dao.EmployeeDAOImpl;
import com.project1.dao.ReimbursementDAO;
import com.project1.dao.ReimbursementDAOImpl;
import com.project1.util.ReimbursementUtil;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

	private ObjectMapper om = new ObjectMapper();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// grab current session, if it exists
		response.setContentType("application/json");
		HttpSession session = request.getSession(false);
		if (session != null) {
			try {
				int empid = Integer.parseInt(session.getAttribute("empId").toString());
				String title = session.getAttribute("title").toString();
				String firstname = session.getAttribute("firstname").toString();
				String lastname = session.getAttribute("lastname").toString();
				boolean ismanager = Boolean.parseBoolean(session.getAttribute("ismanager").toString());
				String phonenumber = session.getAttribute("phonenumber").toString();
				String address = session.getAttribute("address").toString();
				int zipcode = Integer.parseInt(session.getAttribute("zipcode").toString());
				int reportsto = Integer.parseInt(session.getAttribute("reportsto").toString());
				int age = Integer.parseInt(session.getAttribute("age").toString());
				Employee e = new Employee(empid, firstname, lastname, title, phonenumber, age, reportsto, address,
						zipcode, ismanager);
				//make a call to a different endpoint to get managed employees by manager id.. do this elsewhere
				EmployeeDAO dao = new EmployeeDAOImpl();
				ReimbursementUtil util = new ReimbursementUtil();
				ReimbursementDAO reimburse = new ReimbursementDAOImpl();
				List<Employee> managedEmps = dao.getAllManagedEmployees(e);
				List<Reimbursement> list = reimburse.getReimbursementsByEmpId(e);
				List<Reimbursement> allReimbursements = reimburse.getAllResolvedReimbursements();
				List<Employee> approvedManagers = util.showManagersWhoResolved(allReimbursements);
				List<Employee> allEmps = dao.getAllEmployees();
				List<Employee> allManagers = util.showManagers(allEmps);
				List<Reimbursement> pendingList = util.getAllPendingReimbursements(managedEmps);
				List<Employee> pendingEmployees = util.getAllEmployeesFromPendingReimbursements(pendingList);
				response.getWriter().write("{\"User\": " + om.writeValueAsString(e) + ", \"Employees\": " + om.writeValueAsString(managedEmps) + ", \"Reimbursements\": "
				+ om.writeValueAsString(list) + ", \"AllReimbursements\": " + om.writeValueAsString(allReimbursements) + ", \"AllReimbursementManagers\": " + om.writeValueAsString(approvedManagers) + 
				", \"AllEmployees\": " + om.writeValueAsString(allEmps) + ", \"AllManagers\": " + om.writeValueAsString(allManagers) + 
				", \"PendingReimbursements\": " + om.writeValueAsString(pendingList) + ", \"PendingEmployees\": " + om.writeValueAsString(pendingEmployees) + "}");
			} catch (Exception e) {
				response.getWriter().write("{\"session\":null}");
			}
		} else {
			response.getWriter().write("{\"session\":null}");
		}
	}
}