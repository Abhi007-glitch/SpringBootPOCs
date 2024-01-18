package com.app.controller;

import javax.websocket.server.PathParam;

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
import com.app.dto.StudentDTO;
import com.app.service.CourseService;
import com.app.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    
	@Autowired 
	StudentService studentSer;
	

	@PostMapping("/registerStudent/{courseId}")
	public ResponseEntity<?> addStudent(@RequestBody StudentDTO s, @PathVariable Integer courseId )
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(studentSer.addStudentToCourse(s,courseId));
	}
	
	@GetMapping("/student/{studentId}")
	public ResponseEntity<?> getStudentDetails(@PathVariable Integer studentId)
	{
	   return ResponseEntity.ok(studentSer.getStudent(studentId));	
	}
	
	
	
	
	
}
