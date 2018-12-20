package com.project1.service;

import com.project1.beans.Employee;
import com.project1.beans.LoginInfo;
import com.project1.dao.EmployeeDAO;
import com.project1.dao.EmployeeDAOImpl;
import com.project1.dao.LoginInfoDAO;
import com.project1.dao.LoginInfoDAOImpl;
import com.project1.util.ReimbursementUtil;

public class AuthenticationService {
	public AuthenticationService() {
	}
	
	public Employee isValidUser(String username, String password) {
		Employee u = null;
		ReimbursementUtil r = new ReimbursementUtil();
		EmployeeDAO e = new EmployeeDAOImpl();
		LoginInfoDAO l = new LoginInfoDAOImpl();
		if(username != null &&  password != null) {
			if(r.isValidUser(username,password)) {
				u = e.getEmployeeById(l.getEmployeeIdFromUsername(username));
			}
		}
		return u;
	}
}