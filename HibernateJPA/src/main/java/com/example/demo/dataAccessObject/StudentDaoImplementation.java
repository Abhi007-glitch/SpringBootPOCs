package com.example.demo.dataAccessObject;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import com.example.demo.entity.Student;

@Repository // marked it as DAO for spring while component scanning and convert checked exception generated while transaction into unchecked exception
public class StudentDaoImplementation implements StudentDAO{
    
	// EntityManager variable declaration
	private EntityManager studentEntityManager;
	
	// Constructor Dependency Injection of Entity Manager
    @Autowired
    public StudentDaoImplementation(EntityManager thisManager) {
		// TODO Auto-generated constructor stub
    	studentEntityManager = thisManager;
	}
	
	
	
	@Override
	@Transactional   // spring's Transactional annotation manages transaction 
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentEntityManager.persist(student);
		
	}



	@Override
	public Student fetchSinlgeStudent(int id) {
		// TODO Auto-generated method stub
		
		Student s = studentEntityManager.find(Student.class, id);
		return s;
	}



	@Override
	public List<Student> filterAndRetrive(String name) {
		// TODO Auto-generated method stub
		
		// creating query
	  TypedQuery<Student> theQuery = (TypedQuery<Student>) studentEntityManager.createQuery("FROM Student WHERE firstName=:first_name");
	  theQuery.setParameter("first_name", name);
	  
	  List<Student> filteredData = theQuery.getResultList();
		
		return filteredData;
	}



	@Override
	@Transactional
	public void updateSingleStudentData(Student s) {
		// TODO Auto-generated method stub
		
		studentEntityManager.merge(s);
		
	}



	@Override
	@Transactional
	public int filterAndUpdateStudent(String surname) {
		 String x = "sharma";
		 
		 // to compare a string value in the query use ''(single quotes) (like 'SHARMA' in below example
		// int noOfRecordUpdated= studentEntityManager.createQuery("Update Student set lastName=:surname where lastName='SHARMA'").setParameter("surname", surname).executeUpdate();
		 
		 // another method by passing every value as named parameter to the query (more generic)
		 int noOfRecordUpdated= studentEntityManager.createQuery("Update Student set lastName=:surname where lastName=:x").setParameter("surname", surname).setParameter("x", x).executeUpdate();
		return noOfRecordUpdated;
	}



	@Override
	@Transactional
	public void deleteSingleRecord(int id) {
		// TODO Auto-generated method stub
		Student s = studentEntityManager.find(Student.class, id);
		studentEntityManager.remove(s);
		
	}
        
	
}
