package com.pocv01.controller;



import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
/*
    private final AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Create the authentication token
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        
        // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(token);
        
        // Set the authentication in the security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Redirect to home after successful login
        return "redirect:/home";
    }
 */
    @PostMapping("/logout")
    public String logout() {
        // Invalidate session and clear security context
        SecurityContextHolder.clearContext();
        return "redirect:/login";  // Redirect to login page after logout
    }
}

