package com.aws.docker.repository;

import java.util.List;
import com.aws.docker.model.Employee;

public interface IEmployeeRepository {
	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(Long employeeId);
	public List<Employee> addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public List<Employee> deleteEmployee(Long employeeId);
}
