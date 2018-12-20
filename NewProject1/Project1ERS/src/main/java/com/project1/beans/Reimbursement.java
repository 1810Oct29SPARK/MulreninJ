package com.project1.beans;

public class Reimbursement {
	public Reimbursement(int reimburseId, int employeeId, String reimburseName, double amount, String reimburseStatus,
			int resolvedBy) {
		super();
		this.reimburseId = reimburseId;
		this.employeeId = employeeId;
		this.reimburseName = reimburseName;
		this.amount = amount;
		this.reimburseStatus = reimburseStatus;
		this.resolvedBy = resolvedBy;
	}
	public Reimbursement() {
		
	}
	private int reimburseId;
	private int employeeId;
	private String reimburseName;
	private double amount;
	private String reimburseStatus;
	private int resolvedBy;
	public int getReimburseId() {
		return reimburseId;
	}
	public void setReimburseId(int reimburseId) {
		this.reimburseId = reimburseId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getReimburseName() {
		return reimburseName;
	}
	public void setReimburseName(String reimburseName) {
		this.reimburseName = reimburseName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getReimburseStatus() {
		return reimburseStatus;
	}
	public void setReimburseStatus(String reimburseStatus) {
		this.reimburseStatus = reimburseStatus;
	}
	public int getResolvedBy() {
		return resolvedBy;
	}
	public void setResolvedBy(int resolvedBy) {
		this.resolvedBy = resolvedBy;
	}
	@Override
	public String toString() {
		return "Reimbursement [reimburseId=" + reimburseId + ", employeeId=" + employeeId + ", reimburseName="
				+ reimburseName + ", amount=" + amount + ", reimburseStatus=" + reimburseStatus + ", resolvedBy="
				+ resolvedBy + "]";
	}
}