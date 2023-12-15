package com.firstapp.exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

/*
 * private final getters, public constructor
 * equals and hashcode
 */
public record ApiException(String message,
		Throwable throwable,
		HttpStatus httpStatus,
		ZonedDateTime zonedDateTime) { }
