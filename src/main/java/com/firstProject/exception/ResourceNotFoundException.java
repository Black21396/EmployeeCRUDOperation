package com.firstProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// this annotation to send Result (the Exception) in the Response
@ResponseStatus(value = HttpStatus.NOT_FOUND)

// we have to extends from RunTimeException, then we can use super()
// in construction and send our Exception message
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	// attributes show when we have Exception 
	private String resourceName;
	private String fieldName;
	private Object fieldValue;

	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		// call the Parent class constructor to print the Exception message
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getResourceName() {
		return resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}
}
