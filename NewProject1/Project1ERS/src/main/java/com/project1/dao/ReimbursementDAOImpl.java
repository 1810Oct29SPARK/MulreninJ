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
import com.project1.beans.Reimbursement;
import com.project1.util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO{
	public String filename = "connection.properties";
	public void addReimbursement(Employee e, Reimbursement r) {
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "INSERT REIMBURSEMENT(EMPLOYEE_ID,REIMBURSE_NAME,REIMBURSE_AMOUNT,REIMBURSE_STATUS,RESOLVED_BY) " + 
					"INTO REIMBURSEMENTS " + 
					"VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, e.getId());
			pstmt.setString(2, r.getReimburseName());
			pstmt.setDouble(3, r.getAmount());
			pstmt.setString(4, r.getReimburseStatus());
			pstmt.setInt(5, r.getResolvedBy());
			pstmt.executeUpdate();
		} catch (SQLException f) {
			f.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void updateReimbursement(Reimbursement r, int managerId) {
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "UPDATE REIMBURSEMENTS " + 
					"SET RESOLVED_BY = ? " + 
					"WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, managerId);
			pstmt.setInt(2, r.getReimburseId());
			pstmt.executeUpdate();
		} catch (SQLException f) {
			f.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void deleteReimbursementById(int id) {
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "DELETE * FROM REIMBURSEMENTS" + 
						"WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public List<Reimbursement> getAllReimbursements(){
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT REIMBURSEMENT_ID, EMPLOYEE_ID, REIMBURSE_NAME, REIMBURSE_AMOUNT, REIMBURSE_STATUS, RESOLVED_BY " + 
						"FROM REIMBURSEMENTS";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reimburseId = rs.getInt("REIMBURSEMENT_ID");
				int employeeId = rs.getInt("EMPLOYEE_ID");
				String reimburseName = rs.getString("REIMBURSE_NAME");
				double amount = rs.getDouble("REIMBURSE_AMOUNT");
				String status = rs.getString("REIMBURSE_STATUS");
				int resolvedBy = rs.getInt("RESOLVED_BY");
				reimbursements.add(new Reimbursement(reimburseId, employeeId, reimburseName,amount, status, resolvedBy));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	return reimbursements;
	}
}