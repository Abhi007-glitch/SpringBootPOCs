package com.example.demo.dataAccessObject;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentDAO {
	 
	// save single student data to the database
	 void save(Student student);
    
	
	// save multiple data to the database 
	 
	 
	 // fetch data from database 
	 
	 Student fetchSinlgeStudent(int id);  // fetching single student data 
	 List<Student> filterAndRetrive(String name); // filtering and fetching data
	 
	 //update single record data in database
	 void updateSingleStudentData(Student s);  // single record update
	 
	 // update multiple records
	 int filterAndUpdateStudent(String surname);
	 
	 // delete a specific record
	 void deleteSingleRecord(int id);
	 
	 
}
