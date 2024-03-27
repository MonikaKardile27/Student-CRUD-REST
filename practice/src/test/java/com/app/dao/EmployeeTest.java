package com.app.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.pojos.Employee;


@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
class EmployeeTest {
	
	@Autowired
	private EmployeeDao eDao;

	@Test
	void testSaveEmp() {
		
		List<Employee> emp=List.of(
				new Employee("a1", "b1", "a1@gmail.com", LocalDate.parse("2020-10-20"), 34567, "Pune", "RnD"),
				new Employee("a2", "b2", "a2@gmail.com", LocalDate.parse("2020-11-20"), 44567, "Pune", "RnD"));
		List<Employee> emp1=eDao.saveAll(emp);
		assertEquals(2, emp1.size());
		
	}

}
