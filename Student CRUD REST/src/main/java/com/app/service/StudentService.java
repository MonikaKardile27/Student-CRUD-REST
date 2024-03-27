package com.app.service;

import java.util.List;

import com.app.dto.StudentDto;
import com.app.pojos.Student;

public interface StudentService {

	List<Student> viewAllStudent();

	String addStudentDetails(StudentDto stud);

	List<StudentDto> getAllStudentsByCourseTitle(String courseTitle);

	String cancleStudentAdmission(Long cId, Long sId);

}
