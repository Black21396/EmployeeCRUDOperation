package com.firstProject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstProject.model.Employee;
import com.firstProject.services.EmployeeService;

@RestController
// define the url to our application (http://localhost:8008/api/employees)
@RequestMapping("/api/employees")

/*
 * This Controller(handles the HTTP requests) contain the Rest request (add,
 * delete, update, get)
 */
public class EmployeeController {

	// define object to make our business logic (get, update, delete, etc..)
	// this is inject dependency  
	private EmployeeService employeeService;

	
	public EmployeeController(EmployeeService emp) {
		super();
		this.employeeService = emp;
	}

	@PostMapping
	// http://localhost:8080/api/employees
	// add new Employee to DB
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(emp), HttpStatus.CREATED);
	}

	@GetMapping
	// http://localhost:8080/api/employees
	// get all Employees(as JSON) from DB
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("{id}")
	// http://localhost:8080/api/employees/1
	// get Specific Employee(according id) from DB
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}

	@PutMapping("{id}")
	// http://localhost:8080/api/employees
	// edit existing Employee and save the changes in DB
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	// http://localhost:8080/api/employees/1
	// delete an Employee from DB
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully!", HttpStatus.OK);
	}
}
