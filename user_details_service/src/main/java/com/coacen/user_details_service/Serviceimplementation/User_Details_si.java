package com.coacen.user_details_service.Serviceimplementation;

import com.coacen.user_details_service.Entity.User;
import com.coacen.user_details_service.Entity.User_Id_Counter;
import com.coacen.user_details_service.Error_Control.Exceptions.userNotFoundException;
import com.coacen.user_details_service.Repositroy.User_Credentials_Repository;
import com.coacen.user_details_service.Repositroy.User_Id_Counter_Repository;
import com.coacen.user_details_service.Schemas.User_Input;
import com.coacen.user_details_service.Schemas.User_return;
import com.coacen.user_details_service.Service.User_Details_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User_Details_si implements User_Details_Service
{
    @Autowired
    User_Credentials_Repository udr;

    @Autowired
    User_Id_Counter_Repository uicr;

    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Override
    public User_return save_user_details(User_Input udrb)
    {
        User_Id_Counter ab=uicr.findById(1).get();
        int future_id=(ab.getUser_id_counter())+1;
        ab.setUser_id_counter(future_id);
        uicr.save(ab);
        User new_user=new User();
        new_user.setUserId(future_id);
        new_user.setUserPassword(passwordEncoder.encode(udrb.getPassword()));
        new_user.setUserName(udrb.getUsername());
        new_user.setUserRole(udrb.getUserRole());
        udr.save(new_user);
        User_return ur=new User_return();
        ur.setRole(String.valueOf(udrb.getUserRole()));
        ur.setUsername(udrb.getUsername());
        ur.setUser_id(future_id);
        return ur;
    }

    @Override
    public User userDetails_updateService(int userId, User_Input udrb) throws Exception
    {
        Boolean check = udr.findById(userId).isPresent();
        if (check == Boolean.TRUE)
        {
            User x = udr.findById(userId).get();
            x.setUserName(udrb.getUsername());
            x.setUserPassword(passwordEncoder.encode(udrb.getUserPassword()));
            x.setUserRole(udrb.getUserRole());
            udr.save(x);
            return x;
        } else
        {
            throw new userNotFoundException("UserId not Found");
        }
    }

    @Override
    public List<User> getallUsers()
    {
        return udr.findAll();
    }

    @Override
    public User getUsers_byId(int userId) throws Exception
    {
        Boolean check = udr.findById(userId).isPresent();
        if (check == Boolean.TRUE)
        {
            User x = udr.findById(userId).get();
            return x;
        }
        else
        {
            throw new userNotFoundException("UserId not Found");
        }
    }

    @Override
    public Boolean delete_user(int userId) throws userNotFoundException {
        Boolean x=udr.findById(userId).isPresent();
        if (x==Boolean.TRUE)
        {
            udr.deleteById(userId);
            return Boolean.TRUE;
        }
        else
        {
            throw new userNotFoundException("UserId not Found");
        }
    }
}
