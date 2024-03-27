package com.app.service;

import java.util.List;

import com.app.dto.CreateNewCourceDto;
import com.app.pojos.Course;
import com.app.pojos.Student;

public interface CourseService {

	List<Course> allCourseDetails();


	Course updateCourse(Course c);

	String deleteCourse(Long c_id);

	Course listAllCourseById(Long cou_id);

	String UpdateCourseFee(Long id, int fee);

	String LunchNewCourse(CreateNewCourceDto course);
	

}
