package com.employee.management.service;

import java.util.List;

import com.employee.management.model.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);
	
	public Employee update(int employeeId);
	
	public void delete(int employeeId);
	
	public List<Employee> employeeList();
	
	
}
