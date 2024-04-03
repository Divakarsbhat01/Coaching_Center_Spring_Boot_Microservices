package com.coacen.user_details_service.Service;

import com.coacen.user_details_service.Entity.User;
import com.coacen.user_details_service.Error_Control.Exceptions.userNotFoundException;
import com.coacen.user_details_service.Schemas.User_Input;
import com.coacen.user_details_service.Schemas.User_return;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface User_Details_Service {
    User_return save_user_details(User_Input udrb);

    User userDetails_updateService(int userId, User_Input udrb) throws Exception;

    List<User> getallUsers();

    User getUsers_byId(int userId) throws Exception;

    Boolean delete_user(int userId) throws userNotFoundException;
}
