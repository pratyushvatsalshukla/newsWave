package com.userProfile.service;

import com.userProfile.entity.User;

public interface UserService {
    User registerUser(User user) ;

    User loginUser(User user) ;

    User updateUser(User user) ;

    String deleteUser(String email) ;

    User getUserByEmailId(String email) ;
}
