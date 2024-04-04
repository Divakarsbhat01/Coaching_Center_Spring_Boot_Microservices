package com.coacenms.studentservice.Serviceimplementation;

import com.coacenms.studentservice.Entity.Student;
import com.coacenms.studentservice.Error_Control.Exceptions.studentNotFoundException;
import com.coacenms.studentservice.Repository.Student_Repository;
import com.coacenms.studentservice.Schemas.Student_return;
import com.coacenms.studentservice.Service.Student_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Student_si implements Student_Service
{
    @Autowired
    Student_Repository studentRepository;

    public Student_return create_student(Student student)
    {
        Student x=studentRepository.save(student);
        Student_return studentReturn=new Student_return();
        studentReturn.setStudent_age(student.getStudent_age());
        studentReturn.setStudent_first_name(student.getStudent_first_name());
        studentReturn.setStudent_last_name(student.getStudent_last_name());
        studentReturn.setStudent_id(student.getStudent_id());
        studentReturn.setParent_id(student.getParent_id());
        studentReturn.setEmail_id(student.getEmail_id());
        return studentReturn;
    }

    @Override
    public List<Student> get_all_students() {
        return studentRepository.findAll();
    }
    public Optional<Student> get_student_byId(int student_id) throws studentNotFoundException {
        if(studentRepository.findById(student_id).isPresent())
        {
            return Optional.of(studentRepository.findById(student_id).get());
        }
        else
        {
            throw new studentNotFoundException("Student Id not Found");
        }
    }

    @Override
    public Student update_student_by_id(int studentId, Student student) throws Exception {
        if(studentRepository.findById(studentId).isPresent())
        {
            Student x=studentRepository.getReferenceById(studentId);
            x.setStudent_age(student.getStudent_age());
            x.setStudent_first_name(student.getStudent_first_name());
            x.setStudent_last_name(student.getStudent_last_name());
            x.setEmail_id(student.getEmail_id());
            x.setParent_id(student.getParent_id());
            System.out.println(x);
            return studentRepository.save(x);
        }
        else
        {
            throw new studentNotFoundException("Student Id not Found");
        }
    }

    @Override
    public Boolean delete_student_by_id(int studentId)
    {
        if (studentRepository.findById(studentId).isPresent())
        {
            studentRepository.deleteById(studentId);
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }
}
