package com.lovetolearn.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lovetolearn.employeeservice.entity.Employee;
import com.lovetolearn.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("emp")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("save")
	public Employee saveEmployee(@RequestBody Employee employee) {

		return employeeService.saveEmployee(employee);
	}

	@DeleteMapping("delBy/{id}")
	public void deleteById(@PathVariable Integer id) {

		employeeService.deleteById(id);
	}

	@GetMapping("getBy/{id}")
	public Employee getEmployeeById(@PathVariable Integer id) {

		return employeeService.getEmployeeById(id);

	}

	@PutMapping("update")
	public Employee updateEmployee(@RequestBody Employee emp) {

		return employeeService.updateEmployee(emp);
	}

}
