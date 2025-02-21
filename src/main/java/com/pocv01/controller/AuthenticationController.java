package com.pocv01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pocv01.model.AuthResponse;
import com.pocv01.model.Login;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    private com.pocv01.service.authenticationService authenticationService;

    // @CrossOrigin(origins= "http://localhost:5173/")
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Validated @RequestBody Login login) {
        String token = authenticationService.login(login.getUserId(), login.getPassword());
        AuthResponse result = new AuthResponse();
        
        if (token!=null && token!="") {
        	result.setStatus("Login Success");
        	result.setToken(token);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } else {
        	result.setStatus("Invalid User & Password");
        	result.setToken("");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
        //return ResponseEntity.ok(token);
    }
}
