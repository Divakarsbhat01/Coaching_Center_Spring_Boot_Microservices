package com.coacenms.courseservice.Error_Control;


import com.coacenms.courseservice.Error_Control.Exceptions.courseMaterialNotFoundException;
import com.coacenms.courseservice.Error_Control.Exceptions.courseNotFoundException;
import com.coacenms.courseservice.Error_Control.Exceptions.studentNotFoundException;
import com.coacenms.courseservice.Error_Control.Exceptions.teacherNotFoundException;
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
    @ExceptionHandler(studentNotFoundException.class)
    public ResponseEntity<Error_Message> studentnotfoundexception(studentNotFoundException exception, WebRequest webRequest)
    {
        Error_Message errorMessage=new Error_Message(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @ExceptionHandler(teacherNotFoundException.class)
    public ResponseEntity<Error_Message> teachernotfoundexception(teacherNotFoundException exception, WebRequest webRequest)
    {
        Error_Message errorMessage=new Error_Message(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @ExceptionHandler(courseNotFoundException.class)
    public ResponseEntity<Error_Message> coursenotfoundexception(courseNotFoundException exception, WebRequest webRequest)
    {
        Error_Message errorMessage=new Error_Message(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
    @ExceptionHandler(courseMaterialNotFoundException.class)
    public ResponseEntity<Error_Message> coursematerialnotfoundexception(courseMaterialNotFoundException exception, WebRequest webRequest)
    {
        Error_Message errorMessage=new Error_Message(HttpStatus.NOT_FOUND,exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
