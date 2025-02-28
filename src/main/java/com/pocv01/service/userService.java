package com.pocv01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.pocv01.Entity.UserEntity;
import com.pocv01.model.Response;
import com.pocv01.model.User;
import com.pocv01.repository.userRepository;

@Service
public class userService {
	 @Autowired
	 private userRepository userrepo;
	 
	 /*public  UserEntity addUser(UserEntity user) {
		 return userrepo.save(user);
		 
	 }*/
	 
	 public static Response registerUser(User registrationRequest) {
	       
		  
		// Create a new user object
	        UserEntity useEntity = new UserEntity();
	        useEntity.setUserId("bintangs");
	        useEntity.setPassword("ancoleees");
	        useEntity.setIsActive("active");
	        useEntity.setModifyDate(new java.sql.Date(System.currentTimeMillis()));
	        useEntity.setCreationDate(new java.sql.Date(System.currentTimeMillis()));
	       
	        CrudRepository<UserEntity, Long> addUser = null;
			addUser.save(useEntity);
	        	
	        // Save user to the database
	        
	        Response response = new Response();
	        response.setStatus("success");
	        return response;
	    }
	 
	
}
