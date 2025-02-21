package com.pocv01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pocv01.Entity.UserEntity;

@Service
public class getUserService {
	@Autowired
    private com.pocv01.repository.userRepository userRepository;
	
	// Fetch users by active status
    //public List<UserEntity> getUsersByActiveStatus(String isActive) {
    //    return userRepository.findByIsActive(isActive);
    //}

    // Fetch user by userId
    public UserEntity getUserByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    // Fetch all active users
    public List<UserEntity> getActiveUsers() {
        return userRepository.findActiveUsers();
    }
    
 // Service method to find users by status and userId
    public List<UserEntity> getUsersByFilter(String isActive, String userId) {
        return userRepository.findUsersByStatusAndUserId(isActive, userId);
    }

    public void deleteUserById(Long id){
         userRepository.deleteByUserId(id);
    }
	
}
