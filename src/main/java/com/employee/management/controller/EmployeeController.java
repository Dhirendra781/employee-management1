package com.employee.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.management.model.Employee;
import com.employee.management.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
		private EmployeeService employeeService;
	
	//Open employee form
	@GetMapping("/employee")
	public String employeeForm(Model model) {
		model.addAttribute("employee",new Employee());
		return "employee-form";
	}
	
	//Save Employee
	@PostMapping("/employee-save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee, BindingResult result) {
		this.employeeService.saveEmployee(employee);
		return "redirect:/employee-list";
	}
	
	//Employee List
	@GetMapping("/employee-list")
	public String employeeList(Model model) {
		model.addAttribute("employeeList", employeeService.employeeList());
		return "employee_list";
	}
	
	//update employee
	@GetMapping("/employee-update/{id}")
	public String updateEmployee(@PathVariable(value = "id") int id, Model model) {
		Employee employee = this.employeeService.update(id);
		model.addAttribute("employee1", employee);
		return "update-employee";
		
	}
	
	//Delete employee
	@GetMapping("/employee-delete/{id}")
	public String deleteEmployee(@PathVariable(value = "id") int id) {
		this.employeeService.delete(id);
		return "redirect:/employee-list";
	}

}
