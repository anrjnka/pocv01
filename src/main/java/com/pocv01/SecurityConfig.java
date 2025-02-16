package com.pocv01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pocv01.util.JWTAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Define the SecurityFilterChain bean for Spring Security configuration
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // First, we disable CSRF for API endpoints
        http
            .csrf().disable()
            .authorizeHttpRequests()
                .requestMatchers("/api/login").permitAll() // Allow login without authentication
                .anyRequest().authenticated() // Protect other endpoints
            .and()
            .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class); // Add JWT filter before UsernamePasswordAuthenticationFilter

        return http.build(); // Return the configured filter chain
    }
}

