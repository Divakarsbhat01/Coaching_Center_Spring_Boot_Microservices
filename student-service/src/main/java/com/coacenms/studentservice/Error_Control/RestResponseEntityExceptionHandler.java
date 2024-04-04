package com.coacenms.studentservice.Error_Control;

import com.coacenms.studentservice.Error_Control.Exceptions.parentNotFoundException;
import com.coacenms.studentservice.Error_Control.Exceptions.studentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(parentNotFoundException.class)
    public ResponseEntity<Error_Message> parentnotfoundexception(parentNotFoundException exception, WebRequest webRequest)
    {
        Error_Message errorMessage=new Error_Message(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler(studentNotFoundException.class)
    public ResponseEntity<Error_Message> studentnotfoundexception(studentNotFoundException exception, WebRequest webRequest)
    {
        Error_Message errorMessage=new Error_Message(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
