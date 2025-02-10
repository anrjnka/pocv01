package com.pocv01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pocv01.DTO.UserFilterDTO;
import com.pocv01.Entity.UserEntity;
import com.pocv01.service.getUserService;

@RestController
@RequestMapping("/api")
public class GetUserController {
	
	@Autowired
    private getUserService getUserService;
	
	// Get user by userId
    @GetMapping("/{userId}")
    public UserEntity getUserByUserId(@PathVariable String userId) {
        return getUserService.getUserByUserId(userId);
    }

    // Get all active users
    @GetMapping("/active")
    public List<UserEntity> getActiveUsers() {
        return getUserService.getActiveUsers();
    }
    
    @PostMapping("/userFilter")
    public List<UserEntity> getUsersByFilter(@RequestBody UserFilterDTO filterDTO) {
        return getUserService.getUsersByFilter(filterDTO.getIsActive(), filterDTO.getUserId());
    }
}
