package com.app.service;

import java.util.List;

import com.app.Entity.Course;
import com.app.Entity.Student;
import com.app.dto.CourseDTO;
import com.app.dto.StudentDTO;

public interface CourseService {

	List<CourseDTO> getAllCourses();

	CourseDTO getCourse(Integer courseId);

	CourseDTO addCourse(Course c);

	String deleteCourse(Integer courseId);

	List<StudentDTO> GetAllStudent(Integer courseId);

	String deleteStudentByCourse(Integer courseId, Integer studentId);


}
