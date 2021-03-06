package com.project1.main;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project1.beans.Employee;
import com.project1.beans.LoginInfo;
import com.project1.beans.Reimbursement;
import com.project1.dao.EmployeeDAO;
import com.project1.dao.EmployeeDAOImpl;
import com.project1.dao.LoginInfoDAO;
import com.project1.dao.LoginInfoDAOImpl;
import com.project1.dao.ReimbursementDAO;
import com.project1.dao.ReimbursementDAOImpl;
import com.project1.service.AuthenticationService;
import com.project1.util.ConnectionUtil;
import com.project1.util.ReimbursementUtil;

public class Driver {
	public static void main(String[] args) {
		init();
		EmployeeDAO e = new EmployeeDAOImpl();
		LoginInfoDAO login = new LoginInfoDAOImpl();
		ReimbursementDAO reimburse = new ReimbursementDAOImpl();
		List<LoginInfo> log = login.getAllLogins();
		AuthenticationService auth = new AuthenticationService();
		Integer i = null;
		ReimbursementUtil r = new ReimbursementUtil();
		List<Reimbursement> allReimbursements = reimburse.getAllReimbursements();
		List<Employee> approvedManagers = r.showManagersWhoResolved(allReimbursements);
		for(Employee employee:approvedManagers) {
			System.out.println(employee);
		}
		//List<Employee> allEmps = e.getAllManagedEmployees(auth.isValidUser("ICREATEDMICROSOFT", "PASSWORD"));
		/*for(LoginInfo l:log) {
			System.out.println(l);
		}*/
		//System.out.println(login.getEmployeeIdFromUsername("ICREATEDMICROSOFT"));
		/*for(Employee employ:allEmps) {
			System.out.println(employ);
		}*/
		/*List<Employee> emp = e.getAllEmployees();
		for(Employee employ:emp) {
			System.out.println(employ);
		}*/
		//System.out.println(e.getEmployeeById(1));
		//System.out.println(r.isValidUser("ICREATEDMICROSOFT", "PASSWORD"));
		//e.addEmployee("Edward", "Scissorshands", "Cutter", "787-565-3434", 40, 1, "5 Drury Lane", 75757, false);
		//e.deleteEmployee(22);
		//login.updateLoginInfo(20,"Myusername", "PASSWORD");
	}
	static void init(){
		try {
			Connection con = ConnectionUtil.getConnection("connection.properties");
			System.out.println(con);
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}