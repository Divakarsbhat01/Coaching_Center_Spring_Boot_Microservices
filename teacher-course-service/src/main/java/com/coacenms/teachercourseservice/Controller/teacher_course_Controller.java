package com.coacenms.teachercourseservice.Controller;

import com.coacenms.teachercourseservice.Entity.Teacher_Course;
import com.coacenms.teachercourseservice.Schemas.TeaRet;
import com.coacenms.teachercourseservice.Service.Teacher_Course_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class teacher_course_Controller
{
    @Autowired
    Teacher_Course_Service teacherCourseService;

    @PostMapping("/link_teacher_course")
    public ResponseEntity<Teacher_Course> linking_teacher_course(@RequestBody Teacher_Course teacherCourse)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherCourseService.linkstudentcourse(teacherCourse));
    }
    @DeleteMapping("/deleteteachercourselink/{id}")
    public ResponseEntity<HashMap<String,String>>deleting_teacher_course(@PathVariable("id") int id)
    {
        Boolean x=teacherCourseService.deletelink(id);
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
    public ResponseEntity<List<TeaRet>>abcd()
    {
        return ResponseEntity.status(HttpStatus.OK).body(teacherCourseService.getalllinks());
    }
}
