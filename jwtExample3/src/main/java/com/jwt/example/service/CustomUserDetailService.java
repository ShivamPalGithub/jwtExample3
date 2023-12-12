package com.jwt.example.service;

import com.jwt.example.dao.UserRepository;
import com.jwt.example.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);


    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

     User user=   this.userRepository.findByEmail(username).orElseThrow(()-> new RuntimeException("user not found !!"));
        logger.info("username : "+username.toString());
        return user;
    }
}
