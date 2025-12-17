package com.Securityexample.config;

import com.Securityexample.Service.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    @Bean
    public SecurityFilterChain securityConfiguration(HttpSecurity http) throws Exception{
        http.csrf(csrf->csrf.disable()).authorizeHttpRequests(
                req->{
                    req.requestMatchers("/api/v1/welcome/hello","/api/v1/auth/signup").permitAll()
                    .anyRequest().authenticated();

                }
        );
        return http.build();

    }
    @Bean
    public PasswordEncoder getEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(
            AuthenticationConfiguration config
    ){
        return config.getAuthenticationManager();
    }

    @Bean
   public AuthenticationProvider authProvider(
           CustomerUserDetailsService customerUserDetailsService,PasswordEncoder passwordEncoder
    ) {
       DaoAuthenticationProvider authProvider= new DaoAuthenticationProvider(customerUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return  authProvider;
    }

   }










