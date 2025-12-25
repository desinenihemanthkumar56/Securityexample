package com.Securityexample.config;

import com.Securityexample.Service.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
   String[] publicEndpoints={
           "/api/v1/auth/signup",
           "/api/v1/auth/login"
   };


    @Bean
    public SecurityFilterChain securityConfiguration(HttpSecurity http) throws Exception{
        http.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth->auth
                        .requestMatchers(publicEndpoints).permitAll()
                        .requestMatchers("/api/v1/admin/welcome").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());
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
       DaoAuthenticationProvider Provider= new DaoAuthenticationProvider(customerUserDetailsService);
        Provider.setPasswordEncoder(passwordEncoder);
        return  Provider;
    }




   }










