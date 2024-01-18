package com.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entity.Course;
import com.app.Entity.Student;
import com.app.dto.CourseDTO;
import com.app.dto.StudentDTO;
import com.app.service.CourseService;

@RestController
@RequestMapping(path = "/course")
public class CourseContoller {
	
	@Autowired
	CourseService ser;
	
	@GetMapping()
	public ResponseEntity<?> getCourses()
	{
		return ResponseEntity.ok(ser.getAllCourses());
  
	}
	
	@GetMapping(path="/{courseId}")
	public ResponseEntity<?> getCourseDetail(@PathVariable Integer courseId)
	{
		return ResponseEntity.ok(ser.getCourse(courseId));
	}
	
	@PostMapping("/addCourse")
	public ResponseEntity<?> addCourse(@RequestBody Course c)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(ser.addCourse(c));
	}
	
	@PostMapping("/deleteCourse/{courseId}")
	public ResponseEntity<?> deleteCourse(@PathVariable Integer courseId)
	{
	    return  ResponseEntity.status(HttpStatus.ACCEPTED).body(ser.deleteCourse(courseId));	
	}
    
	@GetMapping("{courseId}/Students/")
	public ResponseEntity<?> getStudentByCourse(@PathVariable Integer courseId)
	{ 
		
		return ResponseEntity.ok(ser.GetAllStudent(courseId));
	}
	
	@PostMapping("/{courseId}/student/delete/{studentId}")
	public ResponseEntity<?> cancelStudentAdmissionByCourseId(@PathVariable Integer courseId, @PathVariable Integer studentId)
	{
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(ser.deleteStudentByCourse(courseId,studentId));
	}
	
}
