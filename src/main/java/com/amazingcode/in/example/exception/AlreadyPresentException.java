package com.amazingcode.in.example.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AlreadyPresentException extends RuntimeException {
	
	private final String exceptionMessage;

}