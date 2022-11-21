package com.gestion.tarea.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gestion.tarea.dto.ErrorDTO;
import com.gestion.tarea.exception.RequestException;

@RestControllerAdvice
public class ControllerAdvice {
	
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<ErrorDTO> runtimeExceptionHandler(RuntimeException ex){
		ErrorDTO error = ErrorDTO.builder().code("500").message(ex.getMessage()).build();
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
	/*@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<ErrorDTO> requesExceptionHandler(RequestException ex){
		ErrorDTO error = ErrorDTO.builder().code(ex.getCode()).message(ex.getMessage()).build();
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}*/
}
