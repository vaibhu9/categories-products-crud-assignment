package com.amazingcode.in.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.amazingcode.in.example.response.ErrorResponse;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(AlreadyPresentException.class)
	public ResponseEntity<ErrorResponse> handleAlreadyPresentException(AlreadyPresentException ex){
		ErrorResponse errorResponse = new ErrorResponse(409, ex.getExceptionMessage(), HttpStatus.CONFLICT);
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
	}
	
	@ExceptionHandler(NotPresentException.class)
	public ResponseEntity<ErrorResponse> handleAlreadyPresentException(NotPresentException ex){
		ErrorResponse errorResponse = new ErrorResponse(204, ex.getExceptionMessage(), HttpStatus.NO_CONTENT);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errorResponse);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex){
		ErrorResponse errorResponse = new ErrorResponse(500, ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
