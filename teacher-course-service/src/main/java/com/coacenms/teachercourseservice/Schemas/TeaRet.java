package com.coacenms.teachercourseservice.Schemas;

import com.coacenms.teachercourseservice.Entity.Course;
import com.coacenms.teachercourseservice.Entity.Teacher;
import com.coacenms.teachercourseservice.Entity.Teacher_Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeaRet
{
    private int teacher_id;
    private String teacher_first_name;
    private String teacher_email;
    private int courseid;
    private String course_name;
    private String course_desc;

    public TeaRet(Teacher_Course i, Teacher j, Course k)
    {
        this.teacher_id=j.getTeacher_id();
        this.teacher_first_name=j.getTeacher_first_name();
        this.teacher_email=j.getTeacher_email();
        this.courseid=k.getCourse_id();
        this.course_name=k.getCourse_name();
        this.course_desc=k.getCourse_desc();
    }
}
