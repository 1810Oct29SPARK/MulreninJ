package com.project1.dao;

import java.util.List;

import com.project1.beans.Employee;

public interface EmployeeDAO {

	public Employee getEmployeeById(int id);
	public List<Employee> getAllEmployees();
	public void addEmployee(String firstName, String lastName, String title, String phoneNumber, int age, int reportsTo, String address, int zipCode, boolean isManager);
	public void deleteEmployee(int id);
	public boolean isManagerOf(Employee manager, Employee emp);
	public void updateEmployee(Employee e, int employeeId);
	
}
