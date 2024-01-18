package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Entity.Course;
import com.app.Entity.Student;
import com.app.customExceptionHandling.ResourceNotFoundCustomException;
import com.app.dao.CourseRepository;
import com.app.dao.StudentRepository;
import com.app.dto.CourseDTO;
import com.app.dto.StudentDTO;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository dao;
	
    @Autowired
    ModelMapper mapper;
    
	@Autowired 
	StudentRepository studentDao;
	@Override
	public List<CourseDTO> getAllCourses() {
		// TODO Auto-generated method stub    		
		return dao.findAll().stream().map(i->mapper.map(i, CourseDTO.class)).collect(Collectors.toList());
	}

	@Override
	public CourseDTO getCourse(Integer courseId) {
		// TODO Auto-generated method stub
		Course cur= dao.findById(courseId).orElseThrow(()-> new ResourceNotFoundCustomException("Invalid Course id"));
		return mapper.map(cur, CourseDTO.class);
	}

	@Override
	public CourseDTO addCourse(Course c) {
		// TODO Auto-generated method stub
		Course cur = dao.save(c);
		return mapper.map(cur, CourseDTO.class);
	}

	@Override
	public String deleteCourse(Integer courseId) {
		// TODO Auto-generated method stub
		dao.deleteById(courseId);
		return "Deleted Course successfully";
	}

	@Override
	public List<StudentDTO> GetAllStudent(Integer courseId) {
		// TODO Auto-generated method stub
		
		List<Student> students =studentDao.findByCourseId(courseId);
		System.out.println(students.size());
		
		
		return students.stream().map(i->mapper.map(i, StudentDTO.class)).collect(Collectors.toList());
	}

	@Override
	public String deleteStudentByCourse(Integer courseId, Integer studentId) {
		// TODO Auto-generated method stub
		Course cur = dao.findById(courseId).orElseThrow(()->new ResourceNotFoundCustomException(" No such Course "));
		if (cur!=null)
		{
			Student stuToDelete = studentDao.findById(studentId).orElseThrow(()->new ResourceNotFoundCustomException("No such Student found"));
			if (stuToDelete!=null)
			{
				cur.removeStudent(stuToDelete);
			}
		}
		return "Successfully deleted student from course!!";
	}

	
	
	

}
