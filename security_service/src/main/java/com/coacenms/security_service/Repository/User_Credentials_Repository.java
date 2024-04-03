package com.coacenms.security_service.Repository;

import com.coacenms.security_service.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface User_Credentials_Repository extends MongoRepository<User,Integer>
{
    User findByuserName(String username);
}
