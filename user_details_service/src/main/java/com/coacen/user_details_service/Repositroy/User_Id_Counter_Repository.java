package com.coacen.user_details_service.Repositroy;


import com.coacen.user_details_service.Entity.User_Id_Counter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface User_Id_Counter_Repository extends MongoRepository<User_Id_Counter,Integer>
{

}
