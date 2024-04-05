package com.coacenms.coursematerialservice.Service;

import com.coacenms.coursematerialservice.Entity.Course_Material;
import com.coacenms.coursematerialservice.Error_Control.Exceptions.courseMaterialNotFoundException;
import com.coacenms.coursematerialservice.Schemas.Course_Material_return;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface Course_Material_Service
{

    Course_Material_return create_course(Course_Material courseMaterial);

    List<Course_Material> get_all_courses();

    Optional<Course_Material> get_course_byId(int courseMaterialId) throws courseMaterialNotFoundException;

    Course_Material_return update_course_material_by_id(int courseMaterialId, Course_Material courseMaterial) throws Exception;

    Boolean delete_parent_by_id(int courseMaterialId);
}
