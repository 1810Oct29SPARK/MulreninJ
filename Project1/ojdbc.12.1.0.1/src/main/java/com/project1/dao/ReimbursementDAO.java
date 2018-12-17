package com.project1.dao;

import java.util.List;

import com.project1.beans.Employee;
import com.project1.beans.Reimbursement;

public interface ReimbursementDAO {
	public void addReimbursement(Employee e, Reimbursement r);
	public void updateReimbursement(Reimbursement r, int managerId);
	public void deleteReimbursementById(int id);
	public List<Reimbursement> getAllReimbursements();
}
