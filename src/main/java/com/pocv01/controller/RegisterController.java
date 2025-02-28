package com.pocv01.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pocv01.Entity.UserEntity;
import com.pocv01.model.Response;
import com.pocv01.model.User;
import com.pocv01.service.createUserService;
import com.pocv01.service.userService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RegisterController {
	/*@GetMapping("/register")
    public User doRegister(@PathVariable String userId,String password) {
		
        return new User("1",userId, password, "active", new java.sql.Date(System.currentTimeMillis()),new java.sql.Date(System.currentTimeMillis()));
    }*/
	
	 
	 	
	 /*public UserEntity addUser(@Validated @RequestBody UserEntity user) {
		 return createUserService.a
	    }*/
	
	@Autowired createUserService createUserService;
	
	@PostMapping("/register")
	 public ResponseEntity<Response> registerUser(@Validated @RequestBody UserEntity user) {
		    
		 
		    try {
		    	     Response result = createUserService.addUser(user);
		    	 	
			        if (result.getStatus().equals("success")) {
			            return new ResponseEntity<>(result, HttpStatus.CREATED);
			        } else {
			            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
			        }
		    
			} catch (Exception e) {
				// TODO: handle exception
				Response result = null;
				return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
			}
	       
	    }
}
