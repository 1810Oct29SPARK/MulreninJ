package com.project1.dao;

import java.io.File;
import java.util.List;

import com.project1.beans.Employee;
import com.project1.beans.Reimbursement;

public interface ReimbursementDAO {
	public void addReimbursement(Reimbursement r);
	public void updateReimbursement(Reimbursement r, int managerId);
	public void deleteReimbursementById(int id);
	public List<Reimbursement> getAllReimbursements();
	public void uploadImage(Reimbursement r, File photo);
	public Reimbursement getReimbursementById(int id);
	public List<Reimbursement> getReimbursementsByEmpId(Employee e);
}
