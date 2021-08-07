package com.aws.docker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.docker.model.Employee;
import com.aws.docker.repository.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService{

	@Autowired
	private IEmployeeRepository employeeRepository;
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		return employeeRepository.getEmployeeById(employeeId);
	}

	@Override
	public List<Employee> addEmployee(Employee employee) {
		return employeeRepository.addEmployee(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.updateEmployee(employee);
	}

	@Override
	public List<Employee> deleteEmployee(Long employeeId) {
		return employeeRepository.deleteEmployee(employeeId);
	}

}
