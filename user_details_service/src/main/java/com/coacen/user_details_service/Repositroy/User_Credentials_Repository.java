package com.coacen.user_details_service.Repositroy;

import com.coacen.user_details_service.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface User_Credentials_Repository extends MongoRepository<User,Integer>
{
    User findByuserName(String username);
}
