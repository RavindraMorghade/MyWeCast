package com.wecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wecast.request.Employee;
import com.wecast.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/userRegister")
	public  ResponseEntity<String> registerUser(Employee employee) {
		Employee e = employeeService.registerUser(employee);
		return ResponseEntity.ok().body("User registered successfully"); 
	}
	
	
}
