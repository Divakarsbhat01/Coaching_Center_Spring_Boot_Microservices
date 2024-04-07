package com.coacenms.teachercourseservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher
{
    private String teacher_first_name;
    private String teacher_last_name;
    private String teacher_email;
    private int teacher_id;

}
