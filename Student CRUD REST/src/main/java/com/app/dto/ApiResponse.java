package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter

public class ApiResponse {
	
	private String message;
	private LocalDateTime timestamp;
	
	public ApiResponse(String mesg) {
		super();
		this.message = mesg;
		this.timestamp = LocalDateTime.now();
	}
	
	
	

}
