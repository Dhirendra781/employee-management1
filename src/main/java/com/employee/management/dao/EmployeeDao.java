package com.employee.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.management.model.Employee;

public interface EmployeeDao  extends JpaRepository<Employee, Integer>{

}
