package com.coacenms.teacherservice.Schemas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher_return
{
    private String teacher_first_name;
    private String teacher_last_name;
    private String teacher_email;
    private int teacher_id;
}
