package com.coacenms.teachercourseservice.fiegn;

import com.coacenms.teachercourseservice.Entity.Course;
import com.coacenms.teachercourseservice.Entity.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("TEACHER-SERVICE")
public interface TeacherInterface
{
    @GetMapping("/all_teachers")
    public ResponseEntity<List<Teacher>> get_all_teachers();
}
