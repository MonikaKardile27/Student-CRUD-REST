package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="course")
public class Course extends BaseEntity  {
//course title(unique) , start date , end date , fees , min score
	
	@Column(length=20,unique=true)
	private String title;
	@Column(length=20)
	private String start_date;
	@Column(length=20)
	private String end_date;
	private int fees;
	private int min_score;
	
	@OneToMany(mappedBy = "course" ,cascade = CascadeType.ALL,orphanRemoval  =true)
	@JsonIgnore
	List<Student> student=new ArrayList<>();
	
	public void addStudent(Student s)
	{
		this.student.add(s);
		s.setCourse(this);
	}
	public void removeStudent(Student s)
	{
		this.removeStudent(s);
		s.setCourse(this);
	}
	public Course(String title, String start_date, String end_date, int fees, int min_score) {
		super();
		this.title = title;
		this.start_date = start_date;
		this.end_date = end_date;
		this.fees = fees;
		this.min_score = min_score;
	}
	
	
	
	
	
	
	
	
	
	
}
