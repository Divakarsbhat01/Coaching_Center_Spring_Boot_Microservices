package com.coacenms.teachercourseservice.Serviceimplementation;

import com.coacenms.teachercourseservice.Entity.Course;
import com.coacenms.teachercourseservice.Entity.Teacher;
import com.coacenms.teachercourseservice.Entity.Teacher_Course;
import com.coacenms.teachercourseservice.Repository.Teacher_Course_Repository;
import com.coacenms.teachercourseservice.Schemas.TeaRet;
import com.coacenms.teachercourseservice.Service.Teacher_Course_Service;
import com.coacenms.teachercourseservice.fiegn.CourseInterface;
import com.coacenms.teachercourseservice.fiegn.TeacherInterface;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Teacher_Course_si implements Teacher_Course_Service
{
    @Autowired
    Teacher_Course_Repository teacherCourseRepository;
    @Autowired
    TeacherInterface teacherInterface;

    @Autowired
    CourseInterface courseInterface;
    @Override
    public Teacher_Course linkstudentcourse(Teacher_Course teacherCourse)
    {
        return teacherCourseRepository.save(teacherCourse);
    }

    @Override
    public Boolean deletelink(int id)
    {
        Boolean x=teacherCourseRepository.findById(id).isPresent();
        if(x==Boolean.TRUE)
        {
            teacherCourseRepository.deleteById(id);
            return x;
        }
        else
        {
            return x;
        }
    }

    @Override
    public List<TeaRet> getalllinks()
    {
        List<Teacher>aa=teacherInterface.get_all_teachers().getBody();
        List<Teacher_Course>ab=teacherCourseRepository.findAll();
        List<Course>ac=courseInterface.get_all_courses().getBody();
        List<TeaRet> zz = new ArrayList<>();
        for(Teacher_Course i:ab)
        {
            for (Teacher j:aa)
            {
                if(i.getTeacher_id()==j.getTeacher_id())
                {
                    for(Course k:ac)
                    {
                        if(i.getCourse_id()==k.getCourse_id())
                        {
                            TeaRet aaa=new TeaRet(i,j,k);
                            zz.add(aaa);
                        }
                    }
                }
            }
        }
        return zz;
    }
}
