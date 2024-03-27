package com.app.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.CourseDao;
import com.app.dao.StudentDao;
import com.app.dto.StudentDto;
import com.app.pojos.Course;
import com.app.pojos.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao sDao;
	@Autowired
	private CourseDao cDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Student> viewAllStudent() {
		
		return sDao.findAll();
	}

	@Override
	public String addStudentDetails(StudentDto stud) {
		
		Course course=cDao.findByTitle(stud.getCourseTitle())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid course title!!!"));
		if(stud.getScore() > course.getMin_score())
		{
			Student s=mapper.map(stud,Student.class);
			course.addStudent(s);
			Student persiStu=sDao.save(s);
			return persiStu.getFirst_name()+ " "+persiStu.getLast_name()+ "admitted in the course"+course.getTitle();

		}
		return "Student can't be admitted , Less Score!!!!";
	}

	@Override
	public List<StudentDto> getAllStudentsByCourseTitle(String courseTitle) {
		List<Student> std=sDao.findAllByCourseTitle(courseTitle)
				.orElseThrow(()-> new ResourceNotFoundException("No students enrolled in course " +courseTitle));
		return std.stream().map(student -> mapper.map(student, StudentDto.class)).collect(Collectors.toList());
		
	}

	@Override
	public String cancleStudentAdmission(Long cId, Long sId) {
		if(sDao.existsById(sId)) {
			sDao.deleteById(sId);
			return "Student deleted";
		}
		return "studenr not deleted";
	}


	
}
