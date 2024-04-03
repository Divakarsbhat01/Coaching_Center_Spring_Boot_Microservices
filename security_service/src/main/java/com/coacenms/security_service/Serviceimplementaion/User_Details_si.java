package com.coacenms.security_service.Serviceimplementaion;

import com.coacenms.security_service.Configuration.JwtService;
import com.coacenms.security_service.Entity.User;
import com.coacenms.security_service.Repository.User_Credentials_Repository;
import com.coacenms.security_service.Repository.User_Id_Counter_Repository;
import com.coacenms.security_service.Schema.user_login_input;
import com.coacenms.security_service.Service.User_Details_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User_Details_si implements User_Details_Service {
    @Autowired
    User_Credentials_Repository udr;

    @Autowired
    User_Id_Counter_Repository uicr;

    @Autowired
    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;


    @Override
    public String userlogin(user_login_input userLogibObj)
    {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userLogibObj.getUsername(),userLogibObj.getPassword()
        ));
/*
authenticate the user using authentication manager it redirects internally
to authentication provider which obtains USerDetails through which it access
JPA repository gets username and password and authenticates it with user
provided authentication and password
*/
        User x=udr.findByuserName(userLogibObj.getUsername());
//here map the login details with USer object
        String token= jwtService.generateToken(x);
// pass user object to method in jwt service to generate token
        return token;
//return token to controller
    }
}
