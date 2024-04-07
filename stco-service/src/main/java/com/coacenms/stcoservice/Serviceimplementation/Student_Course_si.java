package com.coacenms.stcoservice.Serviceimplementation;

import com.coacenms.stcoservice.Entity.Course;
import com.coacenms.stcoservice.Entity.Student;
import com.coacenms.stcoservice.Entity.Student_Course;
import com.coacenms.stcoservice.Repository.Student_Course_Repository;
import com.coacenms.stcoservice.Schemas.StcoRet;
import com.coacenms.stcoservice.Service.Student_Course_Service;
import com.coacenms.stcoservice.feign.CourseInterface;
import com.coacenms.stcoservice.feign.StudentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Student_Course_si implements Student_Course_Service
{
    @Autowired
    Student_Course_Repository studentCourseRepository;
    @Autowired
    StudentInterface studentInterface;

    @Autowired
    CourseInterface courseInterface;
    @Override
    public Student_Course linkstudentcourse(Student_Course studentCourse)
    {
        return studentCourseRepository.save(studentCourse);
    }

    @Override
    public Boolean deletelink(int id)
    {
        Boolean x=studentCourseRepository.findById(id).isPresent();
        if(x==Boolean.TRUE)
        {
            studentCourseRepository.deleteById(id);
            return x;
        }
        else
        {
            return x;
        }
    }

    @Override
    public List<StcoRet> getalllinks()
    {
        List<Student>aa=studentInterface.get_all_students().getBody();
        List<Student_Course>ab=studentCourseRepository.findAll();
        List<Course>ac=courseInterface.get_all_courses().getBody();
        List<StcoRet> zz = new ArrayList<>();
        for(Student_Course i:ab)
        {
            for (Student j:aa)
            {
                if(i.getStudent_id()==j.getStudent_id())
                {
                    for(Course k:ac)
                    {
                        if(i.getCourse_id()==k.getCourse_id())
                        {
                            StcoRet aaa=new StcoRet(i,j,k);
                            zz.add(aaa);
                        }
                    }
                }
            }
        }
        return zz;
    }
}
