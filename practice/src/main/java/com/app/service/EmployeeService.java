package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface EmployeeService {

	List<Employee> listAllEmployee();

	Employee addNewEmployee(Employee e);

	Employee updateEmployee(Employee e);

	String deleteEmpDetails(Long id);

	Employee findByEmail(String email);

}
