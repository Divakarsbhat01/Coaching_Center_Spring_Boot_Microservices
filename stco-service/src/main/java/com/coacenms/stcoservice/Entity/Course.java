package com.coacenms.stcoservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course
{
    private String course_name;
    private String course_desc;
    private int course_credit;
    private int course_id;
}
