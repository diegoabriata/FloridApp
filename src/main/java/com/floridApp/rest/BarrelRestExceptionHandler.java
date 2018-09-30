package com.floridApp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BarrelRestExceptionHandler {
	
	//An exception handler for BarrelNotFoundException
	@ExceptionHandler
	public ResponseEntity<BarrelErrorResponse> handleException(BarrelNotFoundException exc){
		BarrelErrorResponse error = new BarrelErrorResponse(HttpStatus.NOT_FOUND.value(),
															exc.getMessage(),
															System.currentTimeMillis()
															);
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	//Another exception handler... to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<BarrelErrorResponse> handleException(Exception exc){
		BarrelErrorResponse error = new BarrelErrorResponse(HttpStatus.BAD_REQUEST.value(),
															exc.getMessage(),
															System.currentTimeMillis()
															);
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
