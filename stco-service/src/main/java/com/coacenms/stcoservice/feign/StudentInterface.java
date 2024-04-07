package com.coacenms.stcoservice.feign;

import com.coacenms.stcoservice.Entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("STUDENT-SERVICE")
public interface StudentInterface
{
    @GetMapping("/all_students")
    public ResponseEntity<List<Student>> get_all_students();
}
