package com.myspringproject.springbootproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Employee {

	private String employeeId;
	private String firstName;
	private String lastName;
	private String emailId;
//	JsonIgnore used in Java frameworks like Jackson to exclude a specific property from being
//	serialized or deserialized. When applied to a field or getter method, it indicates that the 
//	annotated property should be ignored during JSON serialization and deserialization processes.
//	This annotation is helpful when certain fields should not be included in the JSON representation of an object,
//	such as sensitive information or internal implementation details.
	@JsonIgnore 
	private String department;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
}
