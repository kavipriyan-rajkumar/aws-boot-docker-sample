package com.aws.docker.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.aws.docker.model.Employee;

@Repository
public class EmployeeRepository implements IEmployeeRepository{

	private Map<Long,Employee> employeeMap = new ConcurrentHashMap<Long,Employee>();
	@PostConstruct
	public void initializeEmployee() {
		Long employeeId = Long.valueOf(1);
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName("Rajkumar");
		employeeMap.put(employeeId, employee);
	}
	
	
	
	@Override
	public List<Employee> getAllEmployees() {
		return new ArrayList<Employee>(employeeMap.values());
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		return employeeMap.get(employeeId);
	}

	@Override
	public List<Employee> addEmployee(Employee employee) {
		Long employeeId = Long.valueOf(employeeMap.size()+1);
		employee.setEmployeeId(employeeId);
		employeeMap.put(employeeId, employee);
		return new ArrayList<Employee>(employeeMap.values());
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		employeeMap.replace(employee.getEmployeeId(), employee);
		return employeeMap.get(employee.getEmployeeId());
	}

	@Override
	public List<Employee> deleteEmployee(Long employeeId) {
		employeeMap.remove(employeeId);
		return new ArrayList<Employee>(employeeMap.values());
	}

}
