package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.app.dto.ApiResponse;
import com.app.dto.StudentDto;
import com.app.pojos.Student;
import com.app.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService s_ser;
	
	@GetMapping
	public List<Student> viewAllStudent(){
		return s_ser.viewAllStudent();
		
	}
	
	@PostMapping
	public ResponseEntity<?> addStudentDetails(@RequestBody StudentDto stud)
	{
		try {
			System.out.println(" in student detals");
			return new ResponseEntity<>(new ApiResponse(s_ser.addStudentDetails(stud)),HttpStatus.OK);
		}catch(RuntimeException e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}

	
	/*
	 * 3. View all students 
i/p : course title
Send the i/p using a path variable
eg URL for a course title , Mastering Java
 : http://host:port/students/course_title/Mastering Java 
method=GET
	 */
	
	@GetMapping("/course_title/{courseTitle}")
	public ResponseEntity<?> getAllStudentsByCourseTitle(@PathVariable String courseTitle)
	{
		try {
			System.out.println("in all student by course title"+courseTitle);
			return new ResponseEntity<>(s_ser.getAllStudentsByCourseTitle(courseTitle),HttpStatus.OK);
		}catch(RuntimeException e) {
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
	
	/*
	 * Cancel Student admission
i/p : course id n student id
eg URL : for a course id=10 n student id=20
 http://host:port/courses/10/students/20
method=DELETE
	 */
	@DeleteMapping("/{cId}/{sId}")
	public String cancleStudentAdmission(@PathVariable Long cId, @PathVariable Long sId)
	{
		return s_ser.cancleStudentAdmission(cId,sId);
	}
	
	
	

}
