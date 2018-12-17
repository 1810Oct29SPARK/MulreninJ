package com.project1.beans;

public class LoginInfo {
	public LoginInfo(int loginId, int employeeId, String username, String password) {
		super();
		this.loginId = loginId;
		this.employeeId = employeeId;
		this.username = username;
		this.password = password;
	}
	public LoginInfo() {
		
	}
	private int loginId;
	private int employeeId;
	private String username;
	private String password;
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginInfo [loginId=" + loginId + ", employeeId=" + employeeId + ", username=" + username + ", password="
				+ password + "]";
	}
}
