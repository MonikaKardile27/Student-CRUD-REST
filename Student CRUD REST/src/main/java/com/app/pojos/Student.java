package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="student")
public class Student extends BaseEntity{
	
	//first name , last name , email , course title,score obtained.
	@Column(length=20,nullable = false)
	private String first_name;
	@Column(length=20,nullable = false)
	private String last_name;
	@Column(length=20,unique=true,nullable = false)
	private String email;
	private int score;
	
	@ManyToOne
	@JoinColumn(name="courseId",nullable=true)
	private Course course;

	public Student(String first_name, String last_name, String email, int score) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.score = score;
	}
	
	
	
	

}
