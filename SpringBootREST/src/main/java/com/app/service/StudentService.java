package com.app.service;

import com.app.Entity.Student;
import com.app.dto.StudentDTO;

public interface StudentService {

	StudentDTO getStudent(Integer studentId);

	String addStudentToCourse(StudentDTO s, Integer courseId);




}
