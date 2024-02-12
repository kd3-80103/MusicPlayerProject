package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

//DTO :  resp DTO : to send API resp from rest server ---> rest clnt

@Getter
@Setter
public class ApiResponseDTO {
	private LocalDateTime timeStamp;
	private String message;

	public ApiResponseDTO(String message) {
		super();
		this.message = message;
		this.timeStamp = LocalDateTime.now();
	}
}
