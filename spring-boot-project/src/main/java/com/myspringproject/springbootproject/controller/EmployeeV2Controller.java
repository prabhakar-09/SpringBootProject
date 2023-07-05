package com.myspringproject.springbootproject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspringproject.springbootproject.model.Employee;

@RestController
@RequestMapping("/v2/employees")
// In this second version of API we won't get the Employee Id since its set on the service layer,
// here it will only return the details of employee which we enter on the API post method on postman 
public class EmployeeV2Controller {

	@PostMapping
	public Employee save(@RequestBody Employee employee) {
		return employee;
	}
}
