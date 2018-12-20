package com.project1.beans;

public class Employee {
	public Employee() {
		super();
	}
	public Employee(int id, String firstName, String lastName, String title, String phoneNumber, int age, int reportsTo,
			String address, int zipCode, boolean isManager) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.reportsTo = reportsTo;
		this.address = address;
		this.zipCode = zipCode;
		this.isManager = isManager;
	}
	private int id;
	private String firstName;
	private String lastName;
	private String title;
	private String phoneNumber;
	private int age;
	private int reportsTo;
	private String address;
	private int zipCode;
	private boolean isManager;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getReportsTo() {
		return reportsTo;
	}
	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title
				+ ", phoneNumber=" + phoneNumber + ", age=" + age + ", reportsTo=" + reportsTo + ", address=" + address
				+ ", zipCode=" + zipCode + ", isManager=" + isManager + "]";
	}
}