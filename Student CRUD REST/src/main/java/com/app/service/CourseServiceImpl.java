package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.controller.CourseController;
import com.app.dao.CourseDao;
import com.app.dto.CreateNewCourceDto;
import com.app.pojos.Course;
import com.app.pojos.Student;


@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao cDao;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Course> allCourseDetails() {
		
		return cDao.findAll();
	}


	@Override
	public Course updateCourse(Course c) {
		//Cource c1=mapper.map(c,Cource.class);
		return cDao.save(c);
	}

	@Override
	public String deleteCourse(Long c_id) {
		if(cDao.existsById(c_id))
		{
			cDao.deleteById(c_id);
			return "Cource deleted";
		}
		return "Cource not deleted";
	}

	@Override
	public Course listAllCourseById(Long cou_id) {
		return cDao.findAllById(cou_id);
	}


	@Override
	public String UpdateCourseFee(Long id, int fee) {
		Course course = cDao.findById(id)
				.orElseThrow();
		
		course.setFees(fee);
		return "Updated course fees of " + course.getTitle() + " to new fees : " + fee;
	}

	@Override
	public String LunchNewCourse(CreateNewCourceDto course) {
			Course c1=cDao.save(mapper.map(course, Course.class));
			return c1.getTitle()+ " Course Added...";
	}



}
