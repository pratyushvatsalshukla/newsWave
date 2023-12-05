package com.userProfile.controller;
import com.userProfile.service.UserServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.userProfile.entity.User;

@RestController
@RequestMapping("/newsWave/")
public class UserController {

    @Autowired
    UserServiceImpl userService ;

    @PostMapping("/registration")
    public ResponseEntity<User> userRegistration(@RequestBody User user){
        User response = userService.registerUser(user) ;
            return new ResponseEntity<>(response, HttpStatus.OK) ;
        }

    @GetMapping("/getUserById/{email}")
    public ResponseEntity<User> getUserByEmailId(@PathVariable String email){

        return new ResponseEntity<>(userService.getUserByEmailId(email), HttpStatus.OK) ;
    }

    @PutMapping("/updateDetails")
    public ResponseEntity<User> updateUserDetails(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK) ;
    }


    //delete mapping.

    @DeleteMapping("/deleteUser/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email) {
        return new ResponseEntity<String>(userService.deleteUser(email),HttpStatus.OK) ;
    }


    
    @GetMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user){
    	
    	return new ResponseEntity<>(userService.loginUser(user), HttpStatus.OK) ;
    	
    }


    
}

