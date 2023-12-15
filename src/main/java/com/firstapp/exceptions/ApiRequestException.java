package com.firstapp.exceptions;

public class ApiRequestException extends RuntimeException {

	private static final long serialVersionUID = 8864274808038469028L;

	public ApiRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApiRequestException(String message) {
		super(message);
	}	

}
