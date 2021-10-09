package com.wecast.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecast.request.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
