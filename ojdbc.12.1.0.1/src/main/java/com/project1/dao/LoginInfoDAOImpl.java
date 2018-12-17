package com.project1.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project1.beans.Employee;
import com.project1.beans.LoginInfo;
import com.project1.util.ConnectionUtil;

public class LoginInfoDAOImpl implements LoginInfoDAO{
	public String filename = "connection.properties";
	public void addLoginInfo(int id, String username, String password) {
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "INSERT LOGIN_INFO(EMPLOYEE_ID,USERNAME,USER_PASSWORD) " + 
					"INTO LOGIN_INFO " + 
					"VALUES(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, username);
			pstmt.setString(3, password);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void updateLoginInfo(int id, String username, String password) {
		
	}
	
	public void deleteLoginInfoByEmployeeId(int id) {
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "DELETE * FROM LOGIN_INFO " + 
						"WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public List<LoginInfo> getAllLogins(){
			List<LoginInfo> login = new ArrayList<LoginInfo>();
			try(Connection con = ConnectionUtil.getConnection(filename)){
				String sql = "SELECT * FROM LOGIN_INFO";
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					int loginId = rs.getInt("ID");
					int employeeId = rs.getInt("EMPLOYEE_ID");
					String username = rs.getString("USERNAME");
					String password = rs.getString("USER_PASSWORD");
					login.add(new LoginInfo(loginId,employeeId,username,password));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		return login;
	}
	
	public LoginInfo getLoginInfoByEmployeeId(int id) {
		LoginInfo usersLogin = new LoginInfo();
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT * FROM LOGIN_INFO " + 
						"WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int loginId = rs.getInt("ID");
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String username = rs.getString("USERNAME");
				String password = rs.getString("USER_PASSWORD");
				usersLogin = new LoginInfo(loginId,employeeId,username,password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return usersLogin;
	}
}
