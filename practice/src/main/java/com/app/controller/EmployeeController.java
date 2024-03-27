package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping
	public List<Employee> listAllEmployee(){
		return empService.listAllEmployee();
		
	}
	
	@PostMapping
	public Employee addNewEmployee(@RequestBody Employee e)
	{
		return empService.addNewEmployee(e);
		
	}
	
	@PutMapping
	public Employee updateEmployee(@RequestBody Employee e)
	{
		return empService.updateEmployee(e);
		
	}
	
	@DeleteMapping("/{Id}")
	public String deleteEmpDetails(@PathVariable Long Id)
	{
		return empService.deleteEmpDetails(Id);
		
	}
	
	@GetMapping("/{email}")
	public Employee findByEmail(@PathVariable String email)
	{
		return empService.findByEmail(email);
	}

}
