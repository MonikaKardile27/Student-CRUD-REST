package com.app.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.pojos.Course;
import com.app.pojos.Student;


@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
class StudentTest {
	
	@Autowired
	private StudentDao sDao;
	
	@Autowired
	private CourseDao cDao;

	@Test
	void testSaveStudent() {
		
		Course c=cDao.findById(1L).orElseThrow();
		//String first_name, String last_name, String email, int score
		List<Student> stud=List.of(new Student("Monika","Kardile","mnk@gmail.com",500),
				new Student("Hindavi","Dhole","hnd@gmail.com",700));
		stud.forEach(s->c.addStudent(s));

	}

}
