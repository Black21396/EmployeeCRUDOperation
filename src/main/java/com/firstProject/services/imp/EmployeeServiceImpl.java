package com.firstProject.services.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import com.firstProject.exception.ResourceNotFoundException;
import com.firstProject.model.Employee;
import com.firstProject.repository.EmployeeRepository;
import com.firstProject.services.EmployeeService;

/*
 * Define the implementation of Employee services
 * here make dependency injection from "EmployeeRepository" to access 
   to our database und make our operation
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	public Employee saveEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long Id) {
		/*
		 * findById: method in JpaRepository to find specific element
		 * findById: return Optional<Entity> so we can use orElseThrow method
		 * orElseThrow: mehtod return the object (if it exists) or return
		                what we define in method (in or case return our NotFoundException)
		 */
		return employeeRepository.findById(Id).orElseThrow(()-> 
		       new ResourceNotFoundException("Employee", "Id", Id));
	}

	@Override
	public Employee updateEmployee(Employee newEmp, long id) {
		Employee existEmp = employeeRepository.findById(id)
				            .orElseThrow(()-> new ResourceNotFoundException
				            		                  ("Employee", "id", id));
		existEmp.setFirstName(newEmp.getFirstName());
		existEmp.setLastName(newEmp.getLastName());
		existEmp.setEmail(newEmp.getEmail());
		
		// Save in DB
		employeeRepository.save(existEmp);
		return existEmp;
		
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException
				   ("Employee", "id", id));
		employeeRepository.deleteById(id);
	}
}
