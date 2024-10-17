package com.amazingcode.in.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.amazingcode.in.example.response.ErrorResponse;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<ErrorResponse> handleCategoryException(CategoryException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getStatusCode(), ex.getExceptionMessage(), ex.getStatus());
		return new ResponseEntity<>(errorResponse, ex.getStatus());
	}
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<ErrorResponse> handleProductException(ProductException ex){
		ErrorResponse errorResponse = new ErrorResponse(ex.getStatusCode(), ex.getExceptionMessage(), ex.getStatus());
		return new ResponseEntity<>(errorResponse, ex.getStatus());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex){
		ErrorResponse errorResponse = new ErrorResponse(500, ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
