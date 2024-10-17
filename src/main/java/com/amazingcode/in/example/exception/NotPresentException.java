package com.amazingcode.in.example.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotPresentException extends RuntimeException {
	
	private final String exceptionMessage;

}