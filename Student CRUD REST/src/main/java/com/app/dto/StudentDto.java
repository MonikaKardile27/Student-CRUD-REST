package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
@NoArgsConstructor
public class StudentDto {

	private String first_name;
	private String last_name;
	private String email;
	private int score;
	@JsonProperty(access = Access.WRITE_ONLY) 
	// this property is going to be used ONLY during un marshalling(de ser.) to
	// read the course title from the request payload. But it;s not required
	// in resp data
	private String courseTitle;
}
