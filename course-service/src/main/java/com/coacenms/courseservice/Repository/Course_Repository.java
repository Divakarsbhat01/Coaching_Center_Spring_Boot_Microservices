package com.coacenms.courseservice.Repository;

import com.coacenms.courseservice.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Course_Repository extends JpaRepository<Course,Integer> {
}
