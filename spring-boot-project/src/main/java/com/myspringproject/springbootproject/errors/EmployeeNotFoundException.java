package com.myspringproject.springbootproject.errors;

public class EmployeeNotFoundException extends RuntimeException{

	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
