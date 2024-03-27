package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="emp")
public class Employee extends BaseEntity{

	//String firstName, String lastName, String email, String password, LocalDate joinDate, double salary,
	//String location, String department
	@Column(length=20,nullable=false)
	private String firstName;
	@Column(length=20,nullable=false)
	private String lastName;
	@Column(length=20,nullable=false,unique=true)
	private String email;
	private LocalDate joinDate;
	private double salary;
	@Column(length=20,nullable=false)
	private String Location;
	@Column(length=20,nullable=false)
	private String Dept;
}
