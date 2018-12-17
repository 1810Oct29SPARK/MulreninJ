package com.project1.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project1.beans.Employee;
import com.project1.beans.LoginInfo;
import com.project1.dao.EmployeeDAO;
import com.project1.dao.EmployeeDAOImpl;
import com.project1.dao.LoginInfoDAO;
import com.project1.dao.LoginInfoDAOImpl;
import com.project1.util.ConnectionUtil;

public class Driver {
	public static void main(String[] args) {
		init();
		EmployeeDAO e = new EmployeeDAOImpl();
		LoginInfoDAO login = new LoginInfoDAOImpl();
		List<LoginInfo> log = login.getAllLogins();
		for(LoginInfo l:log) {
			System.out.println(l);
		}
		/*List<Employee> emp = e.getAllEmployees();
		for(Employee employ:emp) {
			System.out.println(employ);
		}*/
		//System.out.println(e.getEmployeeById(1));
		//e.addEmployee("Edward", "Scissorshands", "Cutter", "787-565-3434", 40, 1, "5 Drury Lane", 75757, false);
		//e.deleteEmployee(22);
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
