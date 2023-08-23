package com.app.CustomException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	   @ExceptionHandler(customException.class)
       public String HandleCustomException(customException ex) {
    	   return ex.getMessage();
       }
}
