package com.wecast.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecast.repo.EmployeeRepository;
import com.wecast.request.Employee;
import com.wecast.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee registerUser(Employee employee) {
		Employee e = employeeRepository.save(employee);
		return e;
	}

}
