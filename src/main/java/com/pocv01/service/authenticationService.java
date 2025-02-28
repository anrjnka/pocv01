package com.pocv01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pocv01.Entity.UserEntity;
import com.pocv01.util.JWTUtil;
import com.pocv01.util.PasswordEncoderUtil;

@Service
public class authenticationService {

    @Autowired
    private com.pocv01.repository.userRepository userRepository;

    public String login(String userId, String password) {
        UserEntity user = userRepository.findByUserId(userId);

        if (user == null || !PasswordEncoderUtil.matches(password, user.getPassword())) {
        	System.out.println("Invalid username or password");
        	return "";
            //throw new RuntimeException("Invalid username or password");  
        }else {

        return JWTUtil.createToken(userId);
        }
    }
}
