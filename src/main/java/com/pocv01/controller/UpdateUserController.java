package com.pocv01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pocv01.Entity.UserEntity;
import com.pocv01.model.Response;
import com.pocv01.service.createUserService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UpdateUserController {

    @Autowired
    private createUserService UpdateUserService;

    // POST method to update a user
    @PostMapping("/updateUser")
    public ResponseEntity<Response> updateUser(@RequestBody UserEntity userUpdateRequest) {

	    try {
	    	     Response result = UpdateUserService.updateUser(userUpdateRequest);
	    	 	
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
