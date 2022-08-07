package com.lu2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu2code.springboot.cruddemo.dao.EmployeeRepository;
import com.lu2code.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceHibernateService implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getEmployees() {
		
		List<Employee> theEmployee = employeeRepository.findAll();
		
		return theEmployee;
	}

	@Override
	public Employee getEmployee(int theID) { 
		
		Optional<Employee> result = employeeRepository.findById(theID);
		Employee theEmployee = null;
		
		if(result.isPresent())
		{
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("Not Found for this ID" + theID);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		employeeRepository.save(theEmployee);
		
	}

	@Override
	public void delete(int theID) {
		
		employeeRepository.deleteById(theID);
	}


}
