package com.crud.service;

import java.util.List;

import com.crud.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployee();
	Employee getEmployeeById(int id);
	Employee addEmployees(Employee emp);
	Employee updateEmployee(int id ,Employee emp);
	void deleteEmployee(int id);
}
