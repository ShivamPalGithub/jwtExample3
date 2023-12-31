package com.jwt.example.config;

import com.jwt.example.sercurity.JwtAuthenticationEntryPoint;
import com.jwt.example.sercurity.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;


    @Autowired
    public UserDetailsService userDetailsService;

    @Autowired
    public PasswordEncoder passwordEncoder;



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
//                .authorizeRequests().
                .authorizeHttpRequests(auth -> auth.requestMatchers("/test")
                        .authenticated()
                        .requestMatchers("/auth/login", "/swagger-ui/**", "/v3/api-docs/**", "/auth/create-user").permitAll()
//                        .requestMatchers("/auth/create-user").permitAll()
//                        .requestMatchers("/v3/api-docs/**").permitAll()
//                        .requestMatchers("/swagger-ui/**").permitAll()
                        .anyRequest()
                        .authenticated())
                        .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                       .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
                        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
                        return http.build();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        return authenticationProvider;

    }
}
