package com.userProfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userProfile.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User getUserByEmailId(String email) ;

}
