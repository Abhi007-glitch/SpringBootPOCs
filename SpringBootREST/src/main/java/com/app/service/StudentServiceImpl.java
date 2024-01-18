package com.app.service;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Entity.Course;
import com.app.Entity.Student;
import com.app.customExceptionHandling.ResourceNotFoundCustomException;
import com.app.dao.CourseRepository;
import com.app.dao.StudentRepository;
import com.app.dto.StudentDTO;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    
	@Autowired 
	private StudentRepository studentDao;
	
	@Autowired
	private CourseRepository courseDao;
	
    @Autowired
    private ModelMapper mapper;
	@Override
	public StudentDTO getStudent(Integer studentId) {
		// TODO Auto-generated method stub
		Student cur= studentDao.findById(studentId).orElseThrow(()->new ResourceNotFoundCustomException("No such student registered!!"));
		return mapper.map(cur, StudentDTO.class);
	}

	@Override
	public String addStudentToCourse(StudentDTO sDto, Integer courseId) {
		// TODO Auto-generated method stub
		
	    Course curCourse = courseDao.findById(courseId).orElseThrow(()->new ResourceNotFoundCustomException("No such course exsist"));
	    if (curCourse.getMin_score()<=sDto.getScore())
	    {
	    	Student s  = mapper.map(sDto,Student.class);
	    	curCourse.addStudent(s);
	    	//studentDao.save(s);
	    	return "Congratulation for getting enrolled in the "+ curCourse.getTitle() + " course ";
	    }
	    return "Sorry!! You were not selected, better luck next time!!";
		
	}
	
	

}
