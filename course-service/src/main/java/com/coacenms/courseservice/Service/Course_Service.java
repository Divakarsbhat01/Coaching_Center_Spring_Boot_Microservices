package com.coacenms.courseservice.Service;

import com.coacenms.courseservice.Entity.Course;
import com.coacenms.courseservice.Error_Control.Exceptions.courseNotFoundException;
import com.coacenms.courseservice.Schemas.Course_Return;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface Course_Service
{

    Course_Return create_course(Course parent);

    List<Course> get_all_courses();

    Optional<Course> get_course_byId(int courseId) throws courseNotFoundException;

    Course_Return update_course_by_id(int courseId, Course course) throws Exception;

    Boolean delete_parent_by_id(int courseId);
}
