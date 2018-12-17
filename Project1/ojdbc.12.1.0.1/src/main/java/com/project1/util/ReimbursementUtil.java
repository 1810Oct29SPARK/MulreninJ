package com.project1.util;

import java.util.List;

import com.project1.beans.Employee;
import com.project1.dao.EmployeeDAOImpl;
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
	
}
