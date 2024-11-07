package com.pocv01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pocv01.model.Login;
import com.pocv01.model.User;

@RestController
@RequestMapping("/api")
public class LoginController {
	@GetMapping("/login/{userId}/{password}")
    public Login doLogin(@PathVariable String userId,String password) {
        return new Login(userId, password);
    }
}
