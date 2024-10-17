package com.amazingcode.in.example.exception;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductException extends RuntimeException {
	
	private final String exceptionMessage;
    private final Integer statusCode;
    private final HttpStatusCode status;

}
