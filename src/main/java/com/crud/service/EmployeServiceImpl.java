package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Employee;
import com.crud.repository.EmployeeRepo;

@Service
public class EmployeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo repo;
	
	@Override
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public Employee addEmployees(Employee emp) {
		return repo.save(emp);
	}

	@Override
	public Employee updateEmployee(int id, Employee emp) {
		Employee employee =  repo.findById(id).orElse(null);
		if (employee!=null) {
			employee.setName(emp.getName());
			employee.setEmail(emp.getEmail());
			employee.setAddress(emp.getAddress());
			return repo.save(employee);
		}
		return null;
	}

	@Override
	public void deleteEmployee(int id) {
		repo.deleteById(id);
	}
}
