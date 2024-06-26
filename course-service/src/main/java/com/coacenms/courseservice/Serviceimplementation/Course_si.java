package com.coacenms.courseservice.Serviceimplementation;

import com.coacenms.courseservice.Entity.Course;
import com.coacenms.courseservice.Error_Control.Exceptions.courseNotFoundException;
import com.coacenms.courseservice.Repository.Course_Repository;
import com.coacenms.courseservice.Schemas.Course_Return;
import com.coacenms.courseservice.Service.Course_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Course_si implements Course_Service
{
    @Autowired
    Course_Repository courseRepository;
    @Override
    public Course_Return create_course(Course course)
    {

        Course x=courseRepository.save(course);
        Course_Return cr=new Course_Return();
        cr.setCourse_name(x.getCourse_name());
        cr.setCourse_desc(x.getCourse_desc());
        cr.setCourse_id(x.getCourse_id());
        cr.setCourse_credit(x.getCourse_credit());
        return cr;
    }

    @Override
    public List<Course> get_all_courses()
    {

        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> get_course_byId(int courseId) throws courseNotFoundException {
        if(courseRepository.findById(courseId).isPresent())
        {
            return courseRepository.findById(courseId);
        }
        else
        {
            throw new courseNotFoundException("CourseId not found");
        }
    }

    @Override
    public Course_Return update_course_by_id(int courseId, Course course) throws Exception {
        if(courseRepository.findById(courseId).isPresent())
        {
            Course x=courseRepository.getReferenceById(courseId);
            x.setCourse_credit(course.getCourse_credit());
            x.setCourse_name(course.getCourse_name());
            x.setCourse_desc(course.getCourse_desc());
            courseRepository.save(x);
            Course_Return xx=new Course_Return(x);
            return xx;

        }
        else
        {
            throw new courseNotFoundException("CourseId not found");
        }
    }

    @Override
    public Boolean delete_parent_by_id(int courseId) {
        if (courseRepository.findById(courseId).isPresent())
        {
            courseRepository.deleteById(courseId);
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }
}
