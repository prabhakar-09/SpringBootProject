package com.myspringproject.springbootproject.service;

import java.util.List;

import com.myspringproject.springbootproject.model.Employee;

public interface EmployeeService {

	Employee save(Employee employee);

	List<Employee> getAllEmployees();

	Employee getEmployeeById(String id);

	String deleteEmployeeById(String id);
	
}
