package com.goods.gradlegoods.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(value = CustomerNotFoundException.class)

	public ResponseEntity<Object> exception(CustomerNotFoundException exception) {
		
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = SellerNotFoundException.class)
	public ResponseEntity<Object> exception(SellerNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=IOException.class)
	public ResponseEntity<Object> exception(IOException exception) {
		return new ResponseEntity<>("Invalid input please verify it ", HttpStatus.BAD_REQUEST);
	}
}
