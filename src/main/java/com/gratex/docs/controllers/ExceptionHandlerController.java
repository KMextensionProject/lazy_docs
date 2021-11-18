package com.gratex.docs.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gratex.docs.exceptions.IncompleteFormException;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IncompleteFormException.class)
	public final ResponseEntity<String> handleIncompleteForm(IncompleteFormException ife) {
		return new ResponseEntity<String>(ife.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}

}
