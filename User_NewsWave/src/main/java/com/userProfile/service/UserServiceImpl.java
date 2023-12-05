package com.userProfile.service;

import com.userProfile.entity.User;
import com.userProfile.exceptions.UserAlreadyExistsException;
import com.userProfile.exceptions.UserNotFoundException;
import com.userProfile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo ;

    @Override
    public User registerUser(User user) {
        User userByEmailId = userRepo.getUserByEmailId(user.getEmailId());
        if(Objects.isNull(userByEmailId)){
            return userRepo.save(user) ;
        }
        else{
            throw new UserAlreadyExistsException(user.getEmailId()) ;
        }
    }

    @Override
    public User getUserByEmailId(String email) {
        User userByEmailId = userRepo.getUserByEmailId(email);
        if(Objects.nonNull(userByEmailId)){
            return userByEmailId ;
        }
        else{
            throw new UserNotFoundException(email) ;
        }
    }

    @Override
    public User updateUser(User user) {
       User userByEmail = userRepo.getUserByEmailId(user.getEmailId()) ;
       if(Objects.nonNull(userByEmail) && user.getPassword().equals(userByEmail.getPassword())){
           if(userByEmail.getName() != null){
               userByEmail.setName(user.getName());
           }
           return userRepo.save(userByEmail) ;
       }
       else{
           throw new UserNotFoundException(user.getEmailId()) ;
       }
    }

    @Override
    public String deleteUser(String email) {
        User userByEmailId = userRepo.getUserByEmailId(email);
        if(Objects.nonNull(userByEmailId)){
            userRepo.delete(userByEmailId);
            return "User Deleted !" ;
        }
        else{
            throw new UserNotFoundException(email) ;
        }
    }



    @Override
    public User loginUser(User user) {
        User userByEmailId = userRepo.getUserByEmailId(user.getEmailId());
        if(Objects.nonNull(userByEmailId) && userByEmailId.getPassword().equals(user.getPassword())){
            return userByEmailId ;
        }
        else{
            throw new UserNotFoundException(user.getEmailId()) ;
        }

    }


}
