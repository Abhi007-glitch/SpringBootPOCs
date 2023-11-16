package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  // creating a basic(one to one) java object to database table mapping 
@Table(name="student")
public class Student {
    
	// defining mapping from ( object data member -> column name in database)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Identity -> auto-generated and managed by database 
	@Column(name="ID")
	private int id;
	
	
	@Column(name="first_name")
	private String firstName;
	
	@Column (name="last_name")
	private String  lastName;
	
	@Column (name="email")
	private String email;

	// defining constructor 
		// ********** NOTE : @Entity annotated class must have a defined no parameter constructor 
		
   public Student()
   {
	   //
   }
	
	public Student(String firstName, String lastName, String email) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	// defining getter and setter 
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getId()
	{
	 return id;	
	}

	
	
   // Defining toString 
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	

	
}
