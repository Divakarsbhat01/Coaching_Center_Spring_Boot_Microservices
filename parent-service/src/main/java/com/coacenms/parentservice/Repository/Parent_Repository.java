package com.coacenms.parentservice.Repository;

import com.coacenms.parentservice.Entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Parent_Repository extends JpaRepository<Parent,Integer>
{

}
