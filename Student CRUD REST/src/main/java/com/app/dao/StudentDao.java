package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Student;

public interface StudentDao extends JpaRepository<Student, Long> {
	
	
	Optional<List<Student>> findAllByCourseTitle(String courseTitle);

	
	

	

}
