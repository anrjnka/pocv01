package com.pocv01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pocv01.Entity.UserEntity;
import com.pocv01.model.Response;

@Service
public class createUserService {
  @Autowired
  public com.pocv01.repository.userRepository userRepository;
  
  public Response addUser(UserEntity user) {
	  user.setCreationDate(new java.sql.Date(System.currentTimeMillis()));
	  user.setModifyDate(new java.sql.Date(System.currentTimeMillis()));
	  user.setResponse("test");
	  userRepository.save(user); 
	  
	  Response response = new Response();
      response.setStatus("success");
	  return response;
  }	

}
