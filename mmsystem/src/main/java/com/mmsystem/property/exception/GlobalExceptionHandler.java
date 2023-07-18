package com.mmsystem.property.exception;


import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@Slf4j(topic = "GLOBAL_EXCEPTION_HANDLER")
@ControllerAdvice
public class GlobalExceptionHandler {
	
		@ExceptionHandler(value = PropertyManagmentAlreadyExistsException.class)
	    public ResponseEntity handleBlogAlreadyExistsException(PropertyManagmentAlreadyExistsException blogAlreadyExistsException) {
	        return new ResponseEntity("Property Management already exists", HttpStatus.CONFLICT);
	    }

	 	@ExceptionHandler(value = PropertyManagmentNotFoundException.class)
	    public ResponseEntity blogNotFoundException(PropertyManagmentNotFoundException blogNotFoundException) {
	        return new ResponseEntity("Property Management not found.", HttpStatus.NOT_FOUND);
	    }
	 	@ExceptionHandler(value = Exception.class)
	    public ResponseEntity databaseConnectionFailsException(Exception exception) {
	        return new ResponseEntity<>("Server not available", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
