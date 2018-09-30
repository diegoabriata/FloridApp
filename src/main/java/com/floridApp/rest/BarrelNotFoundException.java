package com.floridApp.rest;

public class BarrelNotFoundException extends RuntimeException {

	public BarrelNotFoundException() {
	}

	public BarrelNotFoundException(String message) {
		super(message);
		
	}

	public BarrelNotFoundException(Throwable cause) {
		super(cause);
	
	}

	public BarrelNotFoundException(String message, Throwable cause) {
		super(message, cause);
	
	}

	public BarrelNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	
	}

}
