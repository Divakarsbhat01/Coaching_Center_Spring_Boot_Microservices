package com.coacenms.parentservice.Service;

import com.coacenms.parentservice.Entity.Parent;
import com.coacenms.parentservice.Error_Control.Exceptions.parentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface Parent_Service
{

    Parent create_parent(Parent parent);

    List<Parent> get_all_parents();

    Optional<Parent> get_parent_byId(int parent_id) throws parentNotFoundException, parentNotFoundException;

    Parent update_parent_by_id(int parentId,Parent parent) throws Exception;

    Boolean delete_parent_by_id(int parentId);
}
