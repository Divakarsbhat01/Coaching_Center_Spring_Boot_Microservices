package com.coacen.user_details_service.Controller;

import com.coacen.user_details_service.Entity.User;
import com.coacen.user_details_service.Schemas.User_Input;
import com.coacen.user_details_service.Schemas.User_return;
import com.coacen.user_details_service.Service.User_Details_Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class User_Details_Controller {
    @Autowired
    User_Details_Service uds;

    @GetMapping("/status")
    public HashMap<String, String> api_status()
    {
        HashMap<String, String> retmes = new HashMap<>();
        retmes.put("Message", "I am up and running");
        return retmes;
    }

    @PostMapping("/UserDetails_Create")
    public ResponseEntity<User_return> get_user_details(@Valid @RequestBody User_Input udrb)
    {

        return ResponseEntity.status(HttpStatus.CREATED).body(uds.save_user_details(udrb));
    }

    @PutMapping("/UserDetails_Update/{id}")
    public ResponseEntity<User> update_user_details(@Valid @RequestBody User_Input udrb, @PathVariable("id") int User_id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(uds.userDetails_updateService(User_id,udrb));
    }
    @GetMapping("/get_all_users")
    public ResponseEntity<List<User>> getting_all_users()
    {
        return ResponseEntity.status(HttpStatus.OK).body(uds.getallUsers());
    }

    @GetMapping("/get_users_byId/{id}")
    public ResponseEntity<User> getting_all_users(@PathVariable("id") int user_id) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(uds.getUsers_byId(user_id));
    }
    @DeleteMapping("/delete_user/{id}")
    public ResponseEntity<HashMap<String,String>> delete_given_user(@PathVariable("id") int user_id)throws Exception
    {
       Boolean x=uds.delete_user(user_id);
       HashMap<String,String> ab=new HashMap<>();
       if (x==Boolean.TRUE)
       {
           ab.put("Message","Success");
           return ResponseEntity.status(HttpStatus.OK).body(ab);
       }
       ab.put("Message","Id not found");
        return ResponseEntity.status(HttpStatus.OK).body(ab);
    }

}
