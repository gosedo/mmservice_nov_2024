package com.mmsystem.property.exception;

import org.springframework.http.ResponseEntity;

public class MmsCustomResponseBuilder {
	
	public static ResponseEntity<Object> build(MmsCustomError mmsError) {
	      return new ResponseEntity<>(mmsError, mmsError.getStatus());
	}

}
