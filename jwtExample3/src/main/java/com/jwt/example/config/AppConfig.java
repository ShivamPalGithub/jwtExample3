package com.jwt.example.config;

import com.jwt.example.dao.UserRepository;
import com.jwt.example.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    @Autowired
    private UserRepository userRepository;
/*
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.builder().
                username("SHIVAM")
                .password(passwordEncoder().encode("PAL")).roles("ADMIN").
                build();
        UserDetails userDetails1 = User.builder().
                username("SHIVAM1")
                .password(passwordEncoder().encode("PAL1")).roles("ADMIN").
                build();

        return new InMemoryUserDetailsManager(userDetails,userDetails1);
    }*/

//    @Bean
//    //authentication
//    public UserDetailsService userDetailsService() {
//        return new CustomUserDetailService(userRepository);
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }


}
