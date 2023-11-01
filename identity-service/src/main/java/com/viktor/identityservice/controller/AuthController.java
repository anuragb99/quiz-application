package com.viktor.identityservice.controller;

import com.viktor.identityservice.dto.AuthRequest;
import com.viktor.identityservice.entity.UserCredentials;
import com.viktor.identityservice.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserCredentialsService userCredentialsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/saveUser")
    public String saveUserCredetials(@RequestBody UserCredentials userCredentials){

        return userCredentialsService.saveUserCredentials(userCredentials);
    }

    @PostMapping("/token")
    public String generateToken(@RequestBody AuthRequest authRequest){
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authenticate.isAuthenticated()){
            return userCredentialsService.generateToken(authRequest.getUsername());}
        else{
            throw new RuntimeException("Invalid User");
        }
    }

    @PostMapping("/validation")
    public String validateToken(@RequestParam String token){
        userCredentialsService.validateToken(token);
        return "Valid User";
    }
}
