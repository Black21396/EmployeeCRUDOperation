package com.firstProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstProject.model.Employee;

// this repository inherits JpaRepository, now we can use this interface 
// to deal with database (add, delete, update) data in DB
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
