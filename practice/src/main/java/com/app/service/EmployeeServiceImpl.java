package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.EmployeeDao;
import com.app.pojos.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao empDao;

	@Override
	public List<Employee> listAllEmployee() {
		// TODO Auto-generated method stub
		return empDao.findAll();
	}

	@Override
	public Employee addNewEmployee(Employee e) {
		// TODO Auto-generated method stub
		return empDao.save(e);
	}

	@Override
	public Employee updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		return empDao.save(e);
	}

	@Override
	public String deleteEmpDetails(Long id) {
		if(empDao.existsById(id))
		{
			empDao.deleteById(id);
			return "Deleted";
		}
		return "No id found";
	}

	@Override
	public Employee findByEmail(String email) {
		return empDao.findByEmail(email).
		orElseThrow(()->new ResourceNotFoundException("no email present"+email));
	}
	

}
