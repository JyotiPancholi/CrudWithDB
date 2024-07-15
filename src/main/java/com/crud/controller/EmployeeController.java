package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Employee;
import com.crud.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAll() {
		return ResponseEntity.ok(service.getAllEmployee());
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		Employee employee = service.getEmployeeById(id); 
		return ResponseEntity.ok(employee);
	}
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployees(@RequestBody Employee employee) {
		Employee emp = service.addEmployees(employee);
		return ResponseEntity.ok(emp);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id ,@ RequestBody Employee emp) {
		Employee employee =  service.updateEmployee(id, emp);
		 if (employee != null) {
	            return ResponseEntity.ok(employee);
	        }
	        return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}