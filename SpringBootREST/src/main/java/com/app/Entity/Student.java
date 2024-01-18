package com.app.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="student")
@ToString(exclude = "course")
public class Student extends BaseEntity {
	
	//first name , last name , email , course id,score 
    @NotNull(message="name can't be empty!!")
    @Column(name="firstName", nullable = false)
	private String first_name;
    
	private String last_name;
	
	@NotNull(message="Email can't be empty")
	@Column(name="email", nullable = false)
	@Email(message = "Enter a valid email id")
	private String email;
	
	@Column(name="score", nullable = false)

	@Max(value=100, message="score can;t be more than 100")
	@Min(value=0, message="score can't be negative")
	private int score;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="student_course")
	private Course course;
	
	
	public Student(String first_name, String last_name,String email,int score)
	{
	 this.course=null;
	 this.email=email;
	 this.first_name=first_name;
	 this.last_name=last_name;
	 this.score=score;
	}
	
	
}
