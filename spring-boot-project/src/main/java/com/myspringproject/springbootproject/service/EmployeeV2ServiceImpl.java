package com.myspringproject.springbootproject.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspringproject.springbootproject.entity.EmployeeEntity;
import com.myspringproject.springbootproject.model.Employee;
import com.myspringproject.springbootproject.repository.EmployeeRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService{

	@Autowired
	private  EmployeeRepository employeeRepository;
	
	@Override
	public Employee save(Employee employee) {
		if(employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()) {
			employee.setEmployeeId(UUID.randomUUID().toString());
		}

		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, entity);
		employeeRepository.save(entity);
		
		return employee;
	}           

	@Override
	public List<Employee> getAllEmployees() {
//	Here first we need to get the list of employee entity then convert that to list of employees  
		List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
//		converting to the employee list
		List<Employee> employees = employeeEntityList
									.stream()
									.map(employeeEntity->{
										Employee employee = new Employee();
										BeanUtils.copyProperties(employeeEntity, employee);
										return employee;
									})
									.collect(Collectors.toList());
		return employees;
	}

	@Override
	public Employee getEmployeeById(String id) {
		EmployeeEntity employeEntity = employeeRepository.findById(id).get();
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeEntity, employee);
		return employee;
	}

	@Override
	public String deleteEmployeeById(String id) {

		employeeRepository.deleteById(id);
		return "Employee deleted with ID "+id;
	}

}
