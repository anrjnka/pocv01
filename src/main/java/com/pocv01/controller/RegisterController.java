package com.pocv01.controller;

import java.util.Date;

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

import com.pocv01.model.Response;
import com.pocv01.model.User;
import com.pocv01.service.userService;

@RestController
@RequestMapping("/api")
public class RegisterController {
	/*@GetMapping("/register")
    public User doRegister(@PathVariable String userId,String password) {
		
        return new User("1",userId, password, "active", new java.sql.Date(System.currentTimeMillis()),new java.sql.Date(System.currentTimeMillis()));
    }*/
	
	 @PostMapping("/register")
	    public ResponseEntity<Response> registerUser(@Validated @RequestBody User user) {
	        Response result = userService.registerUser(user);
	        if (result.getStatus().equals("success")) {
	            return new ResponseEntity<>(result, HttpStatus.CREATED);
	        } else {
	            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	        }
	    }
}
