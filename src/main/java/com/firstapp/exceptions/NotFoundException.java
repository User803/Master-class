package com.firstapp.exceptions;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4200570815035960857L;

	public NotFoundException(String message) {
		super(message);
	}	

}
