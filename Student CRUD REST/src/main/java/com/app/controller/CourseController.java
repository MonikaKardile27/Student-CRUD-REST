package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.CreateNewCourceDto;
import com.app.pojos.Course;
import com.app.pojos.Student;
import com.app.service.CourseService;

@RestController
@RequestMapping("/cource")
public class CourseController {
	
	@Autowired
	private CourseService c_ser;
	@GetMapping
	public List<Course> allCourseDetails()
	{
		return c_ser.allCourseDetails();
	}
	
//	@PostMapping
//	public Course addCourse(@RequestBody Course c)
//	{
//		return c_ser.addCourse(c);
//	}
	
	@PostMapping
	public ResponseEntity<?> LunchNewCourse(@RequestBody CreateNewCourceDto course)
	{
		try {
			System.out.println("in lunch course");
			return new ResponseEntity<>(c_ser.LunchNewCourse(course),HttpStatus.OK);

		}catch(RuntimeException e) {
			return new ResponseEntity<>(new ApiResponse(e.getMessage()),HttpStatus.NOT_FOUND);
			
		}
	}
	
	@PutMapping("/{id}")
	public Course updateCourse(@RequestBody Course c)
	{
		return c_ser.updateCourse(c);
	}
	@DeleteMapping("/{c_id}")
	public String deleteCourse(@PathVariable Long c_id)
	{
		return c_ser.deleteCourse(c_id);
	}
	@GetMapping("/{cou_id}")
	public Course listAllCourseByName(@PathVariable Long cou_id)
	{
		return c_ser.listAllCourseById(cou_id);
		
	}

	@PutMapping("/{id}/fees/{fee}")
	public String UpdateCourseFee(@PathVariable Long id, @PathVariable int fee )
	{
		return c_ser.UpdateCourseFee(id,fee);
		
	}

	

}
