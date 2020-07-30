package com.example.ws.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InformationNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1248747476747216358L;

	public InformationNotFound(String message) {
		
		super(message);
		// TODO Auto-generated constructor stub
	}

}
