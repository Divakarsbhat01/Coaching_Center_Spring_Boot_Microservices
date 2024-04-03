package com.coacenms.security_service.Service;

import com.coacenms.security_service.Error_Control.Exceptions.userNotFoundException;
import com.coacenms.security_service.Schema.User_return;
import com.coacenms.security_service.Schema.user_login_input;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface User_Details_Service {

    String userlogin(user_login_input userLogibObj);
}
