package com.pocv01.service;

import org.springframework.stereotype.Service;

import com.pocv01.Entity.UserEntity;
import com.pocv01.model.Response;
import com.pocv01.model.User;

@Service
public class userService {
	 public static Response registerUser(User registrationRequest) {
	       

	       
	        // Create a new user object
	        UserEntity useEntity = new UserEntity();
	        useEntity.setUserId(registrationRequest.getUserId());
	        useEntity.setPassword(registrationRequest.getPassword());
	        useEntity.setIsActive("active");
	        useEntity.setModifyDate(new java.sql.Date(System.currentTimeMillis()));
	        useEntity.setCreationDate(new java.sql.Date(System.currentTimeMillis()));
	        

	        // Save user to the database
	        Response response = new Response();
	        response.setStatus("success");
	        return response;
	    }
}
