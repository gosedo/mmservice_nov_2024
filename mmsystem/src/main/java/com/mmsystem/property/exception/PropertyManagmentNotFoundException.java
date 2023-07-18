package com.mmsystem.property.exception;

public class PropertyManagmentNotFoundException extends RuntimeException {
	
	private String message;
    public PropertyManagmentNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public PropertyManagmentNotFoundException() {
    }

}
