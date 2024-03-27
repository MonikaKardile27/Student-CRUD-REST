package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class CreateNewCourceDto {
	
	private String title;
	private LocalDate start_date;
	private LocalDate end_date;
	private int fees;
	private int min_score;

}
