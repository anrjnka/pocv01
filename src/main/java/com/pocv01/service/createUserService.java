package com.pocv01.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pocv01.Entity.UserEntity;
import com.pocv01.model.Response;
import com.pocv01.util.PasswordEncoderUtil;

@Service
public class createUserService {
  @Autowired
  public com.pocv01.repository.userRepository userRepository;
  
  public Response addUser(UserEntity user) {
	  user.setCreationDate(new java.sql.Date(System.currentTimeMillis()));
	  user.setModifyDate(new java.sql.Date(System.currentTimeMillis()));
	  user.setPassword(PasswordEncoderUtil.encodePassword(user.getPassword()));
	  user.setResponse("test");
	  userRepository.save(user); 
	  
	  Response response = new Response();
      response.setStatus("success");
	  return response;
  }	
  
  public Response updateUser(UserEntity userInput) {
	  Optional<UserEntity> userOptional = userRepository.findById(userInput.getId());

      if (userOptional.isPresent()) {
          UserEntity user = userOptional.get();
          user.setUserId(userInput.getUserId());
          user.setModifyDate(new java.sql.Date(System.currentTimeMillis()));
          userRepository.save(user);
          
          Response response = new Response();
          response.setStatus("success");
          
    	  return response;
      } else {
          //throw new RuntimeException("User not found with id: " + id);
          Response response = new Response();
          response.setStatus("Failed User not found with id" + userInput.getUserId());
    	  return response;
      }
  } 
	  
	  
  

}
