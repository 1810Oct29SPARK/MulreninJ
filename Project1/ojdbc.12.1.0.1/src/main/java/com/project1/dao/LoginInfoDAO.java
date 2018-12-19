package com.project1.dao;

import java.util.List;

import com.project1.beans.Employee;
import com.project1.beans.LoginInfo;

public interface LoginInfoDAO {
	public void addLoginInfo(int id, String username, String password);
	public void updateLoginInfo(int id, String username, String password);
	public void deleteLoginInfoByEmployeeId(int id);
	public LoginInfo getLoginInfoByEmployeeId(int id);
	public List<LoginInfo> getAllLogins();
	public int getEmployeeIdFromUsername(String username);
}
