package com.coacenms.teacherservice.Repository;

import com.coacenms.teacherservice.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Teacher_Repository extends JpaRepository<Teacher,Integer> {
}
