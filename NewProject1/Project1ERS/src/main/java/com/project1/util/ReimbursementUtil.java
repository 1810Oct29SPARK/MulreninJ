package com.project1.util;

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
	
	public List<Employee> showManagersWhoResolved(List<Reimbursement> list){
		List<Employee> empList = new ArrayList<Employee>();
		EmployeeDAO e = new EmployeeDAOImpl();
		for(Reimbursement r:list) {
			if(r.getResolvedBy() != 0) {
				empList.add(e.getEmployeeById(r.getResolvedBy()));
			}
		}
		return empList;
	}
	
	public List<Employee> showManagers(List<Employee> list){
		List<Employee> empList = new ArrayList<Employee>();
		EmployeeDAO e = new EmployeeDAOImpl();
		for(Employee emp:list) {
				empList.add(e.getEmployeeById(emp.getReportsTo()));
		}
		return empList;
	}
	
	public List<Reimbursement> getAllPendingReimbursements(List<Employee> list){
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		ReimbursementDAO r = new ReimbursementDAOImpl();
		for(Employee e:list) {
			List<Reimbursement> empsReimbursements = r.getAllPendingReimbursements();
			for(Reimbursement reimburse:empsReimbursements) {
				if(e.getId() == reimburse.getEmployeeId()) {
					reimbursements.add(reimburse);
				}
			}
		}
		return reimbursements;
	}
	
	public List<Employee> getAllEmployeesFromPendingReimbursements(List<Reimbursement> list){
		List<Employee> e = new ArrayList<Employee>();
		EmployeeDAO emp = new EmployeeDAOImpl();
		for(Reimbursement r:list) {
			e.add(emp.getEmployeeById(r.getEmployeeId()));
		}
		return e;
	}
}
