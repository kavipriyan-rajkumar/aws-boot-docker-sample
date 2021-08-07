package com.aws.docker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.docker.model.Employee;
import com.aws.docker.service.IEmployeeService;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EmployeeRestController {
	
	@Autowired
	private IEmployeeService employeeService;
	//Fetches employee by id
	@GetMapping(value= "/employees", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> responseEmployeeList = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(responseEmployeeList, HttpStatus.OK);
	}
	
	//Fetches employee by id
	@GetMapping(value= "/employee/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId){
		Employee employee = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	//Creates a new employee
	@PostMapping(value= "/employee", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Employee>> addEmployee(@RequestBody Employee employee){
		List<Employee> responseEmployeeList = employeeService.addEmployee(employee);
		return new ResponseEntity<List<Employee>>(responseEmployeeList, HttpStatus.CREATED);
	}
	
	//Updates employee
	@PutMapping(value= "/employee", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		employee = employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	//Deletes employee by id
	@DeleteMapping(value= "/employee/{id}", produces= { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Employee>> deleteEmployee(@PathVariable("id") Long employeeId){
		List<Employee> responseEmployeeList = employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<List<Employee>>(responseEmployeeList, HttpStatus.OK);
	}
}
