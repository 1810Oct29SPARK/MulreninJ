package com.project1.util;

import java.util.ArrayList;
import java.util.List;

import com.project1.beans.Employee;
import com.project1.beans.LoginInfo;
import com.project1.dao.EmployeeDAO;
import com.project1.dao.EmployeeDAOImpl;
import com.project1.dao.LoginInfoDAO;
import com.project1.dao.LoginInfoDAOImpl;
import com.project1.dao.ReimbursementDAOImpl;

public class ReimbursementUtil {
	EmployeeDAOImpl placeholder = new EmployeeDAOImpl();
	public boolean isManagerOf(Employee manager, Employee e) {
		if(manager.getReportsTo() == 1) {
			return true;
		}
		while(e.getReportsTo() != 1) {
			if(e.getReportsTo() == manager.getId()) {
				return true;
			}else {
				List<Employee> allEmp = placeholder.getAllEmployees();
				for(Employee e1 : allEmp) {
					 if(e1.getId()== e.getReportsTo()) {
						e = e1;
					}
				}
			}
		}
		return false;
	}
	
	public boolean isManager(Employee e) {
		if(e.isManager()) {
			return true;
		}
		return false;
	}
	
	public boolean isValidUser(String username, String password) {
		LoginInfoDAO login = new LoginInfoDAOImpl();
		List<LoginInfo> loginList = new ArrayList<LoginInfo>();
		loginList = login.getAllLogins();
		for(LoginInfo l:loginList) {
			if(l.getUsername().equals(username) && l.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean showManagerPage(String username, String password) {
		LoginInfoDAO login = new LoginInfoDAOImpl();
		EmployeeDAO e = new EmployeeDAOImpl();
		if(isValidUser(username, password)) {
			int empId = login.getEmployeeIdFromUsername(username);
			Employee emp = e.getEmployeeById(empId);
			if(emp.isManager()) {
				return true;
			}
		}
		return false;
	}
}
