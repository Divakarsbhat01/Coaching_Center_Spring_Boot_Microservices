package com.coacenms.coursematerialservice.Serviceimplementation;

import com.coacenms.coursematerialservice.Entity.Course_Material;
import com.coacenms.coursematerialservice.Error_Control.Exceptions.courseMaterialNotFoundException;
import com.coacenms.coursematerialservice.Error_Control.Exceptions.courseNotFoundException;
import com.coacenms.coursematerialservice.Repository.Course_Material_Repository;
import com.coacenms.coursematerialservice.Schemas.Course_Material_return;
import com.coacenms.coursematerialservice.Service.Course_Material_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Course_Material_si implements Course_Material_Service
{
    @Autowired
    Course_Material_Repository courseMaterialRepository;

    @Override
    public Course_Material_return create_course(Course_Material courseMaterial)
    {
        Course_Material x=courseMaterialRepository.save(courseMaterial);
        Course_Material_return cmr=new Course_Material_return(x);
        return cmr;
    }

    @Override
    public List<Course_Material> get_all_courses()
    {
        return courseMaterialRepository.findAll();
    }

    @Override
    public Optional<Course_Material> get_course_byId(int courseMaterialId) throws courseMaterialNotFoundException {
        if(courseMaterialRepository.findById(courseMaterialId).isPresent())
        {
            return courseMaterialRepository.findById(courseMaterialId);


        }
        else
        {
         throw new courseMaterialNotFoundException("Course Material not found");
        }

    }

    @Override
    public Course_Material_return update_course_material_by_id(int courseMaterialId, Course_Material courseMaterial) throws Exception {
        if(courseMaterialRepository.findById(courseMaterialId).isPresent())
        {
            Course_Material x=courseMaterialRepository.getReferenceById(courseMaterialId);
            x.setCourse_id(courseMaterial.getCourse_id());
            x.setCourse_url(courseMaterial.getCourse_url());
            courseMaterialRepository.save(x);
            Course_Material_return xx=new Course_Material_return(x);
            return xx;

        }
        else
        {
            throw new courseNotFoundException("CourseId not found");
        }
    }

    @Override
    public Boolean delete_parent_by_id(int courseMaterialId)
    {
        if (courseMaterialRepository.findById(courseMaterialId).isPresent())
        {
            courseMaterialRepository.deleteById(courseMaterialId);
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }
}
