package com.app.enh_webapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(ResourceNotFoundException exception,
                                                         WebRequest webRequest){
        ErrorResponse response = new ErrorResponse();
        response.setTimeStamp(new Date());
        response.setMessage(exception.getMessage());
        response.setDetails(webRequest.getDescription(false));
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception,
                                                         WebRequest webRequest){
        ErrorResponse response = new ErrorResponse();
        response.setTimeStamp(new Date());
        response.setMessage(exception.getMessage());
        response.setDetails(webRequest.getDescription(false));
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
