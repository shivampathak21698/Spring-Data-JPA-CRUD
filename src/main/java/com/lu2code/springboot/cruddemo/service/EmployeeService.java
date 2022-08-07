package com.lu2code.springboot.cruddemo.service;

import java.util.List;

import com.lu2code.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public Employee getEmployee(int theID);
	
	public void save(Employee theEmployee);
	
	public void delete(int theID);
	
}
