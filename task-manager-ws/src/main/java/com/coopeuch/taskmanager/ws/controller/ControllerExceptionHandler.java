package com.coopeuch.taskmanager.ws.controller;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.coopeuch.taskmanager.ws.exception.TaskException;
import com.coopeuch.taskmanager.ws.exception.ResourceNotFoundException;
import com.coopeuch.taskmanager.ws.message.ErrorMessage;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
	  ErrorMessage message = new ErrorMessage(
	        HttpStatus.NOT_FOUND.value(),
	        LocalDateTime.now(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	  return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(TaskException.class)
	public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
	  ErrorMessage message = new ErrorMessage(
	        HttpStatus.INTERNAL_SERVER_ERROR.value(),
	        LocalDateTime.now(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	  return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
