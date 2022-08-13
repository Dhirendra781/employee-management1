package com.employee.management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.management.dao.EmployeeDao;
import com.employee.management.model.Employee;
import com.employee.management.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
		private EmployeeDao employeeDao;
	
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeDao.save(employee);
	}

	@Override
	public Employee update(int employeeId) {
		Optional<Employee> optional = this.employeeDao.findById(employeeId);
		Employee employee = null;
		
		if(optional.isPresent()) {
			employee = optional.get();
		}
		
		else {
			throw new RuntimeException("Employee not found "+employeeId);
		}
		return employee;
	}

	@Override
	public void delete(int employeeId) {
		this.employeeDao.deleteById(employeeId);
	}

	@Override
	public List<Employee> employeeList() {
		return this.employeeDao.findAll();
	}
	
	
}
