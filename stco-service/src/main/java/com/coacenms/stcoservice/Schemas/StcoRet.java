package com.coacenms.stcoservice.Schemas;

import com.coacenms.stcoservice.Entity.Course;
import com.coacenms.stcoservice.Entity.Student;
import com.coacenms.stcoservice.Entity.Student_Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StcoRet
{
    private int student_id;
    private String student_first_name;
    private String student_email;
    private int courseid;
    private String course_name;
    private String course_desc;

    public StcoRet(Student_Course i, Student j, Course k)
    {
        this.student_id=i.getStudent_id();
        this.student_first_name=j.getStudent_first_name();
        this.student_email=j.getEmail_id();
        this.courseid=k.getCourse_id();
        this.course_name=k.getCourse_name();
        this.course_desc=k.getCourse_desc();
    }
}
