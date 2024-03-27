package com.app.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.pojos.Course;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
class CourseTest {
	
	@Autowired
	private CourseDao crc_Dao;

	@Test
	void testSaveCource() {
		//String cource_title, String start_date, String end_date, int fees, int min_score
		List<Course> c=List.of(new Course("PG-DAC","2023-9-8","2024-02-22",115000,400),
				new Course("PG-DBDA","2023-09-08","2024-02-22",125000,500));
		
		List<Course> c2=crc_Dao.saveAll(c);
		assertEquals(2, c2.size());
	 
		
		
		
	}

}
