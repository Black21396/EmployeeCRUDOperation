package com.firstProject.services;

import java.util.List;

import com.firstProject.model.Employee;

/*
 * define the operation for employee service
 */
public interface EmployeeService {

	public Employee saveEmployee(Employee emp); 
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(long Id);
	
	public Employee updateEmployee(Employee emp, long id);
	
	public void deleteEmployee(long id);
}
