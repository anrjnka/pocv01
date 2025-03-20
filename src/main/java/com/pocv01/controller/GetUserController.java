package com.pocv01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin
@RequestMapping("/api/user")
public class GetUserController {
	
	@Autowired
    private getUserService getUserService;

	// Get user by userId
    @GetMapping("/{userId}")
    public UserEntity getUserByUserId(@PathVariable String userId) {
        return getUserService.getUserByUserId(userId);
    }

    // Get all active users
    @GetMapping("/getAllUser")
    public List<UserEntity> getActiveUsers() {
        return getUserService.getActiveUsers();
    }
    
    @PostMapping("/userFilter")
    public List<UserEntity> getUsersByFilter(@RequestBody UserFilterDTO filterDTO) {
        return getUserService.getUsersByFilter(filterDTO.getIsActive(), filterDTO.getUserId());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        try {
            getUserService.deleteUserById(id);
            return ResponseEntity.ok("user deleted");
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(500).body(e.toString());
        }
    }
}
