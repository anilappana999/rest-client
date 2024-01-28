package com.lovetolearn.restclientservice.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.lovetolearn.restclientservice.dto.Employee;

@Service
public class EmployeeRestClientService {

	private final RestClient restclient;

	public EmployeeRestClientService() {

		this.restclient = RestClient.builder().baseUrl("http://localhost:8080/emp").build();
	}

	public Employee saveEmployee(Employee employee) {

		return restclient.post().uri("/save").contentType(MediaType.APPLICATION_JSON).body(employee).retrieve().body(Employee.class);

	}

	public void deleteById(Integer id) {

		restclient.delete().uri("/delBy/{id}", id).retrieve().toBodilessEntity();

	}

	public Employee getEmployeeById(Integer id) {

		return restclient.get().uri("/getBy/{id}", id).retrieve().body(Employee.class);

	}

	public Employee updateEmployee(Employee emp) {

		return restclient.put().uri("/update").contentType(MediaType.APPLICATION_JSON).body(emp).retrieve()
				.body(Employee.class);

	}

}
