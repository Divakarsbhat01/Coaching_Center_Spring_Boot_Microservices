package com.coacenms.teachercourseservice.Service;

import com.coacenms.teachercourseservice.Entity.Teacher_Course;
import com.coacenms.teachercourseservice.Schemas.TeaRet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Teacher_Course_Service
{
    public Teacher_Course linkstudentcourse(Teacher_Course teacherCourse);

    Boolean deletelink(int id);

    List<TeaRet> getalllinks();
}
