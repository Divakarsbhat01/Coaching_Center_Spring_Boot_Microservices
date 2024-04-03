package com.coacenms.security_service.Repository;


import com.coacenms.security_service.Entity.User_Id_Counter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface User_Id_Counter_Repository extends MongoRepository<User_Id_Counter,Integer>
{

}
