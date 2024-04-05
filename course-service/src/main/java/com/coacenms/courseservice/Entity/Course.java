package com.coacenms.courseservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="COURSE")
public class Course
{
    private String course_name;
    private String course_desc;
    private int course_credit;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int course_id;

}
