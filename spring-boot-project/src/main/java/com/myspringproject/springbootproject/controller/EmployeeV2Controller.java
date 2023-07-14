package com.myspringproject.springbootproject.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspringproject.springbootproject.entity.EmployeeEntity;
import com.myspringproject.springbootproject.model.Employee;
import com.myspringproject.springbootproject.service.EmployeeService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@RestController
@RequestMapping("/v2/employees")
// In this second version of API we won't get the Employee Id since its set on the service layer,
// here it will only return the details of employee which we enter on the API post method on postman 
public class EmployeeV2Controller {

	@Qualifier("employeeV2ServiceImpl")
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public Employee save(@RequestBody Employee employee) {
		if(employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()) {
			employee.setEmployeeId(UUID.randomUUID().toString());
		}
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, entity);
				
		employeeService.save(employee);
		
		return employee;
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable String id) {
		return employeeService.getEmployeeById(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable String id) {
		return employeeService.deleteEmployeeById(id);
	}
}
