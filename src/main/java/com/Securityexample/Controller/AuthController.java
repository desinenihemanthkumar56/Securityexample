package com.Securityexample.Controller;

import com.Securityexample.Service.AuthService;
import com.Securityexample.dto.APIResponse;
import com.Securityexample.dto.LoginDto;
import com.Securityexample.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v1/auth")
public class AuthController{

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;
    //http://localhost:8080/api/v1/auth/signup
    @PostMapping("/signup")
    public ResponseEntity<APIResponse<String>> register(
           @RequestBody UserDto userDto
    ){
        APIResponse<String> response = authService.register(userDto);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
    }

    //http://localhost:8080/api/v1/auth/login
    @PostMapping("/login")
    public String verifyLogin(
            @RequestBody LoginDto loginDto
    ){
        UsernamePasswordAuthenticationToken
                token = new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword());
      authenticationManager.authenticate(token);
      return "done";
    }
}

