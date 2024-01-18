package com.app.customCentralizedExceptionalHandling;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.customExceptionHandling.ResourceNotFoundCustomException;
import com.app.dao.ApiResponse;

@RestControllerAdvice
public class CentralizedExceptionHandling {
	
	
	@ExceptionHandler(ResourceNotFoundCustomException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundCustomException ex)
	{
		System.out.println("in resource not found exception");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(ex.getMessage()));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		System.out.println("in argument not found exception");
		List<FieldError> errList = ex.getFieldErrors();
		
		Map<String,String>map = errList.stream().collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException
	(Exception e){
		System.out.println("in catch-all  exc");
		e.printStackTrace();
		return ResponseEntity.status
				(HttpStatus.INTERNAL_SERVER_ERROR).
				body(new ApiResponse(e.getMessage()));
	}
}
