package com.lovetolearn.restclientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lovetolearn.restclientservice.dto.Employee;
import com.lovetolearn.restclientservice.service.EmployeeRestClientService;



@RestController
public class EmployeeTestController {

	@Autowired
	EmployeeRestClientService clientService;
	
	@PostMapping("save")
	public Employee saveEmployee(@RequestBody Employee employee) {

		return clientService.saveEmployee(employee);
	}

	@DeleteMapping("delBy/{id}")
	public void deleteById(@PathVariable Integer id) {

		clientService.deleteById(id);
	}

	@GetMapping("getBy/{id}")
	public Employee getEmployeeById(@PathVariable Integer id) {

		return clientService.getEmployeeById(id);

	}

	@PutMapping("update")
	public Employee updateEmployee(@RequestBody Employee emp) {

		return clientService.updateEmployee(emp);
	}
}
