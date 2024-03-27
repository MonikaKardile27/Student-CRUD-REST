package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Course;

public interface CourseDao extends JpaRepository<Course, Long>{
	
	Course findAllById(Long cou_id);
	
	Optional<Course> findByTitle(String courseTitle );
	

	
	


}
