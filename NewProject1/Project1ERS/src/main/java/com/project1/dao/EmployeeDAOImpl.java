package com.project1.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project1.beans.Employee;
import com.project1.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO{
	public String filename = "connection.properties";
	public Employee getEmployeeById(int id) {
		Employee emp = new Employee();
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT * FROM EMPLOYEES " + 
						"WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String title = rs.getString("JOB_TITLE");
				String phoneNumber = rs.getString("PHONE_NUMBER");
				int age = rs.getInt("AGE");
				int reportsTo = rs.getInt("REPORTS_TO");
				String address = rs.getString("ADDRESS");
				int zipCode = rs.getInt("ZIPCODE");
				boolean isManager = rs.getBoolean("IS_MANAGER");
				emp = (new Employee(employeeId,firstName,lastName,title,phoneNumber,age,reportsTo,address,zipCode,isManager));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return emp;
	}
	public List<Employee> getAllEmployees(){
		List<Employee> emp = new ArrayList<Employee>();
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT * FROM EMPLOYEES";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String title = rs.getString("JOB_TITLE");
				String phoneNumber = rs.getString("PHONE_NUMBER");
				int age = rs.getInt("AGE");
				int reportsTo = rs.getInt("REPORTS_TO");
				String address = rs.getString("ADDRESS");
				int zipCode = rs.getInt("ZIPCODE");
				boolean isManager = rs.getBoolean("IS_MANAGER");
				emp.add(new Employee(employeeId,firstName,lastName,title,phoneNumber,age,reportsTo,address,zipCode,isManager));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return emp;
	}
	public void addEmployee(String firstName, String lastName, String title, String phoneNumber, int age, int reportsTo, String address, int zipCode, boolean isManager) {
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "INSERT INTO EMPLOYEES(FIRST_NAME,LAST_NAME,JOB_TITLE,PHONE_NUMBER,AGE,REPORTS_TO,ADDRESS,ZIPCODE,IS_MANAGER) " + 
						"VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, title);
			pstmt.setString(4, phoneNumber);
			pstmt.setInt(5, age);
			pstmt.setInt(6, reportsTo);
			pstmt.setString(7, address);
			pstmt.setInt(8, zipCode);
			pstmt.setBoolean(9, isManager);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public void deleteEmployee(int id) {
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "DELETE FROM EMPLOYEES " + 
						"WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public boolean isManagerOf(Employee manager, Employee emp) {
		return false;
	}	
	
	public void updateEmployee(Employee e, int employeeId) {
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "UPDATE EMPLOYEES " + 
						"SET FIRST_NAME = ?, LAST_NAME = ?, JOB-TITLE = ?, PHONE_NUMBER = ?, AGE = ?, REPORTS_TO = ?, ADDRESS = ?, ZIPCODE = ?, IS_MANAGER = ? " + 
						"WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, e.getFirstName());
			pstmt.setString(2, e.getLastName());
			pstmt.setString(3, e.getTitle());
			pstmt.setString(4, e.getPhoneNumber());
			pstmt.setInt(5, e.getAge());
			pstmt.setInt(6, e.getReportsTo());
			pstmt.setString(7, e.getAddress());
			pstmt.setInt(8, e.getZipCode());
			pstmt.setBoolean(9, e.isManager());
			pstmt.executeUpdate();
		} catch (SQLException e2) {
			e2.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public List<Employee> getAllManagedEmployees(Employee manager){
		List<Employee> managedEmps = new ArrayList<Employee>();
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT * FROM EMPLOYEES " + 
						"WHERE REPORTS_TO = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, manager.getId());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String title = rs.getString("JOB_TITLE");
				String phoneNumber = rs.getString("PHONE_NUMBER");
				int age = rs.getInt("AGE");
				int reportsTo = rs.getInt("REPORTS_TO");
				String address = rs.getString("ADDRESS");
				int zipCode = rs.getInt("ZIPCODE");
				boolean isManager = rs.getBoolean("IS_MANAGER");
				managedEmps.add(new Employee(employeeId,firstName,lastName,title,phoneNumber,age,reportsTo,address,zipCode,isManager));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return managedEmps;
	}
}
