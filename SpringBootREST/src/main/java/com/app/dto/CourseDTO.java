package com.app.dto;

import java.time.LocalDate;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;

import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CourseDTO {

	@NotEmpty(message="Course name cannot be empty")
	@Size(min=3, max=20, message="course name should be greate than 2 char and less than 21 char!!")
	
	private String title;
	
	private int id;
	
	@NotNull(message="Course Starting date cannot be empty/null")

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate start_date;
	
	@NotNull(message="Course ending date cannot be empty/null")

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate end_date;
	
	//@NotEmpty(message="Course fees cannot be empty/null")

	@Min(value=0, message="fees can not be negative")
	private int fees;
	
	//@NotEmpty(message="Course min qualification score cannot be empty/null")
	@Min(value=40, message="min_score can't be less than 40")
	
	private int min_score;
	
}
