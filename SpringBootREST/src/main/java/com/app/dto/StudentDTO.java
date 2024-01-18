package com.app.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



import com.app.Entity.Course;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDTO {
   
	
//	@JsonProperty(access = Access.READ_ONLY) //used during serialization
//	private Long id;
//	@NotBlank
//	//assume : json prop name : deptLocation
//	@JsonProperty(value = "deptLocation")
//	private String location;
//	@NotBlank
//	private String deptName;
	
	  @NotNull(message="name can't be empty!!")
		private String first_name;
	    private int id;
		private String last_name;
		
		@NotBlank(message="Email can't be empty")
		@Email(message = "Enter a valid email id")
		private String email;
		
		@Max(value=100, message="score can't be more than 100")
		@Min(value=0, message="score can't be negative")
		private int score;
		

		@JsonProperty(access = Access.WRITE_ONLY) 
		private Course course;
		
	
}
