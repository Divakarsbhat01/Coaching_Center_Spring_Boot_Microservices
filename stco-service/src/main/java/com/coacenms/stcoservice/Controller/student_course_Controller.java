package com.coacenms.stcoservice.Controller;

import com.coacenms.stcoservice.Entity.Course;
import com.coacenms.stcoservice.Entity.Student;
import com.coacenms.stcoservice.Entity.Student_Course;
import com.coacenms.stcoservice.Schemas.StcoRet;
import com.coacenms.stcoservice.Service.Student_Course_Service;
import com.coacenms.stcoservice.feign.CourseInterface;
import com.coacenms.stcoservice.feign.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class student_course_Controller
{
    @Autowired
    Student_Course_Service studentCourseService;

    @PostMapping("/link_student_course")
    public ResponseEntity<Student_Course> linking_student_course(@RequestBody Student_Course studentCourse)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentCourseService.linkstudentcourse(studentCourse));
    }
    @DeleteMapping("/deletestudentcourselink/{id}")
    public ResponseEntity<HashMap<String,String>>deleting_student_course(@PathVariable("id") int id)
    {
        Boolean x=studentCourseService.deletelink(id);
        HashMap<String,String>ab=new HashMap<>();
        if (x==Boolean.TRUE)
        {
            ab.put("Message","Success");
            return ResponseEntity.status(HttpStatus.OK).body(ab);
        }
        else
        {
            ab.put("Message","Couldn't delete id not found");
            return ResponseEntity.status(HttpStatus.OK).body(ab);
        }
    }
    @GetMapping("/abcd")
    public ResponseEntity<List<StcoRet>>abcd()
    {
        return ResponseEntity.status(HttpStatus.OK).body(studentCourseService.getalllinks());
    }
}
