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
                .requestMatchers("/api/user/getAllUser").permitAll()
                .requestMatchers("/api/user/delete/{id}").permitAll()
                .requestMatchers("/api/register").permitAll()
                .requestMatchers("/api/gudang/getAllGudang").permitAll()
                .requestMatchers("/api/gudang/createGudang").permitAll()
                .requestMatchers("/api/gudang/delete/{id}").permitAll()
                .requestMatchers("/api/gudang/update/{id}").permitAll()
                .requestMatchers("/api/bahan/getAllBahan").permitAll()
                .requestMatchers("/api/bahan/createBahan").permitAll()
                .requestMatchers("/api/bahan/delete/{id}").permitAll()
                .requestMatchers("/api/bahan/update/{id}").permitAll()
                .requestMatchers("/api/vendor/getAllVendor").permitAll()
                .requestMatchers("/api/vendor/createVendor").permitAll()
                .requestMatchers("/api/vendor/delete/{id}").permitAll()
                .requestMatchers("/api/vendor/update/{id}").permitAll()
                .requestMatchers("/api/satuanBahan/getAllSatuanBahan").permitAll()
                .requestMatchers("/api/satuanBahan/createSatuanBahan").permitAll()
                .requestMatchers("/api/satuanBahan/delete/{id}").permitAll()
                .requestMatchers("/api/satuanBahan/update/{id}").permitAll()
                .requestMatchers("/api/jenisGudang/getAllJenisGudang").permitAll()
                .requestMatchers("/api/jenisGudang/createJenisGudang").permitAll()
                .requestMatchers("/api/jenisGudang/delete/{id}").permitAll()
                .requestMatchers("/api/jenisGudang/update/{id}").permitAll()
                .requestMatchers("/api/catalogVendor/getAllCatalogVendor").permitAll()
                .requestMatchers("/api/catalogVendor/createCatalogVendor").permitAll()
                .requestMatchers("/api/catalogVendor/delete/{id}").permitAll()
                .requestMatchers("/api/catalogVendor/update/{id}").permitAll()
                .requestMatchers("/api/cabang/getAllCabang").permitAll()
                .requestMatchers("/api/cabang/createCabang").permitAll()
                .requestMatchers("/api/cabang/delete/{id}").permitAll()
                .requestMatchers("/api/cabang/update/{id}").permitAll()
                .requestMatchers("/api/lookup/getAllLookUp").permitAll()
                .requestMatchers("/api/lookup/getLookupByKey").permitAll()
                .requestMatchers("/api/purchasing/getAllPurchasing").permitAll()
                .requestMatchers("/api/purchasing/getPurchasing/{id}").permitAll()
                .requestMatchers("/api/purchasing/createPurchasing").permitAll()
                .requestMatchers("/api/purchasing/delete/{id}").permitAll()
                .requestMatchers("/api/purchasing/update/{id}").permitAll()
                .requestMatchers("/api/purchasingDetail/getAllPurchasingDetail").permitAll()
                .requestMatchers("/api/purchasingDetail/getPurchasingDetail/{id}").permitAll()
                .requestMatchers("/api/purchasingDetail/createPurchasingDetail").permitAll()
                .requestMatchers("/api/purchasingDetail/delete/{id}").permitAll()
                .requestMatchers("/api/purchasingDetail/update/{id}").permitAll()
                .anyRequest().authenticated() // Protect other endpoints
            .and()
            .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class); // Add JWT filter before UsernamePasswordAuthenticationFilter

        return http.build(); // Return the configured filter chain
    }
}

