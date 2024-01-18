package com.app.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="course")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "students")
public class Course extends BaseEntity {
	
	//course title(unique) , start date , end date , fees , min score
	@NotEmpty(message="Course name cannot be empty")
	@Size(min=3, max=20, message="course name should be greate than 2 char and less than 21 char!!")
	@Column(nullable = false, name="title", length =20, unique = true)
	private String title;
	
	
	@NotNull(message="Course Starting date cannot be empty/null")
	@Column(name="start_date", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate start_date;
	
	@NotNull(message="Course ending date cannot be empty/null")
	@Column(name="end_date", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate end_date;
	
	//@NotEmpty(message="Course fees cannot be empty/null")
	@Column(name = "fees", nullable = false)
	@Min(value=0, message="fees can not be negative")
	private int fees;
	
	//@NotEmpty(message="Course min qualification score cannot be empty/null")
	@Min(value=40, message="min_score can't be less than 40")
	@Column(name="minScore", nullable = false )
	private int min_score;
	
	
//@OneToMany(mappedBy = "dept", 
//	cascade = CascadeType.ALL, 
	//orphanRemoval = true /* , fetch = FetchType.EAGER */ )
	

	@OneToMany(mappedBy = "course" ,fetch = FetchType.EAGER , cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Student> students= new ArrayList<>(); 
	
	
	public Course(String title,LocalDate startDate, LocalDate endDate, int fees, int minScore)
	{
		this.title=title;
		this.start_date=startDate;
		this.end_date=endDate;
		this.fees=fees;
		this.min_score=minScore;
		
	}
	
	// helper function 
	public void addStudent(Student s)
	{
	   this.students.add(s);
	   s.setCourse(this);
	}
	
	
	public void removeStudent(Student s)
	{
	this.students.remove(s);
	s.setCourse(null);
	}
	
}
