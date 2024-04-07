package com.coacenms.teachercourseservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher_Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int teco_id;
    private int course_id;
    private int teacher_id;
}
