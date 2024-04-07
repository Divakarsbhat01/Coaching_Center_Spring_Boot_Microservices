package com.coacenms.stcoservice.Service;

import com.coacenms.stcoservice.Entity.Student_Course;
import com.coacenms.stcoservice.Schemas.StcoRet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Student_Course_Service
{
    public Student_Course linkstudentcourse(Student_Course studentCourse);

    Boolean deletelink(int id);

    List<StcoRet> getalllinks();
}
