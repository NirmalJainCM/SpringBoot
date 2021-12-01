package com.example.springbootdemowithjpa.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionController {
	@ExceptionHandler(value = LearnerNotFoundException.class)
	public ResponseEntity<Object> exception(LearnerNotFoundException e){
		return new ResponseEntity<>("Learner Not Found", HttpStatus.NOT_FOUND);
	}
}
