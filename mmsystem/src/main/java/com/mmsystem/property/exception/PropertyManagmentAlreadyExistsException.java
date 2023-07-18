package com.mmsystem.property.exception;

public class PropertyManagmentAlreadyExistsException extends RuntimeException  {
	
	private String message;
    public PropertyManagmentAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
    public PropertyManagmentAlreadyExistsException() {
    }

}
