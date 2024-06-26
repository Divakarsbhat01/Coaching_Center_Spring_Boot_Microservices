package com.coacenms.teacherservice.Serviceimplementation;

import com.coacenms.teacherservice.Entity.Teacher;
import com.coacenms.teacherservice.Error_Control.Exceptions.teacherNotFoundException;
import com.coacenms.teacherservice.Repository.Teacher_Repository;
import com.coacenms.teacherservice.Schemas.Teacher_return;
import com.coacenms.teacherservice.Service.Teacher_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Teacher_si implements Teacher_Service
{
    @Autowired
    Teacher_Repository teacherRepository;
    @Override
    public Teacher_return create_teacher(Teacher teacher)
    {
        Teacher x=teacherRepository.save(teacher);
        Teacher_return teacherReturn=new Teacher_return();
        teacherReturn.setTeacher_first_name(teacher.getTeacher_first_name());
        teacherReturn.setTeacher_last_name(teacher.getTeacher_last_name());
        teacherReturn.setTeacher_id(teacher.getTeacher_id());
        teacherReturn.setTeacher_email(teacher.getTeacher_email());
        return teacherReturn;
    }

    @Override
    public List<Teacher> get_all_teachers()
    {
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> get_teacher_byId(int teacherId) throws teacherNotFoundException {
        if(teacherRepository.findById(teacherId).isPresent())
        {
            return teacherRepository.findById(teacherId);
        }
        else
        {
            throw new teacherNotFoundException("TeacherId not found");
        }
    }

    @Override
    public Teacher_return update_teacher_by_id(int teacherId, Teacher teacher) throws Exception
    {
        if(teacherRepository.findById(teacherId).isPresent())
        {
            Teacher x=teacherRepository.getReferenceById(teacherId);
            x.setTeacher_email(teacher.getTeacher_email());
            x.setTeacher_first_name(teacher.getTeacher_first_name());
            x.setTeacher_last_name(teacher.getTeacher_last_name());
            teacherRepository.save(x);
            Teacher_return teacherReturn=new Teacher_return();
            teacherReturn.setTeacher_id(x.getTeacher_id());
            teacherReturn.setTeacher_email(x.getTeacher_email());
            teacherReturn.setTeacher_first_name(x.getTeacher_first_name());
            teacherReturn.setTeacher_last_name(x.getTeacher_last_name());
            return teacherReturn;
        }
        else
        {
            throw new teacherNotFoundException("TeacherId not found");
        }
    }

    @Override
    public Boolean delete_teacher_by_id(int teacherId)
    {
        if (teacherRepository.findById(teacherId).isPresent())
        {
            teacherRepository.deleteById(teacherId);
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }
}
