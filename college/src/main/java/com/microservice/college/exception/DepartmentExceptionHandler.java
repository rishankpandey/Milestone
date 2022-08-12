package com.microservice.college.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DepartmentExceptionHandler{
	
	@ExceptionHandler
	public String handleMaxEmpReached(MaxEmpReached exception)
	{
		return exception.getMessage();
	}
	
	
}
