package com.lu2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lu2code.springboot.cruddemo.entity.Employee;
import com.lu2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;


	@GetMapping("/employee")
	public List<Employee> showEmployees()
	{
		List<Employee> employee = employeeService.getEmployees();
		return employee;
	}
	
	@GetMapping("/employee/{theID}")
	public Employee showEmployee(@PathVariable int theID)
	{
		Employee theEmployee = employeeService.getEmployee(theID);
		
		if(theEmployee==null) {
			throw new RuntimeException("Not found");
		}
		
			
		return theEmployee;
	}
	
	@PostMapping("/employee")
	public void addEmployee(@RequestBody Employee theEmployee)
	{
		theEmployee.setId(0);
		employeeService.save(theEmployee);
	}
	
	@DeleteMapping("/employee/{theID}")
	public void deleteEmployee(@PathVariable int theID)
	{
		employeeService.delete(theID);
	}
	
	@PutMapping("/employee")
	public Employee employeeUpdate(@RequestBody Employee theEmployee)
	{
		employeeService.save(theEmployee);
		
		return theEmployee;
	}

}
