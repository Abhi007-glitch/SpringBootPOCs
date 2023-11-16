package com.example.demo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.dataAccessObject.StudentDAO;
import com.example.demo.entity.Student;



@SpringBootApplication
public class HibernateJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaApplication.class, args);
	}
	
	/// CommandLineRunner - a spring framework hook which get's executed after all beans get's initialized 
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return  runner ->{
//			System.out.println("All beans got initialized!! ");
			
			 //Creating a student
			//createAndSaveStudentToDB(studentDAO);
			
			// find a student (READ)
			//findStudent(studentDAO);
			
			// filter and read students 
			//filterAndFetchStudentsData(studentDAO);
			
			
			//update student data 
			//updateoneRecord(studentDAO);
			
			// filter and update student data 
//			filterAndUpdateSurname(studentDAO);
			
			// delete a single record
			deleteSingleRecord(studentDAO);
		};
	} 
    
	private void deleteSingleRecord(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
		
		Student s = studentEntityManager.find(Student.class, id);
		studentDAO.deleteSingleRecord(3);
		
	}

	private void filterAndUpdateSurname(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		// filter and update data 
		   int noOfRecordsUpdated = studentDAO.filterAndUpdateStudent("SHARMA");
		    System.out.println("No of record updated : "+ noOfRecordsUpdated);
	}

	private void updateoneRecord(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		// fetch student(read)
		   Student s = studentDAO.fetchSinlgeStudent(2);  
		 
		// update Student detail
		   s.setFirstName("abhishek");
		   s.setEmail("abhishek1813@gmail.com");
		
		// save updated value in database 
		   studentDAO.updateSingleStudentData(s);
		   
		
		
	}

	private void filterAndFetchStudentsData(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
		List<Student> filteredList =studentDAO.filterAndRetrive("Vaibhav");
		
		for ( Student s  : filteredList)
		{
			System.out.println(s);
		}
		
	}

	private void findStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
	    System.out.println(studentDAO.fetchSinlgeStudent(1));
		
	}

	private void createAndSaveStudentToDB(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		
		// creating a student 
		System.out.println("Creating a new Student : ");
		Student s1 = new Student("Vaibhav","Mahajan","vaibhavKatus@gmai.com");
		
		// saving the student to the database using DAO object of student
		studentDAO.save(s1);
		
		// verifying Updates in DB by accessing the database auto-generated id for saved student 
		System.out.println("Student id in database table is  : "+ s1.getId());
		
	}
	
	
	 
	

}
