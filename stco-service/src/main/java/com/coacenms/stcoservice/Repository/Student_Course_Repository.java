package com.coacenms.stcoservice.Repository;

import com.coacenms.stcoservice.Entity.Student_Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Student_Course_Repository extends JpaRepository<Student_Course,Integer>
{
}
