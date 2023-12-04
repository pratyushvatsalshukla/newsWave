package com.userProfile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userProfile.entity.User;
import com.userProfile.repository.UserRepository;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	UserRepository userRepo ;
	
	@Override
	public User registerUser(User user) {
		return userRepo.save(user) ;
	}

	
	
}
