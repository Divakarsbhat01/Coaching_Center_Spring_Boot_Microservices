package com.coacenms.teachercourseservice.fiegn;

import com.coacenms.teachercourseservice.Entity.Course;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("COURSE-SERVICE")
public interface CourseInterface
{
    @GetMapping("/all_courses")
    public ResponseEntity<List<Course>> get_all_courses();
}
