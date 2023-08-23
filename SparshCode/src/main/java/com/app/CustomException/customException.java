package com.app.CustomException;

@SuppressWarnings("serial")
public class customException extends RuntimeException{
	
     public customException() {
    	 super();
     }
     
     public customException(String msg) {
    	 super(msg);
     } 
}
