package com.coacenms.security_service.Controller;

import com.coacenms.security_service.Schema.user_login_input;
import com.coacenms.security_service.Service.User_Details_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class User_Details_Controller {
    @Autowired
    User_Details_Service uds;

    @PostMapping("/user_login")
    public HashMap<String,String> abc(@RequestBody user_login_input user_logib_obj)
    {
        String x= uds.userlogin(user_logib_obj);
        HashMap<String,String>ab=new HashMap<>();
        ab.put("token",x);
        ab.put("type","Bearer");
        return ab;
    }
    @GetMapping("/validate")
    public String abcd()
    {
        return "hi";
    }
}
