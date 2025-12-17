package com.Securityexample.Controller;

import com.Securityexample.Service.AuthService;
import com.Securityexample.dto.APIResponse;
import com.Securityexample.dto.LoginDto;
import com.Securityexample.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<APIResponse<String>> verifyLogin(
            @RequestBody LoginDto loginDto
    ){
        APIResponse<String> response = new APIResponse<>();
        UsernamePasswordAuthenticationToken
                token = new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword());
     try {
         Authentication authenticate = authenticationManager.authenticate(token);
         if (authenticate.isAuthenticated()) {
             response.setMessage("Login Sucessful");
             response.setStatus(200);
             response.setData("User has logged");
             return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
         }
     }catch(Exception e) {
     e.printStackTrace();
     }
         response.setMessage("Failed");
         response.setStatus(401);
         response.setData("Un-Authorized Access");
         return new ResponseEntity<>(response,HttpStatusCode.valueOf(response.getStatus()));
    }
//
//     @GetMapping("/profile")
//      public ResponseEntity<String> profile(
//              @AuthenticationPrincipal UserDetails userDetails
//      ){
//        return new ResponseEntity<>(userDetails.getUsername(), HttpStatus.OK);
//      }

    }


