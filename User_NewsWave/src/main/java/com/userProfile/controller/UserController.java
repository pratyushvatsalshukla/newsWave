package com.userProfile.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userProfile.entity.User;
import com.userProfile.service.UserRegistrationServiceImpl;

@RestController
@RequestMapping("/newsWave/")
public class UserController {

    @Autowired
    UserRegistrationServiceImpl userService ;

    @PostMapping("/registration")
    public ResponseEntity<User> userRegistration(@RequestBody User user){
        User response = userService.registerUser(user) ;
            return new ResponseEntity<>(response, HttpStatus.OK) ;
        }
    
    
}

